package fr.eni.module7;

import java.util.*;

public class TpSauteMouton {
	public static int TAILLE = 7;
	public static char[] WIN = {'<', '<', '<', '_', '>', '>', '>'};
	public static char MOUTON_GAUCHE = '<';
	public static char MOUTON_DROIT = '>';
	public static char VIDE = '_';
	
	public static char[] init_jeu() {
	    char[] jeu = new char[TAILLE];
	    int milieu = Math.round(TAILLE / 2);
	    for (int i = 0; i<TAILLE; i++) {
	        if (i < milieu) {
	            jeu[i] = MOUTON_DROIT;
	        } else if (i == milieu) {
	            jeu[i] = VIDE;
	        } else {
	            jeu[i] = MOUTON_GAUCHE;
	        }	   
	    }
	    return jeu;
	}
	
	public static void afficher(char[] jeu) {
	    String grille = "";
	    String grilleJeu = "";
	    for (int i = 0; i<TAILLE; i++) {
	        grille += String.valueOf(i+1);     
	    }
	    System.out.println(grille);
	    for (int i = 0; i<TAILLE; i++) {
	        grilleJeu += jeu[i];    
	    }
	    System.out.println(grilleJeu);
	}
	
	public static boolean coup_possible(char[] jeu, int mouton) {
	    boolean mouvement = false;
	    boolean char_d = jeu[mouton] == MOUTON_DROIT;
	    boolean char_g = jeu[mouton] == MOUTON_GAUCHE;
	    if (char_d & mouton != TAILLE) {
	        if (mouton + 1 < TAILLE) {
	            if (jeu[mouton + 1] == VIDE) {
	                mouvement = true;
	            }
	        }	    
	        if (mouton + 2 < TAILLE) {
	            if ((jeu[mouton + 1] == MOUTON_GAUCHE) & (jeu[mouton + 2] == VIDE)) {
	                mouvement = true;
	            }
	        }
	    }
	    if (char_g & (mouton != 0)) {
	        if ((mouton - 1 >= 0)) {
	            if ((jeu[mouton - 1] == VIDE)) {
	                mouvement = true;
	            }
	        }
	        if ((mouton - 2 >= 0)) {
	            if ((jeu[mouton - 1] == MOUTON_DROIT) & (jeu[mouton - 2] == VIDE)) {
	                mouvement = true;
	            }
	        }
	    }
	    return mouvement;
	}
	
	public static boolean deplacer(char[] jeu, int mouton) {
	    if (coup_possible(jeu, mouton)) {
	        for (int i = 0; i<TAILLE ; i++) {
	            if (jeu[i] == '_') {
	                jeu[i] = jeu[mouton];
	            }
	        }
	        jeu[mouton] = '_';
	        return true;
	    }
	    System.out.println("Ce déplacement est impossible, merci de choisir un autre mouton.");
	    return false;
	}
	
	public static boolean coup_joueur(char[] jeu) {
	    boolean possible = false;
	    boolean victoire = true;
	    boolean defaite = true;
	    int mouton;
	    Scanner scanner = new Scanner(System.in);
	    while (!possible) {
	        System.out.println("Quel mouton voulez-vous déplacer ?");
	        mouton = scanner.nextInt()-1;
	        possible = deplacer(jeu, mouton);
	    }
	    scanner.close();
	    for (int i = 0; i<TAILLE ; i++) {
	        if (jeu[i] != WIN[i]) {
	            victoire = false;   
	        }
	    }
	    if (victoire) {
	        System.out.println("Félicitations, vous avez gagné !");
	        return victoire;
	    }
	    for (int i = 0; i<TAILLE ; i++) {
	        if (coup_possible(jeu, i)) {
	            defaite = false;
	        }
	    }
	    if (defaite) {
	        System.out.println("Oh non, il semblerait que vous ayiez perdu...");
	        return defaite;
	    }
	    return victoire;
	}

	public static void main(String[] args) {
		char[] jeu = init_jeu();
		boolean fin = false;
		while (!fin) {
			afficher(jeu);
			fin = coup_joueur(jeu);
		}
	}

}
