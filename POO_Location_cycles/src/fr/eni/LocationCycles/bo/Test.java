package fr.eni.LocationCycles.bo;

import java.time.LocalDate;

/**
 * @author Junipa
 *
 */
public class Test {
	private static final int NB_CYCLES = 6;
	private static Cycle[] cycles = new Cycle[Test.NB_CYCLES];
	
	public static void main(String[] args) {
		Velo velo1 = new Velo("Lapierre", "Speed 400", LocalDate.now().minusYears(1), 27);
		Cycle c1 = velo1;
		cycles[0] = c1;
		Velo velo2 = new Velo("Btwin", "Riverside 900", LocalDate.now(), 9);
		Cycle c2 = velo2;
		cycles[1] = c2;
		Gyropode gyropode1 = new Gyropode("Segway", "Ninebot Elite", LocalDate.now(), 40, 1.50);
		Cycle c3 = gyropode1;
		cycles[2] = c3;
		Gyropode gyropode2 = new Gyropode("Weebot", "Echo", LocalDate.now().minusYears(1), 35, 1.60);
		Cycle c4 = gyropode2;
		cycles[3] = c4;
		Gyroroue gyroroue1 = new Gyroroue("Immotion", "v8", LocalDate.now(), 40);
		Cycle c5 = gyroroue1;
		cycles[4] = c5;
		Gyroroue gyroroue2 = new Gyroroue("Segway", "Ninebot One E+", LocalDate.now(), 30);
		Cycle c6 = gyroroue2;
		cycles[5] = c6;
		for (Cycle cycle: cycles) {
			System.out.println(cycle.toString());
		}
	}

}
