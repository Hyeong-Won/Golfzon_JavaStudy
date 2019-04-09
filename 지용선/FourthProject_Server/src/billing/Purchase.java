package billing;

import java.io.Serializable;

import common.User;

public abstract class Purchase implements IPurchase, Serializable {
	private static final long serialVersionUID = 1L;
	
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
		return "================\n구매번호 : "+ purchaseNo 
				+ "\n캐시번호 : " + cashNos +"\n캐시금액 : " + cashUseAmts +"\n구매아이템 : "
				+item.getItemName() +"\n================\n";
	}

	public abstract boolean purchaseItem(User user);

}
