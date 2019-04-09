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
			
			System.out.print("�α����� ���� �̸� : ");
			new SocketThread(socket).start();
			while(true) {
				boolean escape = false;
				// ���� ��� ���� 
				// ex) 1^�̸��Է�  -> 1�� ��µ���, '^' �ڴ� ����Ҵ��
				// ex) 2^          -> 2�� �Է¿�û
				// ex) 3^		   -> ����
				String allString = dis.readUTF();
				// ����
				String work = null;
				// �ؽ�Ʈ
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
			
			System.out.println("����");
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
		System.out.println("1: �������");
		System.out.println("2: ĳ������/������ ����");
		System.out.println("3: ���ӽ���");
		System.out.println("4: ��ü��������");
		System.out.println("5: ��ü���ӷα׺���");
		System.out.println("99: ����");
		System.out.println("=========================");
		return scan.nextInt(); 
	}
	
	public static String getUserName(Scanner scan)
	{
		System.out.print("���� �̸��� �Է����ּ��� : ");
		return scan.next(); 
	}

}
