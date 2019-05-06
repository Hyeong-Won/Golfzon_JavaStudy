package billing;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import common.CommonConst;
import common.FileManager;
import common.CommonConst.UseState;
import common.User;
import main.Main;

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
			userInput = printMenu();
			
			purchaseList = FileManager.loadFile(purchaseList);
			
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
				Main.orderRead(user.getUserName(), "1 ~ 5, 99 �� ���� �Է����ּ���.");
				break;
			}
			FileManager.saveFile(purchaseList);
		} while(userInput != CommonConst.TERMINATECODE);
		// TODO Auto-generated method stub
	}
	
	private int printMenu()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t=========================\n");
		sb.append("\t1: ĳ������\n");
		sb.append("\t2: ĳ��ȯ��\n");
		sb.append("\t3: ĳ����ü����\n");
		sb.append("\t4: ������������ü����\n");
		sb.append("\t5: ����Ǳ���\n");
		sb.append("\t6: ���ű�Ϻ���\n");
		sb.append("\t99: �����޴�\n");
		sb.append("\t=========================\n");
		
		Main.orderRead(this.user.getUserName(), sb.toString());
		return Integer.parseInt(Main.orderWrite(this.user.getUserName()));
	}
	
	private void insertCash(Scanner scan) {
		int cashAmt;
		
		Main.orderRead(this.user.getUserName(), "������ �ݾ��� �Է��ϼ���.");
		cashAmt = Integer.parseInt(Main.orderWrite(this.user.getUserName()));
		
		user.getCash().insertCash(cashAmt);
	}
	
	private void refundCash() {
		Main.orderRead(this.user.getUserName(), "����� �غ����Դϴ�.");
	}
	
	public static void printPurchaseList(String userName) {
		if(purchaseList == null) {
			purchaseList = new ArrayList<IPurchase>();
		}
		
		Stream<IPurchase> str = purchaseList.stream().filter(x -> x.getUser().getUserName().equals(userName));
		str.forEach(x -> Main.orderRead(userName,x.toString()));
	}
	
	public static IItemUse getItemUseMethod(int itemCode) {
		if(itemCode == CommonConst.VOUCHERITEMCODE) {
			return (user) -> 
			{
				if(BillingManager.getItemCnt(user, itemCode) <= 0) {
					Main.orderRead(user.getUserName(), "������� �����ϼ���");
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
