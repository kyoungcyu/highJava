package member.service;

import java.util.List;

import member.vo.MemberVO;

/*
 * 컨트롤러에 의해 호출될 실제 기능
 */

public interface IMemberSerivce {

	public MemberVO loginMember(MemberVO mv);

	/**
	 * INSERT 기능
	 * 
	 * @param mv DB 에 저장할 VO 객체
	 * @return 성공 시 1 이상의 int 값 반환, 실패 시 0 반환
	 */
	public int registMember(MemberVO mv);

	/**
	 * UPDATE 기능
	 * 
	 * @param mv DB 에서 수정할 VO 객체
	 * @return 성공 시 1 이상의 int 값 반환, 실패 시 0 반환
	 */
	public int modifyMember(MemberVO mv); // Update

	/**
	 * DELETE 기능
	 * 
	 * @param mv DB 에서 삭제할 VO 객체
	 * @return 성공 시 1 이상의 int 값 반환, 실패 시 0 반환
	 */
	public int disableMember(String memId); // Delete

	/**
	 * 전체 회원 정보를 조회
	 * 
	 * @return 조회된 회원 정보를 담은 List
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
	 * @param memId 조회 대상 회원의 ID
	 * @return 대상 회원이 존재하면 true, 존재하지 않으면 false
	 */
	public boolean checkMember(String memId);
	
	
	public MemberVO selectOne(MemberVO mv);
	
	
	public boolean checkAdmin();
}
