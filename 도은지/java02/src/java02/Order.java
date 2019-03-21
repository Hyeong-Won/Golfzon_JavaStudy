package java02;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	
	Scanner scn = new Scanner(System.in);
    ArrayList<Menu> menuList = new ArrayList<Menu>();
    
	public void setMenu() {
              
		Menu menu = new Menu();
              
		System.out.println("==메뉴명 입력==");
		menu.setName(scn.next());

		System.out.println("==가격 입력==");
		menu.setPrice(scn.nextInt());
              
		menuList.add(menu);
    }
    
	public void getMenu() {
              
		for(int i=0; i<menuList.size(); i++) {
			System.out.println(menuList.get(i).getName() + " : " + menuList.get(i).getPrice() + "원");
		}
              
	}
    
	public static void main(String[] args) {
              
    	Order order = new Order();
    	Scanner scn = new Scanner(System.in);
    	int choice;
	  
    	while(true) {
		  
    		System.out.println("1: 메뉴등록 2: 메뉴보기 3: 나가기");
    		choice = scn.nextInt();
	     
    		if(choice == 3) {
    			break;
    		}
	     
		switch(choice) {
		case 1: 
			order.setMenu();
			break;
		case 2:
			order.getMenu();
			break;
		default :
			System.out.println("범위 안 숫자 입력");
			break;
		}
    	}	
	}

}
