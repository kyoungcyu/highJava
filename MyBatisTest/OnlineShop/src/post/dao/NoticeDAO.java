package post.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import post.vo.PostVO;

public class NoticeDAO extends MyBatisDAO implements IPostDAO {
	private static IPostDAO noticeDAO;

	public NoticeDAO() {
	}

	public static IPostDAO getInstance() {
		if (noticeDAO == null) {
			noticeDAO = new NoticeDAO();
		}

		return noticeDAO;
	}

	@Override
	public int insertPost(PostVO pv) {
		int cnt = insert("onlineShop.insertNotice", pv); // Check
		
		return cnt;
	}

	@Override
	public int updatePost(PostVO pv) {
		int cnt = update("onlineShop.updateNotice", pv); // Check

		return cnt;
	}

	@Override
	public int deletePost(int postNum) {
		int cnt = delete("onlineShop.deleteNotice", postNum); // Check

		return cnt;
	}

	@Override
	public List<PostVO> selectAllPost() {
		List<PostVO> noticeAllList = selectList("onlineShop.selectAllNotice"); // Check

		return noticeAllList;
	}

	@Override
	public List<PostVO> selectAllPost(String userId) {

		return null;
	}

	@Override
	public PostVO selectPost(int postNum) {
		PostVO pv = selectOne("onlineShop.selectNotice", postNum); // Check

		return pv;
	}

	@Override
	public int insertComment(PostVO pv) {

		return 0;
	}

}
