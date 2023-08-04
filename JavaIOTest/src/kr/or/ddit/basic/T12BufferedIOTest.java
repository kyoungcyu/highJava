package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

/*
 * 성능향상을 위한 보조 스트림 예제2
 * (문자기반의 Buffered 스트림예제)
 */
public class T12BufferedIOTest {
	public static void main(String[] args) {
		FileReader fr =null;
		//BufferedReader br =null;
		
		try {
			fr =new FileReader("src/kr/or/ddit/basic/T11BufferedIOTest.java");
			
			int data =0;
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}finally {
			try {
				fr.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
			
		
	}
}
