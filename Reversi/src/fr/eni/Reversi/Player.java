package fr.eni.Reversi;

public interface Player {
	public boolean play(ReversiBoard board, Pawn pawn);
	public void displayTurn();
	public String getName();
}
