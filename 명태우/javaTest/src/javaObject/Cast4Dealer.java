package javaObject;

import java.util.ArrayList;
import java.util.HashMap;

//추상 클래스 상속
public class Cast4Dealer extends Cast {
    @Override
    //Collections 사용
    public ArrayList<HashMap<String, String>> getSkill() {
        ArrayList<HashMap<String, String>> arrSkillList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String>            mapSkill     = null; 
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "은신");
        mapSkill.put("desc", "한턴동안 공격력 2배 증가");
        arrSkillList.add(mapSkill);
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "기습");
        mapSkill.put("desc", "한턴동안 공격력 1.5배 증가 및 영구적으로 공격력 5% 증가");
        arrSkillList.add(mapSkill);
        
        return arrSkillList;
    }
    
    @Override
    public void castSkill(String strSkill, Character objCharacter4Att, Character objCharacter4Def) {
        //스킬 사용
        if (strSkill.equals("은신")) {
            //람다식 사용 - 한턴동안 공격력 2배 증가
            Skill objSkill = (att, def) -> {
                int intPower = att.intPower;
                att.intPower = intPower * 2;
                castAttack(att ,def);
                att.intPower = intPower;
            };
            
            objSkill.skill(objCharacter4Att, objCharacter4Def);
        }
        else if (strSkill.equals("기습")) {
            //람다식 사용 - 한턴동안 공격력 1.5배 증가 및 영구적으로 공격력 5% 증가
            Skill objSkill = (att, def) -> {
                int intPower = att.intPower;
                att.intPower = intPower + Math.round(intPower * 15 / 10);
                castAttack(att ,def);
                att.intPower = intPower + Math.round(intPower * 5 / 100);;
            };
            
            objSkill.skill(objCharacter4Att, objCharacter4Def);
        }
        else {
            //기타
            castAttack(objCharacter4Att ,objCharacter4Def);
        }
        
        return;
    }

}
