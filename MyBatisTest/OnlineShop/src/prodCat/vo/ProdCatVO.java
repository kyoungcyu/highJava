package prodCat.vo;

public class ProdCatVO {
	private int catNum;
	private String catName;
	public int getCatNum() {
		return catNum;
	}
	public void setCatNum(int catNum) {
		this.catNum = catNum;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	@Override
	public String toString() {
		return "ProdCatVO [catNum=" + catNum + ", catName=" + catName + "]";
	}
}
