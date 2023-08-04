package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class Exercise {
	public static boolean inputCheck = false;

	public static void main(String[] args) {

		Thread th1 = new Datainput1();
		th1.start();
		Thread th2 = new CountDown1();
		th2.start();
	}
}


class Datainput1 extends Thread {
		
	@Override
	public void run() {
		Random random = new Random();
		
		String str = JOptionPane.showInputDialog("가위바위보를 입력하세요");
		int sc =random.nextInt(3);
		String arry[] = {"가위","바위","보"};
		
		if(str.equals(arry[sc])) {
			System.out.println("비겼습니다.");
		}else if(str.equals("가위")&& arry[sc].equals("바위")){
			System.out.println("당신이 이겻습니다");
		}else {
			System.out.println("당신이 졌습니다");
		}
				
		T06TreadTest.inputCheck = true;

		System.out.println("입력한 값은 " + str + "입니다.");
		
		

	}
}

class CountDown1 extends Thread {
	@Override
	public void run() {

		for (int i = 5; i >= 1; i--) { // 카운트다운 5초

			if (T06TreadTest.inputCheck) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("5초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}