package fr.eni.module7;

import java.util.Scanner;

public class Tp4ConversionBinaire {
	
	public static double convertToBinary(double x) {
		double i = 7;
		double result = 0;
		while (i >= 0 && x >0) {
			if (x >=Math.pow(2, i)) {
				result += Math.pow(10, i);				
				x -= Math.pow(2, i);
				i--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double value;
		System.out.println("Enter a number to convert it in binary :");
		value = scan.nextDouble(); 
		System.out.println(convertToBinary(value));
		scan.close();

	}

}
