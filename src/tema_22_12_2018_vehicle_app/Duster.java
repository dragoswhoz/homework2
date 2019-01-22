package tema_22_12_2018_vehicle_app;

public class Duster extends Dacia {

	public Duster(int availableFuel, String chassisNumber) {
		super(60, availableFuel, "Diesel", 6, 6.5f, chassisNumber);
	}

	public void start() {
		//atentie, daca ai suprascris metoda asta in Duster si nu ai definit nimic aici, 
		//cand va fi executata pe un obiect de tip Duster, nu va face nimic din ce ai definit in superclasa
		//Tip: poate voiai sa faci super.start();   :)
	}

	public void stop() {

	}

	public void drive(float n) {

	}

}
