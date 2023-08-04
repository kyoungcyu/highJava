package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * SqlSession 객체를 제공하는 팩토리 클래스
 */

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;		// 객체 변수 선언
	
	static {
		try {
			Charset charset = Charset.forName("UTF-8"); // 설정 파일의 한글처리용 Encoding
			Resources.setCharset(charset);

			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);

			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * SqlSession 객체를 제공하는 팩토리 메소드
	 * @return SqlSession 객체
	 */
	public static SqlSession getInstance() {
		return sqlSessionFactory.openSession();
	}

	
	/**
	 * SqlSession 객체를 제공하는 팩토리 메소드
	 * @param autoCommit : true 이면 AutoCommit 사용
	 * @return SqlSession 객체
	 */
	public static SqlSession getInstance(boolean autoCommit) {
		return sqlSessionFactory.openSession(autoCommit);
	}
	
	
}
