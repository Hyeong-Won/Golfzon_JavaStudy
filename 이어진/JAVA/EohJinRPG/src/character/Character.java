package character;

public class Character {	
	protected String 	strName;			// 이름
	protected int 		intHP;				// 현재 보유 체력
	protected int 		intMinimumHP;		// 현재 최소 체력
	protected int 		intMaximumHP;		// 현재 최대 체력
	protected int		intPhysicalDamage;	// 물리 데미지
	
	//protected int		intMagicalDamage;	// 마법 데미지	
	//protected int		intPhysicalAttack;	// 물리 데미지 증가율 	: 퍼밀리아드(1/10000)
	//protected int		intMagicAttack;		// 마법 데미지 증가율 	: 퍼밀리아드(1/10000)
	protected int		intCritical;		// 크리티컬 확률 		: 퍼밀리아드(1/10000)
	protected int		intDodge;			// 회피율 				: 퍼밀리아드(1/10000)
	
	protected int		intAttackSpeed;		// 공격 속도 			: 밀리 초 (1/1000초)
	
	// 스킬
	// 개발 전
	
	// 생성자
	Character ()
	{
		intHP				= CharacterModule.DEFAULT_HP;
		intPhysicalDamage	= CharacterModule.DEFAULT_PHYSICAL_DAMAGE;
		//intMagicalDamage	= CharacterModule.DEFAULT_MAGICAL_DAMAGE;
		intMinimumHP		= CharacterModule.DEFAULT_MINIMUM_HP;
		
		//intPhysicalAttack 	= 0;
		//intMagicAttack 		= 0;
		intCritical 		= 0;
		intDodge 			= 0;
		intAttackSpeed 		= CharacterModule.DEFAULT_ATTACK_SPEED;
		
		//System.out.println("Character ();");
	}
	
	// get Critical
	public int getCrit()
	{
		return intCritical;
	}
	
	// get Dodge
	public int getDod()
	{
		return intDodge;
	}
	
	// get AttackSpeed
	public int getSpd()
	{
		return intAttackSpeed;
	}

	// get PhysicalDamage
	public int getPD()
	{
		return intPhysicalDamage;
	}

	// get HP
	public int getHP()
	{
		return intHP;
	}

	// get Usable HP
	public int getUsableHP()
	{
		return intHP - intMinimumHP;
	}

	// set Minimum HP (자동 계산)
	public void setMinimumHP()
	{
		
	}
	
	// get Name
	public String getName()
	{
		return strName;
	}
	
	/*
	// attack
	public int Attack()
	{
		System.out.printf("%s의 공격, %d의 피해를 입혔다.\n", this.strName, this.intPhysicalDamage);
		return intPhysicalDamage;
	}
	*/
}
