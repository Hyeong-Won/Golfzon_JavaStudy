package java03;

public class ImplementClass implements InterfaceA, InterfaceB{

	@Override
	public void funB() {
		System.out.println("funB");
	}

	@Override
	public void funA() {
		System.out.println("funA");
	}
}
