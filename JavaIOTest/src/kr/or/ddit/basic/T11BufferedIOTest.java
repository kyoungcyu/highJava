package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
  입출력 선능향상을 위한 보조스트림 예제1	
  (바이트 기반의 )
 */

public class T11BufferedIOTest {
	public static void main(String[] args) {
		
		FileOutputStream fos =null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");
	
			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192byte(8Kb)로 설정됨
		
			// 버퍼의 크기가 5인 스트림 객체 생성
			bos = new BufferedOutputStream(fos, 5);
			
			for(char ch='1'; ch<='9'; ch++) {
				System.out.println("쓰기작업.");
				bos.write(ch);
			}
	
			bos.flush(); // 작업종료전 버퍼에 남아있는 데이터를 모두 출력시킴
						 // close시 자동으로 호출됨 .
			System.out.println("작업 끝 ... ");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				bos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
