package lec20Pjt001;

public class MainClass {

	public static void main(String[] args) {
		
		OuterClass oc = new OuterClass();
		System.out.println("oc.num : " + oc.num);
		System.out.println("oc.str1 : " + oc.str1);
		
		System.out.println();
		
		// ��� inner Ŭ����
		OuterClass.InnerClass in = oc.new InnerClass();
		System.out.println("in.num : " + in.num);
		System.out.println("in.str2 : " + in.str2);
		
		System.out.println();
		
		// static inner Ŭ����
		OuterClass.SInnerClass si = new OuterClass.SInnerClass();
		System.out.println("si.num : " + si.num);
		System.out.println("si.str3 : " + si.str3);
		
		System.out.println();
		
		// �͸�(anonymous) Ŭ����
		new AnonymousClass() {
			
			@Override
			public void method() {
				System.out.println(" -- AnonymousClass's Override method START -- ");
			};
		}.method();
	
	}

}
