package fr.eni.module5;

import java.util.Scanner;

public class Tp5PlusGrand {
	
	public static float plusGrand(float num1, float num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static float comparer(float num1, float num2) {
		if (num1 > num2) {
			return 1;
		} else if (num1 == num2) {
			return 0;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Saisies
		System.out.println("Saisissez une première valeur réelle.");
		float num1 = scanner.nextFloat();
		System.out.println("Saisissez une seconde valeur réelle.");
		float num2 = scanner.nextFloat();
		System.out.println("Quelle fonction souhaitez-vous tester ?\n1-Le plus grand\n2-Comparaison");
		int choix = scanner.nextInt(); scanner.nextLine();
		
		//Appels fonctions
		if (choix == 1) {
			System.out.println(plusGrand(num1, num2));
		} else if (choix == 2) {
			System.out.println(comparer(num1, num2));
		} else {
			System.out.println("Saisie non reconnue.");
		}
	}

}
