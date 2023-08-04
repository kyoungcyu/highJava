package post.service;

import java.util.List;

import post.dao.IPostDAO;
import post.dao.NoticeDAO;
import post.vo.PostVO;

public class NoticeService implements IPostService {
	private static IPostService noticeService;
	private static IPostDAO noticeDAO;

	private NoticeService() {
		noticeDAO = NoticeDAO.getInstance();
	}

	public static IPostService getInstance() {
		if (noticeService == null) {
			noticeService = new NoticeService();
		}

		return noticeService;
	}

	@Override
	public int registPost(PostVO pv) {
		int cnt = noticeDAO.insertPost(pv);

		return cnt;
	}

	@Override
	public int modifyPost(PostVO pv) {
		int cnt = noticeDAO.updatePost(pv);

		return cnt;
	}

	@Override
	public int removePost(int postNum) {
		int cnt = noticeDAO.deletePost(postNum);

		return cnt;
	}

	@Override
	public List<PostVO> selectAllPost() {

		return noticeDAO.selectAllPost();
	}

	@Override
	public List<PostVO> selectAllPost(String userId) {

		return null;
	}

	@Override
	public PostVO selectPost(int postNum) {

		return noticeDAO.selectPost(postNum);
	}

	@Override
	public int addComment(PostVO pv) {
		// TODO Auto-generated method stub
		return 0;
	}

}
