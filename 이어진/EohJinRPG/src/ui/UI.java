package ui;

import java.util.HashMap;

public abstract class UI //implements UIInterface
{
	String strMenuName = "";												// 메뉴 명
	HashMap<Integer, String> mapOption = new HashMap<Integer, String>();	// 메뉴 선택지
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

	// 기본 UI 출력
	public void printDefaultUI()
	{
		printCurrentMenuName();
		printMenuOption();
	}

	// 현재 메뉴 명 출력
	void printCurrentMenuName() {
		System.out.println("================================================");
		System.out.println("   현재 메뉴 : " + strMenuName);		
	}
	
	// 선택지 조회
	void printMenuOption()
	{
		System.out.println("------------------------------------------------");
        for( int key : mapOption.keySet() ){
    		System.out.println("  -> " + key + ". " + mapOption.get(key));
        }
        System.out.print("  => 선택 옵션? : ");
	}
	
	// 옵션 선택지 설정
	abstract void setOption();
	
	abstract void exeUI() throws InterruptedException;
}
