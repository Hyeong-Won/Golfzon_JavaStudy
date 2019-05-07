package training;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import character.PlayableCharacter;

public class Training {
	private static HashMap<Integer, Integer> RequiredHP = new HashMap<Integer, Integer>();

	public Training() {

	}
	
	// get Required HP
	public static int getRequiredHP(int intAbility)
	{
		int intAbilityLevel = 0;
		switch (intAbility) {
		// ��
		case 1:
			intAbilityLevel = PlayableCharacter.getInstance().getStr();
			break;
		// ����
		case 2:
			intAbilityLevel = PlayableCharacter.getInstance().getInt();
			break;
		// ��ø
		case 3:
			intAbilityLevel = PlayableCharacter.getInstance().getAgi();
			break;
		}
		
		return RequiredHP.get(intAbilityLevel + 1);
	}

	public static void training(int intAbility) {
		int intRequiredHP 	= 0;
		int intAbilityLevel = 0;
		AddAbilityInterface func = null;
		String strAbility = null;
		
		switch (intAbility) {
		// ��
		case 1:
			intAbilityLevel = PlayableCharacter.getInstance().getStr();
			func = new AddAbilityInterface() {				
				@Override
				public int addAbility(int intRequiredHP) {
					return PlayableCharacter.getInstance().addStr(intRequiredHP);
				}
			};
			strAbility = "��";
			break;
		// ����
		case 2:
			intAbilityLevel = PlayableCharacter.getInstance().getInt();
			func = new AddAbilityInterface() {				
				@Override
				public int addAbility(int intRequiredHP) {
					return PlayableCharacter.getInstance().addInt(intRequiredHP);
				}
			};
			strAbility = "����";
			break;
		// ��ø
		case 3:
			intAbilityLevel = PlayableCharacter.getInstance().getAgi();
			func = new AddAbilityInterface() {				
				@Override
				public int addAbility(int intRequiredHP) {
					return PlayableCharacter.getInstance().addAgi(intRequiredHP);
				}
			};
			strAbility = "��ø";
			break;
		}
		
		intRequiredHP = RequiredHP.get(intAbilityLevel + 1);
		if(PlayableCharacter.getInstance().getUsableHP() < intRequiredHP)
		{
			System.out.println("ü���� �����մϴ�.");
			return;
		}
				
		System.out.println(strAbility + "�� " + func.addAbility(intRequiredHP) + "�� ����Ͽ����ϴ�.");
	}

	public static void setRequiredHP() {
		// ��� ���
		// File.separator : �ü�� ��� ���� ������
		String strFilePath = "data" + File.separator + "ability.txt";
		//File test = new File(strFilePath);
		//System.out.println(test.getAbsolutePath());

		BufferedReader objBR = null;
		FileReader objFR = null;
		try {
			objFR = new FileReader(strFilePath);
			objBR = new BufferedReader(objFR);

			String strLine = null;
			String[] arrText = null;

			while ((strLine = objBR.readLine()) != null) {
				// �迭�� �߶� �ְ�
				arrText = strLine.split(" ");
				// Map�� �Է�
				RequiredHP.put(Integer.parseInt(arrText[0]), Integer.parseInt(arrText[1]));
			}

			/*
	        for( int key : RequiredHP.keySet() ){
	    		System.out.println(key + " -> " + RequiredHP.get(key));
	        }
	        */
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}