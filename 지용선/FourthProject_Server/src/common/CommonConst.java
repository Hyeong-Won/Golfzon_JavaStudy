package common;

import java.io.Serializable;

import billing.Item;

public class CommonConst implements Serializable {

	private static final long serialVersionUID = 1L;

	// ���� ����(ĳ��, ����������)
	public static enum UseState{ ����, ���, ȸ��, ��� };
	
	// ���� �޴�
	public final static int USERREGIST    = 1;
	public final static int BILLING       = 1;
	public final static int GAME          = 2;
	public final static int SHOWALLUSER   = 3;
	public final static int SHOWALLGAME   = 4;
	
	// ���� �޴�
	public final static int CASHINS       = 1;
	public final static int CASHREFUND    = 2;
	public final static int SHOWALLCASH   = 3;
	public final static int SHOWALLITEM   = 4;
	public final static int PURCHASEITEM  = 5;
	public final static int PURCHASEHIST  = 6;
	public final static int TERMINATECODE = 99;
	
	// ������ ���� �ϵ��ڵ�
	public final static int VOUCHERITEMCODE = 2222;
	public final static int TICKETITEMCODE  = 1111;
	
	public static Item[] allItem = 
	{ new Item(VOUCHERITEMCODE, 3000, "�����̿��")
	 ,new Item(TICKETITEMCODE,  1000, "�߱�������Ʈ1ȸ��")};
	
	// ���� ����
	public final static String ORDER_READ      = "1";
	public final static String ORDER_WRITE     = "2";
	public final static String ORDER_TERMINATE = "3";
	public final static String ORDER_DELEMETER = "^";
	
}
