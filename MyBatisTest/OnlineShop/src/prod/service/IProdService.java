package prod.service;

import java.util.List;

import prod.vo.ProdVO;
import prodCat.vo.ProdCatVO;

public interface IProdService {
	public int registProd(ProdVO pv);

	public int modifyProd(ProdVO pv);

	public int removeProd(String prodId);

	public List<ProdVO> selectAllProd();

	public List<ProdVO> selectCatProd(int catNum);
	
	public ProdVO selectProd(String prodId);

	public List<ProdCatVO> showCatNum();
	
	public int payProdStock(ProdVO pv);

}
