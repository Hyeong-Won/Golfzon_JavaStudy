import java.util.Random;
import java.util.Scanner;

class BaseBall 
{ 
	static int[] 	baseBallNum 	= {0, 0, 0};	// 맞춰야하는 배열	
	static int[] 	userNum	 		= {0, 0, 0};	// 유저 입력 배열
	static int 		strikeCnt		= 0; 			// 스트라이크 카운트 수
	static int 		ballCnt			= 0; 			// 볼 카운트 수
	static int 		tryCnt			= 0; 			// 도전 횟수
	static Scanner 	s 				= new Scanner(System.in);

	public static void main (String[] args)
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

		// 스트라이크가 3이 될 때까지 check
		while (strikeCnt < 3) 
		{
			System.out.println("=====================================================");
			System.out.println(++tryCnt + "번째 도전! 숫자를 입력해주세요. :D");

			// 숫자 입력
			for (int i = 0; i < userNum.length; i++) 
			{
				printUI(i);

				// 1 ~ 9의 수만 입력 가능
				while (userNum[i] >= 10 || userNum[i] <= 0) 
				{
					System.out.println("1 ~ 9의 수만 입력 가능합니다. :(");
					printUI(i);
				}

				// 이전에 입력했던 수는 입력 불가능
				while (chkDuplication(userNum[i], i, userNum)) 
				{
					System.out.println("이미 입력한 숫자입니다. :(");
					printUI(i);
				}
			}

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

			// 결과 출력
			System.out.println("<< " + tryCnt + "번째 도전 결과 >>");

			// 3개 다 맞추면 승리
			if (strikeCnt == 3)
			{
				System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
				System.out.println("*     승!!! 리!!!!! XD      *");
				System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
				strikeCnt = tryCnt = 0;
			}
			else
			{
				System.out.println(strikeCnt == 0 ? (ballCnt == 0 ? "아웃!!!!!!! ^0^ㅋㅋㅋㅋ" : ballCnt + " 볼!") : (ballCnt == 0 ? strikeCnt + " 스트라이크!" : ballCnt + " 볼! / " + strikeCnt + " 스트라이크!"));
			}

			// 다음 체크를 위해 다시 초기화
			strikeCnt = ballCnt = 0;
		}
	}

	// 숫자 중복 체크 함수
	private static boolean chkDuplication (int num, int idx, int[] chkOjb)
	{
		for(int i=0; i<idx; i++)
			if (chkOjb[i] == num)
				return true;
		return false;
	}

	// 사용자 입력 UI 출력 함수
	private static void printUI (int num)
	{
		System.out.print(num + 1 + "번째 수 : ");
		userNum[num] = s.nextInt();
	}
}