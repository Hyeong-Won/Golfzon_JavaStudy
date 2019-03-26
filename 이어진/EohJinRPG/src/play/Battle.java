package play;
import java.util.Random;

import character.*;
import character.Character;

public class Battle {
	private	PlayableCharacter		objPlayer;
	private	NonPlayableCharacter 	objNonPlayer;	
	private	String					strBattleLog 	= "";
	private int						intPlayerHP 	= 0;
	private int						intNonPlayerHP 	= 0;
	
	// 생성자
	public Battle(PlayableCharacter objPlayer, NonPlayableCharacter objNonPlayer) {
		this.objPlayer  	= objPlayer;
		this.objNonPlayer 	= objNonPlayer;
		
		intPlayerHP 	= objPlayer.getHP();
		intNonPlayerHP 	= objNonPlayer.getHP();
	}

	// 전투 시작
	public String Fight() throws InterruptedException
	{
		int 	intBattleTime 	= 0; 				// 전투 시간
		int 	intAtkCnt		= 1; 				// 공격자 공격 카운트
		int 	intDefCnt		= 1; 				// 방어자 공격 카운트

		System.out.printf("전투시간  \t진행상황\n");
		while(intBattleTime < PlayModule.DEFAULT_BATTLE_MAX_TIME && intPlayerHP > 0 && intNonPlayerHP > 0)
		{
			// 공격자와 방어자 공격 타이밍 체크
			// 공격자가 더 빠르면
			if(objPlayer.getSpd() * intAtkCnt < objNonPlayer.getSpd() * intDefCnt)
			{
				intBattleTime = objPlayer.getSpd() * intAtkCnt;
				intAtkCnt++;
				System.out.printf("%8dms\t", intBattleTime);
				intNonPlayerHP -= attack(objPlayer, objNonPlayer);				
			}
			// 같으면
			else if (objPlayer.getSpd() * intAtkCnt == objNonPlayer.getSpd() * intDefCnt)
			{
				intBattleTime = objPlayer.getSpd() * intAtkCnt;
				intAtkCnt++;
				intDefCnt++;
				System.out.printf("%8dms\t", intBattleTime);
				intNonPlayerHP -= attack(objPlayer, objNonPlayer);
				if(intNonPlayerHP <= 0)
					break;
				System.out.printf("          \t");
				intPlayerHP -= attack(objNonPlayer, objPlayer);
			}
			// 방어자가 더 빠르면
			else
			{
				intBattleTime = objNonPlayer.getSpd() * intDefCnt;
				intDefCnt++;
				System.out.printf("%8dms\t", intBattleTime);
				intPlayerHP -= attack(objNonPlayer, objPlayer);
			}

			System.out.println("          \t남은체력 - " + objPlayer.getName() + " : " + (intPlayerHP < 0 ? 0 : intPlayerHP) + " VS " + objNonPlayer.getName() + " : " + (intNonPlayerHP < 0 ? 0 : intNonPlayerHP) + "\n");

	        Thread.sleep(100);
		}
		
		// 결과 출력
		if(chkVictory())
		{
			System.out.println(objPlayer.getName() + "의 승리!");
			objPlayer.addHP(objNonPlayer.getRewardHP());
			System.out.println(objNonPlayer.getRewardHP() + "의 HP를 얻었다!");
		}
		else
		{
			System.out.println(objPlayer.getName() + "의 패배!");
		}
		
		return strBattleLog;
	}

	// 공격
	int attack(Character objAtk, Character objDef)
	{	
		System.out.printf("%s의 공격, ", objAtk.getName());
		
		int 	intPD 	= objAtk.getPD();
		String 	strCrit = "";
		
		// 실제 크리티컬 확률 : 크리티컬 확률 - 회피 확률
		// 크리티컬 계산
		int intCrit = objAtk.getCrit() - objDef.getDod(); 
		int intRand = new Random().nextInt(PlayModule.PERCENT_10000); // (0~99)
		if (intRand < intCrit)
		{
			intPD *= 2;
			strCrit = "크리티컬!! ";
		}
		
		// 실제 회피 확률 : 회피 확률 - 크리티컬 확률 : -(실제 크리티컬 확률)
		intRand = new Random().nextInt(PlayModule.PERCENT_10000); // (0~99)
		// 회피
		if (intRand < -intCrit)
		{
			System.out.println("하지만 피했다.");
			intPD = 0;
		}
		else
		{
			System.out.printf(strCrit + "%d의 피해를 입혔다.\n", intPD);
		}
		
		return intPD;
	}	
	
	boolean chkVictory()
	{
		if(intNonPlayerHP > 0)
			return false;
		else
			return true;
	}
}
