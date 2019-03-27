package main;

import java.util.Scanner;

import character.*;
import play.Battle;
import ui.*;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{        
		// 입력 변수
		int		intOption 			= 0; 
		int 	intSubMenuOption 	= 0;
		Scanner s					= new Scanner(System.in);
		
		// 몬스터 관리 객체 생성
		NonPlayableCharacterManager objNPCList 	= new NonPlayableCharacterManager();

		// 플레이어 객체 생성
		PlayableCharacter 			objPC 		= new PlayableCharacter("player");		
		// 상태 출력		
		//objPC.printPlayableCharacterStat();
		
		// 람다 식 사용 사용자 상태 간단 출력
		PrintPlayerStat objPrintInterface = (String strName, int intHP) -> 
		{
			System.out.printf("================================================\n");
			System.out.printf("   현재 체력 조회\n");
			System.out.printf("------------------------------------------------\n");
			System.out.printf(" Name : %s\n", strName);
			System.out.printf(" HP   : %4d (current)\n", intHP);
		};
		
		// 전투 생성
		Battle objBattle = null;
		
		// UI 생성
		// 메인 UI
		MainUI		objMainUI		= new MainUI();
		// 전투 UI
		BattleUI	objBattleUI		= new BattleUI();
		// 전투 UI
		TrainingUI	objTraningUI	= new TrainingUI();
		
		objMainUI.printDefaultUI();
		intOption = s.nextInt();
		while(true)
		{
			switch(intOption)
			{
			// 전투 메뉴
			case 1:
				objBattleUI.printDefaultUI();
				intSubMenuOption = s.nextInt();
				switch(intSubMenuOption)
				{
				// 수련
				case 1:
					System.out.println("================================================");
					System.out.println("   미구현 메뉴");
					break;
				// 야산
				case 2:
					objNPCList.printNPCList();
					int temp = s.nextInt();
					while(temp != 9)
					{
						objBattle = new Battle(objPC, objNPCList.NPC.get(temp));
						objBattle.Fight();
						objPrintInterface.printPlayerHP(objPC.getName(), objPC.getHP());
							
						objNPCList.printNPCList();
						temp = s.nextInt();
					}
					break;
				// 나가기
				case 9:
				default:
					objMainUI.printDefaultUI();
					intOption = s.nextInt();
					break;
				}
				break;
			case 2:
				objTraningUI.printDefaultUI();
				intSubMenuOption = s.nextInt();
				switch(intSubMenuOption)
				{
				case 1:
					System.out.println("================================================");
					System.out.println("   미구현 메뉴");
					break;
				case 2:
					System.out.println("================================================");
					System.out.println("   미구현 메뉴");
					break;
				case 3:
					System.out.println("================================================");
					System.out.println("   미구현 메뉴");
					break;
				case 9:
				default:
					objMainUI.printDefaultUI();
					intOption = s.nextInt();
					break;
				}
				break;
			case 3:
				objPC.printPlayableCharacterStat();
				objMainUI.printDefaultUI();
				intOption = s.nextInt();
				break;
			case 9:		
			default:
				System.out.println("게임이 종료됩니다.");
				s.close();
				return;
			}
		}
		
		/*
		//objPrintInterface.printPlayerHP(objPC.getName(), objPC.getHP());
		
		
		Battle objBattle1 = new Battle(objPC, objNPCList.NPC.get(1));
		objBattle1.Fight();
		
		objPrintInterface.printPlayerHP(objPC.getName(), objPC.getHP());
		
		Battle objBattle2 = new Battle(objPC, objNPCList.NPC.get(2));
		objBattle2.Fight();

		//objPC.printPlayableCharacterStat();

		objPrintInterface.printPlayerHP(objPC.objNPCList(), objPC.getHP());
		*/
	}

}
