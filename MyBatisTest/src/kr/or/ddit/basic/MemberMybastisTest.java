package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MemberMybastisTest {
	public static void main(String[] args) {
		// myBastis를 이용하여 DB 자료를 읽어와 처리하는 작업 순서
		// 1. myBatis의 환경설정파일을 읽어와 myBatis 객체를 생성한다 .
		
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			// 1-1. xml문서 읽어오기
			Charset charset = Charset.forName("UTF-8"); // 설정파일의 한글처리용
			Resources.setCharset(charset);
			
			Reader rd = Resources
					.getResourceAsReader("config/mybatis-config.xml");
			
			// 1-2. 위에서 읽어온 Reader개체를 이용하여 실제 작업을 진행할 객체 생성하기
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			rd.close(); // Reader 닫기
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다 .
		
		// 2-1. insert작업 연습
		System.out.println("insert 작업시작. ");
		
		// 1) 저장할 데이터를 VO에 담는다.
		MemberVO mv = new MemberVO();
		
		mv.setMemId("d002");
		mv.setMemName("강감찬");
		mv.setMemTel("010-333-3333");
		mv.setMemAddr("경남 창원시");
		
		// 2) SqlSession 객체변수를 이용하여 해당 쿼리문을 실행한다 .
		// 예) sqlSession.insert("namespace값.id값", 파라미터객체);
		//		반환값  :  성공한 레코드 수 
	
		SqlSession session = sqlSessionFactory.openSession(true);
		
		
		try {
			int cnt = session.insert("memberTest.insertMember", mv);
			if(cnt > 0) {
				System.out.println("insert 작업성공");
			}else {
				System.out.println("insert 작업실패!!");
			}
			
			System.out.println("insert 작업 끝.");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		System.out.println("-----------------------------------");
		
		// 2-2. update 연습 
		System.out.println("update작업 시작.");
		
		MemberVO mv2 = new MemberVO();
		mv2.setMemId("d002");
		mv2.setMemName("이순신");
		mv2.setMemTel("3333-4444");
		mv2.setMemAddr("전남 목포시 ");
		
		session = sqlSessionFactory.openSession(false);
		
		try {
			// update()의 반환값도 성공한 레코드 수 이다.
			int cnt = session.update("memberTest.updateMember",mv2 );
			
			if(cnt > 0) {
				System.out.println("update작업 성공!");
				
				
			}else {
				System.out.println("update작업 실패! ");
			}
			session.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			session.rollback();
			
		}finally {
		
			session.close();
		}
		System.out.println("update작업 끝! ");
		System.out.println("------------------------------------");
		
		// 2-3. delete 연습
		System.out.println("delete 작업 시작.");
		
		session = sqlSessionFactory.openSession();
		
		try {
			//delete 메소드의 반환값 : 성공한 레코드 수
			
			int cnt = session.delete("memberTest.deleteMember", "d002");
			
			if(cnt > 0) {
				System.out.println("delete 작업성공! ");
			}else {
				System.out.println("delete 작업실패. ");
			}
			session.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		System.out.println("delete 작업 끝 .");
		System.out.println("------------------------------------");
		
		// 2-4.  select 연습
		// 1) 응답결과가 여러개일 경우
		System.out.println("select 연습 시작(결과가 여러개일 경우)...");		
		
		session = sqlSessionFactory.openSession();
		
		try {
			List<MemberVO> memList
				= session.selectList("memberTest.selectAllMember");
			for(MemberVO mv3 :memList) {
				System.out.println("  ID : " + mv3.getMemId());
				System.out.println("이름 : " + mv3.getMemName());
				System.out.println("전화 : " + mv3.getMemTel());
				System.out.println("주소 : " + mv3.getMemAddr());
				System.out.println("------------------------------------");
			}
			System.out.println("출력 끝 .");
			
		}finally {
			session.close();
		}
		
		// 2) 응답이 1개일 경우
		System.out.println("select 연습시작 (결과가 1개일 경우)");
		
		try {
			
			session =sqlSessionFactory.openSession();
			
			// 응답결과가 1개가 확실할 경우에 selectOne() 메소드를 이용한다.
			MemberVO mv4 = (MemberVO) session.selectOne("memberTest.getMember", "a001");
			
			System.out.println("  ID : " + mv4.getMemId());
			System.out.println("이름 : " + mv4.getMemName());
			System.out.println("전화 : " + mv4.getMemTel());
			System.out.println("주소 : " + mv4.getMemAddr());

			System.out.println("출력 끝 .");
			
		}finally {
			session.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
