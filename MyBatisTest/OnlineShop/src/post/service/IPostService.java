package post.service;

import java.util.List;

import post.vo.PostVO;

public interface IPostService {
	public int registPost(PostVO pv);
	
	public int modifyPost(PostVO pv);
	
	public int removePost(int postNum);
	
	public List<PostVO> selectAllPost();
	
	public List<PostVO> selectAllPost(String userId);
	
	public PostVO selectPost(int postNum);
	
	public int addComment(PostVO pv);
	
}
