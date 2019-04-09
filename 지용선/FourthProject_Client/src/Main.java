import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan = null;
		
		OutputStream     os  = null;
		DataOutputStream dos = null;
		
		InputStream     is  = null;
		DataInputStream dis = null;
		
		try {
			socket = new Socket("localhost",9998);
			
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			scan = new Scanner(System.in);
			
			System.out.print("로그인할 유저 이름 : ");
			new SocketThread(socket).start();
			while(true) {
				boolean escape = false;
				// 서버 통신 전문 
				// ex) 1^이름입력  -> 1은 출력동작, '^' 뒤는 출력할대상
				// ex) 2^          -> 2는 입력요청
				// ex) 3^		   -> 종료
				String allString = dis.readUTF();
				// 동작
				String work = null;
				// 텍스트
				String text = null;
				if(allString.indexOf("^") > 0) {
					work = allString.split("\\^")[0];
					text = allString.split("\\^")[1];
				}
				
				switch(work) {
				case Const.READ:
					System.out.println(text);
					break;
				case Const.WRITE:
					new SocketThread(socket).start();
					break;
					
				case Const.TERMINATE:
				default:
					escape = true;
					break;
				}
				
				if(escape) {
					break;
				}
			}
			
			System.out.println("종료");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
		}
	}
	

	public static int PrintMenu(Scanner scan)
	{
		System.out.println("=========================");
		System.out.println("1: 유저등록");
		System.out.println("2: 캐시충전/아이템 구매");
		System.out.println("3: 게임시작");
		System.out.println("4: 전체유저보기");
		System.out.println("5: 전체게임로그보기");
		System.out.println("99: 종료");
		System.out.println("=========================");
		return scan.nextInt(); 
	}
	
	public static String getUserName(Scanner scan)
	{
		System.out.print("유저 이름을 입력해주세요 : ");
		return scan.next(); 
	}

}
