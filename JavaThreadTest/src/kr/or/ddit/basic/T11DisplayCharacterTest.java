package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T11DisplayCharacterTest {
/*
    3개(명)의 스레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸 순서대로 결과를 나타내는
    프로그램을 작성하시오.
 */
	static int currRank =1; //현재 순위정보
	public static void main(String[] args) {
		
		List<DisplayCharacter> disCharList = new ArrayList<>();
		disCharList.add(new DisplayCharacter("홍길동"));
		disCharList.add(new DisplayCharacter("일지매"));
		disCharList.add(new DisplayCharacter("변학도"));
		disCharList.add(new DisplayCharacter("성춘향"));
		
		for(Thread th : disCharList) {
			th.start();
		}
		for(Thread th : disCharList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	 System.out.println("경기 끝");
	 System.out.println();
	 Collections.sort(disCharList);
	 
	 System.out.println("경기 끝...");
	 System.out.println("-------------------------------------");
	 System.out.println("경기 결과");
	 System.out.println();
	 System.out.println("순위\t:\t이름");
	 System.out.println("-------------------------------------");

	 for(DisplayCharacter dc: disCharList) {
		 System.out.println(dc.getRank() + "\t:\t" +dc.getName());
	 }
	}
	
	
	
}
/**
 *  알파벳 대문자를 출력하는 스레드 클래스
 */
class DisplayCharacter extends Thread implements Comparable<DisplayCharacter> {
	private String name;
	private int rank;
	
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public DisplayCharacter(String name) {
		super(name);
		this.name=name;
	}

	@Override
	public void run() {
		for(char ch='A';ch<='Z';ch++) {
			
			System.out.println(name + "의 출력문자 :" +ch);
	
		try {
			//200 ~ 500ms 사이의 정지상태가 일어남  
			//math.random() 자체적으로  [0.0 <= i <1.0] 가지고있어서 301 을 곱하고 +200  
			Thread.sleep((int)(Math.random() *301 +200));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	System.out.println(name + "출력 끝...");
	setRank(T11DisplayCharacterTest.currRank++);
	
}

	@Override
	public int compareTo(DisplayCharacter dc) {
		return new Integer(this.getRank()).compareTo(dc.getRank());
	}
}