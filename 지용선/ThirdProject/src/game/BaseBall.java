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
	int[] 	baseBallNum = {0, 0, 0};	// ������ϴ� �迭	
	int[] 	userNum	 	= {0, 0, 0};	// ���� �Է� �迭
	int 	strikeCnt	= 0; 			// ��Ʈ����ũ ī��Ʈ ��
	int 	ballCnt		= 0; 			// �� ī��Ʈ ��
	int 	tryCnt		= 0; 			// ���� Ƚ��
	int     MaxTryCnt   = 5;           // �ִ� ����Ƚ��
	int     retry        = 1;		    // �ٽ� ���� YN
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
			// �⺻ �� ����
		Random random = new Random();
	
		for (int i=0; i < baseBallNum.length; i++)
		{
			int temp = random.nextInt(9) + 1;
	
			// ���� ���� ������ �ʾ��� ������ ���� ������
			while(chkDuplication(temp, i, baseBallNum))
			{
				temp = random.nextInt(9) + 1;
			}
			baseBallNum[i] = temp;
		}
	
		// ��Ʈ����ũ�� 3�� �� ������ check
		while (strikeCnt < 3 && tryCnt < MaxTryCnt) 
		{
			System.out.println("=====================================================");
			System.out.println(++tryCnt + "��° ����! ���ڸ� �Է����ּ���. :D");
	
			// ���� �Է�
			for (int i = 0; i < userNum.length; i++) 
			{
				printUI(i);
	
				// 1 ~ 9�� ���� �Է� ����
				while (userNum[i] >= 10 || userNum[i] <= 0) 
				{
					System.out.println("1 ~ 9�� ���� �Է� �����մϴ�. :(");
					printUI(i);
				}
	
				// ������ �Է��ߴ� ���� �Է� �Ұ���
				while (chkDuplication(userNum[i], i, userNum)) 
				{
					System.out.println("�̹� �Է��� �����Դϴ�. :(");
					printUI(i);
				}
			}
	
			// ��� üũ
			for (int i = 0; i < 3; i++) 
			{
				for (int j = 0; j < 3; j++) 
				{
					if (baseBallNum[i] == userNum[j])
					{
						// ���� ���� ������ ������ ��Ʈ����ũ
						if (i == j)
						{
							strikeCnt++;
						}
	
						// ���� ���� ������ �ٸ��� ��
						else
						{
							ballCnt++;
						}
					}
				}
			}
	
			// ��� ���
			System.out.println("<< " + tryCnt + "��° ���� ��� >>");
	
			// 3�� �� ���߸� �¸�
			if (strikeCnt == 3)
			{
				System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
				System.out.println("*     ��!!! ��!!!!! XD      *");
				System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
				strikeCnt = tryCnt = 0;
				return true;
			}
			else
			{
				System.out.println(strikeCnt == 0 ? (ballCnt == 0 ? "�ƿ�!!!!!!! ^0^��������" : ballCnt + " ��!") : (ballCnt == 0 ? strikeCnt + " ��Ʈ����ũ!" : ballCnt + " ��! / " + strikeCnt + " ��Ʈ����ũ!"));
			}
			
			while(tryCnt == MaxTryCnt) {
				System.out.println("1. �ٽõ���(õ�� ����) 2. ����");
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
			// ���� üũ�� ���� �ٽ� �ʱ�ȭ
			strikeCnt = ballCnt = 0;
		}
		System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
		System.out.println("*     ��!!! ��!!!!! -_-     *");
		System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
		
		
		return false;
	}
	
	// ���� �ߺ� üũ �Լ�
	private boolean chkDuplication (int num, int idx, int[] chkOjb)
	{
		for(int i=0; i<idx; i++)
			if (chkOjb[i] == num)
				return true;
		return false;
	}

	// ����� �Է� UI ��� �Լ�
	private void printUI (int num)
	{
		System.out.print(num + 1 + "��° �� : ");
		userNum[num] = s.nextInt();
	}
	
	@Override
	public String toString() {
		String result = null;
		if(this.result) {
			result = "�¸�";
		}
		else {
			result = "�й�";
		}
		return "���ӹ�ȣ : " + gameNo + " ����� : " + user.getUserName() + " ���Ӱ�� : " + result + " ���ӽ����� : " + regDate;
	}
}
