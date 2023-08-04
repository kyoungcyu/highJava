package kr.or.ddit.basic;

public class Horse implements Comparable<Horse> {
//말이름 과  멤버변수로같는다
	String name;
	int rank;//순위

	public Horse(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return name + ":" + rank +"등" ;
	}
	@Override
	public int compareTo(Horse o) { // 비교후 등수의 오름차순 정렬
		if (this.rank > o.rank) {// 양수일때 오름차순정렬
			return 1;
		} else if (this.rank == o.rank) {
			return 0;
		} else {
			return -1;

		}
	}
}
