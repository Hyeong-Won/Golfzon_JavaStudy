package billing;

import common.CommonConst;

public class PurchaseFactory {
	public static IPurchase setPurchase(int itemCode) {
		Item item = new Item();
		for(Item temp : CommonConst.allItem) {
			if(temp.getItemCode() == itemCode) {
				item = temp;
			}
		}
		
		switch(itemCode) {
		case CommonConst.VOUCHERITEMCODE:
			return new PurchaseVoucher(item);
			
		case CommonConst.TICKETITEMCODE:
			return new PurchaseTicket(item);
		default :
			return null;
		}
		
	}
}
