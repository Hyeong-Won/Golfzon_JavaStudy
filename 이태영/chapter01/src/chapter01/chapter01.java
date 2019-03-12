package chapter01;

import java.util.Scanner;

public class chapter01 {
	public static void main(String[] args) {
		int intTotalCnt = 0;
		int intPosition  = 0;
		
		String strTargetText;		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요");
		
		strTargetText = scan.nextLine();
		intTotalCnt     = strTargetText.length();

		if(intTotalCnt == 0) {
			System.out.println("입력된 문자열 값이 없습니다\n");
			scan.close();
			return;
		}
		
		System.out.printf("입력된 문자열 : %s, 문자갯수(%d) \n" , strTargetText, intTotalCnt);		
		
		char[] array_word = new char[intTotalCnt];
		
		while(intPosition < intTotalCnt) {
			array_word[intPosition] = strTargetText.charAt(intPosition);
			intPosition = intPosition + 1;
		}
		
		System.out.println( array_word);		
		
		for(int i=0;i<array_word.length;i++) {
			System.out.println(  array_word[i]);
		}
		
		scan.close();
	}
}
