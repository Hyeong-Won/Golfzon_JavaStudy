package PjtEx01;

public class MainClass03 {

	public static void main(String[] args) {
		
		MainClass03 mainClass04 = new MainClass03();
		
		try {
			mainClass04.Method();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void Method() throws Exception {
		System.out.println("10 / 0 = " + ( 10 / 0 ));
	}
}
