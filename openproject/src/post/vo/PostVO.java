package post.vo;

public class PostVO {
	private int postNum;
	private String userId;
	private String postTitle;
	private String postContent;
	private String postDate;
	private String postAnswer;

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostAnswer() {
		return postAnswer;
	}

	public void setPostAnswer(String postAnswer) {
		this.postAnswer = postAnswer;
	}

	@Override
	public String toString() {
		return "PostVO [postNum=" + postNum + ", userId=" + userId + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", postDate=" + postDate + ", postAnswer=" + postAnswer + "]";
	}

}
