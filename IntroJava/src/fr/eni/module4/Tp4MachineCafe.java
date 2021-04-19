package fr.eni.module4;

import java.util.Scanner;

public class Tp4MachineCafe {

	public static void main(String[] args) {
		final double PRIX_CAFE = 0.60;
		double pièce, credit;
		credit = 0.0;
		int valeur, monnaie;
		int renduPièces2e = 0;
		int renduPièces1e = 0;
		int renduPièces50c = 0;
		int renduPièces20c = 0;
		int renduPièces10c = 0;
		int renduPièces5c = 0;
		int nbPièces2e = 10; 
		int nbPièces1e = 10;
		int nbPièces50c = 10;
		int nbPièces20c = 10;
		int nbPièces10c = 10;
		int nbPièces5c = 10;
		Scanner scanner = new Scanner(System.in);

		while (credit < PRIX_CAFE) {
		    System.out.println("Entrez la valeur de la pièce");
		    pièce = scanner.nextDouble();
		    valeur = (int) (pièce * 100);
		    switch(valeur) {
		        case 200:
		            credit += (double) (valeur/100.0);
		            nbPièces2e++;
		            break;
		        case 100:
		            credit += (double) (valeur/100.0);
		            nbPièces1e++;
		            break;
		        case 50:
		            credit += (double) (valeur/100.0);
		            nbPièces50c++;
		            break;
		        case 20:
		            credit += (double) (valeur/100.0);
		            nbPièces20c++;
		            break;
		        case 10:
		            credit += (double) (valeur/100.0);
		            nbPièces10c++;
		            break;
		        case 5:
		            credit += (double) (valeur/100.0);
		            nbPièces5c++;
		            break;
		        default:
		            System.out.println("Pièce non acceptée, entrez une autre pièce");
		    }
		    if (credit < PRIX_CAFE) {
		        System.out.println("Credit insuffisant (" + credit + "€/" + PRIX_CAFE + "€)");
		    }
		}

		if (credit == PRIX_CAFE) {
			System.out.println("Voici votre café.");
		} else if (credit > PRIX_CAFE) {
		    monnaie = (int) ((credit - PRIX_CAFE) * 100);
		    System.out.println("Voici votre café et votre monnaie(" + (credit - PRIX_CAFE) + "€).");
		    while (monnaie > 0) {
		        if (monnaie >= 200) {
		                if (nbPièces2e > 1) {
		                	monnaie -= 200;
		                    renduPièces2e++;
		                    nbPièces2e--;
		                }
		        } else if (monnaie >= 100) {
		                if (nbPièces1e > 1) {
		                    monnaie -= 100;
		                    renduPièces1e++;
		                    nbPièces1e--;
		                }
		        } else if (monnaie >= 50) {
		                if (nbPièces50c > 1) {
		                    monnaie -= 50;
		                    renduPièces50c++;
		                    nbPièces50c--;
		                }
		        } else if (monnaie >= 20) {
		                if (nbPièces20c > 1) {
		                    monnaie -= 20;
		                    renduPièces20c++;
		                    nbPièces20c--;
		                }
		        } else if (monnaie >= 10) {
		                if (nbPièces10c > 1) {
		                    monnaie -= 10;
		                    renduPièces10c++;
		                    nbPièces10c--;
		                }
		        } else {
		                if (nbPièces5c >= 1) {
		                    monnaie -= 5;
		                    renduPièces5c++;
		                    nbPièces5c--;
		                }
		        }
		    }
		}
		if (renduPièces2e > 0) {
		    System.out.println(renduPièces2e + " pièce(s) de 2€");
		}
		if (renduPièces1e > 0) {
		    System.out.println(renduPièces1e + " pièce(s) de 1€");
		}
		if (renduPièces50c > 0) {
		    System.out.println(renduPièces50c + " pièce(s) de 0,50€");
		}
		if (renduPièces20c > 0) {
		    System.out.println(renduPièces20c + " pièce(s) de 0,20€");
		}
		if (renduPièces10c > 0) {
		    System.out.println(renduPièces10c + " pièce(s) de 0,10€");
		}
		if (renduPièces5c > 0) {
		    System.out.println(renduPièces5c + " pièce(s) de 0,05€");
		}

	}

}
