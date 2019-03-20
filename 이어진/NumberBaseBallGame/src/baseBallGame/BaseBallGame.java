package baseBallGame;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
	int[] 	baseBallNum = {0, 0, 0};	// 맞춰야하는 배열	
	int[] 	userNum	 	= {0, 0, 0};	// 유저 입력 배열
	int 	strikeCnt	= 0; 			// 스트라이크 카운트 수
	int 	ballCnt		= 0; 			// 볼 카운트 수
	int 	tryCnt		= 0; 			// 도전 횟수
	
	// 생성자에 컴퓨터 숫자 세팅 추가
	public BaseBallGame ()
	{
		System.out.println("BaseBallGame();");
		
		initialize();
	}
	
	private void initialize ()
	{
		// 기본 값 세팅
		Random random 	= new Random();

		for (int i=0; i < baseBallNum.length; i++)
		{
			int temp = random.nextInt(9) + 1;

			// 이전 값이 나오지 않았을 때까지 랜덤 돌리기
			while(chkDuplication(temp, i, baseBallNum))
			{
				temp = random.nextInt(9) + 1;
			}
			baseBallNum[i] = temp;
		}
		
		// Cnt 초기화
		strikeCnt 	= 0;
		ballCnt 	= 0;
		tryCnt 		= 0;
	}
	
	// 스트라이크 카운트 체크 함수 (3이상이면 true)
	public boolean chkStrikeCnt ()
	{
		if(strikeCnt < 3)
			return true;
		return false;
	}

	// 숫자 중복 체크 함수
	public static boolean chkDuplication (int num, int idx, int[] chkOjb)
	{
		for(int i=0; i<idx; i++)
			if (chkOjb[i] == num)
				return true;
		return false;
	}

	// 사용자 입력 UI 출력 함수
	public void printUI (int num, Scanner s)
	{
		System.out.print(num + 1 + "번째 수 : ");
		userNum[num] = s.nextInt();
	}

	// 시도 횟수 + 1 함수
	public void addTryCnt ()
	{
		tryCnt++;
	}

	// 시도 횟수 Get 함수
	public int getTryCnt ()
	{
		return tryCnt;
	}
	
	// 유저 번호 입력 함수
	public void inputUserNum (Scanner s)
	{
		// 숫자 입력
		for (int i = 0; i < userNum.length; i++) 
		{
			printUI(i, s);

			// 1 ~ 9의 수만 입력 가능
			while (userNum[i] >= 10 || userNum[i] <= 0) 
			{
				System.out.println("1 ~ 9의 수만 입력 가능합니다. :(");
				printUI(i, s);
			}

			// 이전에 입력했던 수는 입력 불가능
			while (chkDuplication(userNum[i], i, userNum)) 
			{
				System.out.println("이미 입력한 숫자입니다. :(");
				printUI(i, s);
			}
		}
	}
	
	// 숫자 체크 함수
	public void checkResult ()
	{
		// 결과 체크
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				if (baseBallNum[i] == userNum[j])
				{
					// 값이 같고 순서도 같으면 스트라이크
					if (i == j)
					{
						strikeCnt++;
					}

					// 값이 같고 순서가 다르면 볼
					else
					{
						ballCnt++;
					}
				}
			}
		}
	}
	
	// 결과 출력 함수
	public void printResult ()
	{
		// 결과 출력
		System.out.println("<< " + tryCnt + "번째 도전 결과 >>");

		// 3개 다 맞추면 승리
		if (strikeCnt == 3)
		{
			System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
			System.out.println("*     승!!! 리!!!!! XD      *");
			System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
			
			// 승리 이후 필요한 값들 다시 리셋
			initialize();
		}
		else
		{
			System.out.println(strikeCnt == 0 ? (ballCnt == 0 ? "아웃!!!!!!! ^0^ㅋㅋㅋㅋ" : ballCnt + " 볼!") : (ballCnt == 0 ? strikeCnt + " 스트라이크!" : ballCnt + " 볼! / " + strikeCnt + " 스트라이크!"));
		}	
	}

	// 스트라이크, 볼 카운트 초기화 함수
	public void resetCnt()
	{
		strikeCnt 	= 0;
		ballCnt 	= 0;
	}
}
