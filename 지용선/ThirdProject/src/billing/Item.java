package billing;

public class Item {
	private int    itemCode;
	private int    itemAmt;
	private String itemName;
	
	public Item(int itemCode, int itemAmt, String itemName) {
		this.itemCode = itemCode;
		this.itemAmt  = itemAmt;
		this.itemName = itemName;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getItemCode() {
		return itemCode;
	}

	public int getItemAmt() {
		return itemAmt;
	}

	public String getItemName() {
		return itemName;
	}
	
	
}
