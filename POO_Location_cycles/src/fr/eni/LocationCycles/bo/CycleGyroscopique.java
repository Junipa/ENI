/**
 * 
 */
package fr.eni.LocationCycles.bo;

import java.time.LocalDate;

/**
 * @author Junipa
 *
 */
public abstract class CycleGyroscopique extends Cycle {
	protected int autonomie;

	public CycleGyroscopique(String marque, String modele, LocalDate dateAchat, int autonomie) {
		super(marque, modele, dateAchat);
		this.autonomie = autonomie;
	}

}
