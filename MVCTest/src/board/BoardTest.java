package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;




public class BoardTest {
	private BoardService borService;
	
	private Scanner scan = new Scanner(System.in);
	public BoardTest() {
		borService = new BoardServiceImpl();
	}
	
	
	public void displayMenu() {
	
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 게시판 작성");
		System.out.println("  2. 게시판 삭제");
		System.out.println("  3. 게시판 수정");
		System.out.println("  4. 전체 목록 출력");
		System.out.println("  5. 게시판 검색");
		System.out.println("  6. 게시판 종료");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}


	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: 
				insertBoard();
				break;
			case 2: 
				deleteBoard();
				break;
			case 3: 
				updateBoard();
				break;
			case 4: 
				allDisplay();
				break;
			case 5: 
				searchBoard();
				break;
			case 6: 
				System.out.println( "작업끝." );
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}
	

		private void insertBoard() {
			
			boolean isExist = false;
			String boardwriter = null;
			
			do {
				System.out.println();
				System.out.println("새롭게 등록할 게시판을 입력하시오.");
				System.out.println("게시판 제목 >>");
				boardwriter =scan.next();
				
				isExist = borService.checkBoard(boardwriter);
				
				if(isExist) {
					System.out.println("게시판 " + boardwriter +"가 이미있습니다.");
					System.out.println("다시 입력하세요 .");
				}
			}while(isExist);
			
			System.out.println("게시판 제목1 >>");
			String boardTitle = scan.next();

			System.out.println("게시판 작성자 >>");
			String boardWriter = scan.next();
			
//			System.out.println("작성 날짜 >>");
//			String boardDate = scan.next();
//			Date.valueOf(boardDate);           ==> 작성 날짜를 직접 적진 않음!!
											// ==> 쿼리에서 자동(sysdate)으로 저장하게 해놓고
											// ==> 출력할때만 빼면될듯!!!.
			
			scan.nextLine();
			System.out.println("글 내용 >>");
			String boardContent = scan.next();
			
			BoardVO bv = new BoardVO();

			bv.setBoardNo(0);
			bv.setBoardTitle(boardTitle);
			bv.setBoardWriter(boardWriter);
//			bv.setBoardDate(boardDate);
			bv.setBoardContent(boardContent);
			
			int cnt = borService.registerBoard(bv);
			
			if(cnt >0) {
				System.out.println(boardwriter + "게시글 작업 성공");
			}else {
				System.out.println(boardwriter + "게시글 작업 실패");
			}
			
			
			
			
			
			
			
			
			
			
			
	}


	private void deleteBoard() {
		// TODO Auto-generated method stub
		
	}


		// TODO Auto-generated method stub
	private void allDisplay() {
		
	}


		private void searchBoard() {
		// TODO Auto-generated method stub
		
	}


	private void updateBoard() {
//		
//	BoardVO bv = new BoardVO();
//	bv.setBoardNo(0);
//	bv.setBoardTitle(null);
//	bv.setBoardWriter(null);
//	bv.setBoardDate(null); 
//	bv.setBoardContent(null); 
//	
//		try {
//		conn = JDBCUtil3.getConnection();
//		String sql = "update jdbc_board"
//				 + " set board_content = ? ";
//			pstmt = conn.prepareStatement(sql);
//		
//		pstmt.setString(1, bv.getBoardContent() );
//		
//		int check = pstmt.executeUpdate();
//		
//		if(check > 0) {
//			System.out.println("수정성공");
//		}else {
//			System.out.println("수정실패");
//		}
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			
//		JDBCUtil3.close(conn, stmt, pstmt, rs);
//		}
//		
//		
	}


	public static void main(String[] args) {
		BoardTest bTest = new BoardTest();
		bTest.start();
	}

}
