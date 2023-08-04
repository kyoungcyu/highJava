package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleWriteTest {
/*
  JSON : Javascript Object Notation
  	자바스크립트 객체 표기법으로 작성된 텍스트이며 , 데이터를 저장하거나 주고받기 위해 사용된다.
  	
  - JSON에서 값으로 사용가능한 데이터 타입
  1. string 
  2. number
  3. object(JSON object)		
  4. array		
  5. boolean
  6. null
 
 */
	public static void main(String[] args) throws IOException {
		
		// JSON 데이터 생성하기
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", "홍길동");
		jsonObj.put("job", "학생");
		jsonObj.put("age", 30);
		jsonObj.put("addr", "대전시 중구 대덕인재개발원");
	
		// JSONArray 데이터 생성
		JSONArray memList =new JSONArray();
	
		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("name", "이순신");
		jsonObj2.put("job", "군인");
		jsonObj2.put("age", 40);
		jsonObj2.put("addr", "서울시");
		memList.add(jsonObj2);
		jsonObj2 = new JSONObject();
		jsonObj2.put("name", "이순신2");
		jsonObj2.put("job", "군인2");
		jsonObj2.put("age", 42);
		jsonObj2.put("addr", "서울시2");
		memList.add(jsonObj2);
		jsonObj2 = new JSONObject();
		jsonObj2.put("name", "이순신3");
		jsonObj2.put("job", "군인3");
		jsonObj2.put("age", 43);
		jsonObj2.put("addr", "서울시3");
		memList.add(jsonObj2);
		jsonObj2 = new JSONObject();
		jsonObj2.put("name", "이순신4");
		jsonObj2.put("job", "군인4");
		jsonObj2.put("age", 44);
		jsonObj2.put("addr", "서울시4");
		memList.add(jsonObj2);
		
		jsonObj.put("memList", memList);
		
		System.out.println(jsonObj);
		
		FileWriter fw = new FileWriter("./myJsonFile.txt");
		
		String myJsonTxt= "{\"name\": \"홍길동\",\"age\": 50}";
		
		fw.write(jsonObj.toString());
		fw.close();
		
	
	 
	}


















}
