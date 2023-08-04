package cart.service;

import java.util.List;

import cart.dao.CartDAO;
import cart.dao.ICartDAO;
import cart.vo.CartVO;

public class CartService implements ICartService{
	private static ICartService cartService;
	private static ICartDAO cartDAO;
	
	private CartService() {
		cartDAO = CartDAO.getInstance();
	}
	
	public static ICartService getInstance() {
		if(cartService == null ) {
			cartService = new CartService();
		}
		return cartService;
	}
	
	@Override
	public int addCart(CartVO cv) {
		int cnt = cartDAO.insertCart(cv);
		
		return cnt;
	}

	@Override
	public int modifyCart(CartVO cv) {
		int cnt = cartDAO.updateCart(cv);
		
		return cnt;
	}

	@Override
	public int removeCart(CartVO cv) {
		int cnt = cartDAO.deleteCart(cv);
		
		return cnt;
	}
	
	@Override
	public int correctPaid(CartVO cv) {
		int cnt = cartDAO.payCart(cv);
		
		return cnt;
	}

	@Override
	public List<CartVO> selectAll() {
		List<CartVO> allCartList = cartDAO.selectAll();
		
		return allCartList;
	}


	@Override
	public List<CartVO> selectAll(CartVO cv) {
		List<CartVO> allUserCartList = cartDAO.selectAll(cv);
		
		return allUserCartList;
	}

	@Override
	public List<CartVO> selectCart(CartVO cv) {
		List<CartVO> selectCart = cartDAO.selectCart(cv);
		
		return selectCart;
	}

	@Override
	public int getCartNum() {
		int cnt = cartDAO.getCartNum();
		
		return cnt;
	}

	@Override
	public int logout(int cartNum) {

		return cartDAO.logout(cartNum);
	}

}
