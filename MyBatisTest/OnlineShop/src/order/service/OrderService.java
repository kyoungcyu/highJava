package order.service;

import java.util.List;

import order.dao.IOrderDAO;
import order.dao.OrderDAO;
import order.vo.OrderVO;
import orderdetail.vo.OrderDetailVO;

public class OrderService implements IOrderService{
	private IOrderDAO orderDAO;
	private static IOrderService orderService;
	
	public OrderService() {
		orderDAO = OrderDAO.getInstance();
	}
	
	public static IOrderService getInstance() {
		if(orderService == null) {
			orderService = new OrderService();
		}
		
		return orderService;
	}

	@Override
	public int addOrder(String userId) {

		return orderDAO.insertOrder(userId);
	}

	@Override
	public int addOrderDetail() {

		return orderDAO.insertODetail();
	}

	@Override
	public List<OrderVO> selectAllOrders(String userId) {

		return orderDAO.selectAllOrders(userId);
	}

	@Override
	public List<OrderDetailVO> selectAllOrderDetails(int orderNum) {

		return orderDAO.selectAllOrderDetails(orderNum);
	}

	@Override
	public List<OrderVO> selectAllOrders() {

		return orderDAO.selectAllOrders();
	}

}
