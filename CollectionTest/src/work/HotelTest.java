package work;

import java.util.Map;
import java.util.Scanner;

public class HotelTest {

	public static void main(String[] args) {
		  

	}

	public class HotelSystem {
		 Map<Integer, HotelKey> hotelKey;
		    Scanner scanner = new Scanner(System.in);

		    void open() {
		        System.out.println("**********************");
		        System.out.println("호텔문을 열었습니다.");
		        System.out.println("**********************");
		        this.work();
		    }
		
		void work() {// 메뉴 출력메소드
			System.out.println();
			System.out.println("********************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인, 2.체크아웃, 3.객실상태, 4.업무종료");
			System.out.println("********************************************");
			System.out.print("메뉴선택>>");
			int inputNum = Integer.parseInt(scanner.nextLine());
			switch (inputNum) {
			case 1:
				checkIn();
				break;
			case 2: 
				checkOut();
				break;
			case 3:
				condition();
				break;
			case 4:
				workout();
				break;
			case 0:
				System.out.println("************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("************************");
			}
			

			
		}

		private void workout() {
			// TODO Auto-generated method stub
			
		}

		private void condition() {
			// TODO Auto-generated method stub
			
		}

		private void checkOut() {
			// TODO Auto-generated method stub
			
		}

		private void checkIn() {
			// TODO Auto-generated method stub
			
		}
	}
	}

class HotelKey{
	private String name;

	public HotelKey(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HoptelKey [name=" + name + "]";
	}
	
}


