package game;

import java.util.ArrayList;

import billing.BillingManager;
import common.CommonConst;
import common.User;

public class GameManager {
	private ArrayList<BaseBall> game;
	
	public GameManager() {
		this.game = new ArrayList<BaseBall>();
	}

	public void addGame(User user) {
		
		BaseBall baseball = null;
		
		if(BillingManager.getItemCnt(user, CommonConst.ITEMCODE2222) <= 0) {
			System.out.println("입장권을 구매하세요.");
			return;
		}
		
		BillingManager.useItem(user, CommonConst.ITEMCODE2222);
		
		baseball = new BaseBall(user);
		
		if(baseball.isResult()) {
			user.addVictoryTime();
		}
		else {
			user.addLooseTime();
		}
		this.game.add(baseball);
		
		System.out.println("게임번호 \'" +baseball.getGameNo() +"\' 가 기록되었습니다.");
	}
	
	public void printAllGame() {
		for (BaseBall game : this.game) {
			System.out.println(game);
		}
	}
}
