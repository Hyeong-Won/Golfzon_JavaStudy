package javaObject;

import java.util.Scanner;

public class CommonModule {
    
    public static enum ROLE { Tanker, Dealer, Nucker, Healer 
        
    }
    
    
    
    public static int isNumerScan(Scanner objScan) {
        while (!objScan.hasNextInt()) {
            objScan.next();
            System.out.print("숫자입력하세요! : ");
        }
        
        return objScan.nextInt();
    }
}
