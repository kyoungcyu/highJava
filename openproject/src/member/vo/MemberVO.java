package member.vo;

public class MemberVO {
	private String userId; // 회원 ID
	private String userPw; // 회원 Pw
	private String userName; // 회원이름
	private String userPhone; // 회원 전화번호
	private String userAddr; // 회원 주소
	private String userEmail; // 회원 이메일
	private String userRegNum; // 회원 주민번호

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRegNum() {
		return userRegNum;
	}

	public void setUserRegNum(String userRegNum) {
		this.userRegNum = userRegNum;
	}

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userAddr=" + userAddr + ", userEmail=" + userEmail + ", userRegNum=" + userRegNum
				+ "]";
	}

}
