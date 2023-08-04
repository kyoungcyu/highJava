package cart.vo;

public class CartVO {
	private int cartNum;
	private String prodId;
	private String userId;
	private int prodCount;
	private String cartPay;

	public int getCartNum() {
		return cartNum;
	}

	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}

	public String getCartPay() {
		return cartPay;
	}

	public void setCartPay(String cartPay) {
		this.cartPay = cartPay;
	}

	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", prodId=" + prodId + ", userId=" + userId + ", prodCount=" + prodCount
				+ ", cartPay=" + cartPay + "]";
	}


}
