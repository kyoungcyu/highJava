package post.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import post.vo.PostVO;

public class QnADAO extends MyBatisDAO implements IPostDAO {
	private static IPostDAO qnaDAO;

	public QnADAO() {
	}

	public static IPostDAO getInstance() {
		if (qnaDAO == null) {
			qnaDAO = new QnADAO();
		}

		return qnaDAO;
	}

	@Override
	public int insertPost(PostVO pv) {
		int cnt = insert("onlineShop.insertQnA", pv); // check

		return cnt;
	}

	@Override
	public int updatePost(PostVO pv) {
		int cnt = update("onlineShop.updateQnA", pv); // check

		return cnt;
	}

	@Override
	public int deletePost(int postNum) {
		int cnt = delete("qnonlineShop.deleteQnA", postNum); // check

		return cnt;
	}

	@Override
	public List<PostVO> selectAllPost() {
		List<PostVO> selectAllQnA = selectList("onlineShop.selectAllQnA"); // check

		return selectAllQnA;
	}

	@Override
	public List<PostVO> selectAllPost(String userId) {
		List<PostVO> selectAllQnA = selectList("onlineShop.selectUserAllQnA", userId); // check

		return selectAllQnA;
	}

	@Override
	public PostVO selectPost(int postNum) {
		PostVO pv = selectOne("onlineShop.selectQnA", postNum); // check

		return pv;
	}

	@Override
	public int insertComment(PostVO pv) {
		int cnt = update("onlineShop.commentQnA", pv); // check

		return cnt;
	}

}
