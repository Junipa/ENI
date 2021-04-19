package fr.eni.module4;

import java.util.Scanner;

public class Tp0CalculPanier {
	/*Calcul du panier contenant une seule ligne
	L'utilisateur saisit la quantité et le prix unitaire d'un article.
	Le programme calcul le montant ht du panier.
	Le programme applique une tva fixe de 20%.
	Le programme affiche un récapitulatif du panier :
	quantité - pu - montant ht
					tva
					montant ttc*/
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Veuillez saisir le prix de l'article.");
		float prix = scanner.nextFloat();
		System.out.println("Veuillez saisir la quantité achetée pour cet article.");
		float quantité = scanner.nextFloat();		
		
		//Calcul du montant ht du panier :
		float ht = prix * quantité;
		
		//Calcul de la TVA :
		float tva = ht * 20/100;
		
		//Calcul du montant TTC :
		float ttc = ht + tva;
		
		//Affichage récapitulatif :
		System.out.println("Quantité: " + quantité + " - Prix: " + prix + " - Montant HT: " + ht);
		System.out.println("TVA: " + tva + "\nMontant TTC: " + ttc);

	}

}
