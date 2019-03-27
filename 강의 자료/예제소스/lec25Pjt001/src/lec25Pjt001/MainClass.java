package lec25Pjt001;

import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {

	public static void main(String[] args) {
		
		// ArrayList ��ü ����
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("list.size : " + list.size());
		
		// ������ �߰�
		list.add("Hello");
		list.add("Java");
		list.add("World");
		System.out.println("list.size : " + list.size());
		System.out.println("list : " + list);
		
		list.add(2, "Programing");	// �߰�
		System.out.println("list : " + list);
		
		list.set(1, "C");			// ����
		System.out.println("list : " + list);
		
		// ������ ����
		String str = list.get(2);
		System.out.println("list.get(2) : " + str);
		System.out.println("list : " + list);
		
		// ������ ����
		str = list.remove(2);
		System.out.println("list.remove(2) : " + str);
		System.out.println("list : " + list);
		
		// ������ ��ü ����
		list.clear();
		System.out.println("list : " + list);
		
		// ������ ����
		boolean b = list.isEmpty();
		System.out.println("list.isEmpty() : " + b);
		
		System.out.println(" ==================================== ");
		
		// HashMap ��ü ����
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("map.size() : " + map.size());
		
		// ������ �߰�
		map.put(5, "Hello");
		map.put(6, "Java");
		map.put(7, "World");
		System.out.println("map : " + map);
		System.out.println("map.size() : " + map.size());
		
		map.put(8, "!!");
		System.out.println("map : " + map);
		
		// ������ ��ü
		map.put(6, "C");
		System.out.println("map : " + map);
		
		// ������ ����
		str = map.get(5);
		System.out.println("map.get(5) : " + str);
		
		// ������ ����
		map.remove(8);
		System.out.println("map : " + map);
		
		// Ư�� ������ ���� ����
		b = map.containsKey(7);
		System.out.println("map.containsKey(7) : " + b);
		
		b = map.containsValue("World");
		System.out.println("map.containsValue(\"World\") : " + b);
		
		// ������ ��ü ����
		map.clear();
		System.out.println("map : " + map);
		
		// ������ ����
		b = map.isEmpty();
		System.out.println("map.isEmpty() : " + b);
	}
	
}
