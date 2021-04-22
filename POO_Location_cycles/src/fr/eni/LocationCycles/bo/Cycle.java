/**
 * 
 */
package fr.eni.LocationCycles.bo;

import java.time.LocalDate;

/**
 * @author Junipa
 *
 */
public abstract class Cycle {
	protected String marque;
	protected String modele;
	protected LocalDate dateAchat;
	
	public Cycle() {
		// TODO Empty as in EMPTY ??
	}
	
	public Cycle(String marque, String modele, LocalDate dateAchat) {
		this.marque = marque;
		this.modele = modele;
		this.dateAchat = dateAchat;
	}
	
	public abstract String toString();
	
	abstract protected String getTarif();
	
	protected int age() {
		int age;
		age = LocalDate.now().getYear() - this.dateAchat.getYear();
		return age;
	}
}
