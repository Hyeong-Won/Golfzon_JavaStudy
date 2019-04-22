package lec10Pjt001;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		// for문
		System.out.print("INPUT NUMBER : ");
		Scanner scanner = new Scanner(System.in);
		int inputNum = scanner.nextInt();
		
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n", inputNum, i, (inputNum * i));
		}
		
		System.out.println();
		
		// while문
		System.out.print("INPUT NUMBER : ");
		int num = scanner.nextInt();
		int i = 1;
		while (i < 10) {
			System.out.printf("%d * %d = %d\n", num, i, (num * i));
			i++;
		}
		
		scanner.close();
		
		System.out.println();
		
		// do ~ while문
		do {
			System.out.println("무조건 1번은 실행합니다.");
		} while (false);
		

	}

}
