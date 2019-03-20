package chapter02;

import java.util.ArrayList;
import java.util.List;

public class FileInfoClass {

	List<String> arrFileList;
	
	public FileInfoClass() {
		this.arrFileList = new ArrayList<String>();
	}
	
	public void addFile(String strFileName) {
		arrFileList.add(strFileName);
	}
	
	public void removeFile(String strFileName) {
		arrFileList.remove(strFileName);
	}	
	
	public void printFileList() {
		for(Object object : arrFileList) {
			String fileList = (String)object;
			
			System.out.printf("fileList : %s\n", fileList );
		}	
		System.out.println("");
	}
	
	public void printSearchFileExt(String strFileExtension) {
		int intMatchedCnt = 0;
		for(Object object : arrFileList) {
			String fileList = (String)object;
			
			String[] arrFilename = fileList.split("\\.");
			
			// csv 확장자만 카운트하여 목록 출력하기
			if(arrFilename[1].equalsIgnoreCase("csv")) {
				intMatchedCnt = intMatchedCnt + 1;
				System.out.println(fileList);
			}							
		}			
		System.out.printf("발견된 %s 파일 총 개수(%d)\n\n", strFileExtension, intMatchedCnt);
	}
}
