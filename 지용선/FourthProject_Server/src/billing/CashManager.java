package billing;

import java.io.Serializable;
import java.util.ArrayList;

import common.CommonConst.UseState;
import main.Main;

public class CashManager implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cash> cash;
	private int             totalCnt;
	private String		    userName;
	
	public CashManager(String userName) {
		this.cash     = new ArrayList<Cash>();
		this.userName = userName;
	}

	public int getTotalCnt() {
		return totalCnt;
	}
	
	public void addCash(Cash cash) {
		this.cash.add(cash);
		Main.orderRead(this.userName, "캐시번호 \'" +cash.getCashNo() +"\' 가 정상 충전되었습니다.");
	}
	
	public int getRemainCash() {
		int result = 0;
		for (Cash cash : this.cash) {
			if(cash.getUseState().equals(UseState.정상)) {
				result += cash.getRemainAmt();
			}
		}
		return result;
	}
	
	public String useCash(int cashAmt) {
		int    remainCash = cashAmt;
		String cashInfo = "";
		boolean isNoBalance = false;
		
		for (Cash cash : this.cash) {
			if(cash.getUseState().equals(UseState.정상) && cash.getRemainAmt() > 0) {
				
				if(cash.getRemainAmt() >= remainCash) {
					Main.orderRead(this.userName, "캐시번호 \'" +cash.getCashNo() +"\' 가 "+ remainCash +" 원 사용되었습니다.");
					
					cashInfo += cash.getCashNo() +"/";
					cashInfo += remainCash+ "^";
					
					cash.setRemainAmt(cash.getRemainAmt() - remainCash);
					remainCash = 0;
					break;
				}
				else {
					Main.orderRead(this.userName, "캐시번호 \'" +cash.getCashNo() +"\' 가 "+cash.getRemainAmt()+" 원 사용되었습니다.");
					
					cashInfo += cash.getCashNo() +"/";
					cashInfo += cash.getRemainAmt() + "^";
					
					remainCash -= cash.getRemainAmt();
					cash.setRemainAmt(0);
					
				}
				
			}
			else {
				isNoBalance = true;
			}
			
		}
		
		if(isNoBalance && remainCash > 0) {
			Cash minus = new Cash(this.userName);
			minus.setRemainAmt(remainCash * -1);
			minus.setPayAmt(remainCash * -1);
			minus.setUseState(UseState.정상);
			
			addCash(minus);
			
			cashInfo += minus.getCashNo() +"/";
			cashInfo += (remainCash * -1) + "^";
			
			remainCash = 0;
		}
		return cashInfo.substring(0, cashInfo.length() - 1);
	}
	

	public void insertCash(int cashAmt) {
		Cash cash;
		cash = new Cash(this.userName);
		int    remainCash = cashAmt;
		
		for (Cash Tempcash : this.cash) {
			if(Tempcash.getUseState().equals(UseState.정상) && Tempcash.getRemainAmt() < 0) {
				
				if(Tempcash.getRemainAmt() * -1 < remainCash) {
					Main.orderRead(this.userName, "캐시번호 \'" +Tempcash.getCashNo() +"\' 의 "+ Tempcash.getRemainAmt() +" 원 마이너스 금액을 상환했습니다.");
					
					remainCash += Tempcash.getRemainAmt();
					Tempcash.setRemainAmt(0);
				}
				else {
					Main.orderRead(this.userName, "캐시번호 \'" +Tempcash.getCashNo() +"\' 의 "+remainCash+" 원 마이너스 금액을 상환했습니다.");
					
					Tempcash.setRemainAmt(Tempcash.getRemainAmt() + remainCash);
					remainCash = 0;
					break;
				}
			}
			
		}
		
		if(remainCash <= 0) {
			cash.setRemainAmt(0);
		}
		else {
			cash.setRemainAmt(remainCash);
		}
		cash.setPayAmt(cashAmt);
		cash.setUseState(UseState.정상);
		
		this.addCash(cash);
	}
	
	public void printAllCash() {
		for (Cash cash : this.cash) {
			Main.orderRead(this.userName, cash.toString());
		}
	}
}
