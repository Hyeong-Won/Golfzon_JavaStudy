package main;

import java.util.Scanner;

import character.*;
import play.Battle;
import ui.*;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{        
		// �Է� ����
		int		intOption 			= 0; 
		int 	intSubMenuOption 	= 0;
		Scanner s					= new Scanner(System.in);
		
		// ���� ���� ��ü ����
		NonPlayableCharacterManager objNPCList 	= new NonPlayableCharacterManager();

		// �÷��̾� ��ü ����
		PlayableCharacter 			objPC 		= new PlayableCharacter("player");		
		// ���� ���		
		//objPC.printPlayableCharacterStat();
		
		// ���� �� ��� ����� ���� ���� ���
		PrintPlayerStat objPrintInterface = (String strName, int intHP) -> 
		{
			System.out.printf("================================================\n");
			System.out.printf("   ���� ü�� ��ȸ\n");
			System.out.printf("------------------------------------------------\n");
			System.out.printf(" Name : %s\n", strName);
			System.out.printf(" HP   : %4d (current)\n", intHP);
		};
		
		// ���� ����
		Battle objBattle = null;
		
		// UI ����
		// ���� UI
		MainUI		objMainUI		= new MainUI();
		// ���� UI
		BattleUI	objBattleUI		= new BattleUI();
		// ���� UI
		TrainingUI	objTraningUI	= new TrainingUI();
		
		objMainUI.printDefaultUI();
		intOption = s.nextInt();
		while(true)
		{
			switch(intOption)
			{
			// ���� �޴�
			case 1:
				objBattleUI.printDefaultUI();
				intSubMenuOption = s.nextInt();
				switch(intSubMenuOption)
				{
				// ����
				case 1:
					System.out.println("================================================");
					System.out.println("   �̱��� �޴�");
					break;
				// �߻�
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
				// ������
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
					System.out.println("   �̱��� �޴�");
					break;
				case 2:
					System.out.println("================================================");
					System.out.println("   �̱��� �޴�");
					break;
				case 3:
					System.out.println("================================================");
					System.out.println("   �̱��� �޴�");
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
				System.out.println("������ ����˴ϴ�.");
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
