package fr.eni.ecole.quelMedecin.bo;

public class MedecinSpecialiste extends MedecinGeneraliste {
	private String specialite;
	private int tarif;

	public MedecinSpecialiste(String nomMedecin, String prenomMedecin, String telephoneMedecin, 
			String specialite, int tarif) {
		super(nomMedecin, prenomMedecin, telephoneMedecin);
		this.specialite = specialite;
		this.tarif = tarif;
	}
	
	public MedecinSpecialiste(String nomMedecin, String prenomMedecin, String telephoneMedecin, 
			Adresse adresse, String specialite, int tarif) {
		this(nomMedecin, prenomMedecin, telephoneMedecin, specialite, tarif);
		this.adresse = adresse;
	}
	
	@Override
	public void afficher() {
		System.out.printf("%s %s%nTelephone : %s%nSpécialité : %s%nTarif : %d%n",
				this.nom, this.prenom, this.telephone, this.specialite, this.tarif);
		if (this.adresse != null) {
			System.out.println("Adresse :");
			this.adresse.afficher();
		}
		System.out.println("\nCréneaux :");
		for (int i = 0; i < this.creneaux.length; i++) {
			if (this.creneaux[i] != null) this.creneaux[i].afficher();			
		}
	}
	
	public int getTarifSpecialiste() {
		return this.tarif;
	}
	
	public String getSpecialite() {
		return specialite;
	}
}
