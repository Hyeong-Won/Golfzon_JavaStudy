package java01;

import java.util.Scanner;

public class ex02 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		double height = 0;
		double weight = 0;
		double bmi = 0;
		
		System.out.println("Ű �Է� : ");
		height = scn.nextDouble();
		
		System.out.println("������ �Է� : ");
		weight = scn.nextDouble();
		
		scn.close();
		
		bmi = weight / (Math.pow((height*0.01), 2));
		
		System.out.printf("����� bmi : %.2f \n", bmi); //�Ҽ��� 2�ڸ�
		
		if(bmi <= 18.5) {
			System.out.println("��ü���Դϴ�");
		}else if(bmi < 25) {
			System.out.println("�����Դϴ�");
		}else if(bmi < 30) {
			System.out.println("��ü���Դϴ�");
		}else {
			System.out.println("���Դϴ�");
		}
		
	}
}
