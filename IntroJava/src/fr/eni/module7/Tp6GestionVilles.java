package fr.eni.module7;

public class Tp6GestionVilles {
	
	public static void displayTable(String[] tab) {
		for (String item : tab) {
			System.out.println(item);
		}
	}
	
	public static void displayItemsStartingWithA(String[] tab) {
		for (String item : tab) {
			if (item.charAt(0) == 'A') {
				System.out.println(item);
			}
		}
	}
	
		public static String[] addIntToTableItems(String[] tab) {
			for (int i = 0; i < tab.length; i++) {
				int randy = (int) Math.abs(Math.round(Math.random() * (1 - tab.length) * 10) / 10);
				tab[i] +=  String.valueOf(randy);
			}
			return tab;
		}
	
	public static void main(String[] args) {
		String[] cities = {"Lille", "Lens", "Amiens", "Rouen", "Caen", "Rennes", "Nantes", "Niort", "Bordeaux", "Bayonne"};
		displayTable(cities);
		displayItemsStartingWithA(cities);
		cities = addIntToTableItems(cities);
		displayTable(cities);
	}
	
}
