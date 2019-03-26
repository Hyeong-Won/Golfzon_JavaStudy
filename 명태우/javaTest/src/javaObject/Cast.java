package javaObject;

import java.util.ArrayList;
import java.util.HashMap;

//추상 클래스
public abstract class Cast {
    //공격 시전
    public void castAttack(Character objCharacter4Att, Character objCharacter4Def) {
        if (objCharacter4Att.intHealthPoint <= 0 || objCharacter4Def.intHealthPoint <= 0) {
            return;
        }
        
        int intDemage = objCharacter4Att.intPower - objCharacter4Def.intDefensive;
        objCharacter4Def.intHealthPoint = objCharacter4Def.intHealthPoint - intDemage > 0 ? objCharacter4Def.intHealthPoint - intDemage : 0;
        return;
    };
    
    //스킬 시전 - 추상 메서드
    public abstract void castSkill(String strSkill, Character objCharacter4Att, Character objCharacter4Def);
    
    //스킬 세팅 - 추상 메서드
    public abstract ArrayList<HashMap<String, String>> getSkill();
    
}
