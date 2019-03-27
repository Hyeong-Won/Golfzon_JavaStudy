package javaObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javaObject.CommonModule.*;

public class MainClass {
    public static ArrayList<Character> arrCharacterList = null;
    public static Character            objCharacter1P   = null;
    public static Character            objCharacter2P   = null;
    
    public static void main(String[] args) {
        int     intMainMode = 0;
        Scanner objScan     = null;
        
        arrCharacterList = new ArrayList<Character>();
        objScan          = new Scanner(System.in);
        
        //샘플 케릭터 생성
        arrCharacterList = makeCharacterSample();
        
        //메인 로직 시작
        do {
            System.out.print("메뉴를 선택하시오.(1:캐릭터 생성, 2:캐릭터 선택, 3:캐릭터 결투) : ");
            intMainMode = CommonModule.isNumerScan(objScan);
            
            switch (intMainMode) {
            case 1:
                //캐릭터 생성
                arrCharacterList.add(makeCharacter(objScan));
                break;
            case 2:
                //캐릭터 선택
                objCharacter1P   = new Character();
                objCharacter2P   = new Character();
                
                selectCharacter(objScan);
                break;
            case 3:
                //캐릭터 결투
                if (checkSelectCharacter()) {
                    fightCharacter(objScan);
                }
                break;
            default:
                //종료
                System.out.println("그만~~~");
                break;
            }
            
        } while(intMainMode == 1 || intMainMode == 2);
        
        
        objScan.close();
        return;
    }
    
    //캐릭터 선택
    public static void selectCharacter(Scanner objScan) {
        int intIndex1P = 0;
        int intIndex2P = 0;
        
        //문자열 클래스 사용
        StringBuilder strSBCharacter = new StringBuilder();
        for (int i = 0; i < arrCharacterList.size(); i++) {
            //String 객체의 데이터가 변경될 때 마다 새로운 객체 생성
            //StringBuilder가 StringBuffer보다 조금 빠르고, StringBuffer가 StringBuilder보다 조금 안정성
            strSBCharacter.append("번호: "     + i);
            strSBCharacter.append(", 이름: "   + arrCharacterList.get(i).strName);
            strSBCharacter.append(", 역활: "   + arrCharacterList.get(i).strRole);
            strSBCharacter.append(", 생명력: " + arrCharacterList.get(i).intHealthPoint);
            strSBCharacter.append(", 마나: "   + arrCharacterList.get(i).intManaPoint);
            strSBCharacter.append(", 공격력: " + arrCharacterList.get(i).intPower);
            strSBCharacter.append(", 방어력: " + arrCharacterList.get(i).intDefensive);
            strSBCharacter.append("\n");
        }
        
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("\t\t캐릭터 리스트");
        System.out.print(strSBCharacter);
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        //1P 선택
        System.out.print("\t1P 캐릭터를 선택하시오?(캐릭터 번호) : ");
        intIndex1P = CommonModule.isNumerScan(objScan);
        objCharacter1P = arrCharacterList.get(intIndex1P);
        System.out.printf("\t==>1P 캐릭터 : %s\n", objCharacter1P.strName.toString());
        
        //2P 선택
        System.out.print("\t2P 캐릭터를 선택하시오?(캐릭터 번호) : ");
        intIndex2P = CommonModule.isNumerScan(objScan);
        objCharacter2P = arrCharacterList.get(intIndex2P);
        System.out.printf("\t==>2P 캐릭터 : %s\n", objCharacter2P.strName.toString());
        
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        return;
    }
    
