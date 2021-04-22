package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;

public class Patient extends Personne {
	private static final String COMMENTAIRE_DEFAULT = "[aucun commentaire]";
	private char sexe;
	private long numeroSecu;
	private LocalDate dateNaissance;
	private String commentaire;	
	
	public Patient(String nom, String prenom, String telephone, char sexe, long numeroSecu, LocalDate dateNaissance) {
		super(nom, prenom, telephone);
		if (sexe == 'F' || sexe == 'M') {
			this.sexe = sexe;
		}		
		this.numeroSecu = numeroSecu;
		this.dateNaissance = dateNaissance;
	}
	
	public Patient(String nom, String prenom, String telephone, char sexe, long numeroSecu, LocalDate dateNaissance, String commentaire) {
		this(nom, prenom, telephone, sexe, numeroSecu, dateNaissance);
		this.commentaire = commentaire;
	}
	
	public Patient(String nom, String prenom, String telephone, char sexe, long numeroSecu, 
			LocalDate dateNaissance, String commentaire, Adresse adresse) {
		this(nom, prenom, telephone, sexe, numeroSecu, dateNaissance, commentaire);
		this.adresse = adresse;
	}
	
	public void afficher() {
		System.out.printf("%s %s%nTelephone : %s%nSexe : %s%nNuméro de Sécurité Sociale : %s%n"
				+ "Date de naissance : %s%nCommentaires : %s%n",
				this.nom.toUpperCase(),this.prenom, this.telephone, 
				this.sexe == 'F' ? "Féminin" : "Masculin", this.numeroSecu, this.dateNaissance,
				this.commentaire != null ? this.commentaire : Patient.COMMENTAIRE_DEFAULT);		
		if (this.adresse != null) {
			System.out.println("Adresse :");
			this.adresse.afficher();
		}
	}
	
	public char getSexe() {
		return sexe;
	}
	
	public long getNumeroSecu() {
		return numeroSecu;
	}
	
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
