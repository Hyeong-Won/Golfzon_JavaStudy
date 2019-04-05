package javaObject;

import java.util.Scanner;

public class CommonModule {
    public static final String MENU = "\n메뉴를 선택하시오.(1:캐릭터 리스트, 2:캐릭터 선택, 3:캐릭터 결투) : ";
    
    public static enum ROLE { Tanker, Dealer, Nucker, Healer }
    
    
    
    public static int isNumerScan(Scanner objScan) {
        while (!objScan.hasNextInt()) {
            objScan.next();
            System.out.print("숫자입력하세요! : ");
        }
        
        return objScan.nextInt();
    }
}
