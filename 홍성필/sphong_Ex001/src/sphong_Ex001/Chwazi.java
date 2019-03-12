package sphong_Ex001;

import java.util.Random;
import java.util.Scanner;

public class Chwazi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();        //객체생성
		Scanner scn = new Scanner(System.in);//객체생성
		
		System.out.print("참가할 인원 수를 적어주세요 : ");		
		int Player = scn.nextInt();          //Player 변수에 참가자 수 입력
		String[] names = new String[Player]; //참가자 수 만큼 배열 생성
		
		System.out.println("참가자 이름 : ");
		Scanner name = new Scanner(System.in);
		
		for(int i=0; i < names.length; i++) { //참가자 수만큼 이름입력	
			names[i] = name.nextLine();
		}
		
		int LoserNo = random.nextInt(names.length);
		System.out.println("당첨자 ! : " + names[LoserNo]);
		
		scn.close();
		name.close();
	}

}
