package fr.eni.module7;

public class Tp3SuiteLogique {
	
	public static String findNextDegree(String previousDegree) {
		String degree = "";		
		int counter;
		char value;
		value = '0';
		counter = 0;
		for (int i=0; i<previousDegree.length(); i++) {
			if (previousDegree.charAt(i) != value) {
				if (i == 0) {
					value = previousDegree.charAt(i);
					counter++;
					if (previousDegree.length() == 1) {
						degree += String.valueOf(counter);
						degree += String.valueOf(value);
					}
				} else {
					degree += String.valueOf(counter);
					degree += String.valueOf(value);
					value = previousDegree.charAt(i);
					counter = 1;
					if (previousDegree.length()- 1 == i) {
						degree += String.valueOf(1);
						degree += String.valueOf(value);
					}
				}				
				
			} else {
				counter++;
				if (previousDegree.length()- 1 == i) {
					degree += String.valueOf(counter);
					degree += String.valueOf(value);
				}
			}
		}
		
		return degree;
	}
	
	public static void sequence(int lastDegree) {
		String degree = "1";
		System.out.println(degree);
		while (lastDegree >= 0) {
			degree = (findNextDegree(degree));
			System.out.println(degree);
			lastDegree--;
		}
		
	}

	public static void main(String[] args) {
		sequence(12);
		
	}

}
