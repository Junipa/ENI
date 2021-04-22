package fr.eni.LocationCycles.bo;

import java.time.LocalDate;

public class Velo extends Cycle {
	private int nbVitesses;
	private static final double TARIF_VELO = 4.9;
	// TARIF ?? How to affect a value to a class variable declared in superclass ??
	
	public Velo(String marque, String modele, LocalDate dateAchat, int nbVitesses) {
		super(marque, modele, dateAchat);
		this.nbVitesses = nbVitesses;
	}

	@Override
	public String toString() {
		String velo = "";
		velo += "- Velo " + this.marque + " " + this.modele + " (" + this.age() + "an) ";
		velo += nbVitesses + " vitesses\t\t\t" + this.getTarif() + "€/heure";
		return velo;
	}

	@Override
	protected String getTarif() {
		String tarif = "";
		tarif += (int) (Velo.TARIF_VELO); 
		tarif += "," + (int) ((Velo.TARIF_VELO) * 100 - ((int) Velo.TARIF_VELO) * 100);
		return tarif;
	}

}
