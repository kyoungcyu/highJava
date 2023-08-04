package main;

import java.util.List;
import java.util.Scanner;

import cart.service.CartService;
import cart.service.ICartService;
import cart.vo.CartVO;
import member.service.IMemberSerivce;
import member.service.MemberService;
import post.service.IPostService;
import post.service.NoticeService;
import post.service.QnAService;
import prod.service.IProdService;
import prod.service.ProdService;
import member.vo.MemberVO;
import order.service.IOrderService;
import order.service.OrderService;
import order.vo.OrderVO;
import orderdetail.vo.OrderDetailVO;
import post.vo.PostVO;
import prod.vo.ProdVO;
import prodCat.vo.ProdCatVO;

public class Main {
	private IMemberSerivce memService;
	private IPostService noticeService;
	private IPostService qnaService;
	private IProdService prodService;
	private ICartService cartSerivce;
	private IOrderService orderService;
	private Scanner scan;
	private MemberVO memVO;

	public int cartNum;

	public Main() {
		scan = new Scanner(System.in);
		createInstance();
	}

	public void initialize() {
		int menu;

		do {
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  --- 메 인 메 뉴 ---");
			System.out.println("  1. 로그인");
			System.out.println("  2. 회원가입");
			System.out.println("  3. 공지사항");
			System.out.println("  4. Q&A");
			System.out.println("  5. 상품목록");
			System.out.println("  6. 종료.");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");

			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				memVO = login();

				if (memVO == null) {
					System.out.println("회원정보가 올바르지 않습니다. 다시 입력해주세요.");
					break;
				} else if (memVO.getUserId().equals("admin")) {
					adminMainMenu();
				} else {
					memberMainMenu();
				}
				break;
			case 2:
				signUp();
				break;
			case 3:
				notice();
				break;
			case 4:
				qna();
				break;
			case 5:
				product();
				break;
			case 6:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 6);
	}

	public void memberMainMenu() {
		int menu;

		do {
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  --- 메 인 메 뉴 ---");
			System.out.println("  1. 로그아웃");
			System.out.println("  2. 마이페이지");
			System.out.println("  3. 공지사항");
			System.out.println("  4. Q&A");
			System.out.println("  5. 상품목록");
			System.out.println("  6. 종료.");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				logout();
				return;
			case 2:
				myPage();
				break;
			case 3:
				notice();
				break;
			case 4:
				qna();
				break;
			case 5:
				product();
				break;
			case 6:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 6);
	}

	public void adminMainMenu() {
		int menu;

		do {
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  --- 메 인 메 뉴 ---");
			System.out.println("  1. 로그아웃");
			System.out.println("  2. 회원관리");
			System.out.println("  3. 공지사항 관리");
			System.out.println("  4. Q&A 관리");
			System.out.println("  5. 상품관리");
			System.out.println("  6. 종료.");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				logout();
				return;
			case 2:
				memManage(); // Show All Member or Delete Member
				break;
			case 3:
				notice();
				break;
			case 4:
				qna();
				break;
			case 5:
				product();
				break;
			case 6:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 6);
	}

	private void memManage() {
		int menu = 0;

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("I  D\t이  름\t전화번호\t주  소");
		System.out.println("------------------------------------------------------------");

		List<MemberVO> memList = memService.selectAll();

		if (memList.size() == 0) {
			System.out.println("조회된 데이터가 없습니다.");
		} else {
			for (MemberVO mv : memList) {
				System.out.println(
						mv.getUserId() + "\t" + mv.getUserName() + "\t" + mv.getUserPhone() + "\t" + mv.getUserAddr());
				System.out.println("------------------------------------------------------------");
			}
		}
		System.out.println("출력 작업 끝");

		do {
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  --- 메 인 메 뉴 ---");
			System.out.println("  1. 회원삭제");
			System.out.println("  2. 뒤로가기");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				String memId = scan.nextLine();

				int cnt = memService.disableMember(memId);

				if (cnt > 0) {
					System.out.println(memId + "회원 삭제 작업 성공");
				}
				return;
			case 2:
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 2);
	}

	public MemberVO login() {
		String id;
		String password;

		System.out.print("  1. 아이디  >> ");
		id = scan.nextLine();
		System.out.println();
		System.out.print("  2. 비밀번호  >> ");
		password = scan.nextLine();

		boolean isExist = memService.checkMember(id);

		if (!isExist) {
			System.out.println("존재하지 않는 회원입니다.");
			return null;
		}

		MemberVO mv = new MemberVO();

		mv.setUserId(id);
		mv.setUserPw(password);

		MemberVO mv2 = memService.loginMember(mv);
		cartNum = cartSerivce.getCartNum() + 1;

		return mv2;
	}

