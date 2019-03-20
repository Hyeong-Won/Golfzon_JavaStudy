package com.pl.common;

import com.pl.mcu.MCUCharacter;

public class MainClass {
    public static void main(String[] args) {
        MCUCharacter iornMan = new MCUCharacter("iornMan", 5000, 68);
        MCUCharacter thanos  = new MCUCharacter();
        thanos.setName("Thanos");
        thanos.setHeath(10000);
        thanos.setPower(153);
        
        while(true) {
            iornMan.attack(thanos);
            if(judgment(thanos)) {
                System.out.println(iornMan.getName() +"의 승리!");
                break;
            }
            thanos.attack(iornMan);
            if(judgment(iornMan)) {
                System.out.println(thanos.getName() +"의 승리!");
                break;
            }
        }
        
        iornMan = null;
        thanos  = null;
        
        System.gc();
    }
    
    public static boolean judgment(MCUCharacter mcuCharacter) {
        if(mcuCharacter.getHeath() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
