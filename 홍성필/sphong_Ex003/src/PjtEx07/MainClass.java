package PjtEx07;

import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {

	public static void main(String[] args) {
		
		// ArrayList 객체생성
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("list.size : " + list.size());
		
		list.add("Hello");
		list.add("Java");
		list.add("World");
		System.out.println("list.size : " + list.size());
		System.out.println("list : " + list);
		
		list.add(2, "Programing");
		System.out.println("list : " + list);
		
		//set 변경
		list.set(1, "C");
		System.out.println("list : " + list);
		
		String str = list.get(2);
		System.out.println("list.get(2) : " + str);
		System.out.println("list : " + list);
		
		//remove 제거
		str = list.remove(2);
		System.out.println("list.remove(2) : " + str);
		System.out.println("list : " + list);
		
		//clear 데이터전체 제거
		list.clear();
		System.out.println("list : " + list);
		
		boolean b = list.isEmpty();
		System.out.println("list.isEmpty() : " + b);
		
		System.out.println(" -------------------------------- ");
		
		// HashMap 객체생성
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("map.size() : " + map.size());
		
		map.put(5, "Hello");
		map.put(6, "Java");
		map.put(7, "World");
		System.out.println("map : " + map);
		System.out.println("map.size() : " + map.size());
		
		map.put(8, "!!");
		System.out.println("map : " + map);
		
		//6번에 데이터 교체
		map.put(6, "C");
		System.out.println("map : " + map);
		
		str = map.get(5);
		System.out.println("map.get(5) : " + str);
		
		map.remove(8);
		System.out.println("map : " + map);
		
		// 특정 데이터 포함 유무
		b = map.containsKey(7);
		System.out.println("map.containsKey(7) : " + b);
		
		b = map.containsValue("World");
		System.out.println("map.containsValue(\"World\") : " + b);
		
		map.clear();
		System.out.println("map : " + map);
		
		b = map.isEmpty();
		System.out.println("map.isEmpty() : " + b);
	}
	
}
