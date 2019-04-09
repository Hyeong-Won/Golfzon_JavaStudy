package main;

import java.net.Socket;

import billing.BillingManager;
import common.CommonConst;
import common.FileManager;
import common.User;
import common.UserManager;
import game.GameManager;

public class SocketThread extends Thread 
{
	Socket s;
	String username;
	public SocketThread(Socket s, String username) {
		this.s = s;
		this.username = username;
	}
	
	@Override
	public void run() 
	{
		int         userInput   = 0;
		User        user        = null;
		UserManager userManager = new UserManager();
		
		BillingManager billing     = null;
		GameManager    gameManager = new GameManager();
		
		try {
			
			do {
				Main.orderRead(username, Main.GetMenu());
				userInput = Integer.parseInt(Main.orderWrite(username));
				
				userManager = FileManager.loadFile(userManager);
				gameManager = FileManager.loadFile(gameManager);
				
				user = userManager.findUserByName(username);
				
				switch(userInput){
				
				case CommonConst.BILLING:
					billing = new BillingManager(user);
					billing.start();
					break;
					
				case CommonConst.GAME:
					gameManager.addGame(user);
					break;
					
				case CommonConst.SHOWALLUSER:
					userManager.printAllUser(user);
					break;
					
				case CommonConst.SHOWALLGAME:
					gameManager.printAllGame(user);
					break;
					
				case CommonConst.TERMINATECODE:
					Main.orderTerminate(username);
					break;
					
				default:
					Main.orderRead(this.username, "1 ~ 5, 99 의 값을 입력해주세요.");
					break;
					
				}
				
				FileManager.saveFile(userManager);
				FileManager.saveFile(gameManager);
			
			} while(userInput != CommonConst.TERMINATECODE);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}