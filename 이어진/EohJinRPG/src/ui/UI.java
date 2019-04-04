package ui;

import java.util.HashMap;

public abstract class UI //implements UIInterface
{
	String strMenuName = "";												// �޴� ��
	HashMap<Integer, String> mapOption = new HashMap<Integer, String>();	// �޴� ������
	int intOption = 0;
			
	// set Menu Name
	void setMenuName(String strMenuName)
	{
		this.strMenuName = strMenuName; 
	}
	// get Menu Name
	String getMenuName()
	{
		return this.strMenuName; 
	}

	// �⺻ UI ���
	public void printDefaultUI()
	{
		printCurrentMenuName();
		printMenuOption();
	}

	// ���� �޴� �� ���
	void printCurrentMenuName() {
		System.out.println("================================================");
		System.out.println("   ���� �޴� : " + strMenuName);		
	}
	
	// ������ ��ȸ
	void printMenuOption()
	{
		System.out.println("------------------------------------------------");
        for( int key : mapOption.keySet() ){
    		System.out.println("  -> " + key + ". " + mapOption.get(key));
        }
        System.out.print("  => ���� �ɼ�? : ");
	}
	
	// �ɼ� ������ ����
	abstract void setOption();
	
	abstract void exeUI() throws InterruptedException;
}
