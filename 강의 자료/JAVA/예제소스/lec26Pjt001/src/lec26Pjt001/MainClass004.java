package lec26Pjt001;

public class MainClass004 {

	public static void main(String[] args) {
		
		MainClass004 mainClass004 = new MainClass004();
		
		try {
			mainClass004.firstMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void firstMethod() throws Exception {
		secondMethod();
	}
	
	public void secondMethod() throws Exception {
		thirdMethod();
	}
	
	public void thirdMethod() throws Exception {
		System.out.println("10 / 0 = " + ( 10 / 0 ));
	}
	
}
