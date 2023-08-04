package orderdetail.vo;

public class OrderDetailVO {
	private int orderNum;
	private String prodId;
	private int orderCount;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [orderNum=" + orderNum + ", prodId=" + prodId + ", orderCount=" + orderCount + "]";
	}

}
