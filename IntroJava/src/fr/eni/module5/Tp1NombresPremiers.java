package fr.eni.module5;

public class Tp1NombresPremiers {
	
	public static boolean isPrime(int num) {
		int compteur = 0;
		for (int i = 1; i < 1000; i++) {
			if (num%i == 0) {
				compteur++;
			}
		}
		if (compteur == 2 && num != 2) {
			return true;
		}
		return false;
	}
	
	public static void primes(int limite) {
		for (int i = 0; i < limite; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		primes(1000);
	}

}
