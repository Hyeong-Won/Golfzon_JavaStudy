package main;

import java.util.Scanner;
import baseBallGame.BaseBallGame;

class Main 
{ 
	public static void main (String[] args)
	{
		Scanner s 				= new Scanner(System.in);
		BaseBallGame baseBall	= new BaseBallGame();

		// ��Ʈ����ũ�� 3�� �� ������ check
		while (baseBall.chkStrikeCnt()) 
		{
			System.out.println("=====================================================");
			System.out.println(baseBall.addTryCnt() + "��° ����! ���ڸ� �Է����ּ���. :D");

			// ���� ���� �Է�
			baseBall.inputUserNum(s);
			
			// ��� üũ
			baseBall.checkResult();

			// ��� ���
			baseBall.printResult();
			
			// ���� üũ�� ���� ��Ʈ����ũ, �� ī��Ʈ �ʱ�ȭ
			baseBall.resetCnt();
		}
		
		s.close();
	}
}