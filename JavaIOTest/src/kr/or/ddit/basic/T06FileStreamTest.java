package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;

public class T06FileStreamTest {
	
	public static void main(String[] args) {
	
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("d:/d_Other/out.txt"); //파일 작성
			
			for(char ch='a'; ch<='z'; ch++) {
				fos.write(ch);
			}
			System.out.println("파일에 쓰기완료 ........");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
}
