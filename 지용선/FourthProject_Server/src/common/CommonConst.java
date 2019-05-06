package common;

import java.io.Serializable;

import billing.Item;

public class CommonConst implements Serializable {

	private static final long serialVersionUID = 1L;

	// 공통 상태(캐시, 보유아이템)
	public static enum UseState{ 정상, 취소, 회수, 사용 };
	
	// 공통 메뉴
	public final static int USERREGIST    = 1;
	public final static int BILLING       = 1;
	public final static int GAME          = 2;
	public final static int SHOWALLUSER   = 3;
	public final static int SHOWALLGAME   = 4;
	
	// 빌링 메뉴
	public final static int CASHINS       = 1;
	public final static int CASHREFUND    = 2;
	public final static int SHOWALLCASH   = 3;
	public final static int SHOWALLITEM   = 4;
	public final static int PURCHASEITEM  = 5;
	public final static int PURCHASEHIST  = 6;
	public final static int TERMINATECODE = 99;
	
	// 아이템 관련 하드코딩
	public final static int VOUCHERITEMCODE = 2222;
	public final static int TICKETITEMCODE  = 1111;
	
	public static Item[] allItem = 
	{ new Item(VOUCHERITEMCODE, 3000, "게임이용권")
	 ,new Item(TICKETITEMCODE,  1000, "야구게임힌트1회권")};
	
	// 동작 구분
	public final static String ORDER_READ      = "1";
	public final static String ORDER_WRITE     = "2";
	public final static String ORDER_TERMINATE = "3";
	public final static String ORDER_DELEMETER = "^";
	
}
