package billing;

import common.User;

public abstract class Purchase implements IPurchase {
	protected int    purchaseNo;
	protected String cashNos = "";
	protected String cashUseAmts ="";
	protected Item   item;
	protected static int purchaseCnt;
	
	protected User   user;
	
	public Purchase(){
		purchaseCnt++;
		
		this.purchaseNo = purchaseCnt;
	}
	
	public int getPurchaseNo() {
		return purchaseNo;
	}

	public String getCashNos() {
		return cashNos;
	}
	
	@Override
	public User getUser() {
		return this.user;
		
	}
	
	@Override
	public String toString() {
		return "================\n���Ź�ȣ : "+ purchaseNo 
				+ "\nĳ�ù�ȣ : " + cashNos +"\nĳ�ñݾ� : " + cashUseAmts +"\n���ž����� : "
				+item.getItemName() +"\n================\n";
	}

	public abstract boolean purchaseItem(User user);

}
