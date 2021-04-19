package fr.eni.module7;

import java.util.Scanner;

public class Tp5Palindromes {
	
	public static boolean isPalindrome(String expression) {
		String half1, half2;
		int midPoint;
		//Delete blank space between words
		String[] words = expression.split(" ");
				expression = "";
		for (String word : words) {
			expression += word;
		}
		//Split the expression in 2 str
		midPoint = expression.length() / 2;
		if (expression.length() % 2 == 0) {			
			half1 = expression.substring(0, midPoint);
		} else {
			midPoint++;
			half1 = expression.substring(0, midPoint - 1);
		}
		half2 = expression.substring(midPoint);
		//Reverse the second half to compare it with the first
		char[] half2Chars = half2.toCharArray();
		char temp;
		for (int i = 0; i < half2Chars.length/2; i++) {
			temp = half2Chars[i];
			half2Chars[i] = half2Chars[(half2Chars.length - 1) - i];
			half2Chars[(half2Chars.length - 1) - i] = temp;
		}
		half2 = "";
		for (char letter : half2Chars) {
			half2 += letter;
		}
		//Compare the first half with the reversed second one
		if (half1.equals(half2)) {
			System.out.println("This expression is indeed a palindrome.");
			return true;
		}
		System.out.println("This expression is not a palindrome.");
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String expression;
		// Prompt user for an expression
		System.out.println("Please enter a expression to check if it is a palindrome.");
		expression = scan.nextLine().toLowerCase();
		scan.close();
		isPalindrome(expression);

	}

}
