package kr.or.ddit.basic;

public class T08TreadPriorityTest {
	public static void main(String[] args) {

		System.out.println("최대 우선순위 :" + Thread.MAX_PRIORITY);
		System.out.println("최소 우선순위 :" + Thread.MIN_PRIORITY);
		System.out.println("보통 우선순위 :" + Thread.NORM_PRIORITY);

		Thread[] ths = new Thread[] { //디폴트값으로 자동으로 스래드 이름이 들어감 
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest2() };

		// 우선 순위는 start()메소드를 호풀하기 전에 설정해 주어야한다.
		for (int i = 0; i < ths.length; i++) {
			if (i == 5) {
				ths[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				ths[i].setPriority(Thread.MIN_PRIORITY);
			}
		}
		
		// 설정된 우선순위 출력하기
		for(Thread th: ths) {
			System.out.println(th.getName() + "의 우선순위 :" + th.getPriority());
		}
		
		// 스레드 시작
		for(Thread th : ths) {
			th.start();
		}
	}
}

// 알파벳 대문자를 출력하는 스래드
class ThreadTest1 extends Thread {
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);

			// 아무것도 하지 않는 반복문(시간때우기)
			for (long i = 1; i <= 1000000000L; i++) {
			}
		}
	}
}

// 알파벳 소문자를 출력하는 스레드
class ThreadTest2 extends Thread {
	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(ch);

			// 아무것도 하지 않는 반복문(시간때우기)
			for (long i = 1; i <= 1000000000L; i++) {
			}
		}
	}
}