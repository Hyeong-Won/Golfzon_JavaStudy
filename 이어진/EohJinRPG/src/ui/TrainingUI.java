package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import character.PlayableCharacter;

public class TrainingUI extends UI {
	public TrainingUI ()
	{
		setMenuName("훈련");
		setOption();
	}

	@Override
	void setOption() {
		mapOption.put(1, "힘");
		mapOption.put(2, "지능");
		mapOption.put(3, "민첩");
		mapOption.put(9, "나가기");
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
    		System.out.printf("  -> " + key + ". " + mapOption.get(key) + ((key != 9) ? "\t/ 필요 HP : " + 0 : "") + "\n");
        }
        System.out.print("  => 선택 옵션? : ");
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
			System.out.println("잘못된 형식을 입력하셨습니다.");
			//e.printStackTrace();
		}
		finally
		{
		}
	}
}
