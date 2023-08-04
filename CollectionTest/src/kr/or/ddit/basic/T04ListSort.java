package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04ListSort {
	public static void main(String[] args) {

		List<Member> memList = new ArrayList<>();
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-1111"));
		memList.add(new Member(2, "일지매", "010-6666-1111"));

		System.out.println("정렬 전...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------");

		Collections.sort(memList);

		System.out.println("이름의 오름차순으로 정렬후...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------");

		Collections.shuffle(memList);
		
		System.out.println("섞은 후...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------");

		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("외부 정렬자를 이용한 정렬후...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------");
	}
}

/*
 * 외부정렬자를 생성하기 위해서 Comparator 인터페이스를 구현한다. (Member 번호의 내림차순으로 정렬하기 )
 */

class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {
		
//		if (mem1.getNum() > mem2.getNum()) {
//			return -1; //음수시 내림차순
//		} else if (mem1.getNum() == mem2.getNum()) {
//			return 0;
//		} else {
//			return 1; //양수시 오름차순
//		}
		
		//return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;
		
		return Integer.compare(mem1.getNum(), mem2.getNum())*-1;
	}
}

/*
 * 회원의 정보를 지정할 클래스 생성하기 회원정보는 회원번호(int), 회원이름 , 전화번호로 되어 있음 회원이름을 기준으로 오름차순 정렬이
 * 될 수 있는 클래스 생성하기
 */
class Member implements Comparable<Member> {
	private int num;
	private String name;
	private String tel;

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	@Override
	public int compareTo(Member mem) {

		return name.compareTo(mem.getName()); // 이름순으로 정렬 Collections.sort(memList);
	}

}