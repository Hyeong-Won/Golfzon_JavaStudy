package javaObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {

    public static void main(String[] args) {
        //소켓 선언
        Socket objSocket = null;
        
        //입출력 선언
        InputStream objInStream = null;
        DataInputStream objDataInStream = null;
        
        OutputStream objOutStram = null;
        DataOutputStream objDataOutStram = null;
        
        Scanner objScan = null;
        
        String strInMsg = null;
        String strOutMsg = null;
        
        try {
            objScan          = new Scanner(System.in);
            
            //서버 연결
            objSocket = new Socket("127.0.0.1", 9000);
            System.out.println("서버 연결");
            
            //입출력 설정
            objInStream = objSocket.getInputStream();
            objDataInStream = new DataInputStream(objInStream);
            objOutStram = objSocket.getOutputStream();
            objDataOutStram = new DataOutputStream(objOutStram);

            while (true) {
                //데이터 수신
                strInMsg = objDataInStream.readUTF();
                System.out.println(strInMsg);
                strInMsg = objScan.next();
                
                //데이터 송신
                objDataOutStram.writeUTF(strInMsg);
                objDataOutStram.flush();
                
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            
        }
        
        
        
        
        
    }
}
