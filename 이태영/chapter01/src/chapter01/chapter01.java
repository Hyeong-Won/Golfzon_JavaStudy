package chapter01;

import java.util.Scanner;

public class chapter01 {
	public static void main(String[] args) {
		/*
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
		
		//배열 전체 값 출력
		System.out.println( array_word);		
		
		//배열 요소 값 출력
		for(int i=0;i<array_word.length;i++) {
			System.out.println(  array_word[i]);
		}
		
		scan.close();
		*/
		
		//폴더에서 파일목록을 가져왔다 치고!
		//그런데 String 배열 선언시 String[] arrFileList 와 String arrFileList[] 는 어떤 차이점이 있는지?
		int intMatchedCnt = 0;
		
		String[] arrFileList = {"filelist1.txt","filelist2.csv","filelist3.txt","filelist4.csv","filelist5.txt"};
		
		for(int i=0;i < arrFileList.length;i++) {
			
			// split 함수의 인자는 정규식이다.  콤마의 경우 정규식 표현으로 무작위의 한글자를 의미
			// 따라서 콤마는 \\ 를 붙여야 한다.
			String[] arrFilename = arrFileList[i].split("\\.");
			
			// csv 확장자만 카운트하여 목록 출력하기
			if(arrFilename[1].equalsIgnoreCase("csv")) {
				intMatchedCnt = intMatchedCnt + 1;
				System.out.println(arrFileList[i]);
			}								
		}
		
		System.out.printf("발견된 csv 파일 총 개수(%d)", intMatchedCnt);

	}
}
