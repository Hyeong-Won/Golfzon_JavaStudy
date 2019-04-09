package billing;

import java.io.Serializable;
import java.util.ArrayList;

import common.CommonConst.UseState;
import main.Main;

public class HoldItemManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<HoldItem> holdItem;
	private int                 totalCnt;
	private String				userName;
	
	public HoldItemManager(String userName) {
		this.holdItem = new ArrayList<HoldItem>();
		this.userName = userName;
	}

	public int getTotalCnt() {
		return totalCnt;
	}
	
	public void addHoldItem(HoldItem item) {
		this.holdItem.add(item);
		Main.orderRead(this.userName, item.getItemName() + " 구매 완료");
	}
	
	public int getHoldItemCntByCodeCount(int itemCode) {
		int result = 0;
		for (HoldItem holdItem : this.holdItem) {
			if(holdItem.getItemCode() == itemCode) {
				result++;
			}
		}
		return result;
	}
	
	public int getHoldItemCntByCodeCount(int itemCode, UseState useState) {
		int result = 0;
		for (HoldItem holdItem : this.holdItem) {
			if(holdItem.getItemCode() == itemCode && holdItem.getUseState() == useState) {
				result++;
			}
		}
		return result;
	}
	
	public HoldItem getHoldItemCntByCode(int itemCode) {
		for (HoldItem holdItem : this.holdItem) {
			if(holdItem.getItemCode() == itemCode) {
				return holdItem;
			}
		}
		return null;
	}
	
	public HoldItem getHoldItemByCode(int itemCode, UseState useState) {
		for (HoldItem holdItem : this.holdItem) {
			if(holdItem.getItemCode() == itemCode && holdItem.getUseState() == useState) {
				return holdItem;
			}
		}
		return null;
	}
	
	public void printAllHoldItem() {
		for (HoldItem holdItem : this.holdItem) {
			Main.orderRead(this.userName, holdItem.toString());
		}
	}
}
