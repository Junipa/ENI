package fr.eni.Reversi;

public class ReversiBoard {
	private static final int BOARD_SIZE = 8;
	private Pawn[][] board = new Pawn[BOARD_SIZE][BOARD_SIZE];
	
	public ReversiBoard() {
		this.initBoard();
	}
	
	private void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				this.board[i][j] = Pawn.FREE;
			}
		}
		this.board[3][3] = Pawn.LIGHT;
		this.board[4][4] = Pawn.LIGHT;
		this.board[3][4] = Pawn.DARK;
		this.board[4][3] = Pawn.DARK;
	}
	
	void displayBoard() {
		System.out.println(" 12345678");
		for (int i = 0; i < board.length; i++) {			
			System.out.print(i+1);
			for (int j = 0; j < board.length; j++) {
				System.out.print(this.board[i][j].getSymbole());
			}
			System.out.println();
		}
	}
	
	int testMove(Pawn pawn, int line, int column) {
		int pawnsReversed = 0;
		if (this.getPawn(line, column).equals(Pawn.FREE)) {
			if (this.testSurroundingPositions(pawn,line, column)) {
				pawnsReversed = this.getReversiblePawnsNumber(pawn, line, column);
			}
		}
		return pawnsReversed;
	}
	
	private boolean testSurroundingPositions(Pawn pawn, int line, int column) {
		for (int i = line - 1; i <= line + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++) {
				if (this.isReversedPawn(pawn, i, j)) return true;
			}
		}
		return false;
	}
	
	private boolean isReversedPawn(Pawn pawn, int line, int column) {
		if (Pawn.reverse(this.getPawn(line, column)).equals(pawn)) {
			return true;
		}
		return false;
	}
	
	private Pawn getPawn(int line, int column) {
		if (line < 0 || line >= this.board.length
				|| column < 0 || column >= this.board.length) {
			return Pawn.FREE;
		}
		return this.board[line][column];
	}
	
	private int getReversiblePawnsNumber(Pawn pawn, int line, int column) {
		int nb = 0;
		nb += this.getReversiblePawnsNumberForDirection(Direction.TOP_LEFT, pawn, line, column);
		nb += this.getReversiblePawnsNumberForDirection(Direction.TOP, pawn, line, column);
		nb += this.getReversiblePawnsNumberForDirection(Direction.TOP_RIGHT, pawn, line, column);
		nb += this.getReversiblePawnsNumberForDirection(Direction.RIGHT, pawn, line, column);
		nb += this.getReversiblePawnsNumberForDirection(Direction.BOTTOM_RIGHT, pawn, line, column);
		nb += this.getReversiblePawnsNumberForDirection(Direction.BOTTOM, pawn, line, column);
		nb += this.getReversiblePawnsNumberForDirection(Direction.BOTTOM_LEFT, pawn, line, column);
		nb += this.getReversiblePawnsNumberForDirection(Direction.LEFT, pawn, line, column);
		return nb;
	}	
	
	private int getReversiblePawnsNumberForDirection(Direction direction, Pawn pawn, int line, int column) {
		int counter = -1;
		if (this.checkLastPawn(direction, pawn, line, column)) {
			do {
				column = Direction.getNextColumn(direction, column);
				line = Direction.getNextLine(direction, line);
				counter++;
			} while (!this.getPawn(line, column).equals(pawn));
			return counter;			
		}
		return 0;
	}
	
	private boolean checkLastPawn(Direction direction, Pawn pawn, int line, int column) {
		do {
			column = Direction.getNextColumn(direction, column);
			line = Direction.getNextLine(direction, line);			
		} while (this.getPawn(line, column).equals(Pawn.reverse(pawn)));
		if (this.getPawn(line, column).equals(pawn)) return true;
		return false;
	}
	
	void reversePawns(Direction direction, Pawn pawn, int line, int column) {
		if (this.checkLastPawn(direction, pawn, line, column)) {
			column = Direction.getNextColumn(direction, column);
			line = Direction.getNextLine(direction, line);
			while (!this.getPawn(line, column).equals(pawn)) {
				this.board[line][column] = pawn;
				column = Direction.getNextColumn(direction, column);
				line = Direction.getNextLine(direction, line);				
			}
		}	
	}
	
	boolean play(Pawn pawn, int line, int column) {
		int reversedPawns = this.testMove(pawn, line, column);
		if(reversedPawns > 0) {
			pawn.earn(reversedPawns + 1);
			Pawn.reverse(pawn).earn(-reversedPawns);
			this.board[line][column] = pawn;
			this.reversePawns(Direction.TOP_LEFT, pawn, line, column);
			this.reversePawns(Direction.TOP, pawn, line, column);
			this.reversePawns(Direction.TOP_RIGHT, pawn, line, column);
			this.reversePawns(Direction.RIGHT, pawn, line, column);
			this.reversePawns(Direction.BOTTOM_RIGHT, pawn, line, column);
			this.reversePawns(Direction.BOTTOM, pawn, line, column);
			this.reversePawns(Direction.BOTTOM_LEFT, pawn, line, column);
			this.reversePawns(Direction.LEFT, pawn, line, column);
			return true;
		}
		return false;
	}	

	boolean isAnyMovePossibleFor(Pawn pawn) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {				
				if (testMove(pawn, i, j) > 0) {
					return true;
				}
			}
		}
		System.out.println("No possible move.");
		return false;
	}
	
	public Pawn[][] getBoard() {
		return board;
	}
	
	public static int getBoardSize() {
		return BOARD_SIZE;
	}
}