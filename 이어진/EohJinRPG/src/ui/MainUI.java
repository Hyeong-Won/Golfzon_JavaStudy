package ui;

public class MainUI extends UI {
	
	public MainUI ()
	{
		setMenuName("Main");
		setMenuOption();
	}

	@Override
	public void setMenuOption() {
		mapOption.put(1, "전투");
		mapOption.put(2, "훈련");
		mapOption.put(3, "상태");
		mapOption.put(9, "종료");
	}
}
