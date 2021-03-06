package billing;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.CommonConst.UseState;

public class Cash implements Serializable {
	private static final long serialVersionUID = 1L;
	private int      cashNo;

	private int      payAmt;
	private int      remainAmt;
	private UseState useState;
	private String   regDate;
	private String   useDate;
	private String   userName;
	
	private static int cashcnt;
	
	public Cash(String userName) {
		Date             today = new Date();
		SimpleDateFormat ymd   = new SimpleDateFormat("yyyyMMdd");
		
		cashcnt++;
		
		this.userName = userName;
		this.cashNo   = cashcnt;
		this.regDate  = ymd.format(today);
	}
	
	public int getCashNo() {
		return cashNo;
	}

	public int getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(int payAmt) {
		this.payAmt = payAmt;
	}

	public int getRemainAmt() {
		return remainAmt;
	}

	public void setRemainAmt(int remainAmt) {
		this.remainAmt = remainAmt;
	}

	public UseState getUseState() {
		return useState;
	}

	public void setUseState(UseState useState) {
		this.useState = useState;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public String getRegDate() {
		return regDate;
	}
	
	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "캐시번호 : " + cashNo + " 충전금액 : " + payAmt + " 남은금액 : " + remainAmt+ " 구매일 : " + regDate + " 상태 : " + useState + " 사용일 : " + useDate;
	}
}
