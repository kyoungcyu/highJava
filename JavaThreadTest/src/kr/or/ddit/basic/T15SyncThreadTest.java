package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {
		//공유객체 
		ShareObject sObj = new ShareObject();
		Thread th1 = new WorkThread("1번 스레드", sObj); 
		Thread th2 = new WorkThread("2번 스레드", sObj);
		
		th1.start();
		th2.start();
	
	
	}
}

//	공통으로 사용할 클래스 
class ShareObject{
	private int sum =0;
	
	// 동기화 하는 방법1: 메소드 자체에 동기화 설정하기
// 동1	public synchronized void add() {
	
	 public void add() {
			for (int i = 0; i < 1000000000; i++) {
			} // 동기화 처리

			 //동기화 하는 방법2 : 동기화 블럭으로 설정하기
			// mutex : Mutual exclusion Object (상호 배제: 동시접근 차단)
//동2			synchronized (this) { // this -> ShareObject

				int n = sum;

				n += 10;

				sum = n;

				System.out.println(Thread.currentThread().getName() + "합계: " + sum);
//동2			}
	}
}
// 작업을 수행하는 스레드
class WorkThread extends Thread {
	private ShareObject sObj;
	
	public WorkThread(String name, ShareObject sObj) {
		super(name);
		this.sObj =sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10 ; i++) {
//동3			synchronized (this) {
				
				sObj.add();
//동3			}
		}
	}
}


