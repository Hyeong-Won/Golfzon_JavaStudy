package character;

import java.util.HashMap;

public class NonPlayableCharacterManager {
	public static HashMap<Integer, NonPlayableCharacter> NPC = new HashMap<Integer, NonPlayableCharacter>();

	// 생성자
	public NonPlayableCharacterManager() {
		NPC.put(1,	 new NonPlayableCharacter("고블린",		30,		4,		0,		0,		2400,	5));
		NPC.put(2,	 new NonPlayableCharacter("창고블린",	50,		10,		2000,	2000,	1200,	10));
		NPC.put(3,	 new NonPlayableCharacter("도적고블린",	100,	8,		5000,	5000,	1800,	15));
		NPC.put(4,	 new NonPlayableCharacter("대장고블린",	200,	20,		0,		0,		4000,	20));
		NPC.put(5,	 new NonPlayableCharacter("오크",		250,	25,		0,		0,		6000,	25));
		NPC.put(6,	 new NonPlayableCharacter("도끼오크",	300,	30,		2000,	0,		6500,	30));
		NPC.put(7,	 new NonPlayableCharacter("오우거",		500,	100,	0,		0,		7000,	35));
		
		//System.out.println("NonPlayableCharacterManager ();");
	}
	
	public static void printNPCList()
	{
		System.out.println("================================================");
		System.out.println("   전투 대상");
		System.out.println("------------------------------------------------");
        for( int key : NPC.keySet() ){
    		System.out.println("  -> " + key + ". " + NPC.get(key).getName());
        }
		System.out.println("  -> 9. 나가기");
        System.out.print("  => 선택 옵션? : ");
	}
}
