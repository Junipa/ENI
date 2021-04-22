/**
 * 
 */
package fr.eni.LocationCycles.bo;

import java.time.LocalDate;

/**
 * @author Junipa
 *
 */
public class Gyroroue extends CycleGyroscopique {
	private static final double TARIF_GYROROUE = 18.9;
	/**
	 * 
	 */
	public Gyroroue(String marque, String modele, LocalDate dateAchat, int autonomie) {
		super(marque, modele, dateAchat, autonomie);
	}

	@Override
	public String toString() {
		String gyroroue = "";
		gyroroue += "- Gyroroue " + this.marque + " " + this.modele + " (" + this.age() + "an) ";
		gyroroue += this.autonomie + " km d'autonomie\t\t" + this.getTarif() + "€/heure";
		return gyroroue;
	}

	@Override
	protected String getTarif() {
		String tarif = "";
		tarif += (int) (Gyroroue.TARIF_GYROROUE); 
		tarif += "," + (int) ((Gyroroue.TARIF_GYROROUE) * 100 - ((int) Gyroroue.TARIF_GYROROUE) * 100);
		return tarif;
	}

}
