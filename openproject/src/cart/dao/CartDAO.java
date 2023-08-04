package cart.dao;

import java.util.List;

import cart.vo.CartVO;
import comm.dao.MyBatisDAO;

public class CartDAO extends MyBatisDAO implements ICartDAO {
	private static ICartDAO cartDAO;

	public CartDAO() {
		// TODO Auto-generated constructor stub
	}

	public static ICartDAO getInstance() {
		if (cartDAO == null) {
			cartDAO = new CartDAO();
		}
		return cartDAO;
	}

	@Override
	public int insertCart(CartVO cv) {
		int cnt = insert("onlineShop.insertCart", cv);				// Check

		return cnt;
	}

	@Override
	public int updateCart(CartVO cv) {
		int cnt = update("onlineShop.updateProdcount", cv);

		return cnt;
	}

	@Override
	public int deleteCart(CartVO cv) {
		int cnt = delete("onlineShop.deleteCart", cv);
		
		return cnt;
	}

	@Override
	public int payCart(CartVO cv) {
		int cnt = update("onlineShop.payCart", cv);

		return cnt;
	}

	@Override
	public List<CartVO> selectAll() {
		List<CartVO> cartAllList = selectList("onlineShop.selectAllCart");

		return cartAllList;
	}

	@Override
	public List<CartVO> selectAll(CartVO cv) {
		List<CartVO> cartAllList = selectList("onlineShop.selectUserAllCart", cv);

		return cartAllList;
	}

	@Override
	public List<CartVO> selectCart(CartVO cv) {
		List<CartVO> selectCart = selectList("onlineShop.selectCart", cv);

		return selectCart;
	}

	@Override
	public int getCartNum() {
		int cnt;

		if (selectOne("onlineShop.getCartNum") == null) {
			cnt = 0;
		} else {
			cnt = selectOne("onlineShop.getCartNum");
		}
		return cnt;
	}

	@Override
	public int logout(int cartNum) {
		int cnt = delete("onlineShop.logoutCart", cartNum);
		
		return cnt;
	}

}
