package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T08HashMaoTest {

	/*
	 * Map = key 값과 value 값을 한 쌍으로 관리하는 객체 = key 값은 중복을 허용하지 않고 순서가 없다.(Set 의 특징) =
	 * value 값은 중복을 허용한다.
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		// 자료추가 = put(key 값, value 값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		System.out.println("map = " + map);

		// 자료 수정 = 데이터를 저장할 때 key 값이 같으면 나중에 입력한 값이 저장됨.
		// put(수정할 key 값, 새로운 value 값);
		map.put("addr", "서울");
		System.out.println("map = " + map);

		// 자료삭제 = remove(삭제할 값)
		map.remove("name");
		System.out.println("map = " + map);

		// 자료 읽기 = get(key 값);
		System.out.println("map.get(\"addr\") = " + map.get("addr"));
		System.out.println("===================================");

		// key 값들을 읽어와 자료를 출력하는 방법
		// 방법1 = keySet() 매서드 이용하기
		// Map 의 key 값들을 담은 객체를 반환한다.
		Set<String> keySet = map.keySet();
		System.out.println("Iterator를 이용한 방법");
		Iterator<String> it = keySet.iterator();

		while (it.hasNext()) {
			String key = it.next();
			System.out.println("map.get(key) = " + map.get(key));
		}
		System.out.println("=-------------------------------------------------=");

		// 방법 2 = Set 형의 데이터를 '향상된 for문' 으로 처리하면 Iterato 를 사용하지 않아도된다.
		System.out.println("향상된 for문");
		for (String s : keySet) {
			System.out.println("key = " + s);
		}
		System.out.println("=-------------------------------------------------=");

		// 방법3 = value 값만 읽어와 출력하기
		System.out.println("value() 메서드 이용");
		for (String value : map.values()) {

			System.out.println("value = " + value);
		}

		System.out.println("=-------------------------------------------------=");

		// 방법4 = Map 관련 클래스는 Map.Entry 타입의 내부 class 가 만들어져 있다.
		// 이 내부 클래스는 ket 와 value 라는 멤버변수로 구성되어 있다.
		// Map 에서 이 Map.Entry 타입의ㅔ 객체들을 Set 타입의 데이터로 저장하여관리한다.

		Set<Map.Entry<String, String>> entrySet = map.entrySet();

		// 가져온 Entry 객체들을 순서대로 처리하기 위해 Iterator 객체 사용하기
		Iterator<Map.Entry<String, String>> entryIt = entrySet.iterator();

		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();

			System.out.println("entry.getKey() = " + entry.getKey());
			System.out.println("entry.getValue() = " + entry.getValue());
			System.out.println();
		}

	}
}
