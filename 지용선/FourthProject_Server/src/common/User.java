package common;

import java.io.Serializable;

import billing.BillingManager;
import billing.CashManager;
import billing.HoldItemManager;
import common.CommonConst.UseState;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String          userName;
	private int				victoryTime;
	private int				looseTime;
	private CashManager     cash;
	private HoldItemManager holdItem;
	
	public User(String userName) {
		cash     = new CashManager(userName);
		holdItem = new HoldItemManager(userName);
		this.userName = userName;
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
