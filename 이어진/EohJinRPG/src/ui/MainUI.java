package ui;

public class MainUI extends UI {
	
	public MainUI ()
	{
		setMenuName("Main");
		setMenuOption();
	}

	@Override
	public void setMenuOption() {
		mapOption.put(1, "����");
		mapOption.put(2, "�Ʒ�");
		mapOption.put(3, "����");
		mapOption.put(9, "����");
	}
}
