package javaObject;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    

    public static void main(String[] args) {

        Classes objClasses = new Classes();
        objClasses.printClass();
        
        Classes objSampleClasses = new Classes();
        objSampleClasses.arrClassesList = makeSampleClasses();
        objSampleClasses.printClass();
        
        
        
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
