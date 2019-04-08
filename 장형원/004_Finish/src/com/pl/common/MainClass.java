package com.pl.common;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.pl.exception.InvalidDataException;
import com.pl.mcu.*;

public class MainClass {
    public static void main(String[] args) {

        ArrayList<MCUCharacter> list = null;

        File             fi  = null;
        FileReader       fr  = null;
        BufferedReader   br  = null;
                         
        File             fo  = null;
        FileWriter       fw  = null;
                                
        Date             d   = new Date();
        SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd hh:mm aaa");
        
        int              len = 0;
        
        try {
            
            fi = new File("D:\\Study\\Golfzon_JavaStudy\\장형원\\004_Finish\\createAvengers.txt");
            fr = new FileReader(fi);
            br = new BufferedReader(fr);
            
            fo = new File("D:\\Study\\Golfzon_JavaStudy\\장형원\\004_Finish\\result.txt");
            fw = new FileWriter(fo, true);
            
            list = new ArrayList<MCUCharacter>();
            createAvengers(list, br);
            br.close();
            fr.close();
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
//            len = 9;

            while (true) {

                System.out.println();
                System.out.println("Avengers의 공격");
                for (int i = 0; i < len - 1; i++) {
                    list.get(i).attack(list.get(len - 1));
                    list.get(i).specialAbility();
                    if (judgment(list.get(len - 1))) {
                        System.out.println("Avengers의 승리");
                        System.out.println("파일에 기록합니다..");
                        fw.write(df.format(d) + " Avengers 승리\n");
                        fw.flush();
                        fw.close();
                        return;
                    }
                }

                System.out.println();
                System.out.println("Thanos의 공격");

                for (int i = len - 1; i > 0; i--) {
                    list.get(len - 1).attack(list.get(i - 1));
                    if (judgment(list.get(i - 1))) {
                        System.out.println(list.get(i - 1).getName() + " 사망");
                        list.remove(i - 1);
                        len = list.size();
                    }
                }
                list.get(len - 1).specialAbility();

                if (len == 1 && list.get(0).getName().endsWith("Thanos")) {
                    System.out.println("Thanos의 승리!");
                    System.out.println("파일에 기록합니다..");
                    fw.write(df.format(d) + " Thanos 승리\n");
                    fw.flush();
                    fw.close();
                    return;
                }
            }
            
        } catch (InvalidDataException e) {
            System.out.println("InvalidDataException 예외를 먼저 확인");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            list = null;
            d    = null;
            df   = null;
                 
            br   = null;
            fr   = null;
            fi   = null;
                      
            fw   = null;
            fo   = null;
        }
    }

    public static void createAvengers(ArrayList<MCUCharacter> list, BufferedReader br) throws NumberFormatException, IOException, InvalidDataException {
        
        String line      = "";
        String[] tempArr = null;
        
        while((line = br.readLine()) != null) {
            tempArr = line.split(",");

            if(tempArr[0].equals("T")) {
                list.add(new MCUHero(tempArr[1], Integer.parseInt(tempArr[2]), Integer.parseInt(tempArr[3])));
            }
        }
        
    }
    
    public static boolean judgment(MCUCharacter mcuCharacter) {
        if (mcuCharacter.getHealth() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
