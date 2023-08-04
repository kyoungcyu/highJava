package prod.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import prod.vo.ProdVO;
import prodCat.vo.ProdCatVO;

public class ProdDAO extends MyBatisDAO implements IProdDAO {
	private static IProdDAO prodDAO;

	public ProdDAO() {
	}

	public static IProdDAO getInstance() {
		if (prodDAO == null) {
			prodDAO = new ProdDAO();
		}

		return prodDAO;
	}

	@Override
	public int insertProd(ProdVO pv) {
		int cnt = insert("onlineShop.insertProd", pv); // check

		return cnt;
	}

	@Override
	public int updateProd(ProdVO pv) {
		int cnt = update("onlineShop.updateProd", pv); // check

		return cnt;
	}

	@Override
	public int deleteProd(String prodId) {
		int cnt = delete("onlineShop.deleteProd", prodId); // check

		return cnt;
	}

	@Override
	public List<ProdVO> selectAllProd() {
		List<ProdVO> prodAllList = selectList("onlineShop.selectAllProd"); // check

		return prodAllList;
	}

	@Override
	public List<ProdVO> selectCatProd(int catNum) {
		List<ProdVO> prodCatList = selectList("onlineShop.selectCatProd", catNum); // check

		return prodCatList;
	}

	@Override
	public ProdVO selectProd(String prodId) {
		ProdVO pv = selectOne("onlineShop.selectProd", prodId); // check

		return pv;
	}

	@Override
	public List<ProdCatVO> selectCatNum() {
		List<ProdCatVO> catNumList = selectList("onlineShop.selectAllCategory");
		
		return catNumList;
	}

	@Override
	public int payProdStock(ProdVO pv) {
		int cnt = update("onlineShop.payProdStock", pv);
		
		return cnt;
	}

	

}
