package sphong_Ex001;

import java.util.Random;
import java.util.Scanner;

public class Chwazi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		Scanner scn = new Scanner(System.in);
		
		System.out.print("참가할 인원 수를 적어주세요 : ");		
		int Player = scn.nextInt();
		String[] names = new String[Player]; //참가자 수 만큼 배열 생성
		
		System.out.print("참가할 사람을 적어주세요  : ");
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
