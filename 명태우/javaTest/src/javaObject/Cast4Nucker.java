package javaObject;

import java.util.ArrayList;
import java.util.HashMap;

//추상 클래스 상속
public class Cast4Nucker extends Cast {
    @Override
    //Collections 사용
    public ArrayList<HashMap<String, String>> getSkill() {
        ArrayList<HashMap<String, String>> arrSkillList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String>            mapSkill     = null; 
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "신비한 화살");
        mapSkill.put("desc", "50%의 공격력 3번 공격");
        arrSkillList.add(mapSkill);
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "시간 왜곡");
        mapSkill.put("desc", "영구적으로 공격력 10% 누적 증가");
        arrSkillList.add(mapSkill);
        
        return arrSkillList;
    }
    
    @Override
    public void castSkill(String strSkill, Character objCharacter4Att, Character objCharacter4Def) {
        //스킬 사용
        if (strSkill.equals("신비한 화살")) {
            //람다식 사용 - 50%의 공격력 5번 공격
            Skill objSkill = (att, def) -> {
                int intPower = att.intPower;
                att.intPower = intPower / 2;
                castAttack(att ,def);
                castAttack(att ,def);
                castAttack(att ,def);
                castAttack(att ,def);
                castAttack(att ,def);
                att.intPower = intPower;
            };
            
            objSkill.skill(objCharacter4Att, objCharacter4Def);
        }
        else if (strSkill.equals("시간 왜곡")) {
            //람다식 사용 - 영구적으로 공격력 10% 누적 증가
            Skill objSkill = (att, def) -> {
                int intPower = att.intPower;
                att.intPower = intPower + Math.round(intPower * 1 / 10);
                castAttack(att ,def);
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
