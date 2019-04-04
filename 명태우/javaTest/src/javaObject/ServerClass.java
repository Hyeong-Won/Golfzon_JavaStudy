package javaObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javaObject.CommonModule.ROLE;

public class ServerClass {
    public static ArrayList<Character> arrCharacterList = null;
    public static Character            objCharacter1P   = null;
    public static Character            objCharacter2P   = null;
    
    public static void main(String[] args) {
        //서버 소켓 선언
        ServerSocket objServerSocket = null;
        Socket       objSocket       = null;
        
        //입출력 선언
        InputStream objInStream = null;
        DataInputStream objDataInStream = null;
        OutputStream objOutStram = null;
        DataOutputStream objDataOutStram = null;
        
        StringBuilder strSBOutMsg = null;
        String strInMsg = null;
        String strOutMsg = null;
        
        int    intInMsg = 0;
                
                
        try {
            
            //문자열 클래스 사용
            strSBOutMsg = new StringBuilder();
            
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
            objInStream = objSocket.getInputStream();
            objDataInStream = new DataInputStream(objInStream);
            objOutStram = objSocket.getOutputStream();
            objDataOutStram = new DataOutputStream(objOutStram);
            
            while (true) {
                strOutMsg = "메뉴를 선택하시오.(1:캐릭터 생성, 2:캐릭터 선택, 3:캐릭터 결투) : ";
                System.out.println(strOutMsg);
                objDataOutStram.writeUTF(strOutMsg);
                objDataOutStram.flush();
                
                //데이터 수신
                //strClientString = objDataInStream.readUTF();
                strInMsg = objDataInStream.readUTF();
                System.out.println(strInMsg);
                intInMsg = Integer.parseInt(strInMsg);
                
                switch (intInMsg) {
                case 1:
                    //캐릭터 생성
                    //arrCharacterList.add(makeCharacter(objScan));
                    objDataOutStram.writeUTF("미구현");
                    objDataOutStram.flush();
                    
                    break;
                case 2:
                    //캐릭터 리스트 조회
                    strSBOutMsg = getCharacterList();
                    objDataOutStram.writeUTF(strSBOutMsg.toString());
                    objDataOutStram.flush();
                    //초기화
                    strSBOutMsg.setLength(0);
                    
                    //캐릭터 선택
                    objCharacter1P   = new Character();
                    strInMsg = objDataInStream.readUTF();
                    System.out.println(strInMsg);
                    intInMsg = Integer.parseInt(strInMsg);
                    
                    strSBOutMsg = selectCharacter(intInMsg);
                    objDataOutStram.writeUTF(strSBOutMsg.toString());
                    objDataOutStram.flush();
                    //초기화
                    strSBOutMsg.setLength(0);
                    
                    break;
                case 3:
                    //캐릭터 결투
                    //if (checkSelectCharacter()) {
                    //    fightCharacter(objScan);
                    //}
                    break;
                default:
                    //종료
                    System.out.println("그만~~~");
                    break;
                }
                
                
                //데이터 송신
                //objDataOutStram.writeUTF("");
                //objDataOutStram.flush();
            }
            
            
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
    
    //메인 게임
    public static void mainGame(int intMainMode) {
        
        
        switch (intMainMode) {
        case 1:
            //캐릭터 생성
            //arrCharacterList.add(makeCharacter(objScan));
            break;
        case 2:
            //캐릭터 선택
            //objCharacter1P   = new Character();
            //objCharacter2P   = new Character();
            
            //selectCharacter(objScan);
            break;
        case 3:
            //캐릭터 결투
            //if (checkSelectCharacter()) {
            //    fightCharacter(objScan);
            //}
            break;
        default:
            //종료
            System.out.println("그만~~~");
            break;
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
    public static StringBuilder getCharacterList() {
        //문자열 클래스 사용
        StringBuilder strSBCharacter = new StringBuilder();
        
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
        strSBCharacter.append("\t캐릭터를 선택하시오?(캐릭터 번호) : ");
        
        return strSBCharacter;
    }
    
    //캐릭터 선택
    public static StringBuilder selectCharacter(int intIndex1P) {
        //문자열 클래스 사용
        StringBuilder strSBCharacter = new StringBuilder();
        
        //캐릭터 선택
        objCharacter1P = arrCharacterList.get(intIndex1P);
        //System.out.printf("\t==>1P 캐릭터 : %s\n", objCharacter1P.strName.toString());
        
        strSBCharacter.append("\t==>1P 캐릭터 : "+ objCharacter1P.strName.toString() + "\n");
        strSBCharacter.append("----------------------------------------------------------------------------------------------------");
        
        return strSBCharacter;
    }
    
    
}
