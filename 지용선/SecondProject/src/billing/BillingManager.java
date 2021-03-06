package billing;

import java.util.Scanner;

import common.User;
import common.CommonConst;
import common.CommonConst.UseState;

public class BillingManager {
	private User user;
	
	public BillingManager(User user) {
		this.user = user;
	}
	
	public void start() {
		Scanner scan      = new Scanner(System.in);
		int     userInput = 0;
		
		do {
			userInput = printMenu(scan);
			
			switch(userInput){
			case CommonConst.CASHINS:
				insertCash(scan);
				break;
			case CommonConst.CASHREFUND:
				refundCash();
				break;
			case CommonConst.SHOWALLCASH:
				user.getCash().printAllCash();
				break;
			case CommonConst.SHOWALLITEM:
				user.getHoldItem().printAllHoldItem();
				break;
			case CommonConst.PURCHASEITEM:
				purchaseItem(CommonConst.ITEMCODE2222, CommonConst.ITEMCODE2222NAME, CommonConst.ITEMCODE2222PIRCE);
				break;
			case CommonConst.TERMINATECODE:
				break;
			default:
				System.out.println("1 ~ 5, 99 의 값을 입력해주세요.");
				break;
			}
		} while(userInput != CommonConst.TERMINATECODE);
		// TODO Auto-generated method stub
	}
	
	private int printMenu(Scanner scan)
	{
		System.out.println("\t=========================");
		System.out.println("\t1: 캐시충전");
		System.out.println("\t2: 캐시환불");
		System.out.println("\t3: 캐시전체보기");
		System.out.println("\t4: 보유아이템전체보기");
		System.out.println("\t5: 아이템구매");
		System.out.println("\t99: 이전메뉴");
		System.out.println("\t=========================");
		return scan.nextInt(); 
	}
	
	private void insertCash(Scanner scan) {
		Cash cash;
		int cashAmt;
		
		System.out.println("충전할 금액을 입력하세요.");
		cashAmt = scan.nextInt();
		cash    = new Cash();
		cash.setPayAmt(cashAmt);
		cash.setRemainAmt(cashAmt);
		cash.setUseState(UseState.정상);
		
		this.user.getCash().addCash(cash);
	}
	
	private void refundCash() {
		System.out.println("기능을 준비중입니다.");
	}
	
	private void purchaseItem(int itemCode, String itemName, int itemAmt) {
		if(this.user.getCash().getRemainCash() < itemAmt) {
			System.out.println("잔액부족");
			return;
		}
		// 유저잔액 사용
		this.user.getCash().useCash(itemAmt);
		
		HoldItem item = new HoldItem();
		item.setItemCode(itemCode);
		item.setItemName(itemName);
		item.setUseState(UseState.정상);
		// 유저 보유 아이템 추가
		this.user.getHoldItem().addHoldItem(item);
	}
	
	public static void useItem(User user, int itemCode) {
		if(user.getHoldItem().getHoldItemCntByCodeCount(itemCode, UseState.정상) > 0) {
			user.getHoldItem().getHoldItemByCode(itemCode , UseState.정상).setUseState(UseState.사용);
		}
	}
	
	public static int getItemCnt(User user, int itemCode) {
		return user.getHoldItem().getHoldItemCntByCodeCount(itemCode , UseState.정상);
	}
}
