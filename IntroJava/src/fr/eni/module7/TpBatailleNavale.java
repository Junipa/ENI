package fr.eni.module7;

import java.util.Random;
import java.util.Scanner;

public class TpBatailleNavale {
	
	public static char BATEAU = ')';
	public static char EAU = 'e';
	public static char PLOUF = '~';
	public static int TAILLE = 5;

	public static void initPlateau(char[][] plateau) {
		Random randy = new Random();
	    for (int i = 0; i < TAILLE; i++) {
	        for (int j = 0; j < TAILLE; j++) {
	            plateau[i][j] = EAU;
	        }
	    }
	    plateau[randy.nextInt(TAILLE)][randy.nextInt(TAILLE)] = BATEAU;
	}

	public static void  afficherPlateau(char[][] plateau) {
	    for (int i = 0; i <TAILLE; i++) {
	        for (int j = 0; j <TAILLE; j++) {
	            if (plateau[i][j] == BATEAU || plateau[i][j] == EAU) {
	                System.out.print("?");
	            } else {
	            	System.out.print(plateau[i][j]);
	            }	            
	        }
	        System.out.println("");
	    }
	    System.out.println("");
	}

	public static boolean tirer(char[][] plateau) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Colonne ?");
		int saisieCol = scanner.nextInt() - 1;
		System.out.println("Ligne ?");
		int saisieLn = scanner.nextInt() - 1;
	    if (plateau[saisieLn][saisieCol] == BATEAU) {	    	
	        return true;
	    } else {
	    	System.out.println("Plouf ! A l'eau !");
	        plateau[saisieLn][saisieCol] = PLOUF;
	        return false;
	    }
	}

	public static void main(String[] args) {
		char[][] plateau = new char[TAILLE][TAILLE];
		boolean victoire; 
		initPlateau(plateau);
		do {
		    afficherPlateau(plateau);
		    victoire = tirer(plateau);
		} while (!victoire);
		System.out.println("Boom ! Touché coulé !");
		System.out.println("Bravo, vous avez gagné !");
	}

}
