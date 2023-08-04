package post.dao;

import java.util.List;

import post.vo.PostVO;

public interface IPostDAO {
	public int insertPost(PostVO pv);

	public int updatePost(PostVO pv);

	public int deletePost(int postNum);

	public List<PostVO> selectAllPost();

	public List<PostVO> selectAllPost(String userId);

	public PostVO selectPost(int postNum);

	public int insertComment(PostVO pv);
	
}
