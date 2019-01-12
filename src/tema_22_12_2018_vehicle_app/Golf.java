package tema_22_12_2018_vehicle_app;

public class Golf extends Vw {
	
	public Golf(float availableFuel, String chassisNumber) {		// only available fuel and chassis number can be set
		super(55, availableFuel, "Diesel", 6, 5.2f, chassisNumber);	// with constructor, the other are default
	}
	
	public void shiftGear(int gear) {								// the consumption is set to be 10% more than 	
		float adjustConsumption = 0;								// factory declared consumption when shifting up;
		if ((gear < getGears()) && (gear > getCurrentGear())) {		// in the last gear avg consumption is the standard one
			adjustConsumption = ( float) 10 / 100;					// also when shifting down the consumption is the standard one
		}
		setAdjustConsumption(adjustConsumption);
		super.shiftGear(gear);
		
	}
	
	public void drive(double n) {
		super.drive(n);
	}

}
