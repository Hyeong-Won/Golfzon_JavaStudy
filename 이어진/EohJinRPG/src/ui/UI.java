package ui;

import java.util.HashMap;

abstract class UI //implements UIInterface
{
	String strMenuName = "";												// �޴� ��
	HashMap<Integer, String> mapOption = new HashMap<Integer, String>();	// �޴� ������
			
	// set Menu Name
	void setMenuName(String strMenuName)
	{
		this.strMenuName = strMenuName; 
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
		System.out.println("   Current Menu : " + strMenuName);		
	}
	
	// ������ ��ȸ
	void printMenuOption()
	{
		System.out.println("------------------------------------------------");
        for( int key : mapOption.keySet() ){
    		System.out.println("  -> " + key + ". " + mapOption.get(key));
        }
        System.out.println("  => Insert Option Number : ");
	}
	
	// �ɼ� ������ ����
	abstract void setMenuOption();
}
