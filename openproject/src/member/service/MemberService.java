package member.service;

import java.util.List;

import member.dao.IMemberDAO;
import member.dao.MemberDAO;
import member.vo.MemberVO;

public class MemberService implements IMemberSerivce {
	private static IMemberDAO memDao;
	private static IMemberSerivce memService;
	public MemberVO memVO;

	private MemberService() {
		memDao = MemberDAO.getInstance();
	}

	public static IMemberSerivce getInstance() {
		if (memService == null) {
			memService = new MemberService();
		}

		return memService;
	}

	@Override
	public MemberVO loginMember(MemberVO mv) {
		memVO = memDao.loginMember(mv);

		return memVO;
	}

	@Override
	public int registMember(MemberVO mv) {
		int cnt = memDao.insertMember(mv);

		return cnt;
	}

	@Override
	public int modifyMember(MemberVO mv) {
		int cnt = memDao.updateMember(mv);

		return cnt;
	}

	@Override
	public int disableMember(String memId) {
		int cnt = memDao.disableMember(memId);

		return cnt;
	}

	@Override
	public MemberVO selectOne(MemberVO mv) {
		return memDao.selectOne(mv);
	}

	@Override
	public List<MemberVO> selectAll() {

		return memDao.selectAll();
	}

	@Override
	public List<MemberVO> selectMember(MemberVO mv) {

		return memDao.selectMember(mv);
	}

	@Override
	public boolean checkMember(String memId) {

		return memDao.checkMember(memId);
	}

	@Override
	public boolean checkAdmin() {
		
		return memDao.checkAdmin();
	}

}
