package javaObject;

public class Character {
    String strName         = null;
    String strRole         = null;
    
    int    intRole         = 0;
    int    intStrength     = 0;
    int    intDexterity    = 0;
    int    intIntelligence = 0;
    
    int    intHealthPoint  = 0;
    int    intManaPoint    = 0;
    int    intPower        = 0;
    int    intDefensive    = 0;
    
    //생성자
    public Character() {
        
    }
    
    //캐릭터 정보 조회
    public void printCharacter() {
        System.out.printf("이름: %s, 역활: %s, 생명력: %d, 마나: %d, 공격력: %d, 방어력: %d", 
                this.strName, this.strRole, this.intHealthPoint, this.intManaPoint, this.intPower, this.intDefensive);
        System.out.println();
    }
    
    //캐릭터 정보 조회
    public void printCharacter(int intPlayer) {
        System.out.printf("%dP => 이름: %s, 역활: %s, 생명력: %d, 마나: %d, 공격력: %d, 방어력: %d", 
                intPlayer, this.strName, this.strRole, this.intHealthPoint, this.intManaPoint, this.intPower, this.intDefensive);
        System.out.println();
    }
    
    //캐릭터 생성
    public void makeCharacter(String strName, int intRole, int intStrength, int intDexterity, int intIntelligence) {
        this.strName         = strName;
        this.intRole         = intRole;
        this.intStrength     = intStrength;
        this.intDexterity    = intDexterity;
        this.intIntelligence = intIntelligence;
        
        //역활별 능력 설정
        CharacterRole objCharacterRole = new CharacterRole(intRole, intStrength, intDexterity, intIntelligence);
        this.strRole        = objCharacterRole.strRoleName;
        this.intHealthPoint = objCharacterRole.intHealthPoint;
        this.intManaPoint   = objCharacterRole.intManaPoint;
        this.intPower       = objCharacterRole.intPower;
        this.intDefensive   = objCharacterRole.intDefensive;
        
        return;
    }
    
    
}
