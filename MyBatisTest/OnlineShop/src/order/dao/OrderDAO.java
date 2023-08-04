package order.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import order.vo.OrderVO;
import orderdetail.vo.OrderDetailVO;

public class OrderDAO extends MyBatisDAO implements IOrderDAO {
	private static IOrderDAO orderDAO;
	
	public OrderDAO() {
	}
	
	public static IOrderDAO getInstance() {
		if(orderDAO == null) {
			orderDAO = new OrderDAO();
		}
		return orderDAO;
	}
	
	
	@Override
	public int insertOrder(String userId) {
		int cnt = insert("onlineShop.insertOrder", userId);
		
		return cnt;
	}

	@Override
	public int insertODetail() {
		int cnt = insert("onlineShop.insertOrderDetails", 1);
		
		return cnt;
	}

	@Override
	public List<OrderVO> selectAllOrders(String userId) {
		List<OrderVO> orderList = selectList("onlineShop.selectAllUserOrders", userId);
		
		return orderList;
	}

	@Override
	public List<OrderVO> selectAllOrders() {
		List<OrderVO> orderList = selectList("onlineShop.selectAllOrders");
		
		return orderList;
	}

	@Override
	public List<OrderDetailVO> selectAllOrderDetails(int orderNum) {
		List<OrderDetailVO> orderDetailList = selectList("onlineShop.selectAllOrderDetails", orderNum);
		
		return orderDetailList;
	}


}