	public void signUp() {
		String id, password, name, regNum, phone, addr, email;

		System.out.println();
		System.out.println("----------------------");
		System.out.println("  --- 회 원 가 입 ---");
		System.out.print("  1. 아이디  >> ");
		id = scan.nextLine();
		System.out.println();
		System.out.print("  2. 비밀번호  >> ");
		password = scan.nextLine();
		System.out.println();
		System.out.print("  3. 이름  >> ");
		name = scan.nextLine();
		System.out.println();
		System.out.print("  4. 주민번호  >> ");
		regNum = scan.nextLine();
		System.out.println();
		System.out.print("  5. 전화번호  >> ");
		phone = scan.nextLine();
		System.out.println();
		System.out.print("  6. 주소  >> ");
		addr = scan.nextLine();
		System.out.println();
		System.out.print("  7. 이메일  >> ");
		email = scan.nextLine();
		System.out.println("----------------------");

		MemberVO mv = new MemberVO();

		mv.setUserId(id);
		mv.setUserPw(password);
		mv.setUserName(name);
		mv.setUserRegNum(regNum);
		mv.setUserPhone(phone);
		mv.setUserAddr(addr);
		mv.setUserEmail(email);

		System.out.println(mv);

		// INSERT Member

		int cnt = memService.registMember(mv);

		if (cnt > 0) {
			System.out.println("회원 가입 성공!!");
		} else {
			System.out.println("회원 가입 실패");
		}
	}

