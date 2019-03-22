package javaObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaObject.CommonModule.*;


//import javaObject.CommonDodule;

public class MainClass {
    
    public static void main(String[] args) {
        List<Character> arrCharacterList = new ArrayList<Character>();
        Character objCharacter = null;
        Scanner objScan  = null;
        int intMode;
        
        //샘플 케릭터 생성
        arrCharacterList = makeCharacterSample();
        
        
        
        objScan  = new Scanner(System.in);
        
        do {
            System.out.print("뭐할까?(1:생성,2:선택,3:싸움) : ");
            intMode = CommonModule.isNumerScan(objScan);
            
            switch (intMode) {
            case 1:
                arrCharacterList.add(makeCharacter(objScan));
                break;
            case 2:
                getCharacter(arrCharacterList);
                break;
            case 3:
                System.out.println("아직 미구현");
                break;
            default:
                System.out.println("그만하자");
                break;
            }
            
        } while(intMode == 1 || intMode == 2 || intMode == 3);
        
        
        objScan.close();

        return;
    }

    
    public static void getCharacter(List<Character> arrCharacterList) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("\t\t캐릭터 리스트");
        for (Character arrCharacter : arrCharacterList) {
            System.out.printf("이름: %s, 생명력: %d, 마나: %d, 공격력: %d, 방어력: %d\n", 
                    arrCharacter.strName, arrCharacter.intHealthPoint, arrCharacter.intManaPoint, arrCharacter.intPower, arrCharacter.intDefensive);
        }
        System.out.println("----------------------------------------------------------------------");
    }
    
    public static Character makeCharacter(Scanner objScan) {
        Character objCharacter = null;

        String strName;
        int    intRole;
        int    intStrength;
        int    intDexterity;
        int    intIntelligence;
        
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
        objCharacter.makeCharacter(strName, intRole, intStrength, intDexterity, intIntelligence);
        
        System.out.println("생성 완료 : " + strName);
        
        return objCharacter;
    }

    private static List<Character> makeCharacterSample() {
        List<Character> arrCharacterList = new ArrayList<Character>();
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
            System.out.printf("이름: %s, 생명력: %d, 마나: %d, 공격력: %d, 방어력: %d\n", 
                    arrCharacter.strName, arrCharacter.intHealthPoint, arrCharacter.intManaPoint, arrCharacter.intPower, arrCharacter.intDefensive);
        }
        System.out.println("----------------------------------------------------------------------");
        
        return arrCharacterList;
    }
    
}
