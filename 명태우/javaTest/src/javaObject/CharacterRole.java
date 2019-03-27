package javaObject;

public class CharacterRole {
    String strRoleName     = null;
    int    intHealthPoint  = 0;
    int    intManaPoint    = 0;
    int    intPower        = 0;
    int    intDefensive    = 0;
    
    //생성자
    public CharacterRole() {
        
    }
    
    //생성자(인자)
    public CharacterRole(int intRole, int intStrength, int intDexterity, int intIntelligence) {
        this.strRoleName    = getRoleName(intRole);
        this.intHealthPoint = setHealth(intRole);
        this.intManaPoint   = 100;
        this.intPower       = setPower(intStrength, intDexterity, intIntelligence);
        this.intDefensive   = setDefensive(intRole, intStrength, intDexterity, intIntelligence);
    }
    
    //캐릭터 역활 조회
    private String getRoleName(int intRole) {
        String strRoleName;
        
        switch (intRole) {
        case 0:
            strRoleName = "탱커";
            break;
        case 1:
            strRoleName = "딜러";
            break;
        case 2:
            strRoleName = "누커";
            break;
        case 3:
        default:
            strRoleName = "힐러";
            break;
        }
        
        return strRoleName;
    }
    
    //캐릭터 생명력 세팅
    private int setHealth(int intRole) {
        int intHealth;
        
        switch (intRole) {
        case 0:
            intHealth = 700;
            break;
        case 1:
        case 2:
        case 3:
        default:
            intHealth = 500;
            break;
        }
        
        return intHealth;
    }
    
    //캐릭터 공격력 세팅
    private int setPower(int intStrength, int intDexterity, int intIntelligence) {
        return Math.round((intStrength + intDexterity + intIntelligence) / 3);
    }
    
    //캐릭터 방어력 세팅
    private int setDefensive(int intRole, int intStrength, int intDexterity, int intIntelligence) {
        return Math.round((intStrength + intDexterity + intIntelligence) * (intRole == 0 ? 2 : 1) / 30 );
    }

}
