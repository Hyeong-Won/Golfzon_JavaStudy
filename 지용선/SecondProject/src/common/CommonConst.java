package common;

public class CommonConst {
	// 공통 상태(캐시, 보유아이템)
	public static enum UseState{ 정상, 취소, 회수, 사용 };
	
	// 공통 메뉴
	public final static int USERREGIST    = 1;
	public final static int BILLING       = 2;
	public final static int GAME          = 3;
	public final static int SHOWALLUSER   = 4;
	public final static int SHOWALLGAME   = 5;
	
	// 빌링 메뉴
	public final static int CASHINS       = 1;
	public final static int CASHREFUND    = 2;
	public final static int SHOWALLCASH   = 3;
	public final static int SHOWALLITEM   = 4;
	public final static int PURCHASEITEM  = 5;
	public final static int TERMINATECODE = 99;
	
	// 아이템 관련 하드코딩
	public final static int    ITEMCODE2222      = 2222;
	public final static int    ITEMCODE2222PIRCE = 3000;
	public final static String ITEMCODE2222NAME  = "게임이용권";
	
}
