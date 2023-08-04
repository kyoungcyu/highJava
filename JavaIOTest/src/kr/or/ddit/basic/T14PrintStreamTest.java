package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *	프린터 기능을 제공하는 보조스트림
 */
public class T14PrintStreamTest {
	public static void main(String[] args) throws IOException{
		
		FileOutputStream fos = new FileOutputStream("d:/d_Other/print.txt");
		
		// PrintStram은 모든 데이터를 출력할 수 있는 기능을 제공하는 보조스트림이다.
		
		PrintStream out = new PrintStream(fos);
		out.print("안녕하세요. PrintStream 입니다 .\n");
		out.println("안녕하세요. PrintStream 입니다2 .");
		out.println("안녕하세요. PrintStream 입니다3 .");
		out.println(out); //객체출력
		out.println(3.14);
		
		System.out.println();
		/////////////////////////////////////////////////////
	
		/*
		 	PrintWriter가 PrintStream보다 다양한 인코딩의 문자처리에 적합하지만 
		 	예전부터 써 오던 객체라 계속 사용중임 .
		 */
			
			PrintWriter pw = new PrintWriter(
								new OutputStreamWriter(
										new FileOutputStream("d:/D_Other/print2.txt"),"UTF-8"));
		
			pw.print("안녕하세요. PrintWriter 입니다. \n");
			pw.println("안녕하세요. PrintWriter 입니다2. ");
			pw.println("안녕하세요. PrintWriter 입니다3. ");
			
			pw.close();
	}
}
