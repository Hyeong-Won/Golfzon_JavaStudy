package java04;

public class ExceptionMain03 {
	public static void main(String[] args) {
	
		ExceptionMain03 em = new ExceptionMain03();
		
		try {
			em.firstMethod();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void firstMethod() throws Exception {
		secondMethod();
	}

	public void secondMethod() throws Exception {
		thirdMethod();
	}

	public void thirdMethod() throws Exception {
		System.out.println("10 / 0 = " + ( 10 / 0 ));
	}

}
