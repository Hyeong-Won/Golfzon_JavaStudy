package main;

import character.*;
import play.Battle;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{        
		PlayableCharacter 			objPC 		= new PlayableCharacter("player");
		NonPlayableCharacterManager objNPCMap 	= new NonPlayableCharacterManager();
		
		objPC.printPlayableCharacterStat();
		
		PrintPlayerStat printInterface = (String strName, int intHP) -> 
		{
			System.out.printf("================================================\n");
			System.out.printf(" Name : %s\n", strName);
			System.out.printf(" HP   : %4d (current)\n", intHP);
			System.out.printf("================================================\n");
		};
		//printInterface.printMin(objPC.getName(), objPC.getHP());
		
		
		Battle objBattle1 = new Battle(objPC, objNPCMap.NPC.get(1));
		objBattle1.Fight();
		
		//objPC.printPlayableCharacterStat();

		printInterface.printMin(objPC.getName(), objPC.getHP());
		
		Battle objBattle2 = new Battle(objPC, objNPCMap.NPC.get(2));
		objBattle2.Fight();

		//objPC.printPlayableCharacterStat();

		printInterface.printMin(objPC.getName(), objPC.getHP());
	}

}
