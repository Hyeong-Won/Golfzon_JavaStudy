package javaObject;

public class Character {
    String strName;
    String strRole;
    
    int intStrength;
    int intDexterity;
    int intIntelligence;
    
    int intHealthPoint;
    int intManaPoint;
    int intPower;
    int intDefensive;
    
    //생성자
    public Character() {
        
    }
    
    
    
    //캐릭터 생성
    public void makeCharacter(String strName, int intRole, int intStrength, int intDexterity, int intIntelligence) {
        this.strName         = strName;
        //this.strRole = strRole;
        this.intStrength     = intStrength;
        this.intDexterity    = intDexterity;
        this.intIntelligence = intIntelligence;
        
        //직업별 능력 설정
        CharacterClass objClass = new CharacterClass();
        this.intHealthPoint = objClass.setHealth(intRole);
        this.intManaPoint   = 100;
        this.intPower       = objClass.setPower(intStrength, intDexterity, intIntelligence);
        this.intDefensive   = objClass.setDefensive(intRole, intStrength, intDexterity, intIntelligence);
        
        
        //System.out.printf("이름: %s, 힘: %d, 민첩: %d, 지능: %d, 생명력: d%, 마나: d%, 공격력: %d, 방어력: %d");
        
        return;
    }
    
    
}
