package main;

import java.util.Scanner;

import billing.BillingManager;
import common.CommonConst;
import common.User;
import common.UserManager;
import game.GameManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner     scan        = new Scanner(System.in);
		int         userInput   = 0;
		String      userName    = null;
		User        user        = null;
		UserManager userManager = new UserManager();
		
		BillingManager billing     = null;
		GameManager    gameManager = new GameManager();
		
		do {
			userInput = PrintMenu(scan);
			user = new User();
			switch(userInput){
			
			case CommonConst.USERREGIST:
				userName = getUserName(scan);
				
				user.setUserName(userName);
				userManager.addUser(user);
				break;
				
			case CommonConst.BILLING:
				userName = getUserName(scan);
				
				user = userManager.findUserByName(userName);
				if(user == null) {
					System.out.println("해당 유저가 없습니다.");
					break;
				}
				billing = new BillingManager(user);
				billing.start();
				break;
				
			case CommonConst.GAME:
				userName = getUserName(scan);
				
				user = userManager.findUserByName(userName);
				if(user == null) {
					System.out.println("해당 유저가 없습니다.");
					break;
				}
				
				gameManager.addGame(user);
				break;
				
			case CommonConst.SHOWALLUSER:
				userManager.printAllUser();
				break;
				
			case CommonConst.SHOWALLGAME:
				gameManager.printAllGame();
				break;
				
			case CommonConst.TERMINATECODE:
				System.out.println("종료되었습니다.");
				break;
				
			default:
				System.out.println("1 ~ 5, 99 의 값을 입력해주세요.");
				break;
				
			}
		} while(userInput != CommonConst.TERMINATECODE);
		// TODO Auto-generated method stub
	}
	
	public static int PrintMenu(Scanner scan)
	{
		System.out.println("=========================");
		System.out.println("1: 유저등록");
		System.out.println("2: 캐시충전/아이템 구매");
		System.out.println("3: 게임시작");
		System.out.println("4: 전체유저보기");
		System.out.println("5: 전체게임로그보기");
		System.out.println("99: 종료");
		System.out.println("=========================");
		return scan.nextInt(); 
	}
	
	public static String getUserName(Scanner scan)
	{
		System.out.print("유저 이름을 입력해주세요 : ");
		return scan.next(); 
	}

}
