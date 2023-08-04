package order.vo;

public class OrderVO {
	private int orderNum;
	private String userId;
	private String orderDate;
	private int orderPrice;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "OrderVO [orderNum=" + orderNum + ", userId=" + userId + ", orderDate=" + orderDate + ", orderPrice="
				+ orderPrice + "]";
	}

}
