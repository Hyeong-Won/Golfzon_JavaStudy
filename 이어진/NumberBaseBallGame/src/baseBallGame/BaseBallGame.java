package baseBallGame;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
	int[] 	baseBallNum = {0, 0, 0};	// ������ϴ� �迭	
	int[] 	userNum	 	= {0, 0, 0};	// ���� �Է� �迭
	int 	strikeCnt	= 0; 			// ��Ʈ����ũ ī��Ʈ ��
	int 	ballCnt		= 0; 			// �� ī��Ʈ ��
	int 	tryCnt		= 0; 			// ���� Ƚ��
	
	// �����ڿ� ��ǻ�� ���� ���� �߰�
	public BaseBallGame ()
	{
		System.out.println("BaseBallGame();");
		
		initialize();
	}
	
	private void initialize ()
	{
		// �⺻ �� ����
		Random random 	= new Random();

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
		
		// Cnt �ʱ�ȭ
		strikeCnt 	= 0;
		ballCnt 	= 0;
		tryCnt 		= 0;
	}
	
	// ��Ʈ����ũ ī��Ʈ üũ �Լ� (3�̻��̸� true)
	public boolean chkStrikeCnt ()
	{
		if(strikeCnt < 3)
			return true;
		return false;
	}

	// ���� �ߺ� üũ �Լ�
	public static boolean chkDuplication (int num, int idx, int[] chkOjb)
	{
		for(int i=0; i<idx; i++)
			if (chkOjb[i] == num)
				return true;
		return false;
	}

	// ����� �Է� UI ��� �Լ�
	public void printUI (int num, Scanner s)
	{
		System.out.print(num + 1 + "��° �� : ");
		userNum[num] = s.nextInt();
	}

	// �õ� Ƚ�� + 1 �Լ�
	public void addTryCnt ()
	{
		tryCnt++;
	}

	// �õ� Ƚ�� Get �Լ�
	public int getTryCnt ()
	{
		return tryCnt;
	}
	
	// ���� ��ȣ �Է� �Լ�
	public void inputUserNum (Scanner s)
	{
		// ���� �Է�
		for (int i = 0; i < userNum.length; i++) 
		{
			printUI(i, s);

			// 1 ~ 9�� ���� �Է� ����
			while (userNum[i] >= 10 || userNum[i] <= 0) 
			{
				System.out.println("1 ~ 9�� ���� �Է� �����մϴ�. :(");
				printUI(i, s);
			}

			// ������ �Է��ߴ� ���� �Է� �Ұ���
			while (chkDuplication(userNum[i], i, userNum)) 
			{
				System.out.println("�̹� �Է��� �����Դϴ�. :(");
				printUI(i, s);
			}
		}
	}
	
	// ���� üũ �Լ�
	public void checkResult ()
	{
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
	}
	
	// ��� ��� �Լ�
	public void printResult ()
	{
		// ��� ���
		System.out.println("<< " + tryCnt + "��° ���� ��� >>");

		// 3�� �� ���߸� �¸�
		if (strikeCnt == 3)
		{
			System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
			System.out.println("*     ��!!! ��!!!!! XD      *");
			System.out.println("*:*:*:*:*:*:*:*:*:*:*:*:*:*:*");
			
			// �¸� ���� �ʿ��� ���� �ٽ� ����
			initialize();
		}
		else
		{
			System.out.println(strikeCnt == 0 ? (ballCnt == 0 ? "�ƿ�!!!!!!! ^0^��������" : ballCnt + " ��!") : (ballCnt == 0 ? strikeCnt + " ��Ʈ����ũ!" : ballCnt + " ��! / " + strikeCnt + " ��Ʈ����ũ!"));
		}	
	}

	// ��Ʈ����ũ, �� ī��Ʈ �ʱ�ȭ �Լ�
	public void resetCnt()
	{
		strikeCnt 	= 0;
		ballCnt 	= 0;
	}
}
