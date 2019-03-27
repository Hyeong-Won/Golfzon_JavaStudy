package PjtEx01;

public class MainClass {
	
	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
		
		child.parentFun();
		child.childFun();
		
		System.out.println("child.str : " + child.str);//부모클래스를 상속받았기때문에 사용가능
		//System.out.println("child.num : " + child.num); //private접근자 이므로 불가
		//child.parentPrivateFun(); //private접근자 이므로 불가
	}
	
}
