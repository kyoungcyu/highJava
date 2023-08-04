package order.dao;

import java.util.List;

import order.vo.OrderVO;
import orderdetail.vo.OrderDetailVO;

public interface IOrderDAO {
	public int insertOrder(String userId);
	
	public int insertODetail();
	
	public List<OrderVO> selectAllOrders(String userId);

	public List<OrderVO> selectAllOrders();

	public List<OrderDetailVO> selectAllOrderDetails(int orderNum);	
}
