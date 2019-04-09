package PjtEx040;

public class ImplementClass implements InterfaceA, InterfaceB, InterfaceC{ //extends는 다중 x implements는 다중가능

	public ImplementClass() {
		System.out.println("ImplementClass 생성");
	}
	
	@Override
	public void funA() {
		System.out.println(" -- funA go --");
	}
	
	@Override
	public void funB() {
		System.out.println(" -- funB go --");
	}

	@Override
	public void funC() {
		System.out.println(" -- funD go --");
	}
	
}
