package character;

import java.util.HashMap;

public class NonPlayableCharacterManager {
	public HashMap<Integer, NonPlayableCharacter> NPC = new HashMap<Integer, NonPlayableCharacter>();

	// ������
	public NonPlayableCharacterManager() {
		NPC.put(1,	 new NonPlayableCharacter("���",		30,		4,		0,		0,		2400,	5));
		NPC.put(2,	 new NonPlayableCharacter("â���",	50,		10,		2000,	2000,	1200,	10));
		NPC.put(3,	 new NonPlayableCharacter("�������",	100,	8,		5000,	5000,	1800,	15));
		NPC.put(4,	 new NonPlayableCharacter("������",	200,	20,		0,		0,		4000,	20));
		NPC.put(5,	 new NonPlayableCharacter("��ũ",		250,	25,		0,		0,		6000,	25));
		NPC.put(6,	 new NonPlayableCharacter("������ũ",	300,	30,		2000,	0,		6500,	30));
		NPC.put(7,	 new NonPlayableCharacter("�����",		500,	100,	0,		0,		7000,	35));
		

		NPC.put(4,	 new NonPlayableCharacter("������",	100,	100,	0,		0,		7000,	35));

		//System.out.println("NonPlayableCharacterManager ();");
	}
}
