package ui;

public class TrainingUI extends UI {
	public TrainingUI ()
	{
		setMenuName("�Ʒ�");
		setOption();
	}

	@Override
	void setOption() {
		mapOption.put(1, "��");
		mapOption.put(2, "����");
		mapOption.put(3, "��ø");
		mapOption.put(9, "������");
	}
}
