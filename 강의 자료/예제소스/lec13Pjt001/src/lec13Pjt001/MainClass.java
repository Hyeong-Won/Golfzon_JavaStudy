package lec13Pjt001;

public class MainClass {

	public static void main(String[] args) {
		
		ChildClass childClass = new ChildClass();
		
		String s = childClass.getS();
		System.out.println(" s : " + s);
		
		System.out.println();
		
		childClass.getInfo();
		childClass.getInfo(10, 20);
		childClass.getInfo("str1", "str2");
		
		System.out.println();
		
		childClass.methodPublic();

	}

}
