package PjtEx01;

public class MainClass01 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 0;
			
		try {
			int c = a / b;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println("Exception: " + msg);
		}
	}
	
}