    //캐릭터 선택 유무 체크
    //캐릭터 선택 여부
    public static boolean checkSelectCharacter() {
        boolean blnSelectCharacter = false;
        
        if (objCharacter1P.strName == null || objCharacter2P.strName == null) {
            System.out.println("캐릭터 선택부터 ~~~");
        }
        else {
            blnSelectCharacter = true;
            
            //캐릭터 정보 출력
            System.out.println("----------------------------------------------------------------------------------------------------");
            objCharacter1P.printCharacter(1);
            objCharacter2P.printCharacter(2);
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        return blnSelectCharacter;
    }
    
     
    //캐릭터 결투
    public static void fightCharacter(Scanner objScan) {
        String strVictory;
        
        while(objCharacter1P.intHealthPoint > 0 && objCharacter2P.intHealthPoint > 0) {
            //공격
            castAction(objCharacter1P, objCharacter2P, objScan);
            castAction(objCharacter2P, objCharacter1P, objScan);
            
            //캐릭터 정보 출력
            System.out.println("----------------------------------------------------------------------------------------------------");
            objCharacter1P.printCharacter(1);
            objCharacter2P.printCharacter(2);
            System.out.println("----------------------------------------------------------------------------------------------------");
        };
        
        if (objCharacter1P.intHealthPoint == objCharacter2P.intHealthPoint) {
            System.out.println("무.승.부");
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        else {
            strVictory = objCharacter1P.intHealthPoint > objCharacter2P.intHealthPoint ? "1P " + objCharacter1P.strName : "2P : " + objCharacter2P.strName;
            System.out.println(strVictory + "승리~~!!!");
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        
        objCharacter1P = null;
        objCharacter2P = null;
        return;
    }
    
    //캐릭터 액션
    public static void castAction(Character objCharacter4Att, Character objCharacter4Def, Scanner objScan) {
        int    intAction    = 0;
        String strAction    = null;
        Cast   objCast      = null;
        ArrayList<HashMap<String, String>> arrSkillList = new ArrayList<HashMap<String, String>>();
                
        //각 역활의 시전 클래스 - 추상 클래스
        switch(objCharacter4Att.intRole) {
            case 0:
                objCast  = new Cast4Tanker();
                break;
            case 1:
                objCast  = new Cast4Dealer();
                break;
            case 2:
                objCast  = new Cast4Nucker();
                break;
            case 3:
            default:
                objCast  = new Cast4Healer();
                break;
        }
        
        //스킬 세팅
        arrSkillList = objCast.getSkill();
        
        //스킬 설명 출력
        for (HashMap<String, String> mapSkill : arrSkillList) {
            System.out.printf("%s 스킬 : %s (%s)\n", objCharacter4Att.strName, mapSkill.get("name"), mapSkill.get("desc"));
        }
        
        //공격 액션 선택
        System.out.printf("\t%s 선택하시오(1:공격, 2:스킬(%s), 3:스킬(%s) : ", objCharacter4Att.strName, arrSkillList.get(0).get("name"), arrSkillList.get(1).get("name"));
        intAction = CommonModule.isNumerScan(objScan);
        
        if (intAction == 1) {
            //공격
            objCast.castAttack(objCharacter4Att, objCharacter4Def);
            strAction = "공격";
        }
        else if (intAction == 2) {
            //스킬 시전 - 추상 메서드
            objCast.castSkill(arrSkillList.get(0).get("name"), objCharacter4Att, objCharacter4Def);
            strAction = arrSkillList.get(0).get("name") + " 공격";
        }
        else if(intAction == 3) {
            //스킬 시전 - 추상 메서드
            objCast.castSkill(arrSkillList.get(1).get("name"), objCharacter4Att, objCharacter4Def);
            strAction = arrSkillList.get(1).get("name") + " 공격";
        }
        
        System.out.printf("\t%s --> %s : %s", objCharacter4Att.strName, objCharacter4Def.strName, strAction);
        System.out.println();
        
        return;
    }
    
    //캐릭서 생성
    //캐릭터 생성
    public static Character makeCharacter(Scanner objScan) {
        Character objCharacter    = null;
        String    strName         = null;
        int       intRole         = 0;
        int       intStrength     = 0;
        int       intDexterity    = 0;
        int       intIntelligence = 0;;
        
        System.out.print("\t이름? : ");
        strName = objScan.next();
        
        System.out.print("\t역활?(1:탱커,2:딜러,3:누커:,4:힐러) : ");
        
        switch (CommonModule.isNumerScan(objScan)) {
        case 1:
            intRole = ROLE.Tanker.ordinal();
            break;
        case 2:
            intRole = ROLE.Dealer.ordinal();
            break;
        case 3:
            intRole = ROLE.Nucker.ordinal();
            break;
        case 4:
        default :
            intRole = ROLE.Nucker.ordinal();
            break;
        }
        
        System.out.print("\t힘? : ");
        intStrength = CommonModule.isNumerScan(objScan);
        
        System.out.print("\t민첩? : ");
        intDexterity = CommonModule.isNumerScan(objScan);
        
        System.out.print("\t지능? : ");
        intIntelligence = CommonModule.isNumerScan(objScan);
        
        objCharacter = new Character();
        //캐릭터 생성
        objCharacter.makeCharacter(strName, intRole, intStrength, intDexterity, intIntelligence);
        //캐릭터 조회
        objCharacter.printCharacter();
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        return objCharacter;
    }
    
    
    //캐릭터 생성(샘플)
    //캐릭터 생성(샘플)
    private static ArrayList<Character> makeCharacterSample() {
        ArrayList<Character> arrCharacterList = new ArrayList<Character>();
        Character objCharacter = null;
        
        objCharacter = new Character();
        objCharacter.makeCharacter("전사", ROLE.Tanker.ordinal(), 100, 70, 30);
        arrCharacterList.add(objCharacter);
        
        objCharacter = new Character();
        objCharacter.makeCharacter("도적", ROLE.Dealer.ordinal(), 70, 150, 30);
        arrCharacterList.add(objCharacter);
        
        objCharacter = new Character();
        objCharacter.makeCharacter("법사", ROLE.Nucker.ordinal(), 30, 70, 150);
        arrCharacterList.add(objCharacter);
        
        objCharacter = new Character();
        objCharacter.makeCharacter("사제", ROLE.Healer.ordinal(), 30, 30, 150);
        arrCharacterList.add(objCharacter);
        
        System.out.println("\t\t캐릭터 리스트");
        for (Character arrCharacter : arrCharacterList) {
            System.out.printf("이름: %s, 역활: %s, 생명력: %d, 마나: %d, 공격력: %d, 방어력: %d\n", 
                    arrCharacter.strName, arrCharacter.strRole, arrCharacter.intHealthPoint, arrCharacter.intManaPoint, arrCharacter.intPower, arrCharacter.intDefensive);
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        return arrCharacterList;
    }
    
    
}
