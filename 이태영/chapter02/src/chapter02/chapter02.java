package chapter02;

public class chapter02 {
	
	public static void main(String[] args) {
		
		FileInfoClass fileInfo = new FileInfoClass();
		
		fileInfo.addFile("filelist1.txt");
		fileInfo.addFile("filelist2.csv");
		fileInfo.addFile("filelist3.txt");
		fileInfo.addFile("filelist4.csv");		
		fileInfo.addFile("filelist5.txt");
		
		fileInfo.printFileList();
		
		fileInfo.printSearchFileExt("csv");
		fileInfo.printSearchFileExt("txt");
		
		
		fileInfo.removeFile("filelist4.csv");
		
		fileInfo.printFileList();
	}

}
