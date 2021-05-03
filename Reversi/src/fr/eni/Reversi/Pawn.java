package fr.eni.Reversi;

public enum Pawn {
	FREE('·'), 
	DARK('●'), 
	LIGHT('o');
	private final char symbole;
	private int totalPawns;
	
	private Pawn(char symbole) {
		this.symbole = symbole;
	}
	
	public static Pawn reverse(Pawn pawn) {
		if (pawn.getSymbole() == '●') {
			return LIGHT;
		} else if (pawn.getSymbole() == 'o') {
			return DARK;
		}
		return FREE;
	}
	
	public void earn(int pawns) {
		this.totalPawns += pawns;
	}
	
	public char getSymbole() {
		return this.symbole;
	}
	
	public int getTotalPawns() {
		return this.totalPawns;
	}
}
