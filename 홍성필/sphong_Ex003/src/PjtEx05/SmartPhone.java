package PjtEx05;

public class SmartPhone extends Phone{ //추상클래스를 상속받아서 자식클래스생성

	public SmartPhone(String owner) {
		super(owner);
	}
	
	public void AppDown() {
		System.out.println("앱을 다운받습니다.");
	}
}
