package sphong_Ex002;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		//while문을 이용한 구구단
		System.out.print("숫자를 입력해주세요 : ");
		int num = scanner.nextInt();
		int i = 1;
		while (i < 10) {
			System.out.printf("%d * %d = %d\n", num, i, (num * i));
			i++;
		}
		
		//for 문을 이용한 구구단
		System.out.print("\n숫자를 입력해주세요 : ");
		int num1 = scanner.nextInt();  
		for(int j= 1; j < 10; j++) {
			System.out.printf("%d * %d = %d\n", num1, j, (num1 * j));
		}
		
		scanner.close();
	}

}
