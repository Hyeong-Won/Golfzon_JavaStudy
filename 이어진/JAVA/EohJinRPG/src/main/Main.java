package main;

import training.Training;
import ui.MainUI;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{
		try
		{
			Training.setRequiredHP();
			
			// 메인 UI
			MainUI		objMainUI		= new MainUI();
			
			objMainUI.exeUI();
			
			System.out.println("게임이 종료됩니다.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
