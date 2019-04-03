package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import character.PlayableCharacter;

public class TrainingUI extends UI {
	public TrainingUI ()
	{
		setMenuName("�Ʒ�");
		setOption();
	}

	@Override
	void setOption() {
		mapOption.put(1, "��");
		mapOption.put(2, "����");
		mapOption.put(3, "��ø");
		mapOption.put(9, "������");
	}
	
	@Override
	public void printDefaultUI()
	{
		PlayableCharacter.getInstance().printPlayableCharacterStat();
		super.printDefaultUI();
	}
	
	@Override
	public void printMenuOption()
	{
		System.out.println("------------------------------------------------");
        for( int key : mapOption.keySet() ){
    		System.out.printf("  -> " + key + ". " + mapOption.get(key) + ((key != 9) ? "\t/ �ʿ� HP : " + 0 : "") + "\n");
        }
        System.out.print("  => ���� �ɼ�? : ");
	}
	
	@Override
	public void exeUI() throws InterruptedException {	
		Scanner s = new Scanner(System.in);
		try
		{
			while(true)
			{
				printDefaultUI();
				int intOption = s.nextInt();
				switch(intOption)
				{
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 9:
					return;
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("�߸��� ������ �Է��ϼ̽��ϴ�.");
			//e.printStackTrace();
		}
		finally
		{
		}
	}
}
