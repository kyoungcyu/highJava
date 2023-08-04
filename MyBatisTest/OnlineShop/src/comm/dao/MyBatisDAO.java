package comm.dao;


import java.util.Collections;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

public class MyBatisDAO {
	
	public <T> T selectLogin(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		
		T obj = null;
		
		try {
			obj = sqlSession.selectOne(statement, parameter);				// #{memId} #{memPw}
			
		} catch (PersistenceException e) {
			throw new RuntimeException("MyBatis Data Select Error", e);
		} finally {
			sqlSession.close();
		}
		
		return obj;
	}
	
	
	public int insert(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;

		try {
			cnt = sqlSession.insert(statement, parameter);

			sqlSession.commit();
		} catch (PersistenceException e) {
			sqlSession.rollback();
			throw new RuntimeException("MyBatis Data Insert Error", e);
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	public int update(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;

		try {
			cnt = sqlSession.update(statement, parameter);

			sqlSession.commit();
		} catch (PersistenceException e) {
			sqlSession.rollback();
			throw new RuntimeException("MyBatis Data Update Error", e);
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	public int delete(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;

		try {
			cnt = sqlSession.delete(statement, parameter);
			sqlSession.commit();
		} catch (PersistenceException e) {
			sqlSession.rollback();
			throw new RuntimeException("MyBatis Data Delete Error", e);
		} finally {
			sqlSession.close();
		}

		return cnt;
	}
	
	public <T> T selectOne(String statecent) {
		SqlSession sqlSession = MyBatisUtil.getInstance(true); // 세션 열기

		T obj = null;

		try {
			obj = sqlSession.selectOne(statecent);
		} catch (PersistenceException e) {
			throw new RuntimeException("MyBatis 에서 데이터 조회 중 예외 발생", e);
		} finally {
			sqlSession.close();
		}

		return obj;
	}

	public <T> T selectOne(String statecent, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getInstance(true); // 세션 열기

		T obj = null;

		try {
			obj = sqlSession.selectOne(statecent, parameter);
		} catch (PersistenceException e) {
			throw new RuntimeException("MyBatis 에서 데이터 조회 중 예외 발생", e);
		} finally {
			sqlSession.close();
		}

		return obj;
	}

	public <T> List<T> selectList(String statement) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		List<T> list = Collections.EMPTY_LIST; // 리스트 초기화(null 과 다름)

		try {
			list = sqlSession.selectList(statement);
		} catch (PersistenceException e) {
			throw new RuntimeException("MyBatis 에서 목록 조회 중 예외 발생", e);
		} finally {
			sqlSession.close();
		}

		return list;
	}

	public <T> List<T> selectList(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		List<T> list = Collections.EMPTY_LIST; // 리스트 초기화(null 과 다름)

		try {
			list = sqlSession.selectList(statement, parameter);
		} catch (PersistenceException e) {
			throw new RuntimeException("MyBatis 에서 목록 조회 중 예외 발생", e);
		} finally {
			sqlSession.close();
		}

		return list;
	}
	
}
