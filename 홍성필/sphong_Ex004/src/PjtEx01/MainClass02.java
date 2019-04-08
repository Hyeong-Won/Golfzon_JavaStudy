package PjtEx01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass02 {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int a, b;
		ArrayList<String> list = null;
		
		int[] iArr = {0, 1, 2, 3, 4};
				
		try {
			
			System.out.println("input a : ");
			a = scanner.nextInt();
			System.out.println("input b : ");
			b = scanner.nextInt();
			
			System.out.println("a / b = " + ( a / b));
			
			for (int k = 0; k < 6; k++) {
				System.out.println("iArr["+ k + "] : " + iArr[k]);
			}
			
			System.out.println("list.size() : " + list.size());
			
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("무조건 실행 되는 부분");
		}
				
	}
	
}
