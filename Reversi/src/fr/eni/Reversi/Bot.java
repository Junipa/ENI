package fr.eni.Reversi;

public class Bot implements Player {
	private String name = "Bob the bot";
	
	public Bot() {}
	
	public Bot(String name) {
		this.name = name;
	}

	@Override
	public boolean play(ReversiBoard board, Pawn pawn) {
		this.displayTurn();
		board.displayBoard();
		if (board.isAnyMovePossibleFor(pawn)) {
			for (int i = 0; i < ReversiBoard.getBoardSize(); i++) {
				for (int j = 0; j < ReversiBoard.getBoardSize(); j++) {				
					if (board.testMove(pawn, i, j) > 0) {
						board.play(pawn, i, j);
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void displayTurn() {
		System.out.printf("%s's turn...", this.getName());
		System.out.println();
	}

	@Override
	public String getName() {
		return this.name;
	}
}
