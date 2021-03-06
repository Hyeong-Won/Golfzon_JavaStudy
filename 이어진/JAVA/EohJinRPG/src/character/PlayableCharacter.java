package character;

public class PlayableCharacter extends Character //implements PrintPlayerStat 
{
	// 싱글톤
	public static final PlayableCharacter PC = new PlayableCharacter("player");
    public static PlayableCharacter getInstance(){ return PC;}
    
	private int 	intMinimumHP;		// 최소 체력
	private int 	intStrength;		// 힘
	private int		intIntelligence;	// 지능
	private int		intAgility;			// 민첩
	private int		intPlayPoint;		// 행동력

	// 생성자
	
	private PlayableCharacter (String strName)
	{
		setPlayableCharacter (strName);
		
		//System.out.println("PlayableCharacter (name);");
	}

	// 플레이어 기본 값 세팅
	private void setPlayableCharacter ()
	{
		intMinimumHP	= CharacterModule.DEFAULT_MINIMUM_HP;
		intStrength 	= 0;
		intIntelligence = 0;
		intAgility 		= 0;
		intPlayPoint	= CharacterModule.DEFAULT_MAX_PLAY_POINT;
		
		//System.out.println("setPlayableCharacter ();");
	}

	// get Strength
	public int getStr() {
		return intStrength;
	}
	
	// add Strength
	public int addStr(int intRequiredHP)
	{
		intHP -= intRequiredHP; 
		return ++intStrength;
	}

	// get Intelligence
	public int getInt() {
		return intIntelligence;
	}
	
	// add Intelligence
	public int addInt(int intRequiredHP)
	{
		intHP -= intRequiredHP;
		return ++intIntelligence;
	}

	// get Agility
	public int getAgi() {
		return intAgility;
	}
	
	// add Agility
	public int addAgi(int intRequiredHP)
	{
		intHP -= intRequiredHP;
		return ++intAgility;
	}

	private void setPlayableCharacter (String strName)
	{
		this.strName = strName;
		
		setPlayableCharacter ();
		
		//System.out.println("setPlayableCharacter (" + this.name + ");");
	}
	
	// 플레이어 스탯 출력
	public void printPlayableCharacterStat()
	{
		System.out.printf("================================================\n");
		System.out.printf("   플레이어 상태\n");
		System.out.printf("------------------------------------------------\n");
		System.out.printf(" Name : %s\n", this.strName);
		System.out.printf(" HP   : %4d / %4d (current / min)\n", this.intHP, this.intMinimumHP);
		System.out.printf(" Str  : %4d | Int  : %4d | Agi  : %4d\n", this.intStrength, this.intIntelligence, this.intAgility);
		System.out.printf(" Crit : %3d%% | Dod  : %3d%% | Spd  : %4dms\n", getCrit()/100, getDod()/100, getSpd());
		System.out.printf(" PP   : %4d point\n", this.intPlayPoint);
	}
	
	// add HP
	public void addHP(int intRewardHP)
	{
		intHP += intRewardHP;
	}
}
