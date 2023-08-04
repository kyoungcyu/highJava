package member.dao;

import java.util.List;

import member.vo.MemberVO;

public interface IMemberDAO {

	public MemberVO loginMember(MemberVO mv);

	/**
	 * INSERT
	 * 
	 * @param mv DB 에 저장할 VO 객체
	 * @return 작업이 성공하면 1 이상의 int 값, 실패 시 0 반환
	 */
	public int insertMember(MemberVO mv);

	/**
	 * UPDATE
	 * 
	 * @param mv DB 에서 수정할 VO 객체
	 * @return 작업이 성공하면 1 이상의 int 값, 실패 시 0 반환
	 */
	public int updateMember(MemberVO mv);

	/**
	 * DELETE
	 * 
	 * @param mv DB 에서 삭제할 VO 객체
	 * @return 작업이 성공하면 1 이상의 int 값, 실패 시 0 반환
	 */
	public int disableMember(String memId);

	/**
	 * 전체 회원 정보를 조회
	 * 
	 * @return 조회된 회원 정보를 담은 List 객체
	 */
	public List<MemberVO> selectAll();

	/**
	 * 특정 회원 정보를 조회
	 * 
	 * @param mv 조회할 조건 정보를 담은 VO 객체
	 * @return 조회된 회원 정보를 담은 List 객체
	 */
	public List<MemberVO> selectMember(MemberVO mv);

	/**
	 * 작업을 수행할 대상 회원이 존재하는지 여부 조회
	 * 
	 * @param memId 조회할 대상 회원의 ID
	 * @return 대상 회원이 존재하면 true, 존재하지 않으면 false
	 */
	public boolean checkMember(String memId);

	public MemberVO selectOne(MemberVO mv);
	
	public boolean checkAdmin();


}
