package sphong_Ex002;

import java.util.Scanner;
 

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int user = 0; //변수 초기화선언
		
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("가위 바위 보 게임 !!!");
		
				
		do {				
			System.out.println("1.가위 | 2.바위 | 3.보 | 4.기권");
			System.out.print("무엇을 낼 것인지 입력해주세요. -> ");
			user= scn.nextInt(); //입력
			
			System.out.print("당신이 선택한 것은 : ");
			
			switch(user) { 
			case 1: System.out.println("가위");
			break;
			case 2: System.out.println("바위");
			break;
			case 3: System.out.println("보");
			}
			
			int com=(int)(Math.random()*3+1); //정수형태로 형변환			
			
			System.out.print("컴퓨터가 선택한 것은 :");
			switch(com) {
			case 1: System.out.println("가위");
			break;
			case 2: System.out.println("바위");
			break;
			case 3: System.out.println("보");
			}
			if(user==com) {
				System.out.println("무승부");
			}else if(user==1) {
				switch(com) {
				case 2: System.out.println("컴퓨터 승리");
				case 3: System.out.println("당신이 승리");
				}
			}else if(user==2) {
				switch(com) {
				case 1: System.out.println("당신이 승리");
				case 3: System.out.println("컴퓨터 승리");
				}
			}
			else if(user==3) {
				switch(com) {
				case 1: System.out.println("컴퓨터 승리");
				case 2: System.out.println("당신이 승리");
				}
			}
			else if(user==4) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			else {
				System.out.println("잘못입력");
			}
		}while(!(user==4)); //user가 기권아닐경우 진행
	}

}
