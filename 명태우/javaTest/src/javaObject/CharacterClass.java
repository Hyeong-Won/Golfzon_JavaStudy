package javaObject;

public class CharacterClass {
    int intPower = 0;
    int intDefensive = 0;
    
    //생성자
    public CharacterClass() {
        
    }
    

    public int setHealth(int intRole) {
        int intHealth;
        
        switch (intRole) {
        case 1:
            intHealth = 1500;
            break;
        case 2:
        case 3:
        case 4:
        default:
            intHealth = 1000;
            break;
        }
        
        return intHealth;
    }
    
    public int setPower(int intStrength, int intDexterity, int intIntelligence) {
        return Math.round((intStrength + intDexterity + intIntelligence) / 3);
    }

    public int setDefensive(int intRole, int intStrength, int intDexterity, int intIntelligence) {
        return Math.round((intStrength + intDexterity + intIntelligence) * (intRole == 1 ? 2 : 1) / 30 );
    }
}
