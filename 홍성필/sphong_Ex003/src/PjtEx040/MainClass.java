package PjtEx040;

public class MainClass {

	public static void main(String[] args) {
		
		InterfaceA ia = new ImplementClass();
		InterfaceB ib = new ImplementClass();
		InterfaceC ic = new ImplementClass();
		
		System.out.println("------------------------------");
		
		ia.funA();
		ib.funB();
		ic.funC();
		
	}
	
}
