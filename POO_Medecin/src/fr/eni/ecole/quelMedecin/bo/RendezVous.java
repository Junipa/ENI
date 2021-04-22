package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;

public class RendezVous {
	private Creneau creneau;
	private Patient patient;
	private LocalDate date;
	
	
	public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
		this.creneau = creneau;
		this.patient = patient;
		this.date = date;
	}
	
	public void afficher() {
		System.out.printf("Rendez-vous du %d %s %d ", 
				this.date.getDayOfMonth(), this.date.getMonth(), this.date.getYear());
		this.creneau.afficher();
		System.out.printf("avec le Dr %s%nPour ", this.creneau.getMedecin().getNom());
		this.patient.afficher();
	}
}
