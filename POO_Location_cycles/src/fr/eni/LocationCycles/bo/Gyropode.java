/**
 * 
 */
package fr.eni.LocationCycles.bo;

import java.time.LocalDate;

/**
 * @author Junipa
 *
 */
public class Gyropode extends CycleGyroscopique {
	private double tailleMin;
	private static final double TARIF_GYROPODE = 29.9;

	public Gyropode(String marque, String modele, LocalDate dateAchat, int autonomie, double tailleMin) {
		super(marque, modele, dateAchat, autonomie);
		this.tailleMin = tailleMin;
	}

	@Override
	public String toString() {
		String gyropode = "";
		gyropode += "- Gyropode " + this.marque + " " + this.modele + " (" + this.age() + "an) ";
		gyropode += this.autonomie + " km d'autonomie [1m" + (int) ((this.tailleMin - 1) * 100) + "]\t\t" + 
				this.getTarif() + "€/heure";
		return gyropode;
	}

	@Override
	protected String getTarif() {
		String tarif = "";
		tarif += (int) (Gyropode.TARIF_GYROPODE); 
		tarif += "," + (int) ((Gyropode.TARIF_GYROPODE) * 100 - ((int) Gyropode.TARIF_GYROPODE) * 100);
		return tarif;
	}

}
