package fr.eni.module7;

import java.util.Scanner;

public class TpTicTactoe {
	public static int SIZE = 3;
	public static char PLAYER1 = 'X';
	public static char PLAYER2 = 'O';
	
	public static char[][] initGrid() {
		char[][] grid = new char[SIZE][SIZE];
		for (int i = 0; i<SIZE; i++) {
			for (int j = 0; j<SIZE; j++) {
				grid[i][j] = '.';
			}
		}
		return grid;
	}
	
	public static void displayGrid(char[][] grid) {
		for (int i = 0; i<SIZE; i++) {
			for (int j = 0; j<SIZE; j++) {
				System.out.print(grid[i][j]);				
			}
			System.out.println("");
		}
	}
	
	public static boolean isPositionAvailable(char[][] grid, int column, int row) {
		if (grid[row][column] == '.') {
			return true;
		}
		return false;
	}
	
	public static char move(char[][] grid, char player, int column, int row) {
		Scanner scanner= new Scanner(System.in);
		char result;
		boolean position = false;
		do {
			System.out.println(player + "'s turn.");
			System.out.println("Select a column:");
			column = scanner.nextInt()-1;
			System.out.println("Select a row");
			row = scanner.nextInt()-1;
			position = isPositionAvailable(grid, column, row);
			if (!position) {
				System.out.println("Position unavailable.");
				displayGrid(grid);
			}
		}while (!position);
		grid[row][column] = player;
		result = verifyGrid(grid);
		return result;
	}
	
	public static char verifyGrid(char[][] grid) {
		for (int i=0; i<SIZE; i++) {
			if (grid[i][0] != '.' || grid[0][i] != '.') {
				if (grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
					return grid[i][0];
				} else if (grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i]) {
					return grid[0][i];
				}
			}			
		}
		if (grid[1][1] != '.') {
			if((grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2])
				||(grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0])) {
				return grid[1][1];
			}
		}
		return '.';
	}

	public static void main(String[] args) {
		int column = 0; 
		int row = 0;
		boolean fin = false;
		char winner = '.';
		char[][] grid = new char[SIZE][SIZE];
		grid = initGrid();
		while (!fin) {
			displayGrid(grid);
			winner = move(grid, PLAYER1, column, row);
			displayGrid(grid);
			if (winner != '.') {			
				fin = true;
				break;
			}
			winner = move(grid, PLAYER2, column, row);
			if (winner != '.') {			
				fin = true;
			}
		}
		System.out.println("Congratulations, " + winner + ", you won the game!");
	}

}
