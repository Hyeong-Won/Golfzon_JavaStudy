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
	
	// ������
	public Battle(PlayableCharacter objPlayer, NonPlayableCharacter objNonPlayer) {
		this.objPlayer  	= objPlayer;
		this.objNonPlayer 	= objNonPlayer;
		
		intPlayerHP 	= objPlayer.getHP();
		intNonPlayerHP 	= objNonPlayer.getHP();
	}

	// ���� ����
	public String Fight() throws InterruptedException
	{
		int 	intBattleTime 	= 0; 				// ���� �ð�
		int 	intAtkCnt		= 1; 				// ������ ���� ī��Ʈ
		int 	intDefCnt		= 1; 				// ����� ���� ī��Ʈ

		System.out.printf("�����ð�  \t�����Ȳ\n");
		while(intBattleTime < PlayModule.DEFAULT_BATTLE_MAX_TIME && intPlayerHP > 0 && intNonPlayerHP > 0)
		{
			// �����ڿ� ����� ���� Ÿ�̹� üũ
			// �����ڰ� �� ������
			if(objPlayer.getSpd() * intAtkCnt < objNonPlayer.getSpd() * intDefCnt)
			{
				intBattleTime = objPlayer.getSpd() * intAtkCnt;
				intAtkCnt++;
				System.out.printf("%8dms\t", intBattleTime);
				intNonPlayerHP -= attack(objPlayer, objNonPlayer);				
			}
			// ������
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
			// ����ڰ� �� ������
			else
			{
				intBattleTime = objNonPlayer.getSpd() * intDefCnt;
				intDefCnt++;
				System.out.printf("%8dms\t", intBattleTime);
				intPlayerHP -= attack(objNonPlayer, objPlayer);
			}

			System.out.println("          \t����ü�� - " + objPlayer.getName() + " : " + (intPlayerHP < 0 ? 0 : intPlayerHP) + " VS " + objNonPlayer.getName() + " : " + (intNonPlayerHP < 0 ? 0 : intNonPlayerHP) + "\n");

	        Thread.sleep(100);
		}
		
		// ��� ���
		if(chkVictory())
		{
			System.out.println(objPlayer.getName() + "�� �¸�!");
			objPlayer.addHP(objNonPlayer.getRewardHP());
			System.out.println(objNonPlayer.getRewardHP() + "�� HP�� �����!");
		}
		else
		{
			System.out.println(objPlayer.getName() + "�� �й�!");
		}
		
		return strBattleLog;
	}

	// ����
	int attack(Character objAtk, Character objDef)
	{	
		System.out.printf("%s�� ����, ", objAtk.getName());
		
		int 	intPD 	= objAtk.getPD();
		String 	strCrit = "";
		
		// ���� ũ��Ƽ�� Ȯ�� : ũ��Ƽ�� Ȯ�� - ȸ�� Ȯ��
		// ũ��Ƽ�� ���
		int intCrit = objAtk.getCrit() - objDef.getDod(); 
		int intRand = new Random().nextInt(PlayModule.PERCENT_10000); // (0~99)
		if (intRand < intCrit)
		{
			intPD *= 2;
			strCrit = "ũ��Ƽ��!! ";
		}
		
		// ���� ȸ�� Ȯ�� : ȸ�� Ȯ�� - ũ��Ƽ�� Ȯ�� : -(���� ũ��Ƽ�� Ȯ��)
		intRand = new Random().nextInt(PlayModule.PERCENT_10000); // (0~99)
		// ȸ��
		if (intRand < -intCrit)
		{
			System.out.println("������ ���ߴ�.");
			intPD = 0;
		}
		else
		{
			System.out.printf(strCrit + "%d�� ���ظ� ������.\n", intPD);
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
