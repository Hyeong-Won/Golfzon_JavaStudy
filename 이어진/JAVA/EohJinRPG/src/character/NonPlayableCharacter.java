package character;

public class NonPlayableCharacter extends Character {
	private int intRewardHP;

	// »ý¼ºÀÚ
	NonPlayableCharacter(String strName, int intHP, int intPhysicalDamage, int intCritical, int intDodge, 
								int intAttackSpeed, int intRewardHP)
	{
		this.strName 			= strName;
		this.intHP				= intHP;
		this.intPhysicalDamage 	= intPhysicalDamage;
		this.intCritical		= intCritical;		
		this.intDodge 			= intDodge;		
		
		this.intAttackSpeed 	= intAttackSpeed;
		this.intRewardHP 		= intRewardHP;
		
		//System.out.println("NonPlayableCharacter (String strName, int intHP, int intPhysicalDamage, int intCritical, int intDodge, int intAttackSpeed, int intRewardHP);");
	}
	
	// get RewardHP
	public int getRewardHP ()
	{
		return intRewardHP;
	}

	// get HP
	public int getHP()
	{
		return intHP;
	}
}
