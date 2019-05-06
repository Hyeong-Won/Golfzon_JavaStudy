package javaObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javaObject.CommonModule.ROLE;

public class ServerClass {
    public static ArrayList<Character> arrCharacterList = null;
    public static Character            objCharacter1P   = null;
    public static Character            objCharacter2P   = null;
    
    //입출력 선언
    public static InputStream      objInStream     = null;
    public static DataInputStream  objDataInStream = null;
    public static OutputStream     objOutStram     = null;
    public static DataOutputStream objDataOutStram = null;
    
    
    public static void main(String[] args) {
        int    intRetVal = 0;
        int    intInMsg  = 0;
        String strInMsg  = null;
        
        //서버 소켓 선언
        ServerSocket objServerSocket = null;
        Socket       objSocket       = null;
        
        
        try {
            //캐릭터 리스트
            arrCharacterList = new ArrayList<Character>();
            
            //샘플 케릭터 생성
            arrCharacterList = makeCharacterSample();
            
            System.out.println("서버 시작");
            
            //클라이언트 연결
            objServerSocket = new ServerSocket(9000);
            objSocket = objServerSocket.accept();
            System.out.println("클라이언트 연결 : " + objSocket);
            
            //입출력 설정
            objInStream     = objSocket.getInputStream();
            objDataInStream = new DataInputStream(objInStream);
            objOutStram     = objSocket.getOutputStream();
            objDataOutStram = new DataOutputStream(objOutStram);
            
            objDataOutStram.writeUTF(CommonModule.MENU);
            objDataOutStram.flush();
            
            while (intRetVal == 0) {
                //데이터 수신
                strInMsg = objDataInStream.readUTF();
                System.out.println("메뉴 :" + strInMsg);
                intInMsg = Integer.parseInt(strInMsg);
                
                switch (intInMsg) {
                case 1:
                    //캐릭터 리스트 조회
                    intRetVal = getCharacterList();
                    
                    break;
                case 2:
                    objCharacter1P   = new Character();
                    objCharacter2P   = new Character();
                    
                    //캐릭터 선택
                    intRetVal = selectCharacter();
                    
                    break;
                case 3:
                    //캐릭터 선택 체크
                    if (checkSelectCharacter()) {
                        //캐릭터 결투
                        intRetVal = fightCharacter();
                    }
                    
                    objDataOutStram.writeUTF("종료");
                    objDataOutStram.flush();
                    
                    break;
                default:
                    //종료
                    intRetVal = 10;
                    objDataOutStram.writeUTF("종료");
                    objDataOutStram.flush();
                    
                    System.out.println("그만~~~");
                    break;
                }
            }
            
            System.out.println("종료 " + intRetVal);
            objServerSocket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (objDataOutStram != null) {
                    objDataOutStram.close();
                }
                if (objOutStram != null) {
                    objOutStram.close();
                }
                if (objDataInStream != null) {
                    objDataInStream.close();
                }
                if (objInStream != null) {
                    objInStream.close();
                }
                if (objSocket != null) {
                    objSocket.close();
                }
                if (objServerSocket != null) {
                    objServerSocket.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    //캐릭터 생성(샘플)
    private static ArrayList<Character> makeCharacterSample() {
        ArrayList<Character> arrCharacterList = new ArrayList<Character>();
        Character objCharacter = null;
        
        objCharacter = new Character();
        objCharacter.makeCharacter("전사", ROLE.Tanker.ordinal(), 100, 70, 30);
        arrCharacterList.add(objCharacter);
        
        objCharacter = new Character();
        objCharacter.makeCharacter("도적", ROLE.Dealer.ordinal(), 70, 150, 30);
        arrCharacterList.add(objCharacter);
        
        objCharacter = new Character();
        objCharacter.makeCharacter("법사", ROLE.Nucker.ordinal(), 30, 70, 150);
        arrCharacterList.add(objCharacter);
        
        objCharacter = new Character();
        objCharacter.makeCharacter("사제", ROLE.Healer.ordinal(), 30, 30, 150);
        arrCharacterList.add(objCharacter);
        
        return arrCharacterList;
    }
    
    //캐릭터 리스트
    public static int getCharacterList() {
        int intRetVal = 0;
        
        //문자열 클래스 사용
        StringBuilder strSBCharacter = null;
        
        try {
            strSBCharacter = new StringBuilder();
            
            strSBCharacter.append("----------------------------------------------------------------------------------------------------\n");
            strSBCharacter.append("\t\t캐릭터 리스트\n");
            
            for (int i = 0; i < arrCharacterList.size(); i++) {
                strSBCharacter.append("번호: "     + i);
                strSBCharacter.append(", 이름: "   + arrCharacterList.get(i).strName);
                strSBCharacter.append(", 역활: "   + arrCharacterList.get(i).strRole);
                strSBCharacter.append(", 생명력: " + arrCharacterList.get(i).intHealthPoint);
                strSBCharacter.append(", 마나: "   + arrCharacterList.get(i).intManaPoint);
                strSBCharacter.append(", 공격력: " + arrCharacterList.get(i).intPower);
                strSBCharacter.append(", 방어력: " + arrCharacterList.get(i).intDefensive);
                strSBCharacter.append("\n");
            }
            
            strSBCharacter.append("----------------------------------------------------------------------------------------------------\n");
            strSBCharacter.append(CommonModule.MENU);
            
            //데이터 전송
            objDataOutStram.writeUTF(strSBCharacter.toString());
            objDataOutStram.flush();
            
        }
        catch (Exception e) {
            intRetVal = 99;
            e.printStackTrace();
        }
        
        return intRetVal;
    }
    
    //캐릭터 선택
    public static int selectCharacter() {
        int intRetVal = 0;
        int intIndex1P = 0;
        int intIndex2P = 0;
        
        StringBuilder strSBCharacter = null;
        Random objRandom = null;
        
        try {
            strSBCharacter = new StringBuilder();
            objRandom = new Random();
            
            //데이터 전송
            objDataOutStram.writeUTF("\t1P 캐릭터를 선택하시오?(캐릭터 번호) : ");
            objDataOutStram.flush();
        
            //데이터 수신
            intIndex1P = Integer.parseInt(objDataInStream.readUTF());
            System.out.println("\t캐릭터 : " + intIndex1P);
            
            //상대 선택용
            intIndex2P = objRandom.nextInt(arrCharacterList.size());
            
            //캐릭터 선택
            objCharacter1P = arrCharacterList.get(intIndex1P);
            objCharacter2P = arrCharacterList.get(intIndex2P);
            
            strSBCharacter.append("\t1P 캐릭터 : " + objCharacter1P.printCharacter());
            strSBCharacter.append("\t2P 캐릭터 : " + objCharacter2P.printCharacter());
            strSBCharacter.append("----------------------------------------------------------------------------------------------------");
            strSBCharacter.append(CommonModule.MENU);
            //데이터 전송
            objDataOutStram.writeUTF(strSBCharacter.toString());
            objDataOutStram.flush();
        
        }
        catch (Exception e) {
            intRetVal = 99;
            e.printStackTrace();
        }
        
        return intRetVal;
    }
    
    //캐릭터 선택 여부
    public static boolean checkSelectCharacter() {
        boolean blnSelectCharacter = false;
        StringBuilder strSBCharacter = null;
        
        try {
            strSBCharacter = new StringBuilder();
            
            if (objCharacter1P == null || objCharacter2P == null) {
                blnSelectCharacter = false;
                
                strSBCharacter.append("캐릭터 선택부터 ~~~");
            }
            else {
                blnSelectCharacter = true;
                
                strSBCharacter.append("----------------------------------------------------------------------------------------------------");
                strSBCharacter.append("1P => 이름: " + objCharacter1P.strName + ", 역활: " + objCharacter1P.strRole);
                strSBCharacter.append("2P => 이름: " + objCharacter2P.strName + ", 역활: " + objCharacter2P.strRole);
                strSBCharacter.append("----------------------------------------------------------------------------------------------------");
            }
            
            //데이터 전송
            //objDataOutStram.writeUTF(strSBCharacter.toString());
            //objDataOutStram.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return blnSelectCharacter;
    }
    
    //캐릭터 결투
    public static int fightCharacter() {
        int intRetVal = 0;
        
        try {
            
            while (objCharacter1P.intHealthPoint > 0 && objCharacter2P.intHealthPoint > 0) {
                if (objCharacter1P.intHealthPoint > 0) {
                    castAction(objCharacter1P, objCharacter2P, 1);
                }
                if (objCharacter2P.intHealthPoint > 0) {
                    castAction(objCharacter2P, objCharacter1P, 2);
                }
            }
            
            intRetVal = 10;
            
            //데이터 전송
//            objDataOutStram.writeUTF(Integer.toString(intRetVal));
//            objDataOutStram.flush();
            
        
        }
        catch (Exception e) {
            intRetVal = 99;
            e.printStackTrace();
        }
        finally {
            objCharacter1P = null;
            objCharacter2P = null;
        }
        return intRetVal;
    }
    
    //캐릭터 액션
    public static void castAction(Character objCharacter4Att, Character objCharacter4Def, int intPlayer) {
        int    intAction    = 0;
        int    intActionNo  = 0;
        
        Cast   objCast      = null;
        StringBuilder strSBCharacter = null;
        ArrayList<HashMap<String, String>> arrSkillList = null;
        Random objRandom = null;
        
        try {
            strSBCharacter = new StringBuilder();
            arrSkillList = new ArrayList<HashMap<String, String>>();
            objRandom = new Random();
            
            //각 역활의 시전 클래스 - 추상 클래스
            switch(objCharacter4Att.intRole) {
                case 0:
                    objCast  = new Cast4Tanker();
                    break;
                case 1:
                    objCast  = new Cast4Dealer();
                    break;
                case 2:
                    objCast  = new Cast4Nucker();
                    break;
                case 3:
                default:
                    objCast  = new Cast4Healer();
                    break;
            }
            
            //스킬 세팅
            arrSkillList = objCast.getSkill();
            
            if (intPlayer == 1) {
                strSBCharacter.append("1 공격\n");
                
                //스킬 설명 출력
                for (int i = 0; i < arrSkillList.size(); i++) {
                    intActionNo = i + 2;
                    strSBCharacter.append(intActionNo + " 스킬 " + arrSkillList.get(i).get("name") + " -> " + arrSkillList.get(i).get("desc") + "\n");
                }
                
                strSBCharacter.append(objCharacter4Att.strName + "선택 하시오\n");
                
                //데이터 전송
                objDataOutStram.writeUTF(strSBCharacter.toString());
                objDataOutStram.flush();
                
                //데이터 수신
                intAction = Integer.parseInt(objDataInStream.readUTF());
                System.out.println("\t1P 액션 : " + intAction);
            }
            else {
                intAction = objRandom.nextInt(3) + 1;
                System.out.println("\t2P 액션 : " + intAction);
            }
            
            //초기화
            strSBCharacter.setLength(0);
            
            if (intAction == 1) {
                //공격
                strSBCharacter.append("\t공격 : " + objCharacter4Att.strName + " -> " + objCharacter4Def.strName + "\n");
                objCast.castAttack(objCharacter4Att, objCharacter4Def);
            }
            else if (intAction == 2) {
                //스킬 시전 - 추상 메서드
                objCast.castSkill(arrSkillList.get(0).get("name"), objCharacter4Att, objCharacter4Def);
                strSBCharacter.append("\t스킬 - " + arrSkillList.get(0).get("name") + " : " + objCharacter4Att.strName + " -> " + objCharacter4Def.strName + "\n");
            }
            else if(intAction == 3) {
                //스킬 시전 - 추상 메서드
                objCast.castSkill(arrSkillList.get(1).get("name"), objCharacter4Att, objCharacter4Def);
                strSBCharacter.append("\t스킬 - " + arrSkillList.get(1).get("name") + " : " + objCharacter4Att.strName + " -> " + objCharacter4Def.strName + "\n");
            }
            
            strSBCharacter.append("----------------------------------------------------------------------------------------------------");
            strSBCharacter.append("\t1P 캐릭터 : " + objCharacter1P.printCharacter());
            strSBCharacter.append("\t2P 캐릭터 : " + objCharacter2P.printCharacter());
            strSBCharacter.append("----------------------------------------------------------------------------------------------------");
            
            if (objCharacter1P.intHealthPoint > 0 && objCharacter2P.intHealthPoint <= 0) {
                strSBCharacter.append("\n\t\t1P 승리~~!!!");
            }
            else if (objCharacter2P.intHealthPoint > 0 && objCharacter1P.intHealthPoint <= 0) {
                strSBCharacter.append("\n\t\t2P 승리~~!!!");
            }
            
            strSBCharacter.append("\n계속하려면 아무키나 누르세요");
            
            //데이터 전송
            objDataOutStram.writeUTF(strSBCharacter.toString());
            objDataOutStram.flush();
            
            //데이터 수신
            intAction = Integer.parseInt(objDataInStream.readUTF());
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return;
    }
    
    
}

