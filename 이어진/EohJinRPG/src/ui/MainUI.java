package ui;

public class MainUI extends UI {
	
	public MainUI ()
	{
		setMenuName("����");
		setOption();
	}

	@Override
	public void setOption() {
		mapOption.put(1, "����");
		mapOption.put(2, "�Ʒ�");
		mapOption.put(3, "����");
		mapOption.put(9, "����");
	}
}
