package kr.or.ddit.basic;

public class T19WaitNotifyTest {
/*
   wait() => 동기화 영역에서 락을 풀고 Wait-set영역(공유객체별 존재)으로 이동시킨다
   
   notify() 또는 notifyAll() => Wait-Set영역에 있는 스레드를 깨워서 실행될 수 있도록 한다.
   (notify()는 하나 , notifyAll()은 Wait-Set에 있는 모든 스레드를 깨운다)
   
    => wait() 와 notify(),notifyAll()메소드는 동기화 영역에서만 실행할 수 있고, Object클래스에서
    제공하는 메소드잇다
 */
	public static void main(String[] args) {
		WorkObject workobj = new WorkObject();
		
		new ThreadA(workobj).start();
		new ThreadB(workobj).start();
		
	}
}
// 공통으로 사용할 객체
class WorkObject{
	public synchronized void methodA(){
		System.out.println("methodA() 메소드 작업 중 ...");
		System.out.println(Thread.currentThread().getName()+": notify() 호출");
		
		notify();
		
		try {
		System.out.println(Thread.currentThread().getName()+": wait() 호출");
		wait();
		}catch(InterruptedException  ex) {
			ex.printStackTrace();
		}
		
		}

public synchronized void methodB(){
	System.out.println("methodB() 메소드 작업 중 ...");
	System.out.println(Thread.currentThread().getName()+": notify() 호출");
	
	notify();
	
	try {
		System.out.println(Thread.currentThread().getName()+": wait() 호출");
		wait();
	}catch(InterruptedException ex) {
		ex.printStackTrace();
	}
	
}
}
// workObject의 methodA() 만 호출한믄 스레드
class ThreadA extends Thread {
	private WorkObject workobj;
	
	public ThreadA(WorkObject workObj) {
		super("ThreadA");
		this.workobj=workObj;
	}
	@Override
	public void run() {
		for(int i=1;i<=10; i++) {
			workobj.methodA();
		}
		System.out.println("ThreadA 종료.");
	}
}


class ThreadB extends Thread {
	private WorkObject workobj;
	
	public ThreadB(WorkObject workObj) {
		super("ThreadB");
		this.workobj=workObj;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10; i++) {
			workobj.methodB();
		}
		System.out.println("ThreadB 종료.");
	}
}
