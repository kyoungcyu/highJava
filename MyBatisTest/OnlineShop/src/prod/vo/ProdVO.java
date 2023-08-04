package prod.vo;

public class ProdVO {
	private String prodId;
	private String prodName;
	private int prodPrice;
	private int prodStock;
	private int catNum;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdStock() {
		return prodStock;
	}

	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}

	public int getCatNum() {
		return catNum;
	}

	public void setCatNum(int catNum) {
		this.catNum = catNum;
	}

	@Override
	public String toString() {
		return "ProdVO [prodNum=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodStock="
				+ prodStock + ", catNum=" + catNum + "]";
	}

}
