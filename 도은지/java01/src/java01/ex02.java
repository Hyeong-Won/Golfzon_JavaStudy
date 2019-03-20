package java01;

import java.util.Scanner;

public class ex02 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		double height = 0;
		double weight = 0;
		double bmi = 0;
		
		System.out.println("키 입력 : ");
		height = scn.nextDouble();
		
		System.out.println("몸무게 입력 : ");
		weight = scn.nextDouble();
		
		scn.close();
		
		bmi = weight / (Math.pow((height*0.01), 2));
		
		System.out.printf("당신의 bmi : %.2f \n", bmi); //소수점 2자리
		
		if(bmi <= 18.5) {
			System.out.println("저체중");
		}else if(bmi < 25) {
			System.out.println("표준");
		}else if(bmi < 30) {
			System.out.println("과체중");
		}else {
			System.out.println("비만");
		}
		
	}
}
