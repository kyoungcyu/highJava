package prod.dao;

import java.util.List;

import prod.vo.ProdVO;
import prodCat.vo.ProdCatVO;

public interface IProdDAO {
	public int insertProd(ProdVO pv);
	
	public int updateProd(ProdVO pv);
	
	public int deleteProd(String prodId);
	
	public List<ProdVO> selectAllProd();

	public List<ProdVO> selectCatProd(int catNum);
	
	public ProdVO selectProd(String prodId);
	
	public List<ProdCatVO> selectCatNum();
	
	public int payProdStock(ProdVO pv);

}
