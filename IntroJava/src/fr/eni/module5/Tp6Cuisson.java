package fr.eni.module5;

import java.util.Scanner;

public class Tp6Cuisson {
	static final int BOEUF = 1;
	static final int AGNEAU = 2;
	static final int BLEU = 1;
	static final int A_POINT = 2;
	static final int B_CUIT = 3;
	static final int MINUTE = 60;
	static final double BLEU_B = 10.0/500;
	static final double BLEU_A = 15.0/400;
	static final double A_PT_B = 17.0/500;
	static final double A_PT_A = 25.0/400; 
	static final double B_CU_B = 25.0/500;
	static final double B_CU_A = 40.0/400;
	
	public static int saisirViande(Scanner scanner) {
		System.out.println("Saisir le type de viande souhaité:\n1-BOEUF\n2-AGNEAU");
		int type = scanner.nextInt();
		return type;
	}
	
	public static int saisirCuisson(Scanner scanner) {
		System.out.println("Saisir la cuisson souhaitée:\n1-BLEU\n2-A POINT\n3-BIEN CUIT");
		int cuisson = scanner.nextInt();
		return cuisson;
	}
	
	public static int saisirPoids(Scanner scanner) {
		System.out.println("Saisir le poids du morceau de viande à cuire.");
		int poids = scanner.nextInt();
		return poids;		
	}
	
	public static int cuissonBoeuf(int cuisson, int poids) {
		double coef;
		switch(cuisson)
		{
		case BLEU:
			coef = BLEU_B;
			break;
		case A_POINT:
			coef = A_PT_B;
			break;
		case B_CUIT:
			coef = B_CU_B;
			break;
		default:
			coef = 0;
			System.out.println("Une erreur s'est produite pendant le traitement.");
		}
		return (int) (poids * coef * MINUTE);
	}
	
	public static int cuissonAgneau(int cuisson, int poids) {
		double coef;
		switch(cuisson)
		{
		case BLEU:
			coef = BLEU_A;
			break;
		case A_POINT:
			coef = A_PT_A;
			break;
		case B_CUIT:
			coef = B_CU_A;
			break;
		default:
			coef = 0;
			System.out.println("Une erreur s'est produite pendant le traitement.");
		}
		return (int) (poids * coef * MINUTE);		
	}
	
	public static int traiter(int type, int cuisson, int poids) {
		if (type == BOEUF) {
			return cuissonBoeuf(cuisson, poids);
		} else if (type == AGNEAU) {
			return cuissonAgneau(cuisson, poids);
		} else {
			System.out.println("Une erreur s'est produite avant le traitement.");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		int type, cuisson, poids, temps;
		boolean selectionValide = false;
		Scanner scanner = new Scanner(System.in);
		//Saisies
		do {
			do {
				type = saisirViande(scanner);
			} while (type != BOEUF && type != AGNEAU);
			do {
				cuisson = saisirCuisson(scanner);
			} while (cuisson != BLEU && cuisson != A_POINT && cuisson != B_CUIT);
			do {
				poids = saisirPoids(scanner);
			} while (poids <= 0);
			selectionValide = true;
		} while (!selectionValide);
		//Traitement
		temps = traiter(type, cuisson, poids);
		//Affichage du résultat
		System.out.println("Le temps de cuisson est de: " + temps + " secondes.");
	}

}
