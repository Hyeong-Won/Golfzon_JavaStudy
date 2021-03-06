import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


public class Billing {
	final static int USERREGIST    = 1;
	final static int CASHINS       = 2;
	final static int CASHREFUND    = 3;
	final static int SHOWALLUSER   = 4;
	final static int TERMINATECODE = 5;
	
	static String[] userNames    = null;
	static int   [] userBalances = null;

	public static void main(String[] args) {
		Scanner scan      = new Scanner(System.in);
		int     userInput = 0;
		
		userNames    = new String[0];
		userBalances = new int[0];
		
		do {
			userInput = PrintMenu(scan);
			
			switch(userInput){
			case USERREGIST:
				RegUser(scan);
				break;
			case CASHINS:
				CashManage(scan, 1);
				break;
			case CASHREFUND:
				CashManage(scan, 2);
				break;
			case SHOWALLUSER:
				PrintAllUser();
				break;
			case TERMINATECODE:
				PrintAllUser();
				System.out.println("종료되었습니다.");
				break;
			default:
				System.out.println("1 ~ 5 의 값을 입력해주세요.");
				break;
			}
		} while(userInput != TERMINATECODE);
		// TODO Auto-generated method stub
		
	}
	
	public static int PrintMenu(Scanner scan)
	{
		System.out.println("1: 유저등록");
		System.out.println("2: 캐시충전");
		System.out.println("3: 캐시환불");
		System.out.println("4: 전체유저보기");
		System.out.println("5: 종료");
		return scan.nextInt(); 
	}
	
	public static void RegUser(Scanner scan){
		String userName = null;
		System.out.println("유저 이름을 입력하세요 : ");
		userName = scan.next();
		
		if(FindUser(userName, 2) != -9999){
			userNames    = Arrays.copyOf(userNames, userNames.length + 1);
			userBalances = Arrays.copyOf(userBalances, userBalances.length + 1);
			userNames[userNames.length - 1]       = userName;
			userBalances[userBalances.length - 1] = 0;
			System.out.println("등록이 완료되었습니다.");
		}
	}
	
	public static void CashManage(Scanner scan, int type){
		// 1충전, 2회수
		String userName  = null;
		int    userIndex = 0;
		int    cashAmt   = 0;
		System.out.println("유저 이름을 입력하세요 : ");
		userName = scan.next();
		
		userIndex = FindUser(userName, 1);
		if(userIndex != -9999){
			if(type == 1){
				System.out.println("충전할 금액을 입력하세요 : ");
				cashAmt = ChkAmount(scan, userIndex, type);
				userBalances[userIndex] += cashAmt;
			}
			else if(type == 2){
				System.out.println("회수할 금액을 입력하세요 : ");
				cashAmt = ChkAmount(scan, userIndex, type);
				userBalances[userIndex] -= cashAmt;
			}
			System.out.println("정상처리 되었습니다.");
		}
	}
	
	public static int FindUser(String userName, int findType){
		// findType 1 : 조회시 , 2: 등록시
		for(int i = 0; i < userNames.length; i++){
			if(findType == 1){
				if(userNames[i].equals(userName)){
					return i;
				}
			}
			else{
				if(userNames[i].equals(userName)){
					System.out.println("해당 유저는 이미 존재합니다.");
					return -9999;
				}
			}
		}
		
		if(findType == 1){
			System.out.println("해당아이디를 찾을수 없습니다.");
			return -9999;
		}
		else{
			// 의미 X
			return userNames.length + 1;
		}
	}
	
	public static int ChkAmount(Scanner scan,int index, int type){
		int amt = scan.nextInt();
		
		if(amt < 0 || (type == 2 && userBalances[index] - amt < 0)){
			amt = 0;
			System.out.println("금액이 잘못되었습니다.");
		}
		return amt;
	}

	public static void PrintAllUser(){
		DecimalFormat df = new DecimalFormat("#,###");
		// findType 1 : 조회시 , 2: 등록시
		for(int i = 0; i < userNames.length; i++){
			System.out.println("이름 : " + userNames[i] + ", 잔액 : " + df.format(userBalances[i]) +"원");
		}
	}

}
