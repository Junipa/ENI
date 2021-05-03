package fr.eni.Reversi;

import java.util.Scanner;

public class HumanPlayer implements Player{
	private Scanner scan = new Scanner (System.in);
	private String name;
	private static int nbPlayers = 0;
	
	public HumanPlayer() {
		this.name = "Player"+nbPlayers;
	}
	
	public HumanPlayer(String name) {
		nbPlayers++;
		this.name = name;
	}

	@Override
	public boolean play(ReversiBoard board, Pawn pawn) {
		int line;
		int column;
		boolean hasPlayed = true;
		this.displayTurn();
		board.displayBoard();
		if (board.isAnyMovePossibleFor(pawn)) {
			do {				
				System.out.println("Line ?");
				line = scan.nextInt() - 1;
				System.out.println("Column ?");
				column = scan.nextInt() - 1;
				if (!board.play(pawn, line, column)) {
					System.out.println("Invalid move ; try again...");
					board.displayBoard();
					hasPlayed = false;
				}
			} while (!hasPlayed);
			return true;
		}
		return false;
	}
	
	public void displayTurn() {
		System.out.printf("%s's turn...", this.getName());
		System.out.println();
	}
	
	void closeScanner() {
		scan.close();
	}

	@Override
	public String getName() {
		return this.name;
	}

}