	public void notice() {
		int menu;

		if (memVO == null || !memVO.getUserId().equals("admin")) {
			System.out.println("----------------------");
			System.out.println("  --- 공 지 사 항 ---");
			System.out.println("------------------------------------------------------------");
			System.out.println("글 번 호\t제  목\t작성일자");
			System.out.println("------------------------------------------------------------");

			List<PostVO> noticeList = noticeService.selectAllPost();
			if (noticeList.size() == 0) {
				System.out.println("조회된 데이터가 없습니다.");
			} else {

				for (PostVO pov : noticeList) {
					System.out.println(pov.getPostNum() + "\t" + pov.getPostTitle() + "\t" + pov.getPostDate());
					System.out.println("------------------------------------------------------------");
				}
			}

			do {
				System.out.println();
				System.out.println("----------------------");
				System.out.println("  --- 공 지 사 항 ---");
				System.out.println("  1. 조회");
				System.out.println("  2. 뒤로가기");
				System.out.println("----------------------");
				System.out.print("원하는 작업 선택 >> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1:
					selectNotice();
					break;
				case 2:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} while (menu != 2);
		} else {
			System.out.println("----------------------");
			System.out.println("  --- 공 지 사 항 ---");
			System.out.println("------------------------------------------------------------");
			System.out.println("글 번 호\t제  목\t작성일자");
			System.out.println("------------------------------------------------------------");

			List<PostVO> noticeList = noticeService.selectAllPost();

			if (noticeList.size() == 0) {
				System.out.println("조회된 데이터가 없습니다.");
			} else {
				for (PostVO pv : noticeList) {
					System.out.println(pv.getPostNum() + "\t" + pv.getPostTitle() + "\t" + pv.getPostDate());
					System.out.println("------------------------------------------------------------");
				}
			}
			do {
				System.out.println();
				System.out.println("----------------------");
				System.out.println("  --- 공 지 사 항 ---");
				System.out.println("  1. 조회");
				System.out.println("  2. 작성");
				System.out.println("  3. 삭제");
				System.out.println("  4. 뒤로가기");
				System.out.println("----------------------");
				System.out.print("원하는 작업 선택 >> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1:
					selectNotice();
					break;
				case 2:
					insertNotice();
					break;
				case 3:
					deleteNotice();
					break;
				case 4:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} while (menu != 4);
		}
	}

	private void selectNotice() {
		int menu = 0;

		if (memVO == null || !memVO.getUserId().equals("admin")) {
			int postNum = 0;

			System.out.print("조회할 공지사항 >> ");
			postNum = Integer.parseInt(scan.nextLine());

			PostVO pv = noticeService.selectPost(postNum);

			String title = pv.getPostTitle();
			String content = pv.getPostContent();
			String date = pv.getPostDate();

			System.out.println();
			System.out.println("제목 : " + title);
			System.out.println("작성일자 :" + date);
			System.out.println("----------------------------------");
			System.out.println("내용 : " + content);
			System.out.println("----------------------------------");

		} else {
			int postNum = 0;

			System.out.print("조회할 공지사항 >> ");
			postNum = Integer.parseInt(scan.nextLine());

			PostVO pv = noticeService.selectPost(postNum);

			String title = pv.getPostTitle();
			String content = pv.getPostContent();
			String date = pv.getPostDate();

			System.out.println();
			System.out.println("제목 : " + title);
			System.out.println("작성일자 :" + date);
			System.out.println("----------------------------------");
			System.out.println("내용 : " + content);

			do {
				System.out.println();
				System.out.println("----------------------");
				System.out.println("  --- 공 지 사 항 ---");
				System.out.println("  1. 수정");
				System.out.println("  2. 뒤로가기");
				System.out.println("----------------------");
				System.out.print("원하는 작업 선택 >> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1:
					updateNotice(postNum);
					break;
				case 2:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} while (menu != 2);
		}
	}

	private void insertNotice() {
		String title, content;

		System.out.print("  1. 제목  >> ");
		title = scan.nextLine();
		System.out.print("  2. 내용  >> ");
		content = scan.nextLine();

		PostVO pv = new PostVO();

		pv.setUserId(memVO.getUserId());
		pv.setPostTitle(title);
		pv.setPostContent(content);

		int cnt = noticeService.registPost(pv);

		if (cnt > 0) {
			System.out.println("등록이 완료되었습니다.");
		} else {
			System.out.println("등록 실패");
		}
	}

	private void updateNotice(int postNum) {
		String content;

		System.out.print("  1. 내용  >> ");
		content = scan.nextLine();

		PostVO pv = new PostVO();

		pv.setPostNum(postNum);
		pv.setPostContent(content);
		pv.setUserId(memVO.getUserId());

		System.out.println(pv);

		int cnt = noticeService.modifyPost(pv);

		if (cnt > 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정 실패");
		}
	}

	private void deleteNotice() {
		int postNum = 0;

		System.out.print("삭제할 공지사항 >> ");
		postNum = Integer.parseInt(scan.nextLine());

		int cnt = noticeService.removePost(postNum);

		if (cnt > 0) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("삭제 실패");
		}

	}

	public void qna() {
		int menu;

		if (memVO == null) {
			System.out.println("----------------------");
			System.out.println("      --- Q & A ---      ");
			System.out.println("------------------------------------------------------------");
			System.out.println("글 번 호\t제  목\t작성일자\t\t작성자");
			System.out.println("------------------------------------------------------------");

			List<PostVO> qnaList = qnaService.selectAllPost();

			if (qnaList.size() == 0) {
				System.out.println("조회된 데이터가 없습니다.");
			} else {
				for (PostVO pv : qnaList) {
					System.out.println(pv.getPostNum() + "\t" + "\t" + pv.getPostTitle() + "\t" + pv.getPostDate()
							+ "\t" + pv.getUserId());
					System.out.println("------------------------------------------------------------");
				}
			}

			do {
				System.out.println();
				System.out.println("----------------------");
				System.out.println("  --- Q & A ---");
				System.out.println("  1. Q&A 조회");
				System.out.println("  2. 뒤로가기");
				System.out.println("----------------------");
				System.out.print("원하는 작업 선택 >> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1:
					selectQna();
					break;
				case 2:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} while (menu != 2);
		} else if (!memVO.getUserId().equals("admin")) {
			System.out.println("----------------------");
			System.out.println("      --- Q & A ---      ");
			System.out.println("------------------------------------------------------------");
			System.out.println("글 번 호\t제  목\t작성일자\t\t작성자");
			System.out.println("------------------------------------------------------------");

			List<PostVO> qnaList = qnaService.selectAllPost();

			if (qnaList.size() == 0) {
				System.out.println("조회된 데이터가 없습니다.");
			} else {
				for (PostVO pv : qnaList) {
					System.out.println(pv.getPostNum() + "\t" + "\t" + pv.getPostTitle() + "\t" + pv.getPostDate()
							+ "\t" + pv.getUserId());
					System.out.println("------------------------------------------------------------");
				}
			}
			do {
				System.out.println();
				System.out.println("----------------------");
				System.out.println("  --- Q & A ---");
				System.out.println("  1. Q&A 조회");
				System.out.println("  2. Q&A 작성");
				System.out.println("  3. Q&A 수정");
				System.out.println("  4. Q&A 삭제");
				System.out.println("  5. 뒤로가기");
				System.out.println("----------------------");
				System.out.print("원하는 작업 선택 >> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1:
					selectQna();
					break;
				case 2:
					insertQna();
					break;
				case 3:
					updateQna();
					break;
				case 4:
					deleteQna();
					break;
				case 5:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} while (menu != 5);
		} else {
			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("글 번 호\t제  목\t작성일자\t\t작성자");
			System.out.println("------------------------------------------------------------");

			List<PostVO> qnaList = qnaService.selectAllPost();

			if (qnaList.size() == 0) {
				System.out.println("조회된 데이터가 없습니다.");
			} else {
				for (PostVO pv : qnaList) {
					System.out.println(pv.getPostNum() + "\t" + "\t" + pv.getPostTitle() + "\t" + pv.getPostDate()
							+ "\t" + pv.getUserId());
					System.out.println("------------------------------------------------------------");
				}
			}
			do {
				System.out.println();
				System.out.println("----------------------");
				System.out.println("  --- Q & A ---");
				System.out.println("  1. Q&A 조회");
				System.out.println("  2. Q&A 작성");
				System.out.println("  3. Q&A 수정");
				System.out.println("  4. 뒤로가기");
				System.out.println("----------------------");
				System.out.print("원하는 작업 선택 >> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1:
					selectQna();
					break;
				case 2:
					insertQna();
					break;
				case 3:
					updateQna();
					break;
				case 4:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} while (menu != 4);
		}

	}

	private void selectQna() {
		int menu = 0;

		if (memVO == null || !memVO.getUserId().equals("admin")) {
			int postNum = 0;

			System.out.print("조회할 QnA >> ");
			postNum = Integer.parseInt(scan.nextLine());

			PostVO pv = qnaService.selectPost(postNum);

			String title = pv.getPostTitle();
			String content = pv.getPostContent();
			String date = pv.getPostDate();
			String postAnswer = pv.getPostAnswer();

			System.out.println("제목 : " + title);
			System.out.println("작성일자 :" + date);
			System.out.println("----------------------------------");
			System.out.println("내용 : " + content);
			System.out.println("----------------------------------");
			System.out.println("답글 : " + postAnswer);
			System.out.println("----------------------------------");

		} else {
			int postNum = 0;

			System.out.print("조회할 QnA >> ");
			postNum = Integer.parseInt(scan.nextLine());

			PostVO pv = qnaService.selectPost(postNum);

			String title = pv.getPostTitle();
			String content = pv.getPostContent();
			String date = pv.getPostDate();
			String postAnswer = pv.getPostAnswer();

			System.out.println("제목 : " + title);
			System.out.println("작성일자 :" + date);
			System.out.println("----------------------------------");
			System.out.println("내용 : " + content);
			System.out.println("----------------------------------");
			System.out.println("답글 : " + postAnswer);
			System.out.println("----------------------------------");

			do {
				System.out.println();
				System.out.println("----------------------");
				System.out.println("  --- Q & A ---");
				System.out.println("  1. 답글달기");
				System.out.println("  2. 뒤로가기");
				System.out.println("----------------------");
				System.out.print("원하는 작업 선택 >> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1:
					addpostAnswer(postNum);
					break;
				case 2:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} while (menu != 2);
		}
	}

	private void insertQna() {
		String title, content;

		System.out.print("  1. 제목  >> ");
		title = scan.nextLine();
		System.out.print("  2. 내용  >> ");
		content = scan.nextLine();

		PostVO pv = new PostVO();

		pv.setUserId(memVO.getUserId());
		pv.setPostTitle(title);
		pv.setPostContent(content);

		int cnt = qnaService.registPost(pv);

		if (cnt > 0) {
			System.out.println("등록에 성공하였습니다.");
		} else {
			System.out.println("등록 실패");
		}
	}

	private void updateQna() {
		int postNum;
		String content;

		System.out.print("  1. 글 번호  >> ");
		postNum = Integer.parseInt(scan.nextLine());
		System.out.print("  2. 내용  >> ");
		content = scan.nextLine();

		PostVO pv = new PostVO();

		pv.setPostNum(postNum);
		pv.setPostContent(content);
		pv.setUserId(memVO.getUserId());

		int cnt = qnaService.modifyPost(pv);

		if (cnt > 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정 실패");
		}

	}

	private void deleteQna() {
		int postNum;

		System.out.print("삭제할 QnA >> ");
		postNum = Integer.parseInt(scan.nextLine());

		PostVO pv = qnaService.selectPost(postNum);

		if (!pv.getUserId().equals(memVO.getUserId())) {
			System.out.println("해당 글의 작성자가 아닙니다.");
			return;
		}

		int cnt = qnaService.removePost(postNum);

		if (cnt > 0) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("삭제 실패");
		}
	}

	private void addpostAnswer(int postNum) {
		String postAnswer;

		System.out.print("  답변  >> ");
		postAnswer = scan.nextLine();

		PostVO pv = new PostVO();

		pv.setPostNum(postNum);
		pv.setPostAnswer(postAnswer);

		int cnt = qnaService.addComment(pv);

		if (cnt > 0) {
			System.out.println("답글이 등록되었습니다.");
		} else {
			System.out.println("등록 실패");
		}
	}

	public void product() {
		int category;

		if (memVO == null) {
			do {
				System.out.println("----------------------");
				System.out.println("  --- Products ---");
				System.out.println("  1. 노트북");
				System.out.println("  2. 스마트폰");
				System.out.println("  3. 테블릿");
				System.out.println("  4. 기타");
				System.out.println("  5. 뒤로가기");
				System.out.print("원하는 작업 선택 >> ");
				category = Integer.parseInt(scan.nextLine());
				switch (category) {
				case 1:
				case 2:
				case 3:
				case 4:
					nonLoginProd(category);
					break;
				case 5:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요");
					break;
				}
			} while (category != 5);
		} else if (!memVO.getUserId().equals("admin")) {
			do {
				System.out.println("----------------------");
				System.out.println("  --- Products ---");
				System.out.println("  1. 노트북");
				System.out.println("  2. 스마트폰");
				System.out.println("  3. 테블릿");
				System.out.println("  4. 기타");
				System.out.println("  5. 뒤로가기");
				System.out.print("원하는 작업 선택 >> ");
				category = Integer.parseInt(scan.nextLine());
				switch (category) {
				case 1:
				case 2:
				case 3:
				case 4:
					showProd(category);
					break;
				case 5:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요");
					break;
				}
			} while (category != 5);
		} else if (memVO.getUserId().equals("admin")) {
			System.out.println();
			System.out.println("  --- Category ---");
			System.out.println("------------------------------------------------------------");
			System.out.println("카테고리 번호\t     카테고리명");
			System.out.println("------------------------------------------------------------");

			List<ProdCatVO> catNumList = prodService.showCatNum();

			if (catNumList.size() == 0) {
				System.out.println("조회된 데이터가 없습니다.");
			} else {
				for (ProdCatVO pcv : catNumList) {
					System.out.println(pcv.getCatNum() + "\t" + pcv.getCatName());
					System.out.println("------------------------------------------------------------");
				}
			}

			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("상 품 I D\t상 품 명\t가  격\t재  고");
			System.out.println("------------------------------------------------------------");

			List<ProdVO> prodList = prodService.selectAllProd();

			if (prodList.size() == 0) {
				System.out.println("조회된 데이터가 없습니다.");
			} else {
				for (ProdVO pv : prodList) {
					System.out.println(pv.getProdId() + "\t" + pv.getProdName() + "\t" + pv.getProdPrice() + "\t"
							+ pv.getProdStock());
					System.out.println("------------------------------------------------------------");
				}
			}
			do {
				System.out.println("----------------------");
				System.out.println("  --- Products ---");
				System.out.println("  1. 상품등록");
				System.out.println("  2. 상품수정");
				System.out.println("  3. 상품삭제");
				System.out.println("  4. 매출관리");
				System.out.println("  5. 뒤로가기");
				System.out.print("원하는 작업 선택 >> ");
				category = Integer.parseInt(scan.nextLine());
				switch (category) {
				case 1:
					insertProd();
					break;
				case 2:
					updateProd();
					break;
				case 3:
					deleteProd();
					break;
				case 4:
					salesManage();
					break;
				case 5:
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력하세요");
					break;
				}
			} while (category != 5);
		}
	}

	private void nonLoginProd(int category) {
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("상 품 I D\t상 품 명\t가  격\t재  고");
		System.out.println("------------------------------------------------------------");

		List<ProdVO> prodList = prodService.selectCatProd(category);

		if (prodList.size() == 0) {
			System.out.println("조회된 데이터가 없습니다.");
		} else {
			for (ProdVO pv : prodList) {
				System.out.println(
						pv.getProdId() + "\t" + pv.getProdName() + "\t" + pv.getProdPrice() + "\t" + pv.getProdStock());
				System.out.println("------------------------------------------------------------");
			}
		}
	}

	private void showProd(int category) {
		int menu;
		String prodId;

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("상 품 I D\t상 품 명\t가  격\t재  고");
		System.out.println("------------------------------------------------------------");

		List<ProdVO> prodList = prodService.selectCatProd(category);

		if (prodList.size() == 0) {
			System.out.println("조회된 데이터가 없습니다.");
		} else {
			for (ProdVO pv : prodList) {
				System.out.println(
						pv.getProdId() + "\t" + pv.getProdName() + "\t" + pv.getProdPrice() + "\t" + pv.getProdStock());
				System.out.println("------------------------------------------------------------");
			}
		}
		do {
			System.out.println("----------------------");
			System.out.println("  --- Products ---");
			System.out.println("  1. 상품담기");
			System.out.println("  2. 뒤로가기");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				addCart();
				break;
			case 2:
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 2);
	}

	private void addCart() {
		int prodCount;
		String prodId;

		// Insert CartVO 에 추가
		System.out.print("상품 ID를 입력하세요 >> ");
		prodId = scan.nextLine();

		System.out.print("담을 상품 개수를 입력하시오  >> ");
		prodCount = Integer.parseInt(scan.nextLine());

		CartVO cv = new CartVO();

		cv.setCartNum(cartNum);
		cv.setProdId(prodId);
		cv.setUserId(memVO.getUserId());
		cv.setProdCount(prodCount);
		cv.setCartPay("n");

		int cnt = cartSerivce.addCart(cv);

		if (cnt > 0) {
			System.out.println("장바구니에 상품이 추가되었습니다.");
		} else {
			System.out.println("추가 실패");
		}

	}

	private void insertProd() {
		String prodId;
		String prodName;
		int prodPrice;
		int prodStock;
		int catNum;

		System.out.print("  1. 상품 ID  >> ");
		prodId = scan.nextLine();
		System.out.print("  2. 상품명  >> ");
		prodName = scan.nextLine();
		System.out.print("  3. 가격  >> ");
		prodPrice = Integer.parseInt(scan.nextLine());
		System.out.print("  4. 재고  >> ");
		prodStock = Integer.parseInt(scan.nextLine());
		System.out.print("  5. 카테고리 번호  >> ");
		catNum = Integer.parseInt(scan.nextLine());

		ProdVO pv = new ProdVO();

		pv.setProdId(prodId);
		pv.setProdName(prodName);
		pv.setProdPrice(prodPrice);
		pv.setProdStock(prodStock);
		pv.setCatNum(catNum);

		int cnt = prodService.registProd(pv);

		if (cnt > 0) {
			System.out.println("상품 등록 완료.");
		} else {
			System.out.println("상품 등록 실패");
		}
	}

	private void updateProd() {
		String prodId;
		int prodPrice;

		System.out.print("  수정할 상품 ID  >> ");
		prodId = scan.nextLine();
		System.out.print("  수정 후 상품 가격  >> ");
		prodPrice = Integer.parseInt(scan.nextLine());

		ProdVO pv = prodService.selectProd(prodId);

		pv.setProdPrice(prodPrice);

		int cnt = prodService.modifyProd(pv);

		if (cnt > 0) {
			System.out.println("상품 가격 수정 완료.");
		} else {
			System.out.println("수정 실패");
		}

	}

	private void deleteProd() {
		String prodId;

		System.out.print("  수정할 상품 ID  >> ");
		prodId = scan.nextLine();

		int cnt = prodService.removeProd(prodId);

		if (cnt > 0) {
			System.out.println("상품 삭제 완료.");
		} else {
			System.out.println("삭제 실패");
		}
	}

	private void salesManage() {
		int menu;
		do {
			System.out.println("----------------------");
			System.out.println("  --- Products ---");
			System.out.println("  1. 총 매출");
			System.out.println("  2. 뒤로가기");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				// Show All Sales
				showSales();
				break;
			case 2:
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 2);
	}

	private void showSales() {
		int sales = 0;
		
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("주문번호\t주문일자\t소계");
		System.out.println("------------------------------------------------------------");
		List<OrderVO> orderList = orderService.selectAllOrders();

		if (orderList.size() == 0) {
			System.out.println("조회된 데이터가 없습니다.");
		} else {
			for (OrderVO ov : orderList) {
				
				System.out.println(ov.getOrderNum() + "\t" + ov.getOrderDate() + "\t" + ov.getOrderPrice());

				sales += ov.getOrderPrice();
			}
		}
		System.out.println("------------------------------------------------------------");
		System.out.println(String.format("총 매출 : %d 원", sales));
		System.out.println("------------------------------------------------------------");
		
	}

	public void myPage() {
		int menu;
		do {
			System.out.println("----------------------");
			System.out.println("  --- My Page ---");
			System.out.println("  1. 회원정보");
			System.out.println("  2. 장바구니");
			System.out.println("  3. 주문내역조회");
			System.out.println("  4. 뒤로가기");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				showMemInfo();
				break;
			case 2:
				cart();
				break;
			case 3:
				showOrders();
				break;
			case 4:
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 4);
	}

	private void showMemInfo() {
		int menu;

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("회원 ID : " + memVO.getUserId());
		System.out.println("------------------------------------------------------------");
		System.out.println("회원명 : " + memVO.getUserName());
		System.out.println("------------------------------------------------------------");
		System.out.println("전화번호 : " + memVO.getUserPhone());
		System.out.println("------------------------------------------------------------");
		System.out.println("주소 : " + memVO.getUserAddr());
		System.out.println("------------------------------------------------------------");
		System.out.println("Email : " + memVO.getUserEmail());
		System.out.println("------------------------------------------------------------");
		System.out.println();

		do {
			System.out.println("----------------------");
			System.out.println("  --- My Page ---");
			System.out.println("  1. 회원정보수정");
			System.out.println("  2. 뒤로가기");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			System.out.println(menu);
			switch (menu) {
			case 1:
				modifyUserInfo();
				break;
			case 2:
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 2);
	}

	private void modifyUserInfo() {
		String memPw;

		System.out.print("비밀번호를 입력하시오  >> ");
		memPw = scan.nextLine();

		if (memPw.equals(memVO.getUserPw())) {
			System.out.print("  1. 수정할 전화번호  >> ");
			String phone = scan.nextLine();
			System.out.println();
			System.out.print("  2. 수정할 주소  >> ");
			String addr = scan.nextLine();
			System.out.println();
			System.out.print("  3. 수정할 이메일  >> ");
			String email = scan.nextLine();
			System.out.println();

			if (!phone.equals("") || phone != null) {
				memVO.setUserPhone(phone);
			}
			if (!addr.equals("") || addr != null) {
				memVO.setUserAddr(addr);
			}
			if (!email.equals("") || email != null) {
				memVO.setUserEmail(email);
			}

			System.out.println(memVO);

			int cnt = memService.modifyMember(memVO);

			if (cnt > 0) {
				System.out.println("회원 정보 수정 완료.");
			} else {
				System.out.println("정보 수정 실패");
			}
		}

	}

	private void cart() {
		int menu;

		CartVO cv = new CartVO();

		cv.setUserId(memVO.getUserId());
		cv.setCartNum(cartNum);

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("번 호\t상 품 명\t수  량\t소  계");
		System.out.println("------------------------------------------------------------");

		List<CartVO> cartList = cartSerivce.selectAll(cv);

		if (cartList.size() == 0) {
			System.out.println("조회된 데이터가 없습니다.");
		} else {
			for (CartVO cv2 : cartList) {
				ProdVO pv = prodService.selectProd(cv2.getProdId());

				System.out.println(cv2.getProdId() + "\t" + pv.getProdName() + "\t" + cv2.getProdCount() + "\t"
						+ (pv.getProdPrice() * cv2.getProdCount()));
				System.out.println("------------------------------------------------------------");
			}
		}

		do {
			System.out.println("----------------------");
			System.out.println("  --- My Page ---");
			System.out.println("  1. 결제하기");
			System.out.println("  2. 수량변경");
			System.out.println("  3. 물품삭제");
			System.out.println("  4. 뒤로가기");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				payCart();
				break;
			case 2:
				changeQty();
				break;
			case 3:
				deleteCart();
				break;
			case 4:
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 4);
	}

	private void payCart() {
		CartVO cv = new CartVO();

		cv.setCartNum(cartNum);
		cv.setUserId(memVO.getUserId());

		int cnt1 = orderService.addOrder(memVO.getUserId());
		int cnt2 = orderService.addOrderDetail();
		if (cnt1 > 0 && cnt2 > 0) {
			int cnt3 = cartSerivce.correctPaid(cv);

			if (cnt3 > 0) {
				List<CartVO> cartList = cartSerivce.selectCart(cv);

				if (cartList.size() == 0) {
					System.out.println("조회된 데이터가 없습니다.");
				} else {
					for (CartVO cv2 : cartList) {
						ProdVO pv = new ProdVO();

						pv.setProdId(cv2.getProdId());
						pv.setProdStock(cv2.getProdCount());

						int cnt4 = prodService.payProdStock(pv);

						if (cnt4 > 0) {
							
						} else {
							System.out.println("결제 실패.");
						}
					}
				}
			} else {
				System.out.println("결제 실패.");
			}
		} else {
			System.out.println("결제 실패.");
		}
	}

	private void showOrders() {
		int menu;

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("번 호\t주문 일자\t\t소  계");
		System.out.println("------------------------------------------------------------");
		List<OrderVO> orderList = orderService.selectAllOrders(memVO.getUserId());

		if (orderList.size() == 0) {
			System.out.println("조회된 데이터가 없습니다.");
		} else {
			for (OrderVO ov : orderList) {
				System.out.println(ov.getOrderNum() + "\t" + ov.getOrderDate() + "\t" + ov.getOrderPrice());
				System.out.println("------------------------------------------------------------");
			}
		}
		do {
			System.out.println("----------------------");
			System.out.println("  --- My Page ---");
			System.out.println("  1. 상세보기");
			System.out.println("  2. 뒤로가기");
			System.out.print("원하는 작업 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				orderDetails();
				break;
			case 2:
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				break;
			}
		} while (menu != 2);

	}

	private void orderDetails() {
		int orderNum;

		System.out.print("  1. 확인할 주문번호  >> ");
		orderNum = Integer.parseInt(scan.nextLine());
		System.out.println();

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("번 호\t상 품 명\t\t소  계");
		System.out.println("------------------------------------------------------------");

		List<OrderDetailVO> orderDetailList = orderService.selectAllOrderDetails(orderNum);

		if (orderDetailList.size() == 0) {
			System.out.println("조회된 데이터가 없습니다.");
		} else {
			for (OrderDetailVO odv : orderDetailList) {
				ProdVO pv = prodService.selectProd(odv.getProdId());
				
				System.out.println(odv.getOrderNum() + "\t" + pv.getProdName() + "\t" + odv.getOrderCount());
				System.out.println("------------------------------------------------------------");
			}
		}
	}

	private void changeQty() {
		int prodCount;
		String prodId;

		System.out.print("  1. 변경할 상품번호  >> ");
		prodId = scan.nextLine();
		System.out.println();
		System.out.print("  2. 변경할 상품수량  >> ");
		prodCount = Integer.parseInt(scan.nextLine());
		System.out.println();

		CartVO cv = new CartVO();

		cv.setProdCount(prodCount);
		cv.setProdId(prodId);
		cv.setUserId(memVO.getUserId());

		int cnt = cartSerivce.modifyCart(cv);

		if (cnt > 0) {
			System.out.println("상품 수량이 변경되었습니다.");
		} else {
			System.out.println("변경 실패.");
		}
	}

	private void deleteCart() {
		String prodId;

		System.out.print("  1. 변경할 상품번호  >> ");
		prodId = scan.nextLine();
		System.out.println();

		CartVO cv = new CartVO();

		cv.setProdId(prodId);
		cv.setUserId(memVO.getUserId());

		System.out.println(cv);

		int cnt = cartSerivce.removeCart(cv);

		if (cnt > 0) {
			System.out.println("주문 삭제되었습니다.");
		} else {
			System.out.println("변경 실패.");
		}
	}

	private void createInstance() {
		memService = MemberService.getInstance();
		noticeService = NoticeService.getInstance();
		qnaService = QnAService.getInstance();
		prodService = ProdService.getInstance();
		cartSerivce = CartService.getInstance();
		orderService = OrderService.getInstance();
	}

	private void logout() {
		memVO = null;
		int cnt = cartSerivce.logout(cartNum);

		if (cnt > 0) {
			System.out.println("로그아웃 되었습니다.");
		} else {
			System.out.println("작업이 정상적으로 수행되지 않았습니다.");
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
	}
}
