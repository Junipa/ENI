package fr.eni.module7;

import java.util.Scanner;

public class Tp8bManipTable {
	
	public static int[] createTable(Scanner scanner) {
		int[] table = new int[5];
		System.out.println("Please, enter 5 integer numbers. Press 'Enter' after each one.");
		for (int i = 0; i < table.length; i++) {
			table[i] = scanner.nextInt();
		}
		return table;
	}
	
	public static void displayTable(int[] table) {
		for (int i = 0; i < table.length; i++) {
			System.out.print(" | " + table[i]);
		}
		System.out.print(" |");
		System.out.println("");
	}
	
	public static void searchValue(Scanner scanner, int[] table) {
		int choice;
		int value;
		boolean found = false;
		do {
			System.out.println("Do you want to search for a value ?\n1- Yes\n2- No");
			choice = scanner.nextInt();
			if (choice != 1 && choice != 2) {
				System.out.println("Input not recognised. Please enter '1' or '2'.");
			}
		} while (choice != 1 && choice != 2);
		if (choice == 1) {
			System.out.println("Enter the value to search:");
			value = scanner.nextInt();
			for (int i = 0; i < table.length; i++) {
				if (value == table[i]) {
					found = true;
					System.out.println("The value " + value + " has been found in position " + (i+1) + ".");				
				}
			}
			if (!found) {
				System.out.println("The value " + value + " has not been found in this table.");
			}
		}
		System.out.println("Program over.");	
	}

	public static void main(String[] args) {
		/*Le programme trie le contenu du tableau de manière croissante. 
		Après le tri, la première case du tableau contient la valeur la plus petite, 
		alors que la dernière contient la plus grande. 
		Principe du tri à bulle et notion d’échange de valeurs sont à utiliser ici. */
		Scanner scanner = new Scanner(System.in);
		int[] table = new int[5];
		table = createTable(scanner);
		displayTable(table);
		searchValue(scanner, table);
		scanner.close();
	}

}
