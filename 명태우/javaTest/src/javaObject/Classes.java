package javaObject;

import java.util.ArrayList;
import java.util.List;

public class Classes {

    List<Classes> arrClassesList = null;
    
    String strName;
    String strRole;
    String strDesc;

    int intHealth;
    int intPower;
    int intSpeed;
    int intDefensive;
    
    int intStrength;
    int intDexterity;
    int intIntelligence;
    
    public Classes() {
        this.arrClassesList = new ArrayList<Classes>();
    }



    public int setPower(int intStr, int intDex, int intInt) {
        int intPower = Math.round((intStr + intDex + intInt) / 3);

        return intPower;
    }

    public int setSpeed(int intStr, int intDex) {
        int intSpeed = 0;
        
        if (intDex >= intStr) {
            intSpeed = 5;
        }
        else {
            intSpeed = 3;
        }
        
        return intSpeed;
    }

    public void setStatusPoint(String strRole, int intStr, int intDex, int intInt) {
        this.intStrength = intStr;
        this.intDexterity = intDex;
        this.intIntelligence = intInt;
        this.intPower = setPower(intStr, intDex, intInt);
        this.intSpeed = setSpeed(intStr, intDex);

        switch (strRole) {
            case "Tanker" :
                this.intHealth = 1500;
                this.intDefensive = 50;
                break;
            case "Dealer" :
                this.intHealth = 1000;
                this.intDefensive = 20;
                break;
            case "Healer" :
                this.intHealth = 1000;
                this.intDefensive = 30;
                break;
            default :
                this.intHealth = 1000;
                this.intDefensive = 10;
                break;
        }
        
        return;
    }
    
    public void makeClass(String strName, String strRole, int intStr, int intDex, int intInt) {
        
        this.strName = strName;
        this.strRole = strRole;
        
        //역활에 따라 스탯 설정
        setStatusPoint(strRole, intStr, intDex, intInt);
        
    }
    
    public void printClass() {
        printClass("");
    }
    
    public void printClass(String strName) {
        if (strName.isEmpty())
        {
            for (Classes classes : this.arrClassesList) {
                System.out.printf("이름 : %s, 역활 : %s, 공격력 : %d, 공속 : %d, 방어력 : %d\n", classes.strName, classes.strRole, classes.intPower, classes.intSpeed, classes.intDefensive);
            }
        }
        System.out.println("--------------------------------------------------");
    }
    

}
