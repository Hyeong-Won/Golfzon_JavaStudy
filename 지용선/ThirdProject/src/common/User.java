package common;

import billing.BillingManager;
import billing.CashManager;
import billing.HoldItemManager;
import common.CommonConst.UseState;

public class User {
	private String          userName;
	private int				victoryTime;
	private int				looseTime;
	private CashManager     cash;
	private HoldItemManager holdItem;
	
	public User() {
		cash     = new CashManager();
		holdItem = new HoldItemManager();
	}
	
	public CashManager getCash() {
		return cash;
	}
	
	public HoldItemManager getHoldItem() {
		return holdItem;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getVictoryTime() {
		return victoryTime;
	}

	public void addVictoryTime() {
		this.victoryTime++;
	}

	public int getLooseTime() {
		return looseTime;
	}

	public void addLooseTime() {
		this.looseTime++;
	}

	@Override
	public String toString() {
		return userName +" ���� �ܾ� : " + cash.getRemainCash() + " ��, ���� ������ ���� : " +
			   (holdItem.getHoldItemCntByCodeCount(CommonConst.VOUCHERITEMCODE,UseState.����) + holdItem.getHoldItemCntByCodeCount(CommonConst.TICKETITEMCODE,UseState.����)) + 
			   ", �¸� Ƚ�� : " + victoryTime + ", �й� Ƚ�� : " + looseTime;
	}
}
