package work;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("110", "아구찜", 90, 80, 85));
		list.add(new Student("223", "고구마", 87, 76, 34));
		list.add(new Student("243", "닭가슴살", 60, 78, 45));
		list.add(new Student("287", "옥수수", 80, 80, 90));
		list.add(new Student("119", "하마", 66, 77, 85));
		list.add(new Student("400", "고릴라", 66, 77, 85));

		StudentTest st = new StudentTest();
		st.setGrade(list);
		Collections.sort(list);
		// 학번 오름차순정렬
		for (Student num : list) {
			System.out.println("학번 오름차순: " + num);
		}
		System.out.println(
				"========================================================================================================");

		Collections.sort(list, new Allscore());
		// 총점 내림차순 정렬
		for (Student score : list) {
			System.out.println("총점 내림차순: " + score);
		}
		System.out.println(
				"========================================================================================================");
	}

	public void setGrade(List<Student> list) {
		int rank = 1;
		for (Student st1 : list) {
			for (Student st2 : list) {
				if (st1.getGrade() < st2.getGrade()) {
					rank++;
				}
			}
			st1.setGrade(rank);
		} 
	}
}

class Student implements Comparable<Student> {
	private String num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int score;
	private int grade;

	public Student(String num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.score = kor + eng + mat;

	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "학번 :" + num + ",이름:" + name + ",국어점수:" + kor + ",영어점수:" + eng + ", 수학점수: " + mat + ",총점: " + score
				+ ",등수 :" + grade;
	}

	@Override
	public int compareTo(Student st) {
		return num.compareTo(st.getNum());
	}

}

class Allscore implements Comparator<Student> {

	@Override
	public int compare(Student st1, Student st2) {// 총점 정렬
		if (st1.getScore() == st2.getScore()) {// 다른객체가 같은 총점을 가질경우
			return st1.getNum().compareTo(st2.getNum()) * -1; // 내림차순
		} else {
			return Integer.compare(st1.getScore(), st2.getScore()) * -1; // 1번째점수와 2번쨰 점수를 인트화후 음수화 내림차순
		}
	}

}
