package billing;

import common.User;
import common.CommonConst.UseState;

public class PurchaseTicket extends Purchase {

	public PurchaseTicket(Item item) {
		super();
		this.item = item;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean purchaseItem(User user) {
		// TODO Auto-generated method stub
		// �����ܾ� ���
		this.user = user;
		String CashInfo = user.getCash().useCash(item.getItemAmt());
		
		for (String text : CashInfo.split("\\^")) {
			this.cashNos     += text.split("\\/")[0] +"\t";
			this.cashUseAmts += text.split("\\/")[1] +"\t";
		}
		
		HoldItem holdItem = new HoldItem();
		holdItem.setItemCode(item.getItemCode());
		holdItem.setItemName(item.getItemName());
		holdItem.setUseState(UseState.���);
		// ���� ���� ������ �߰�
		user.getHoldItem().addHoldItem(holdItem);
		
		return true;
	}

}
