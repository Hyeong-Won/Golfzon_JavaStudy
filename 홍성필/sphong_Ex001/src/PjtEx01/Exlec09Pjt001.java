package PjtEx01;

import java.util.Scanner;

public class Exlec09Pjt001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputNum = new Scanner(System.in);
		
		System.out.println("수학과 영어의 점수를 입력하세요");
		int mathscore = inputNum.nextInt();
		int engscore = inputNum.nextInt();
		
		
		
		if(mathscore > engscore) { //수학점수가 영어점수보다 높은경우
			System.out.printf("수학점수보다 영어점수가 %d점 높습니다. ", mathscore-engscore);
		}
		else if(engscore > mathscore) { //영어점수보다 수학점수가 높은경우
			System.out.printf("영어점수가 수학점수보다 %d점 높습니다.",engscore-mathscore);
		}
		else { //점수가 같은경우
			System.out.println("점수가 같습니다.");
		}
	}
}
