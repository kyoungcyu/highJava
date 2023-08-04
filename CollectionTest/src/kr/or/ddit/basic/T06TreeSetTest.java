package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class T06TreeSetTest {
	public static void main(String[] args) {
		//TreeSet은 자동정렬 기능이 들어가있음
		TreeSet<String> ts =new TreeSet<>();
		
		List<String> abcList = new ArrayList<>();
		
		//영어 대문자를 문자열로 반환하여 List에 저장하기
		
		for(char ch ='A' ; ch<='Z';ch++) {
			String temp =String.valueOf(ch);//모든것을 string 으로 타입변환value
			abcList.add(temp);
		}
		
		Collections.shuffle(abcList);
		
		System.out.println("섞은 후 abcList:"+ abcList);
		
		for(String str :abcList) {
			ts.add(str);
		}
		System.out.println("TreeSet 데이터 :"+ ts);
		
		//TreeSet에 저장된 자료 중 특정한 자료보다 작은 자료를 찾아서 SortedSet으로 반환하는
		//메서드가 있다/
		// => headSet(기준값) : 기본적으로 '기준값'은 포함시키지 않는다.
		// => headSet(기준값, 논리값) : 논리값이 'true'이면 '기준값'포함시킨다.
		
		SortedSet<String> ss1 = ts.headSet("K");//기준값을 포함하지않음
		System.out.println("K 이전 자료 : " +ss1);//default는 기준값을 포함하지 않음 k전 까지만 나옴 
		System.out.println("K 이전자료 (기준값 포함): "+ts.headSet("K",true));//k 포함하고 싶을경우
		
		//'기준값' 보다 큰 자료를 찾아 SortedSet으로 반환하는 메소드
		// => tailSet(기준값) : 기본적으로 '기준값' 을 포함시킨다
		// => tailSet(기준값, 논리값) :  '논리값'이 'false'이면 '기준값'  미포함
		
		SortedSet<String> ss2= ts.tailSet("K");//기준값 포함해서 결과 출력
		System.out.println("K 이후 자료: "+ ss2);
		System.out.println("K 이후 자료(기준값 미포함):" + ts.tailSet("K", false));
		
		//subSet(기준값1, 기준값2) : 기준값1~ 기준값2 사이의 값을 가져온다.
		//							('기준값1' 포함, ' 기준값2' 미포함)
		//subSet(기준값1,논리값1, 기준값2, 논리값2): 각'기준값'을 포함할지 여부를 설정한다.)
		//												('논리값'이 true이면 포함, false이면 미포함)
		
		System.out.println("K (포함)부터 N(미포함)까지 :"+ts.subSet("K", "N"));
		System.out.println("K (포함)부터 N(포함)까지 :"+ts.subSet("K",true, "N",true));
		System.out.println("K (미포함)부터 N(미포함)까지 :"+ts.subSet("K", false,"N",false));
		System.out.println("K (미포함)부터 N(포함)까지 :"+ ts.subSet("K",false,"N", true));
	}
}
