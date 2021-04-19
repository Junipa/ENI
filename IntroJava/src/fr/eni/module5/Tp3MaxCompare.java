package fr.eni.module5;

public class Tp3MaxCompare {
	public static float plusGrand(float val1, float val2) {
		if (val1 > val2) {
			return val1;
		}
		return val2;
	}
	
	public static float comparer(float val1, float val2) {
		if (val1 > val2) {
			return 1;
		}
		if (val1 == val2) {
			return 0;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(plusGrand(1, 2));
		System.out.println(comparer(1, 2));
	}

}