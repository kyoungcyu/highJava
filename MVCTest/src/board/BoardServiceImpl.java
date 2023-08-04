package board;

public class BoardServiceImpl implements BoardService{

	private BoardDao borDao;
	public BoardServiceImpl() {
		borDao = new BoardDaoImpl();
	}
	
	
	@Override
	public int registerBoard(BoardVO bv) {
	int cnt = borDao.insertBoard(bv);
	
	if(cnt > 0) {
		
	}
	
	return cnt;
	}

	@Override
	public int modifyBoard(BoardVO bv) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean checkBoard(String boardwriter) {

		return borDao.checkBoard(boardwriter) ;
	}

}
