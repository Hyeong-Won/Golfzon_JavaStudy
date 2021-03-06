package game;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import billing.BillingManager;
import billing.IItemUse;
import common.CommonConst;
import common.User;

public class BaseBall {
	private User user   = null;
	int[] 	baseBallNum = {0, 0, 0};	// 맞춰야하는 배열	
	int[] 	userNum	 	= {0, 0, 0};	// 유저 입력 배열
	int 	strikeCnt	= 0; 			// 스트라이크 카운트 수
	int 	ballCnt		= 0; 			// 볼 카운트 수
	int 	tryCnt		= 0; 			// 도전 횟수
	int     MaxTryCnt   = 5;           // 최대 도전횟수
	int     retry        = 1;		    // 다시 도전 YN
	Scanner s 			= new Scanner(System.in);
	
	private int        gameNo;
	private static int gamecnt;
	private String     regDate;
	private boolean    result;
	
	public boolean isResult() {
		return result;
	}

	public int getGameNo() {
		return gameNo;
	}

	public String getRegDate() {
		return regDate;
	}

	public BaseBall(User user) {
		this.user = user;
		Date             today = new Date();
		SimpleDateFormat ymd   = new SimpleDateFormat("yyyyMMdd");
		
		gamecnt++;
		
		this.gameNo  = gamecnt;
		this.regDate = ymd.format(today);
		
		result = start();
	}
	
	public boolean start() {
			// 기본 값 세팅
		Random random = new Random();
	
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
		while (strikeCnt < 3 && tryCnt < MaxTryCnt) 
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
				return true;
			}
			else
			{
				System.out.println(strikeCnt == 0 ? (ballCnt == 0 ? "아웃!!!!!!! ^0^ㅋㅋㅋㅋ" : ballCnt + " 볼!") : (ballCnt == 0 ? strikeCnt + " 스트라이크!" : ballCnt + " 볼! / " + strikeCnt + " 스트라이크!"));
			}
			
			while(tryCnt == MaxTryCnt) {
				System.out.println("1. 다시도전(천원 과금) 2. 종료");
				retry = s.nextInt();
				
				if(retry != 1) {
					break;
				}
				IItemUse itemUse = BillingManager.getItemUseMethod(CommonConst.TICKETITEMCODE);
				if(itemUse.useItem(this.user)) {
					MaxTryCnt++;
					break;
				}
				
			}
			// 다음 체크를 위해 다시 초기화
			strikeCnt = ballCnt = 0;
		}
		System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
		System.out.println("*     패!!! 배!!!!! -_-     *");
		System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
		
		
		return false;
	}
	
	// 숫자 중복 체크 함수
	private boolean chkDuplication (int num, int idx, int[] chkOjb)
	{
		for(int i=0; i<idx; i++)
			if (chkOjb[i] == num)
				return true;
		return false;
	}

	// 사용자 입력 UI 출력 함수
	private void printUI (int num)
	{
		System.out.print(num + 1 + "번째 수 : ");
		userNum[num] = s.nextInt();
	}
	
	@Override
	public String toString() {
		String result = null;
		if(this.result) {
			result = "승리";
		}
		else {
			result = "패배";
		}
		return "게임번호 : " + gameNo + " 사용자 : " + user.getUserName() + " 게임결과 : " + result + " 게임시작일 : " + regDate;
	}
}
