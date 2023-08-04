package cart.service;

import java.util.List;

import cart.vo.CartVO;

public interface ICartService {

	/**
	 * 구매하고자 하는 상품을 주문 테이블에 추가
	 * 
	 * @param cv 주문 테이블에 저장할 장바구니 객체
	 * @return 정상적으로 완료되면 1 이상의 int 값, 실패 시 0 반환
	 */
	public int addCart(CartVO cv);

	/**
	 * 주문 테이블에 저장된 주문 내역의 상품 정보 또는 수량 정보를 수정
	 * 
	 * @param cv 주문 테이블에 저장된 장바구니 객체
	 * @return 정상적으로 완료되면 1 이상의 int 값, 실패 시 0 반환
	 */
	public int modifyCart(CartVO cv);
	
	public int removeCart(CartVO cv);

	/**
	 * 주문 테이블에 저장된 주문 내역의 결제 상태를 수정
	 * 
	 * @param cv 주문 테이블에 저장된 장바구니 객체
	 * @return 정상적으로 완료되면 1 이상의 int 값, 실패 시 0 반환
	 */
	public int correctPaid(CartVO cv);

	public List<CartVO> selectAll();

	public List<CartVO> selectAll(CartVO cv);

	public List<CartVO> selectCart(CartVO cv);

	public int getCartNum();
	
	public int logout(int cartNum);

	
}
