package work;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();
		
		Hotel hotel = new Hotel();
		while (true) {
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴선택 => ");
			try {
				int choseNum = sc.nextInt();
				switch (choseNum) {
				case 1:
					System.out.println("어느방에 체크인 하시겠습니까?");
					System.out.print("방번호 입력 => ");
					hotel.setRoomNum(sc.nextInt());
					System.out.println();
					System.out.println("누구를 체크인 하시겠습니까?");
					System.out.print("이름 입력 => ");
					sc.nextLine();
					hotel.setUnderName(sc.nextLine());
					System.out.println();
					if (hotel.checkin()) {
						System.out.println("체크인 되었습니다");
					} else {
						System.out.println(hotel.getRoomNum() + "방에는 이미 사람이 있습니다");
					}
					break;
				case 2:
					System.out.println("어느방을 체크아웃 하시겠습니까?");
					System.out.print("방번호 입력 => ");
					hotel.checkout(sc.nextInt());
					break;
				case 3:
					hotel.roomCondition();
					break;
				case 4:
					System.out.println("**************************");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("**************************");
					return;
				default:
					System.out.println("잘못된 입력입니다 다시 입력해주세요");
					System.out.println("\n\n\n\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다 다시 입력해주세요");
				sc.next();
			}
		}}}
	



