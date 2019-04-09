package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import battle.Battle;
import character.NonPlayableCharacterManager;
import character.PlayableCharacter;
import character.PrintPlayerStat;

public class BattleUI extends UI {
	Battle objBattle = null;
	NonPlayableCharacterManager objNPCList 	= new NonPlayableCharacterManager();
	
	public BattleUI ()
	{
		setMenuName("전투");
		setOption();
	}

	@Override
	public void setOption() {
		mapOption.put(1, "야산");
		mapOption.put(9, "나가기");
	}

	@Override
	public void exeUI() throws InterruptedException
	{		
		Scanner s = new Scanner(System.in);
		// 람다 식 사용 사용자 상태 간단 출력
		PrintPlayerStat objPrintInterface = (String strName, int intHP) -> 
		{
			System.out.printf("================================================\n");
			System.out.printf("   현재 체력 조회\n");
			System.out.printf("------------------------------------------------\n");
			System.out.printf(" Name : %s\n", strName);
			System.out.printf(" HP   : %4d (current)\n", intHP);
		};
		
		try
		{
			while(true)
			{
				printDefaultUI();
				int intOption = s.nextInt();
				switch(intOption)
				{
				case 1:
					NonPlayableCharacterManager.printNPCList();
					int temp = s.nextInt();
					if(temp == 9)
						break;
					objBattle = new Battle(PlayableCharacter.getInstance(), NonPlayableCharacterManager.NPC.get(temp));
					Battle.Fight();
					objPrintInterface.printPlayerHP(PlayableCharacter.getInstance().getName(), PlayableCharacter.getInstance().getHP());
					break;
				// 나가기
				case 9:
					return;
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("잘못된 형식을 입력하셨습니다.");
			//e.printStackTrace();
		}
		finally
		{
		}
	}
}
