package lec26Pjt001;

public class MainClass001 {

	public static void main(String[] args) {
		
		int i = 10;
		int j = 0;
		int r = 0;
		
		System.out.println("Ecexption BEFORE");
		
		try {
			r = i / j;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println("Exception: " + msg);
		}
		
		System.out.println("Ecexption AFTER");
		
	}
	
}
