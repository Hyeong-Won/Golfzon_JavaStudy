package ui;

public class BattleUI extends UI {

	public BattleUI ()
	{
		setMenuName("����");
		setOption();
	}

	@Override
	public void setOption() {
		mapOption.put(1, "����");
		mapOption.put(2, "�߻�");
		mapOption.put(9, "������");
	}
}
