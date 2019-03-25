package javaObject;

import java.util.ArrayList;
import java.util.HashMap;

//추상 클래스 상속
public class Cast4Tanker extends Cast {
    @Override
    //Collections 사용
    public ArrayList<HashMap<String, String>> getSkill() {
        ArrayList<HashMap<String, String>> arrSkillList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String>            mapSkill     = null; 
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "돌진");
        mapSkill.put("desc", "한턴동안 방어력 10배만큼 공격력 증가");
        arrSkillList.add(mapSkill);
        
        mapSkill = new HashMap<String, String>();
        mapSkill.put("name", "도발");
        mapSkill.put("desc", "영구적으로 방어력 20% 증가");
        arrSkillList.add(mapSkill);
        
        return arrSkillList;
    }
    
    @Override
    public void castSkill(String strSkill, Character objCharacter4Att, Character objCharacter4Def) {
        //스킬 사용
        if (strSkill.equals("돌진")) {
            //람다식 사용 - 한턴동안 방어력 10배만큼 공격력 증가
            Skill objSkill = (att, def) -> {
                int intPower = att.intPower;
                att.intPower = intPower + (att.intDefensive * 10);
                castAttack(att ,def);
                att.intPower = intPower;
            };
            
            objSkill.skill(objCharacter4Att, objCharacter4Def);
        }
        else if (strSkill.equals("도발")) {
            //람다식 사용 - 영구적으로 방어력 30% 증가
            Skill objSkill = (att, def) -> {
                int intDefensive = att.intDefensive;
                att.intDefensive = intDefensive + Math.round(intDefensive * 3 / 10);
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
