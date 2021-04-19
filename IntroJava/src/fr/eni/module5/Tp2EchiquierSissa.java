package fr.eni.module5;

import java.math.BigInteger;

public class Tp2EchiquierSissa {

	public static BigInteger calculer() {
		final int cases = 64;
		BigInteger grains = BigInteger.ONE;
		//BigInteger total = ONE;
		for (int i = 0; i < cases; i++) {
			System.out.println(i); //DEBUG A VIRER
			System.out.println("grains: " + grains); //DEBUG A VIRER
			//System.out.println("total: " + total); //DEBUG A VIRER
			grains = grains.multiply(BigInteger.TWO);
			//total = total.add(grains);
		}
		return grains;//total;
	}
	
	public static void main(String[] args) {
		System.out.println(calculer()); 
	}
	
}
