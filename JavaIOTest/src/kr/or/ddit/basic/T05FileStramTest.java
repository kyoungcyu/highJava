package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *  파일 읽기 예제
 */
public class T05FileStramTest {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
	
		try {
			fis= new FileInputStream("d:/D_Other/test.txt");
			
			int data = 0;
			while((data = fis.read()) != -1) {
					//읽은 데이터 출력
				System.out.print((char) data);
			} //byte 범위넘어가면 깨짐  한국말 x
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close();
			}catch(IOException e){
				e.printStackTrace();				
			}
		}
		
	}
}
