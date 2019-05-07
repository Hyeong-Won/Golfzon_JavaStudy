package main;

import training.Training;
import ui.MainUI;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{
		try
		{
			Training.setRequiredHP();
			
			// ���� UI
			MainUI		objMainUI		= new MainUI();
			
			objMainUI.exeUI();
			
			System.out.println("������ ����˴ϴ�.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
