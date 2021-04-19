package fr.eni.module7;

import java.util.Arrays;

public class Tp1MelangeurMots {
	
	public static String melangerMot(String mot) {
		String resultat = "";
		if (mot.length() > 3) {
			int i;
			int randy;
			int[] indices = new int[mot.length() - 2];
			char[] motMelange = new char[mot.length()];			
			boolean validRand;
	
			//Récupérer la première et la dernière lettre:
			motMelange[0] = mot.charAt(0);
			motMelange[mot.length()-1] = mot.charAt(mot.length()-1);
			
			//Mélanger l'ordre des caractères restants:
			for (i = 1; i < motMelange.length - 1; i++) {
				do {
					validRand = true;
					randy = (int) Math.abs(Math.round(Math.random() * (1 - motMelange.length) * 10) / 10);
					for (int index : indices) {
						if (randy == index) {
							validRand = false;
						}
					}
				} while (!validRand);
				motMelange[i] = mot.charAt(randy);
				for (int j = 0; j < indices.length; j++) {
					if (indices[j] == 0) {
						indices[j] = randy;
						break;
					}
				}
			}
			// Ajouter les caractères au résultat:
			for (i = 0 ; i < motMelange.length; i++) {
				resultat += motMelange[i];
			}
			return resultat;
		}
		return mot;
	}
	
	public static String melangerTexte(String texte) {
		String temp = "";
		String texteMelange ="";
		
		while (texte.length() > 0) {
			if (Character.isAlphabetic(texte.charAt(0))) {
				while (Character.isAlphabetic(texte.charAt(0))) {
					temp += texte.charAt(0);
					texte = texte.substring(1, texte.length());
				}
				temp = melangerMot(temp);
				texteMelange += temp;
				temp = "";
			} else {
				texteMelange += texte.charAt(0);
				texte = texte.substring(1, texte.length());
			}
		}
		
		return texteMelange;
	}

	public static void main(String[] args) {
		System.out.println(melangerTexte("La mégère se met le doigt dans l'oeil."));
	}

}