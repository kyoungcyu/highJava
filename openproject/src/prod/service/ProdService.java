package prod.service;

import java.util.List;

import prod.dao.IProdDAO;
import prod.dao.ProdDAO;
import prod.vo.ProdVO;
import prodCat.vo.ProdCatVO;

public class ProdService implements IProdService {
	private static IProdService prodService;
	private static IProdDAO prodDAO;

	private ProdService() {
		prodDAO = ProdDAO.getInstance();
	}

	public static IProdService getInstance() {
		if (prodService == null) {
			prodService = new ProdService();
		}

		return prodService;
	}
	
	@Override
	public int registProd(ProdVO pv) {
		int cnt = prodDAO.insertProd(pv);
		
		return cnt;
	}

	@Override
	public int modifyProd(ProdVO pv) {
		int cnt = prodDAO.updateProd(pv);
		
		return cnt;
	}

	@Override
	public int removeProd(String prodId) {
		int cnt = prodDAO.deleteProd(prodId);
		
		return cnt;
	}

	@Override
	public List<ProdVO> selectAllProd() {

		return prodDAO.selectAllProd();
	}

	@Override
	public List<ProdVO> selectCatProd(int catNum) {

		return prodDAO.selectCatProd(catNum);
	}

	@Override
	public ProdVO selectProd(String prodId) {

		return prodDAO.selectProd(prodId);
	}

	@Override
	public List<ProdCatVO> showCatNum() {

		return prodDAO.selectCatNum();
	}

	@Override
	public int payProdStock(ProdVO pv) {

		return prodDAO.payProdStock(pv);
	}

	
}
