package lec15Pjt001;

public class MainClass {

	public static void main(String[] args) {
		
		// ����Ʈ ������
		ObjectEx obj1 = new ObjectEx();
		
		System.out.println();
		
		// ����� ���� ������
		ObjectEx obj2 = new ObjectEx(10);
		
		int arr[] = {10, 20, 30};
		ObjectEx obj3 = new ObjectEx("Java", arr);
		
		
		// �Ҹ���
		ObjectEx obj4; 
		
		obj4 = new ObjectEx();
		obj4 = new ObjectEx();
		
		System.gc();
		
		// this Ű����
		int ints[] = {10, 20, 30};
		ObjectEx obj5 = new ObjectEx(10, "Java", ints); 
	}

}
