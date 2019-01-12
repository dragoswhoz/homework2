package tema_22_12_2018_vehicle_app;

public class Logan extends Dacia {

	public Logan(int availableFuel, String chassisNumber) {				// only available fuel and chassis number can be set
		super(50, availableFuel, "Petrol", 5, 6.5f, chassisNumber);		// with constructor, the other are default

	}

	public void drive(double n) {
		float adjustConsumption = 0;
		int gear = getCurrentGear();
		switch (gear) {
		case 1:
			adjustConsumption = (float) 100 / 100;
			break;
		case 2:
			adjustConsumption = (float) 50 / 100;
			break;
		case 3:
			adjustConsumption = (float) 30 / 100;
			break;
		case 4:
			adjustConsumption = (float) 20 / 100;
			break;
		case 5:
			adjustConsumption = (float) 10 / 100;
			break;

		default:
			adjustConsumption = 0;
			break;
		}
		
		setAdjustConsumption(adjustConsumption);
		super.drive(n);
		

	}

}
