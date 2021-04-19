package fr.eni.module7;

import java.util.Scanner;

public class Tp2CryptagePolyalphabetique {
	final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String encrypt(String word, String key) {
		String result = "";
		int column = 0;
		int line = 0;
		
		for (int i = 0; i < word.length(); i++) {
			column = ALPHABET.indexOf(word.toCharArray()[i]);
			line = ALPHABET.indexOf(key.toCharArray()[i]);
			if (column + line < ALPHABET.length()) {
				result += ALPHABET.charAt(column + line);
			} else {
				result += ALPHABET.charAt(column + line - ALPHABET.length());
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word, key;
		int diff;
		
		// Prompt user for a string
		System.out.println("Please enter the word to encrypt.");
		word = scan.nextLine().toUpperCase();		
		
		// Prompt user for a key oO
		System.out.println("Please enter the encryption key.");
		key = scan.nextLine().toUpperCase();
		
		// Modify key's length to fit word's
		if (key.length() > word.length()) {
			key = key.substring(0, word.length());
		} else if (key.length() < word.length()) {
			diff = word.length() - key.length();
			key += key.substring(0, diff);
		}
		
		// Encrypt the string, duh !
		System.out.println("here is your encrypted word: " + encrypt(word, key));
	}

}
