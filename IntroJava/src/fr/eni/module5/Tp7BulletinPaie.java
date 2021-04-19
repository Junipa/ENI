package fr.eni.module5;

import java.util.Scanner;

public class Tp7BulletinPaie {
	static final double TAUX_NORMAL = 1.0;
	static final double TAUX_COMP = 1.5;
	static final double TAUX_SUPP = 1.6;
	static final int STATUT_AS = 1;
	static final int STATUT_EMP = 2;
	static final int STATUT_CADRE = 3;
	static final double CSG_I = 3.49 / 100;
	static final double CSG_NI = 6.15 / 100;
	static final double AM = 0.95 / 100;
	static final double AV = 8.44 / 100;
	static final double AC = 3.05 / 100;
	static final double IRCEM = 3.81 / 100;
	static final double AGFF = 1.02 / 100;
	static final int PRIME_UN_ENFANT = 20;
	static final int PRIME_DEUX_ENFANTS = 50;
	static final int PRIME_BASE_NB = 70;
	static final char OUI = 'o';
	static final char NON = 'n';
	
	public static boolean validerSaisie(Scanner scanner, String saisie) {
		char reponse;
		do {
			System.out.println("Vous avez saisi:\n" + saisie);
			System.out.println("Souhaitez-vous valider cette saisie ?\no-OUI\nn-NON");
			reponse = scanner.next().charAt(0); scanner.nextLine();
			if (reponse != OUI && reponse != NON) {
				System.out.println("Erreur de saisie.");
			}
		} while (reponse != OUI && reponse != NON);
		if (reponse == OUI) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String saisirNom(Scanner scanner) {
		String nom;
		do {
			System.out.println("Nom ?");
			nom = scanner.nextLine();
		} while (!validerSaisie(scanner, nom));
		return nom;
	}
	
	public static String saisirPrenom(Scanner scanner) {
		String prenom;
		do {
			System.out.println("Prenom ?");
			prenom = scanner.nextLine();
		} while (!validerSaisie(scanner, prenom));
		return prenom;
	}
	
	public static String saisirStatut(Scanner scanner) {
		String statut;
		boolean saisieCorrecte = false;
		do {
			do {
				System.out.println("Statut ?\n1-Agent de service\n2-Employé de bureau\n3-Cadre");
				statut = scanner.nextLine();
				if (Integer.parseInt(statut) == STATUT_AS 
						|| Integer.parseInt(statut) == STATUT_EMP 
						|| Integer.parseInt(statut) == STATUT_CADRE) {
					saisieCorrecte = true;
				} else {
					System.out.println("Erreur de saisie, merci de recommencer.");
				}
			} while (!saisieCorrecte);
		} while (!validerSaisie(scanner, statut));
		return statut;
	}
	
	public static String saisirHeures(Scanner scanner) {
		String heures = "-1";
		do {
			do {
				System.out.println("Nombre d'heures travaillées ?");
				heures = scanner.nextLine();
				if (Integer.parseInt(heures) < 0 ) {
					System.out.println("Erreur : Le nombre d'heures saisi est négatif. Merci de recommencer.");
				}
			} while (Integer.parseInt(heures) < 0);
		} while (!validerSaisie(scanner, heures));
		return heures;
	}
	
	public static String saisirTaux(Scanner scanner) {
		String taux;
		do {
			System.out.println("Taux horaire ?");
			taux = scanner.nextLine();
		} while (!validerSaisie(scanner, taux));
		return taux;
	}
	
	public static String saisirNbEnfants(Scanner scanner) {
		String nbEnfants = "-1";
		do {
			do {
				System.out.println("Nombre d'enfants ?");
				nbEnfants = scanner.nextLine();
				if (Integer.parseInt(nbEnfants) < 0 ) {
					System.out.println("Erreur : Le nombre d'heures saisi est négatif. Merci de recommencer.");
				}
			} while (Integer.parseInt(nbEnfants) < 0 );
		} while (!validerSaisie(scanner, nbEnfants));
		return nbEnfants;
	}
	
	public static void saisirBulletin(Scanner scanner, String nom, String prenom, int statut, int heures, double tauxHoraire, int nbEnfants) {
		nom = saisirNom(scanner);
		prenom = saisirPrenom(scanner);
		statut = Integer.parseInt(saisirStatut(scanner));
		heures = Integer.parseInt(saisirHeures(scanner));
		if (heures > 0) {
			tauxHoraire = Double.parseDouble(saisirTaux(scanner));
		}
		nbEnfants = Integer.parseInt(saisirNbEnfants(scanner));
		System.out.println("saisirBulletin heure: " + heures);
	}
	
	public static int calculerHeuresNorm(int heures) {
		if (heures < 170) {
			return heures;
		} else {
			return 169;
		}
	}
	
	public static int calculerHeuresComp(int heures) {
		if (heures < 170) {
			return 0;
		} else if (heures < 180) {
			return heures - 169;
		} else {
			return 11;
		}
	}
	
	public static int calculerHeuresSupp(int heures) {
		if (heures < 180) {
			return 0;
		} else {
			return heures - 180;
		}
	}
		
	public static double calculerSalaireBrut(int heures, double tauxHoraire,
			int heuresNorm, int heuresComp, int heuresSupp) {
		double salaireBrut;
		salaireBrut = (heuresNorm * TAUX_NORMAL * tauxHoraire) + (heuresComp * TAUX_COMP * tauxHoraire) + (heuresSupp * TAUX_SUPP  * tauxHoraire);
		return salaireBrut;
	}
	
	
	public static double calculerCotisations(double salaireBrut, double cotis_csgi, double cotis_csgni, double cotis_am, double cotis_av, double cotis_ac, double cotis_ircem, double cotis_agff,
			double totalCotisations) {
		totalCotisations = cotis_csgi + cotis_csgni + cotis_am + cotis_av + cotis_ac + cotis_ircem + cotis_agff;
		return totalCotisations;
	}
	
	public static double calculerPrimeF(int nbEnfants) {
		double primeFamiliale = 0;
		if (nbEnfants == 1) {
		    primeFamiliale = PRIME_UN_ENFANT;
		} else if (nbEnfants == 2) {
		    primeFamiliale = PRIME_DEUX_ENFANTS;
		}else if (nbEnfants > 2) {
		    primeFamiliale = PRIME_BASE_NB + 20 * (nbEnfants - 2);
		}
		return primeFamiliale;
	}
	
	public static void afficherBulletin(String nom, String prenom, int statut, int heures, double tauxHoraire, int nbEnfants, 
			int heuresNorm, int heuresComp, int heuresSupp, double salaireBrut, double salaireNet, double primeFamiliale,
			double cotis_csgi, double cotis_csgni, double cotis_am, double cotis_av, double cotis_ac, double cotis_ircem, double cotis_agff,
			double totalCotisations, double salaire) {
		System.out.println("Bulletin de "+ prenom + " " + nom +"\nStatut : " + statut);
		System.out.println("Salaire brut : " + salaireBrut + " € (" + heuresNorm + "h sans majoration, " + heuresComp + "h avec une majoration de 50%, " + heuresSupp + "h avec une majoration de 60%)");
		System.out.println("Calcul des cotisations :");
		System.out.println("- Contribution pour le remboursement de la dette sociale et contribution sociale généralisée imposable " + salaireBrut + " € × " + (CSG_I * 100) + "% = " + cotis_csgi + "€");
		System.out.println("- Contribution sociale généralisée non imposable " + salaireBrut + " € × " + (CSG_NI * 100) + "% = " + (Math.round(cotis_csgni*100)/100.0) + "€");
		System.out.println("- Assurance maladie " + salaireBrut + " € × " + (AM * 100) + "% = " + (Math.round(cotis_am*100)/100.0) + "€");
		System.out.println("- Assurance vieillesse " + salaireBrut + " € × " + (AV * 100) + "% = " + (Math.round(cotis_av*100)/100.0) + "€");
		System.out.println("- Assurance chômage " + salaireBrut + " € × " + (AC * 100) + "% = " + (Math.round(cotis_ac*100)/100.0) + "€");
		System.out.println("- Retraite complémentaire (IRCEM) " + salaireBrut + " € × " + (IRCEM * 100) + "% = " + (Math.round(cotis_ircem*100)/100.0) + "€");
		System.out.println("- Cotisation AGFF " + salaireBrut + " € × " + (AGFF * 100) + "% = " + (Math.round(cotis_agff*100)/100.0) + "€");
		System.out.println("Total des cotisations salariales : " + (Math.round(totalCotisations*100)/100.0) + "€");
		System.out.println("Salaire net : " + (Math.round(salaireNet*100)/100.0) + "€");
		System.out.println("- Prime familiale : " + primeFamiliale + "€");
		System.out.println("Salaire net à payer : " + (Math.round(salaire*100)/100.0) + "€");
	}
	
	public static boolean terminerSaisie(Scanner scanner) {
		char saisie;
		do {
			System.out.println("Avez-vous un autre bulletin à traiter ?\no-OUI\nn-NON");
			saisie = scanner.next().charAt(0); scanner.nextLine();
		} while (saisie != NON && saisie != OUI);
		if (saisie == NON) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void afficherRecap(double masseSalariale, int nbBulletins) {
		System.out.println("Vous avez saisi " + nbBulletins + " bulletins.");
		System.out.println("La masse salariale est de: " + masseSalariale);
	}

	public static void main(String[] args) {
		String nom = "";
		String prenom = "";
		int statut = 0;
		int heures = 0;
		int nbEnfants = 0;
		int nbBulletins = 0;
		int heuresNorm = 0; 
		int heuresComp = 0;
		int heuresSupp = 0;
		double tauxHoraire = 0;
		double salaireBrut = 0;
		double salaireNet = 0;
		double primeFamiliale = 0;
		double  salaire = 0;
		double  masseSalariale = 0;
		double cotis_csgi = 0;
		double  cotis_csgni = 0;
		double  cotis_am = 0;
		double  cotis_av = 0;
		double  cotis_ac = 0;
		double  cotis_ircem = 0;
		double  cotis_agff = 0;
		double  totalCotisations = 0;
		boolean dernierBulletin;
		Scanner scanner = new Scanner(System.in);

		do {
			//Saisir bulletin
			nom = saisirNom(scanner);
			prenom = saisirPrenom(scanner);
			statut = Integer.parseInt(saisirStatut(scanner));
			heures = Integer.parseInt(saisirHeures(scanner));
			if (heures > 0) {
				tauxHoraire = Double.parseDouble(saisirTaux(scanner));
			}
			nbEnfants = Integer.parseInt(saisirNbEnfants(scanner));
			//Traiter bulletin
			heuresNorm = calculerHeuresNorm(heures);
			heuresComp = calculerHeuresComp(heures);
			heuresSupp = calculerHeuresSupp(heures);
			salaireBrut = calculerSalaireBrut(heures, tauxHoraire, heuresNorm, heuresComp, heuresSupp);			
			primeFamiliale = calculerPrimeF(nbEnfants);
			cotis_csgi = salaireBrut * CSG_I;
			cotis_csgni = salaireBrut * CSG_NI;
			cotis_am = salaireBrut * AM;
			cotis_av = salaireBrut * AV;
			cotis_ac = salaireBrut * AC;
			cotis_ircem = salaireBrut * IRCEM;
			cotis_agff = salaireBrut * AGFF;
			totalCotisations = cotis_csgi + cotis_csgni + cotis_am + cotis_av + cotis_ac + cotis_ircem + cotis_agff;
			salaireNet = salaireBrut - totalCotisations;
			salaire = salaireNet + primeFamiliale;
			afficherBulletin(nom, prenom, statut, heures, tauxHoraire, nbEnfants, 
					heuresNorm, heuresComp, heuresSupp, salaireBrut, salaireNet, primeFamiliale,
					cotis_csgi, cotis_csgni, cotis_am, cotis_av, cotis_ac, cotis_ircem, cotis_agff,
					totalCotisations, salaire);
			dernierBulletin = terminerSaisie(scanner);
			nbBulletins++;
			masseSalariale += Math.round(salaire * 100)/100;
		} while (!dernierBulletin);
		afficherRecap(masseSalariale, nbBulletins);
	}


}
