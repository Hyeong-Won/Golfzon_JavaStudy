package ui;

public class TrainingUI extends UI {
	public TrainingUI ()
	{
		setMenuName("ÈÆ·Ã");
		setOption();
	}

	@Override
	void setOption() {
		mapOption.put(1, "Èû");
		mapOption.put(2, "Áö´É");
		mapOption.put(3, "¹ÎÃ¸");
		mapOption.put(9, "³ª°¡±â");
	}
}
