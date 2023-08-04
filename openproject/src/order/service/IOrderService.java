package order.service;

import java.util.List;

import order.vo.OrderVO;
import orderdetail.vo.OrderDetailVO;

public interface IOrderService {
	public int addOrder(String userId);
	
	public int addOrderDetail();
	
	public List<OrderVO> selectAllOrders(String userId);
	
	public List<OrderVO> selectAllOrders();

	public List<OrderDetailVO> selectAllOrderDetails(int orderNum);
	
	
}
