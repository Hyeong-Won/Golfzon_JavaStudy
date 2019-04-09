package billing;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import common.CommonConst;
import common.CommonConst.UseState;
import common.User;

public class BillingManager {
	private User user;
	private static ArrayList<IPurchase> purchaseList;
	
	public BillingManager(User user) {
		this.user         = user;
		
		if(purchaseList == null) {
			purchaseList = new ArrayList<IPurchase>();
		}
	}
	
	public void start() {
		Scanner   scan     = new Scanner(System.in);
		IPurchase purchase = null;
		int       userInput = 0;
		
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
				purchase = PurchaseFactory.setPurchase(CommonConst.VOUCHERITEMCODE);
				if(purchase.purchaseItem(user)) {
					purchaseList.add(purchase);					
				}
				break;
			case CommonConst.PURCHASEHIST:
				printPurchaseList(user.getUserName());
				break;
			case CommonConst.TERMINATECODE:
				break;
			default:
				System.out.println("1 ~ 5, 99 �� ���� �Է����ּ���.");
				break;
			}
		} while(userInput != CommonConst.TERMINATECODE);
		// TODO Auto-generated method stub
	}
	
	private int printMenu(Scanner scan)
	{
		System.out.println("\t=========================");
		System.out.println("\t1: ĳ������");
		System.out.println("\t2: ĳ��ȯ��");
		System.out.println("\t3: ĳ����ü����");
		System.out.println("\t4: ������������ü����");
		System.out.println("\t5: ����Ǳ���");
		System.out.println("\t6: ���ű�Ϻ���");
		System.out.println("\t99: �����޴�");
		System.out.println("\t=========================");
		return scan.nextInt(); 
	}
	
	private void insertCash(Scanner scan) {
		int cashAmt;
		
		System.out.println("������ �ݾ��� �Է��ϼ���.");
		cashAmt = scan.nextInt();
		
		user.getCash().insertCash(cashAmt);
	}
	
	private void refundCash() {
		System.out.println("����� �غ����Դϴ�.");
	}
	
	public static void printPurchaseList(String userName) {
		if(purchaseList == null) {
			purchaseList = new ArrayList<IPurchase>();
		}
		
		Stream<IPurchase> str = purchaseList.stream().filter(x -> x.getUser().getUserName().equals(userName));
		str.forEach(x -> System.out.println(x));
	}
	
	public static IItemUse getItemUseMethod(int itemCode) {
		if(itemCode == CommonConst.VOUCHERITEMCODE) {
			return (user) -> 
			{
				if(BillingManager.getItemCnt(user, itemCode) <= 0) {
					System.out.println("������� �����ϼ���.");
					return false;
				}
				
				BillingManager.useItem(user, itemCode);
				return true;
			};
		}
		else {
			return (user) -> 
			{
				IPurchase pur = PurchaseFactory.setPurchase(itemCode);
				pur.purchaseItem(user);
				
				BillingManager.purchaseList.add(pur);
				return true;
			};
		}
	}
	
	private static void useItem(User user, int itemCode) {
		if(user.getHoldItem().getHoldItemCntByCodeCount(itemCode, UseState.����) > 0) {
			user.getHoldItem().getHoldItemByCode(itemCode , UseState.����).setUseState(UseState.���);
		}
	}
	
	private static int getItemCnt(User user, int itemCode) {
		return user.getHoldItem().getHoldItemCntByCodeCount(itemCode , UseState.����);
	}
}
