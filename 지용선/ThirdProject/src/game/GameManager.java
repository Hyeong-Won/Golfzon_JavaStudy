package game;

import java.util.ArrayList;

import billing.BillingManager;
import billing.IItemUse;
import common.CommonConst;
import common.User;

public class GameManager {
	private ArrayList<BaseBall> game;
	
	public GameManager() {
		this.game = new ArrayList<BaseBall>();
	}

	public void addGame(User user) {
		
		BaseBall baseball = null;
		
		IItemUse itemUse = BillingManager.getItemUseMethod(CommonConst.VOUCHERITEMCODE);
		if(!itemUse.useItem(user)) {
			return;
		}
		
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
