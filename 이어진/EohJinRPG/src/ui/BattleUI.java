package ui;

public class BattleUI extends UI {

	public BattleUI ()
	{
		setMenuName("전투");
		setOption();
	}

	@Override
	public void setOption() {
		mapOption.put(1, "수련");
		mapOption.put(2, "야산");
		mapOption.put(9, "나가기");
	}
}
