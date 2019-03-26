package main;

import character.*;
import play.Battle;
import ui.MainUI;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{        
		// 몬스터 관리 객체 생성
		NonPlayableCharacterManager objNPCMap 	= new NonPlayableCharacterManager();

		// 플레이어 객체 생성
		PlayableCharacter 			objPC 		= new PlayableCharacter("player");		
		// 상태 출력		
		objPC.printPlayableCharacterStat();
		
		// 람다 식 사용 사용자 상태 간단 출력
		PrintPlayerStat printInterface = (String strName, int intHP) -> 
		{
			System.out.printf("================================================\n");
			System.out.printf(" Name : %s\n", strName);
			System.out.printf(" HP   : %4d (current)\n", intHP);
			System.out.printf("================================================\n");
		};
		
		// UI 생성
		MainUI						objMainUI	= new MainUI();
		
		objMainUI.printDefaultUI();
		
		
		
		
		
		
		/*
		//printInterface.printMin(objPC.getName(), objPC.getHP());
		
		
		Battle objBattle1 = new Battle(objPC, objNPCMap.NPC.get(1));
		objBattle1.Fight();
		
		printInterface.printMin(objPC.getName(), objPC.getHP());
		
		Battle objBattle2 = new Battle(objPC, objNPCMap.NPC.get(2));
		objBattle2.Fight();

		//objPC.printPlayableCharacterStat();

		printInterface.printMin(objPC.getName(), objPC.getHP());
		*/
	}

}
