package character;

public class Character {	
	protected String 	strName;			// �̸�
	protected int 		intHP;				// ���� ���� ü��
	protected int 		intMinimumHP;		// ���� �ּ� ü��
	protected int 		intMaximumHP;		// ���� �ִ� ü��
	protected int		intPhysicalDamage;	// ���� ������
	
	//protected int		intMagicalDamage;	// ���� ������	
	//protected int		intPhysicalAttack;	// ���� ������ ������ 	: �۹и��Ƶ�(1/10000)
	//protected int		intMagicAttack;		// ���� ������ ������ 	: �۹и��Ƶ�(1/10000)
	protected int		intCritical;		// ũ��Ƽ�� Ȯ�� 		: �۹и��Ƶ�(1/10000)
	protected int		intDodge;			// ȸ���� 				: �۹и��Ƶ�(1/10000)
	
	protected int		intAttackSpeed;		// ���� �ӵ� 			: �и� �� (1/1000��)
	
	// ��ų
	// ���� ��
	
	// ������
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

	// set Minimum HP (�ڵ� ���)
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
		System.out.printf("%s�� ����, %d�� ���ظ� ������.\n", this.strName, this.intPhysicalDamage);
		return intPhysicalDamage;
	}
	*/
}
