package lec18Pjt001;

public class ParentClass {
	
	public String str = "ParentClass";
	private int num = 10;
	
	public ParentClass() {
		
		System.out.println("ParentClass constructor");
		
	}
	
	public void parentFun() {
		
		System.out.println("-- parentFun() START -- ");
		
	}
	
	private void parentPrivateFun() {
		
		System.out.println("-- parentPrivateFun() START -- ");
		
	}

}
