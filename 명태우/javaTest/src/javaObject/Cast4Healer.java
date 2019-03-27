package javaObject;

import java.util.ArrayList;
import java.util.HashMap;

//추상 클래스 상속
public class Cast4Healer extends Cast {
    @Override
    //Collections 사용
    public ArrayList<HashMap<String, String>> getSkill() {
        ArrayList<HashMap<String, String>> arrSkillList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String>            mapSkill     = null; 
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "치유");
        mapSkill.put("desc", "영구적으로 체력 200 회복(증가)");
        arrSkillList.add(mapSkill);
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "흡혈의 손길");
        mapSkill.put("desc", "한턴동안 공격력 1.5배 증가 및 데미지만큼 체력 회복(증가)");
        arrSkillList.add(mapSkill);
        
        return arrSkillList;
    }
    
    @Override
    public void castSkill(String strSkill, Character objCharacter4Att, Character objCharacter4Def) {
        //스킬 사용
        if (strSkill.equals("치유")) {
            //람다식 사용 - 영구적으로 체력 200 회복(증가)
            Skill objSkill = (att, def) -> {
                int intHealthPoint = att.intHealthPoint;
                att.intHealthPoint = intHealthPoint + 200;
                castAttack(att ,def);
            };
            
            objSkill.skill(objCharacter4Att, objCharacter4Def);
        }
        else if (strSkill.equals("흡혈의 손길")) {
            //람다식 사용 - 한턴동안 공격력 1.5배 증가 및 데미지의 50% 만큼 체력 회복(증가)
            Skill objSkill = (att, def) -> {
                int intPower  = att.intPower;
                att.intPower = intPower + Math.round(intPower * 15 / 10);
                castAttack(att ,def);
                int intDemage = att.intPower - def.intDefensive;
                att.intHealthPoint = att.intHealthPoint + (intDemage / 2);
                att.intPower = intPower;
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
