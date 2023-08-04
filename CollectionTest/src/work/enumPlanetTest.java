package work;


public class enumPlanetTest {
	public enum Planet {
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		private int str;

		Planet(int str) {
			this.str = str;
		}

		public int getStr() {
			return str;
		}

	}

	public static void main(String[] args) {
		Planet pln1 = Planet.수성;
		Planet pln2 = Planet.금성;
		Planet pln3 = Planet.지구;
		Planet pln4 = Planet.화성;
		Planet pln5 = Planet.목성;
		Planet pln6 = Planet.토성;
		Planet pln7 = Planet.천왕성;
		Planet pln8 = Planet.해왕성;

		Planet[] enumArr = Planet.values();
//		for (int i = 0; i < enumArr.length; i++) {
//			System.out.println(enumArr[i].name() + ":" + enumArr[i].getStr());
//		}

		for (Planet planet : Planet.values()) {
			System.out.println(planet + ":" + planet.getStr());
		}
//		Planet planet = Planet.수성;
	}
}
