package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import battle.Battle;
import character.NonPlayableCharacterManager;
import character.PlayableCharacter;

public class MainUI extends UI {
	BattleUI 	objBattleUI 	= new BattleUI();
	TrainingUI 	objTrainingUI 	= new TrainingUI();
	
	public MainUI ()
	{
		setMenuName("����");
		setOption();
	}

	@Override
	public void setOption() {
		mapOption.put(1, "����");
		mapOption.put(2, "�Ʒ�");
		mapOption.put(3, "����");
		mapOption.put(9, "����");
	}

	@Override
	public
	void exeUI() throws InterruptedException {
		Scanner s = new Scanner(System.in);
		try
		{
			printDefaultUI();
			int intOption = s.nextInt();
			while(true)
			{
				switch(intOption)
				{
				// ���� �޴�
				case 1:
					objBattleUI.exeUI();
					break;
				case 2:
					objTrainingUI.exeUI();
					break;
				case 3:
					PlayableCharacter.getInstance().printPlayableCharacterStat();
					printDefaultUI();
					intOption = s.nextInt();
					break;
				case 9:
					return;
				}
				printDefaultUI();
				intOption = s.nextInt();
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("�߸��� ������ �Է��ϼ̽��ϴ�. ���� �޴��� ���ư��ϴ�.");
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			s.close();
		}
	}
}
