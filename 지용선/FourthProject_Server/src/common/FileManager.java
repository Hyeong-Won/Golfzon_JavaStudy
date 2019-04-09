package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {

	public static <T> void saveFile(T obj) {
		FileOutputStream   fos = null;
		ObjectOutputStream os  = null; 
		try {
			String path = System.getProperty("user.dir")+"/"+obj.getClass().getSimpleName();
			fos = new FileOutputStream(path);
			os  = new ObjectOutputStream(fos); 
			
			os.writeObject(obj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(os != null) {
					os.close();
				}
				if(fos != null) {					
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static <T> T loadFile(T obj) {
		FileInputStream   fileStream = null;
		ObjectInputStream is = null;
		try {
			String path = System.getProperty("user.dir")+"/"+obj.getClass().getSimpleName();
			fileStream = new FileInputStream(path);
			is         = new ObjectInputStream(fileStream); // 읽어온 직렬화된 내용을 역직렬화 하는 역할

			return obj = (T)is.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return obj;
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return obj;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return obj;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return obj;
		}
		finally {
			try {
				if(is != null) {
					is.close();
				}
				if(fileStream != null) {
					fileStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
