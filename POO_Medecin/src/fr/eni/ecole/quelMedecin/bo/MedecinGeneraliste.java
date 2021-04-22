package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste extends Personne {
	private static int TARIF = 25;
	private static int NB_CRENEAUX_MAX = 15;
	protected Creneau[] creneaux = new Creneau[NB_CRENEAUX_MAX];	
	
	public MedecinGeneraliste(String nomMedecin, String prenomMedecin, String telephoneMedecin) {
		super(nomMedecin, prenomMedecin, telephoneMedecin);
	}
	
	public MedecinGeneraliste(String nomMedecin, String prenomMedecin, String telephoneMedecin, Adresse adresse) {
		super(nomMedecin, prenomMedecin, telephoneMedecin, adresse);
	}
	
	@Override
	public void afficher() {
		System.out.printf("%s %s%nTelephone : %s%nTarif : %s%n",
				this.nom.toUpperCase(),this.prenom, this.telephone, MedecinGeneraliste.getTarif());	
		if (this.adresse != null) {
			System.out.println("Adresse :");
			this.adresse.afficher();
		}
		System.out.println("Créneaux :");
		for (int i = 0; i < this.creneaux.length; i++) {
			if (this.creneaux[i] != null) this.creneaux[i].afficher();			
		}
	}
	
	public void ajouterCreneau(Creneau creneau) {
		if (this == creneau.getMedecin()) {
			for (int i = 0; i < this.creneaux.length; i++) {
				if (this.creneaux[i] == null) {
					this.creneaux[i] = creneau;
					break;
				}
			}
		}
	}
	
	public static int getTarif() {
		return MedecinGeneraliste.TARIF;
	}
	
	public static void setTarif(int tarif) {
		MedecinGeneraliste.TARIF = tarif;
	}
}
