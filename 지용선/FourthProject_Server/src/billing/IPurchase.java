package billing;

import common.User;

public interface IPurchase {
	public boolean purchaseItem(User user);
	public User getUser();
}
