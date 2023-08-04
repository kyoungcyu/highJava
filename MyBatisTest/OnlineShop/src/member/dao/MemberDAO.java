package member.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import member.vo.MemberVO;

public class MemberDAO extends MyBatisDAO implements IMemberDAO {
	private static IMemberDAO memDao;
	private MemberVO memVO;

	private MemberDAO() {
	}

	public static IMemberDAO getInstance() {
		if (memDao == null) {
			memDao = new MemberDAO();
		}
		return memDao;
	}

	@Override
	public MemberVO loginMember(MemberVO mv) {
		memVO = selectLogin("onlineShop.loginMember", mv);

		return memVO;
	}

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = insert("onlineShop.insertMember", mv);
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = update("onlineShop.updateMember", mv);
		
		return cnt;
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> memList = selectList("onlineShop.selectAllMember");
		
		return memList;
	}

	@Override
	public List<MemberVO> selectMember(MemberVO mv) {
		List<MemberVO> memList = selectList("onlineShop.selectAllMember2", mv);

		return memList;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = false;


		int cnt = selectOne("onlineShop.checkMember", memId);

		if (cnt > 0) {
			isExist = true;
		}

		return isExist;
	}

	@Override
	public int disableMember(String memId) {
		int cnt = delete("onlineShop.disableMember", memId);
		
		return cnt;
	}

	@Override
	public MemberVO selectOne(MemberVO mv) {
		MemberVO mv2 = selectOne("", mv);
		
		return mv2;
	}
	

	@Override
	public boolean checkAdmin() {

		return false;
	}

}
