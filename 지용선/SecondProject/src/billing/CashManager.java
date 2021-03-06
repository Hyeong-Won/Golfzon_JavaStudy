package billing;

import java.util.ArrayList;

import common.CommonConst.UseState;

public class CashManager {
	private ArrayList<Cash> cash;
	private int             totalCnt;
	
	public CashManager() {
		this.cash = new ArrayList<Cash>();
	}

	public int getTotalCnt() {
		return totalCnt;
	}
	
	public void addCash(Cash cash) {
		this.cash.add(cash);
		System.out.println("캐시번호 \'" +cash.getCashNo() +"\' 가 정상 충전되었습니다.");
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
	
	public void useCash(int cashAmt) {
		int remainCash = cashAmt;
		
		for (Cash cash : this.cash) {
			if(cash.getUseState().equals(UseState.정상) && cash.getRemainAmt() > 0) {
				
				if(cash.getRemainAmt() >= remainCash) {
					System.out.println("캐시번호 \'" +cash.getCashNo() +"\' 가 "+ remainCash +" 원 사용되었습니다.");
					cash.setRemainAmt(cash.getRemainAmt() - remainCash);
					break;
				}
				else {
					System.out.println("캐시번호 \'" +cash.getCashNo() +"\' 가 "+cash.getRemainAmt()+" 원 사용되었습니다.");
					remainCash -= cash.getRemainAmt();
					cash.setRemainAmt(0);
				}
			}
		}
	}
	
	public void printAllCash() {
		for (Cash cash : this.cash) {
			System.out.println(cash);
		}
	}
}
