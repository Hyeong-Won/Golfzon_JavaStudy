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
		setMenuName("메인");
		setOption();
	}

	@Override
	public void setOption() {
		mapOption.put(1, "전투");
		mapOption.put(2, "훈련");
		mapOption.put(3, "상태");
		mapOption.put(9, "종료");
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
				// 전투 메뉴
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
			System.out.println("잘못된 형식을 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
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
