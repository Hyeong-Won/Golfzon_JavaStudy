package java04;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain02 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int i,j;
		ArrayList<String> a = null;
		
		int iArr[] = {0,1,2,3,4};
		
		System.out.println("Exception BEFORE");
		
		try {

			System.out.println("input i : ");
			i = scn.nextInt();
			
			System.out.println("input j : ");
			j = scn.nextInt();

			System.out.println("i / j = " + ( i / j));

			for (int k = 0; k < 6; k++) {
				System.out.println("iArr["+ k + "] : " + iArr[k]);
			}

			System.out.println(a.size());

		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("항상실행");
		}

		System.out.println("Exception AFTER");
		
	}
}
