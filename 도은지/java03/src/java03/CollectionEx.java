package java03;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionEx {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("hello");
		list.add("java");
		list.add("world");
		System.out.println(list.toString());
		
		list.add(2,"Programming");
		list.set(1, "C");
		System.out.println(list.toString());
		
		String str = list.get(1);
		System.out.println(str);
		
		list.clear();
		System.out.println(list.toString());
		
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(2,"hello");
		map.put(5,"java");
		map.put(6,"world");
		System.out.println(map.toString());
		
		map.put(6,"WORLD");
		System.out.println(map.toString());
		
		str = map.get(2);
		System.out.println(str);
		
		map.remove(5);
		System.out.println(map.toString());
		
		boolean b = map.containsValue("haha");
		System.out.println(b);
		
		map.clear();
		b = map.isEmpty();
		System.out.println(b);
		
	}
}
