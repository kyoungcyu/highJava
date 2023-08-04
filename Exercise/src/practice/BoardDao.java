package practice;

import java.util.List;

public interface BoardDao {

	public int insertBoard(BoardVO bv) ;
	
	public int deleteBoard(BoardVO bv) ;
	
	public int updateBoard(BoardVO bv) ;
	
	//번호로 해당 게시판을 조회 
	public boolean allDisplay(int boardNo) ;
	
	
	public List<BoardVO> saearchBoard() ;

	public boolean checkBoard(String boardwriter);
		
	
		
		
}
