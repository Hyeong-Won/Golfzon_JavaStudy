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
		// 힘
		case 1:
			intAbilityLevel = PlayableCharacter.getInstance().getStr();
			break;
		// 지능
		case 2:
			intAbilityLevel = PlayableCharacter.getInstance().getInt();
			break;
		// 민첩
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
		// 힘
		case 1:
			intAbilityLevel = PlayableCharacter.getInstance().getStr();
			func = new AddAbilityInterface() {				
				@Override
				public int addAbility(int intRequiredHP) {
					return PlayableCharacter.getInstance().addStr(intRequiredHP);
				}
			};
			strAbility = "힘";
			break;
		// 지능
		case 2:
			intAbilityLevel = PlayableCharacter.getInstance().getInt();
			func = new AddAbilityInterface() {				
				@Override
				public int addAbility(int intRequiredHP) {
					return PlayableCharacter.getInstance().addInt(intRequiredHP);
				}
			};
			strAbility = "지능";
			break;
		// 민첩
		case 3:
			intAbilityLevel = PlayableCharacter.getInstance().getAgi();
			func = new AddAbilityInterface() {				
				@Override
				public int addAbility(int intRequiredHP) {
					return PlayableCharacter.getInstance().addAgi(intRequiredHP);
				}
			};
			strAbility = "민첩";
			break;
		}
		
		intRequiredHP = RequiredHP.get(intAbilityLevel + 1);
		if(PlayableCharacter.getInstance().getUsableHP() < intRequiredHP)
		{
			System.out.println("체력이 부족합니다.");
			return;
		}
				
		System.out.println(strAbility + "이 " + func.addAbility(intRequiredHP) + "로 상승하였습니다.");
	}

	public static void setRequiredHP() {
		// 상대 경로
		// File.separator : 운영체제 상관 없는 구분자
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
				// 배열에 잘라서 넣고
				arrText = strLine.split(" ");
				// Map에 입력
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