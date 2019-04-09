package com.pl.common;

import java.util.ArrayList;

import com.pl.mcu.*;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<MCUCharacter> list = new ArrayList<MCUCharacter>();
        
        int len = 0;
        
        list.add(new MCUHero("IornMan", 3000, 50));
        list.add(new MCUHero("Captain", 2000, 25));
        list.add(new MCUHero("Hulk", 6000, 65));
        list.add(new MCUHero("Thor", 8000, 78));
        
        list.add(new MCUVillain("Thanos", 10000, 98));
        
        System.out.println();
        
        new MCUCharacter() {
           
            public void fight() {
                System.out.println("=====================");
                System.out.println("======엔드게임시작!======");
                System.out.println("=====================");
            }

            @Override
            public void specialAbility() {
                // TODO Auto-generated method stub
                
            }
        }.fight();
        
        len = list.size();

        while (true) {
            
            System.out.println();
            System.out.println("Avengers의 공격");
            for(int i = 0; i < len - 1; i++ ) {
                list.get(i).attack(list.get(len - 1));
                list.get(i).specialAbility();
                if(judgment(list.get(len - 1))) {
                    System.out.println("Avengers의 승리");
                    return;
                }
            }
            
            System.out.println();
            System.out.println("Thanos의 공격");
            
            for(int i = len - 1; i > 0; i--) {
                list.get(len - 1).attack(list.get(i - 1));
                if(judgment(list.get(i - 1))) {
                    System.out.println(list.get(i - 1).getName() +" 사망");
                    list.remove(i - 1);
                    len = list.size();
                }
            }
            list.get(len - 1).specialAbility();
            
            if(len == 1 && list.get(0).getName().endsWith("Thanos")) {
                System.out.println("Thanos의 승리!");
                return;
            }
        }
    }
    
    public static boolean judgment(MCUCharacter mcuCharacter) {
        if(mcuCharacter.getHealth() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
