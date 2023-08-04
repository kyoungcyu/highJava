package practice;

public interface BoardService {

	public int registerBoard(BoardVO bv);
	
	public int modifyBoard(BoardVO bv);
	
	public boolean checkBoard(String boardwriter);
}
