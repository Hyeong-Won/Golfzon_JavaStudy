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
		
		System.out.println("���ӹ�ȣ \'" +baseball.getGameNo() +"\' �� ��ϵǾ����ϴ�.");
	}
	
	public void printAllGame() {
		for (BaseBall game : this.game) {
			System.out.println(game);
		}
	}
}
