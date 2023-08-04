package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {  //Number class 

		double v1 = t1.doubleValue();	
		double v2 = t2.doubleValue();

		return Double.compare(v1, v2);
	}
}

public class T04GenericMethodTest {
	public static void main(String[] args) {

		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3);
		System.out.println(result2);
		
//		Util2.compare("C", "JAVA"); 타입이 Number 클래스가 아니기 때문에 안됨  
		List<?> list = new ArrayList<String>();   //와일드 카드  <> 후에나타날 타입이 뭔지모를때사용  
	}
}
