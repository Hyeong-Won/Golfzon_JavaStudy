package billing;

import java.util.ArrayList;

import common.CommonConst.UseState;

public class HoldItemManager {
	private ArrayList<HoldItem> holdItem;
	private int                 totalCnt;
	
	public HoldItemManager() {
		this.holdItem = new ArrayList<HoldItem>();
	}

	public int getTotalCnt() {
		return totalCnt;
	}
	
	public void addHoldItem(HoldItem item) {
		this.holdItem.add(item);
		System.out.println(item.getItemName() + " ���� �Ϸ�");
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
			System.out.println(holdItem);
		}
	}
}
