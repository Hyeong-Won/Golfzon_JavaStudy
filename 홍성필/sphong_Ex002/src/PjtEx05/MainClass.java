package PjtEx05;

public class MainClass {

	public static void main(String[] args) {
		
		ObjectEx obj1 = new ObjectEx();
		
		System.out.println();
		
		ObjectEx obj2 = new ObjectEx(10);
		
		int arr[] = {10, 20, 30};
		ObjectEx obj3 = new ObjectEx("Java", arr);
		
		
		ObjectEx obj4; 
		
		obj4 = new ObjectEx();
		obj4 = new ObjectEx();
		
		System.gc();
		
		int ints[] = {10, 20, 30};
		ObjectEx obj5 = new ObjectEx(10, "Java", ints); 
	}

}
