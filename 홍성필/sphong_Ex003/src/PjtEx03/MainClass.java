package PjtEx03;

public class MainClass {

	public static void main(String[] args) {
		
		OuterClass oc = new OuterClass(); //객체생성
		System.out.println("oc.num : " + oc.num);
		System.out.println("oc.str1 : " + oc.str1);
		
		System.out.println();
		
		OuterClass.InnerClass in = oc.new InnerClass(); //OuterClass의 InnerClass 객체생성
		System.out.println("in.num : " + in.num); //InnerClass의 속성에 접근
		System.out.println("in.str2 : " + in.str2);
		
		System.out.println();
		
		OuterClass.SInnerClass si = new OuterClass.SInnerClass(); //Static Inner Class 객체 생성
		System.out.println("si.num : " + si.num);
		System.out.println("si.str3 : " + si.str3);
		
		System.out.println();
		
		new AnonymousClass() { 
			
			@Override
			public void method() {
				System.out.println(" -- AnonymousClass's Override method START -- ");
			};
		}.method();
	
	}

}
