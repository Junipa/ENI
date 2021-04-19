package fr.eni.module4;

import java.util.Scanner;

public class Tp2BulletinPaie {

	public static void main(String[] args) {
		// Afficher le bulletin de paie simplifié d’un salarié à partir des informations saisies.
		final double TAUX_NORMAL = 1.0;
		final double TAUX_COMP = 1.5;
		final double TAUX_SUPP = 1.6;
		final int STATUT_AS = 1;
		final int STATUT_EMP = 2;
		final int STATUT_CADRE = 3;
		final double CSG_I = 3.49 / 100;
		final double CSG_NI = 6.15 / 100;
		final double AM = 0.95 / 100;
		final double AV = 8.44 / 100;
		final double AC = 3.05 / 100;
		final double IRCEM = 3.81 / 100;
		final double AGFF = 1.02 / 100;
		final int PRIME_UN_ENFANT = 20;
		final int PRIME_DEUX_ENFANTS = 50;
		final int PRIME_BASE_NB = 70;
		String nom, prenom;
		int statut, nbEnfants;
		double heures, heuresNorm, heuresComp, heuresSupp, tauxHoraire, salaireBrut, salaireNet, primeFamiliale, salaire;
		double cotis_csgi, cotis_csgni, cotis_am, cotis_av, cotis_ac, cotis_ircem, cotis_agff, totalCotisations;
		Scanner scannerInt = new Scanner(System.in);
		Scanner scannerDbl = new Scanner(System.in);
		Scanner scannerStr = new Scanner(System.in);
		salaireBrut = 0;
		heuresNorm = 0;
		heuresComp = 0;
		heuresSupp = 0;

		// Saisies
		System.out.println("Nom ?");
		nom = scannerStr.nextLine();
		System.out.println("Prénom ?");
		prenom = scannerStr.nextLine();
		System.out.println("Statut ? 1-Agent de service 2-Employé de bureau 3-Cadre");
		statut = scannerInt.nextInt();
		System.out.println("Nombre d'heures travaillées ?");
		heures = scannerDbl.nextDouble();
		System.out.println("Taux horaire ?");
		tauxHoraire = scannerDbl.nextDouble();
		System.out.println("Nombre d'enfants");
		nbEnfants = scannerInt.nextInt();

		// Calcul salaireBrut
		if (heures < 170) {
		    salaireBrut = heures * TAUX_NORMAL * tauxHoraire;
		    heuresNorm = heures;
		} else if (heures > 169) {
			heuresNorm = 169;
		    if (heures <= 180) {
		        heuresComp = heures - 169;
		        salaireBrut = (heuresNorm * TAUX_NORMAL * tauxHoraire) + (heuresComp * TAUX_COMP * tauxHoraire);
		    }
		    if (heures > 180) {
		        heuresComp = 11;
		        heuresSupp = heures - 180;
		        salaireBrut = (heuresNorm * TAUX_NORMAL * tauxHoraire) + (heuresComp * TAUX_COMP * tauxHoraire) + (heuresSupp * TAUX_SUPP  * tauxHoraire);
		    }
		}
		
		// Calcul cotisations
		cotis_csgi = salaireBrut * CSG_I;
		cotis_csgni = salaireBrut * CSG_NI;
		cotis_am = salaireBrut * AM;
		cotis_av = salaireBrut * AV;
		cotis_ac = salaireBrut * AC;
		cotis_ircem = salaireBrut * IRCEM;
		cotis_agff = salaireBrut * AGFF;
		totalCotisations = cotis_csgi + cotis_csgni + cotis_am + cotis_av + cotis_ac + cotis_ircem + cotis_agff;

		salaireNet = salaireBrut - totalCotisations;
		if (nbEnfants == 1) {
		    primeFamiliale = PRIME_UN_ENFANT;
		} else if (nbEnfants == 2) {
		    primeFamiliale = PRIME_DEUX_ENFANTS;
		}else if (nbEnfants > 2) {
		    primeFamiliale = PRIME_BASE_NB + 20 * (nbEnfants - 2);
		} else {
			primeFamiliale = 0;
		}
		salaire = salaireNet + primeFamiliale;

		// Affichage
		System.out.println("Bulletin de Gérard Duchemin\nStatut : " + statut);
		System.out.println("Salaire brut :" + salaireBrut + " € (" + heuresNorm + "h sans majoration, " + heuresComp + "h avec une majoration de 50%, " + heuresSupp + "h avec une majoration de 60%)");
		System.out.println("Calcul des cotisations :");
		System.out.println("- Contribution pour le remboursement de la dette sociale et contribution sociale généralisée imposable" + salaireBrut + " € × " + CSG_I + "% = " + cotis_csgi + "€");
		System.out.println("- Contribution sociale généralisée non imposable" + salaireBrut + " € × " + CSG_NI + "% = " + cotis_csgni + "€");
		System.out.println("- Assurance maladie" + salaireBrut + " € × " + AM + "% = " + cotis_am + "€");
		System.out.println("- Assurance vieillesse" + salaireBrut + " € × " + AV + "% = " + cotis_av + "€");
		System.out.println("- Assurance chômage" + salaireBrut + " € × " + AC + "% = " + cotis_ac + "€");
		System.out.println("- Retraite complémentaire (IRCEM)" + salaireBrut + " € × " + IRCEM + "% = " + cotis_ircem + "€");
		System.out.println("- Cotisation AGFF" + salaireBrut + " € × " + AGFF + "% = " + cotis_agff + "€");
		System.out.println("Total des cotisations salariales : " + totalCotisations + "€");
		System.out.println("Salaire net : " + salaireNet + "€");
		System.out.println("- Prime familiale : " + primeFamiliale + "€");
		System.out.println("Salaire net à payer : " + salaire + "€");

	}

}
