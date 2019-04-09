package billing;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.CommonConst.UseState;

public class HoldItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int      itemCode;
	private String   itemName;
	private String   regDate;
	private String   useDate;
	private UseState useState;
	
	private String   itemType;
	
	public HoldItem() {
		Date             today = new Date();
		SimpleDateFormat ymd   = new SimpleDateFormat("yyyyMMdd");
		
		this.regDate = ymd.format(today);
	}
	
	public int getItemCode() {
		return itemCode;
	}
	
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	
	public UseState getUseState() {
		return useState;
	}

	public void setUseState(UseState useState) {
		this.useState = useState;
	}

	public String getRegDate() {
		return regDate;
	}
	
	public String getItemType() {
		return itemType;
	}

	@Override
	public String toString() {
		return "아이템 코드 : " + itemCode + " 아이템 이름 : " + itemName + " 구매일 : " + regDate + " 상태 : " + useState + " 사용일 : " + useDate;
	}
}
