package main;

import java.util.Scanner;
import baseBallGame.BaseBallGame;

class Main 
{ 
	public static void main (String[] args)
	{
		Scanner s 				= new Scanner(System.in);
		BaseBallGame baseBall	= new BaseBallGame();

		// 스트라이크가 3이 될 때까지 check
		while (baseBall.chkStrikeCnt()) 
		{
			System.out.println("=====================================================");
			System.out.println(baseBall.addTryCnt() + "번째 도전! 숫자를 입력해주세요. :D");

			// 유저 숫자 입력
			baseBall.inputUserNum(s);
			
			// 결과 체크
			baseBall.checkResult();

			// 결과 출력
			baseBall.printResult();
			
			// 다음 체크를 위해 스트라이크, 볼 카운트 초기화
			baseBall.resetCnt();
		}
		
		s.close();
	}
}