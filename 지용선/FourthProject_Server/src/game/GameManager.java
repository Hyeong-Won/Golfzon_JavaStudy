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
			text = user.getUserName() + "���� �¸��ϼ̽��ϴ�.";
		}
		else {
			user.addLooseTime();
			text = user.getUserName() + "���� �й��ϼ̽��ϴ�.";
		}
		this.game.add(baseball);
		Main.BroadCastAllUser(text);
		Main.orderRead(user.getUserName(), "���ӹ�ȣ \'" +baseball.getGameNo() +"\' �� ��ϵǾ����ϴ�.");
	}
	
	public void printAllGame(User user) {
		for (BaseBall game : this.game) {
			Main.orderRead(user.getUserName(), game.toString());
		}
	}
}
