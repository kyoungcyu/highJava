package kr.or.ddit.basic;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class T03ResorceBundleTest {
/*
    ResourceBundle객체 => 확장자가 properties인 파일 정보를 읽어와 key값과 value값을 분리할 정보를 갖는 객체
    
    		=> 읽어올 파일은  'key값 = value값' 형태로 되어 있어야 한다.
 */
	public static void main(String[] args) {
		/*
		  	ResourceBundle 객체 생성하기 
		  	=> 파일을 지정할 때는 '파일명'만 지정하고 확장자는 지정하지 않는다.
		  	  (확장자는 항상 properties이기 때문에.. )	
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("db",Locale.JAPANESE);
		
		Enumeration<String> keys = bundle.getKeys();
		
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			// key 값을 이용하여 value값을 가져오는 방법
			// => bundle 객체변수, getString(key값);
			String value = bundle.getString(key);
			
			System.out.println(key + " : " + value);
			
		}
		System.out.println("출력 끝 .");
	}
}
