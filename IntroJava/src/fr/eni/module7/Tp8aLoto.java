package fr.eni.module7;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Tp8aLoto {
	
	public static int[] draw() {
		int[] drawing = new int[6];
		Random rand = new Random();
		int randy;
		// Draw the winning numbers
		for (int i = 0; i < drawing.length - 1; i++) {
			randy = (rand.nextInt(49)) + 1;
			for (int j = 0; j < drawing.length - 1; j++) {
				if (randy != drawing[j])
				drawing[i] = randy;
			}
		}
		drawing[drawing.length - 1] = (rand.nextInt(10)) + 1;
		// Sort the first 5 numbers
		Arrays.sort(drawing, 0, drawing.length - 1);
		return drawing;
	}
	
	public static void fillGrid(int[] grid) {
		Scanner scan = new Scanner(System.in);
		int input;
		System.out.println("Please enter 5 numbers between 1 and 49. Press 'Enter' between each number.");
		for (int i = 0; i < 5; i++) {
			input = scan.nextInt(); scan.nextLine();
			while (input < 1 || input > 49) {
				System.out.println("That number is not between 1 and 49. Please enter another one.");
				input = scan.nextInt(); scan.nextLine();
			}
			grid[i] = input;
		}
		do {
			System.out.println("Please enter a complementary number between 1 and 10.");
			input = scan.nextInt(); scan.nextLine();
		} while (input < 1 || input > 10);
		grid[5] = input;
		scan.close();
	}
	
	public static boolean hasWon(int[] grid, int[] drawing) {
		return Arrays.equals(grid, drawing);
	}
	
	public static void displayDrawing(int[] drawing) {
		String display = "The winning numbers are :\n";
		for (int i = 0; i < drawing.length - 1; i++) {
			display += "    " + drawing[i];
		}
		display += "\nThe complementary number is:\n    " + drawing[drawing.length - 1];
		System.out.println(display);
	}

	public static void main(String[] args) {
		int[] grid = new int[6];
		int[] winningGrid = draw();
		fillGrid(grid);
		if (hasWon(grid, winningGrid)) {
			System.out.println("Congratulations you won !!");
		} else {
			System.out.println("Unfortunately, you lost...");
		}
		displayDrawing(winningGrid);
	}

}
