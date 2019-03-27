package java03;

public class LambdaMain {
	public static void main(String[] args) {
		LambdaInterfaceA li = (String s1, String s2) -> {System.out.println(s1 + "," + s2);};
		li.method("hi","bye");
		
		//타입 같을 때 생략 가능.
		LambdaInterfaceA li2 = (s1, s2) -> {System.out.println(s1 + "," + s2);};
		li2.method("hi","bye");
		
		//매개변수, 실행문 1개 일때 (),{} 생략가능.
		LambdaInterfaceB li3 = a -> System.out.println(a);
		li3.method(1);
	
		//반환값이 있는 경우
		LambdaInterfaceC li4 = (x,y) -> {
			int result = x+y;
			return result;
		};
		System.out.println(li4.method(1,10));
		
	}
}
