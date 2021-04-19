package fr.eni.module4;

import java.util.Scanner;

public class Tp3Cheques {

	public static void main(String[] args) {
		int nbChèques = 0;
		int nbChèquesI = 0;
		int nbChèquesS = 0;
		long noChèque;
		long noChèqueMin = 0;
		long noChèqueMax = 0;		
		double total = 0.0;
		double totalI = 0.0;
		double totalS = 0.0;
		double montant, moyenne, montantMin, montantMax;
		montantMin = 0.0;
		montantMax = 0.0;
		Scanner ScanNum = new Scanner(System.in);
		Scanner ScanMontant = new Scanner(System.in);
		
		do {
			System.out.println("Saisir le numéro du chèque ou 0 pour quitter.");
			noChèque = ScanNum.nextLong();
			if (noChèque != 0) {
				System.out.println("Saisir le montant du chèque.");
				montant = ScanMontant.nextDouble();
				if (nbChèques == 0) {
					noChèqueMin = noChèque;
					montantMin = montant;
				}
				nbChèques++;
				total += montant;
				if (montant < 200) {
					nbChèquesI++;
					totalI += montant;
				} else {
					nbChèquesS++;
					totalS += montant;
				}
				if (montant < montantMin) {
					noChèqueMin = noChèque;
					montantMin = montant;
				} else if (montant > montantMax) {
					noChèqueMax = noChèque;
					montantMax = montant;
				}
			}
		} while (noChèque != 0);
		
		//Calcul moyenne
		moyenne = (total / nbChèques);

		//Affichage
		System.out.println("Vous avez saisi " + nbChèques + " chèque(s).");
		if (nbChèques > 0) {
			System.out.println("Montant total: " + total + "€.");
			System.out.println("Moyenne des montants: " + moyenne + "€.");
			System.out.println("Nombre de chèques dont le montant est inférieur à 200€: " + nbChèquesI);
			System.out.println("Montant total des chèques inférieurs à 200€: " + totalI);
			System.out.println("Nombre de chèques dont le montant est supérieur ou égal à 200€: " + nbChèquesS);
			System.out.println("Montant total des chèques supérieurs ou égaux à 200€: " + totalS);
			System.out.println("Numéro du chèque dont le montant est le plus petit: " + noChèqueMin);
			System.out.println("Montant du chèque dont le montant est le plus petit: " + montantMin);
			System.out.println("Numéro du chèque dont le montant est le plus grand: " + noChèqueMax);
			System.out.println("Montant du chèque dont le montant est le plus grand: " + montantMax);
		}
	}

}
