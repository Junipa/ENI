package fr.eni.ecole.quelMedecin.bo;

public class Adresse {
	private int numero;
	private String complementNumero;
	private String voie;
	private int codePostal;
	private String commune;
	private String mentionComplementaire;
	
	public Adresse(int numero, String complementNumero, String voie, 
			int codePostal, String commune) {
		this.numero = numero;
		this.complementNumero = complementNumero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.commune = commune;
	}
	
	public Adresse(String mentionComplementaire, int numero, String complementNumero, 
			String voie, int codePostal, String commune) {
		this(numero, complementNumero, voie, codePostal, commune);
		this.mentionComplementaire = mentionComplementaire;
	}
	
	public void afficher() {
		if (this.mentionComplementaire != null) {
			System.out.println(this.mentionComplementaire);
		}
		System.out.printf("%d %s %s%n%d %s%n",
				this.numero, this.complementNumero != null ? this.complementNumero : "",
				this.voie, this.codePostal, this.commune);
	}
}
