package fr.eni.module4;

import java.util.Scanner;

public class Tp1Cuisson {

	public static void main(String[] args) {
		final int BOEUF = 1;
		final int BLEU = 1;
		final int A_POINT = 2;
		final int MINUTE = 60;
		final double BLEU_B = 10.0/500;
		final double BLEU_A = 15.0/400;
		final double A_PT_B = 17.0/500;
		final double A_PT_A = 25.0/400; 
		final double B_CU_B = 25.0/500;
		final double B_CU_A = 40.0/400;
		int type, cuisson, poids, temps;		
		double coef;
		Scanner scanner = new Scanner(System.in);
		
		// Récupérer les choix de l'utilisateur :
		System.out.println("Saisir type :\n1-BOEUF\n2-AGNEAU");
		type = scanner.nextInt();
		System.out.println("Saisir cuisson :\n1-BLEU\n2-A POINT\n3-BIEN CUIT");
		cuisson = scanner.nextInt();
		System.out.println("Saisir poids.");
		poids = scanner.nextInt();

		if (type == BOEUF) {
			switch(cuisson)
			{
			case BLEU:
				coef = BLEU_B;
				break;
			case A_POINT:
				coef = A_PT_B;
				break;
			default:
				coef = B_CU_B;
			}
		} else {
			switch(cuisson)
			{
			case BLEU:
				coef = BLEU_A;
				break;
			case A_POINT:
				coef = A_PT_A;
				break;
			default:
				coef = B_CU_A;		
			}
		}          

		// Afficher le résultat :
		temps = (int) (coef * poids * MINUTE);
		System.out.println("Le temps de cuisson est de: " + temps + " secondes.");
	}

}
