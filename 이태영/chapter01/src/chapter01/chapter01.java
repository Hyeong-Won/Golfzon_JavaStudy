package chapter01;

import java.util.Scanner;

public class chapter01 {
	public static void main(String[] args) {
		/*
		int intTotalCnt = 0;
		int intPosition  = 0;
		
		String strTargetText;		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("���ڿ��� �Է��ϼ���");
		
		strTargetText = scan.nextLine();
		intTotalCnt     = strTargetText.length();

		if(intTotalCnt == 0) {
			System.out.println("�Էµ� ���ڿ� ���� �����ϴ�\n");
			scan.close();
			return;
		}
		
		System.out.printf("�Էµ� ���ڿ� : %s, ���ڰ���(%d) \n" , strTargetText, intTotalCnt);		
		
		char[] array_word = new char[intTotalCnt];
		
		while(intPosition < intTotalCnt) {
			array_word[intPosition] = strTargetText.charAt(intPosition);
			intPosition = intPosition + 1;
		}
		
		//�迭 ��ü �� ���
		System.out.println( array_word);		
		
		//�迭 ��� �� ���
		for(int i=0;i<array_word.length;i++) {
			System.out.println(  array_word[i]);
		}
		
		scan.close();
		*/
		
		//�������� ���ϸ���� �����Դ� ġ��!
		//�׷��� String �迭 ����� String[] arrFileList �� String arrFileList[] �� � �������� �ִ���?
		int intMatchedCnt = 0;
		
		String[] arrFileList = {"filelist1.txt","filelist2.csv","filelist3.txt","filelist4.csv","filelist5.txt"};
		
		for(int i=0;i < arrFileList.length;i++) {
			
			// split �Լ��� ���ڴ� ���Խ��̴�.  �޸��� ��� ���Խ� ǥ������ �������� �ѱ��ڸ� �ǹ�
			// ���� �޸��� \\ �� �ٿ��� �Ѵ�.
			String[] arrFilename = arrFileList[i].split("\\.");
			
			// csv Ȯ���ڸ� ī��Ʈ�Ͽ� ��� ����ϱ�
			if(arrFilename[1].equalsIgnoreCase("csv")) {
				intMatchedCnt = intMatchedCnt + 1;
				System.out.println(arrFileList[i]);
			}								
		}
		
		System.out.printf("�߰ߵ� csv ���� �� ����(%d)", intMatchedCnt);

	}
}
