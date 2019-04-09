package PjtEx06;

public class MainClass {

	public static void main(String[] args) {

		String str = new String("안녕");
		str = str + " 하세요";
		System.out.println("str : " + str);
		
		System.out.println();
		
		// StringBuilder
		StringBuilder sd = new StringBuilder();
		sd.append("Java");
		sd.append("Program Study");
		System.out.println(sd.toString());
		
		sd.insert(4, "2");
		System.out.println(sd.toString());
		
		sd.setCharAt(4, '6');
		System.out.println(sd.toString());
		
		sd.replace(6, 13, "book");
		System.out.println(sd.toString());
		
		sd.delete(4, 5);
		System.out.println(sd.toString());
		
		
		System.out.println("총문자수 : " + sd.length());
		
	}
	
}
