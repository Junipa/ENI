package fr.eni.Reversi;

import java.util.Scanner;

public class ReversiMain {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ReversiBoard board = new ReversiBoard();
		Pawn dark = Pawn.DARK;
		Pawn light = Pawn.LIGHT;
		String name;
		System.out.println("Please enter your name:");
		name = scan.nextLine();
		HumanPlayer player1 = new HumanPlayer(name);
		Player player2;
		if (choseGameMode() == 1) {
			System.out.println("Please enter your name:");
			name = scan.nextLine();
			player2 = new HumanPlayer(name);
		} else {
			player2 = new Bot();
		}
		boolean isGameOver = false;
		do {
			isGameOver = !player1.play(board, dark);
			isGameOver = !player2.play(board, light);
		} while (!isGameOver);
		//player1.closeScanner();
		System.out.printf("%s: %d\n%s: %d",
				dark.getSymbole(), dark.getTotalPawns(),
				light.getSymbole(), light.getTotalPawns());
		scan.close();
	}
	
	private static int choseGameMode() {
		int choice;
		do {
			System.out.println("Do you want to play against a friend or a bot ?\n1-Friend\n2-Bot");
			choice = scan.nextInt();
		} while (choice != 1 && choice != 2);
		return choice;
	}
}