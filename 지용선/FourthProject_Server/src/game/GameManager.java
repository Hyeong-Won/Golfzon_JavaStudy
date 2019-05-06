package game;

import java.io.Serializable;
import java.util.ArrayList;

import billing.BillingManager;
import billing.IItemUse;
import common.CommonConst;
import common.User;
import main.Main;

public class GameManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<BaseBall> game;
	
	public GameManager() {
		this.game = new ArrayList<BaseBall>();
	}

	public void addGame(User user) {
		
		BaseBall baseball = null;
		String   text     = null;
		
		IItemUse itemUse = BillingManager.getItemUseMethod(CommonConst.VOUCHERITEMCODE);
		if(!itemUse.useItem(user)) {
			return;
		}
		
		baseball = new BaseBall(user);
		
		if(baseball.isResult()) {
			user.addVictoryTime();
			text = user.getUserName() + "님이 승리하셨습니다.";
		}
		else {
			user.addLooseTime();
			text = user.getUserName() + "님이 패배하셨습니다.";
		}
		this.game.add(baseball);
		Main.BroadCastAllUser(text);
		Main.orderRead(user.getUserName(), "게임번호 \'" +baseball.getGameNo() +"\' 가 기록되었습니다.");
	}
	
	public void printAllGame(User user) {
		for (BaseBall game : this.game) {
			Main.orderRead(user.getUserName(), game.toString());
		}
	}
}
