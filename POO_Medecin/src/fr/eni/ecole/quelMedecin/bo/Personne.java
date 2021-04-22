package fr.eni.ecole.quelMedecin.bo;

public class Personne {
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected Adresse adresse;
	
	public Personne(String nom, String prenom, String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;		
	}
	
	public Personne(String nom, String prenom, String telephone, Adresse adresse) {
		this(nom, prenom, telephone);
		this.adresse = adresse;
	}
	
	public void afficher() {
		System.out.printf("%s %s%nTelephone : %s%nAdresse : %s%n",
				this.nom.toUpperCase(),this.prenom, this.telephone, this.adresse);
	}

	public Adresse getAdresse() {
		return adresse;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
