package post.service;

import java.util.List;

import post.dao.IPostDAO;
import post.dao.NoticeDAO;
import post.dao.QnADAO;
import post.vo.PostVO;

public class QnAService implements IPostService {
	private static IPostService qnaService;
	private static IPostDAO qnaDAO;

	private QnAService() {
		qnaDAO = QnADAO.getInstance();
	}

	public static IPostService getInstance() {
		if (qnaService == null) {
			qnaService = new QnAService();
		}

		return qnaService;
	}

	@Override
	public int registPost(PostVO pv) {
		int cnt = qnaDAO.insertPost(pv);

		return cnt;
	}

	@Override
	public int modifyPost(PostVO pv) {
		int cnt = qnaDAO.updatePost(pv);

		return cnt;
	}

	@Override
	public int removePost(int postNum) {
		int cnt = qnaDAO.deletePost(postNum);

		return cnt;
	}

	@Override
	public List<PostVO> selectAllPost() {

		return qnaDAO.selectAllPost();
	}

	@Override
	public List<PostVO> selectAllPost(String userId) {

		return qnaDAO.selectAllPost(userId);
	}

	@Override
	public PostVO selectPost(int postNum) {

		return qnaDAO.selectPost(postNum);
	}

	@Override
	public int addComment(PostVO pv) {
		int cnt = qnaDAO.insertComment(pv);

		return cnt;
	}

}
