package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HorseTest {
	static int rank;

	public static void main(String[] args) {
		List<Horse> horses = new ArrayList<>(); // 1번째 말 객체

		horses.add(new Horse("1번말"));
		horses.add(new Horse("2번말"));
		horses.add(new Horse("3번말"));
		horses.add(new Horse("4번말"));
		horses.add(new Horse("5번말"));
		horses.add(new Horse("6번말"));
		horses.add(new Horse("7번말"));
		horses.add(new Horse("8번말"));
		horses.add(new Horse("9번말"));
		horses.add(new Horse("10번말"));

		List<Thread> ths = new ArrayList<>();

		for (Horse h : horses) {
			ths.add(new HorseRace(h)); // Horse 클래스가 Thread 타입을 상속받지 않고 있어서 발생하는 에러
		}
		for (Thread th : ths) {
			th.start();
		}
		for (Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(horses);
		for (Horse h : horses) {
			System.out.println(h);
		}
	}
}

class HorseRace extends Thread {
	String[] stadium;

	Horse horse;

	public HorseRace(Horse horse) { // 경마장
		stadium = new String[50];
		this.horse = horse;

		stadium[0] = ">"; // 말
		for (int i = 1; i < stadium.length; i++) { // 트랙
			stadium[i] = "-";
		}
	}

	@Override
	public void run() {
		String position = "";
		Random random = new Random();

		for (int i = 0; i < stadium.length; i++) {
			System.out.println(horse.getName() + "");
			for (String str : stadium) {
				System.out.print(str);
			}
			System.out.println();

			if (stadium[stadium.length - 1].equals(">")) {
				horse.setRank(++HorseTest.rank);
				return;
			}

			position = stadium[i];
			stadium[i] = stadium[i + 1];
			stadium[i + 1] = position;

			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
