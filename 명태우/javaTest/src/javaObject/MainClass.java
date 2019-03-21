package javaObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class MainClass {
    
    public static void main(String[] args) {
        Classes objClasses = new Classes();
        int intType = 0;
        
        //샘플 클래스
        //Classes objSampleClasses = new Classes();
        //objSampleClasses.arrClassesList = makeSampleClasses();
        //objSampleClasses.printClass();
        
        
        objClasses.arrClassesList = makeSampleClasses();
        objClasses.printClass();
        
        Scanner objScan  = new Scanner(System.in);
        
        do {
            System.out.print("뭐할까?(1:생성,2:선택,3:싸움) : ");
            intType = isNumerScan(objScan);
            
            switch (intType) {
            case 1:
                objClasses.arrClassesList.add(fnMakeClasses(objScan));
                objClasses.printClass();
                break;
            case 2:
                System.out.println("아직 미구현");
                break;
            case 3:
                System.out.println("아직 미구현");
                break;
            default:
                System.out.println("그만하자");
                break;
            }
            
        } while(intType == 1 || intType == 2 || intType == 3);
        
        
        objScan.close();
        return;
    }
    
    public static Classes fnMakeClasses(Scanner objScan) {
        Classes objClasses;
        String strName;
        String strRole;
        int    intStr;
        int    intDex;
        int    intInt;
        
        System.out.print("이름? : ");
        strName = objScan.next();
        
        System.out.print("역활?(1:탱커,2:딜러,3:힐러) : ");
        
        switch (isNumerScan(objScan)) {
        case 1:
            strRole = "Tanker";
            break;
        case 2:
            strRole = "Dealer";
            break;
        case 3:
            strRole = "Healer";
            break;
        default :
            strRole = "Tanker";
            break;
        }
        
        System.out.print("힘? : ");
        intStr = isNumerScan(objScan);
        
        System.out.print("민첩? : ");
        intDex = isNumerScan(objScan);
        
        System.out.print("지능? : ");
        intInt = isNumerScan(objScan);
        
        objClasses = new Classes();
        objClasses.makeClass(strName, strRole, intStr, intDex, intInt);
        
        return objClasses;
    }
    
    private static int isNumerScan(Scanner objScan) {
        while (!objScan.hasNextInt()) {
            objScan.next();
            System.out.print("숫자입력하세요 : ");
        }
        
        return objScan.nextInt();
    }
    
    public static List<Classes> makeSampleClasses() {
        List<Classes> arrUserList = new ArrayList<Classes>();
        
        Classes objClasses = null;
        
        objClasses = new Classes();
        objClasses.makeClass("전사", "Tanker", 100, 70, 30);
        arrUserList.add(objClasses);
        
        objClasses = new Classes();
        objClasses.makeClass("도적", "Dealer", 70, 150, 30);
        arrUserList.add(objClasses);
        
        objClasses = new Classes();
        objClasses.makeClass("법사", "Dealer", 30, 70, 150);
        arrUserList.add(objClasses);
        
        objClasses = new Classes();
        objClasses.makeClass("사제", "Healer", 30, 30, 150);
        arrUserList.add(objClasses);
        
        return arrUserList;
    }
    
}
