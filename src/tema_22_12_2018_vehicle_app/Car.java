package tema_22_12_2018_vehicle_app;

public abstract class Car implements Vehicle {
	private final String chassisNumber;
	private final int fuelTankSize;
	private final String fuelType;
	private final int gears;  // number of gears 
	private final float declaredConsumptionPer100Km; // factory declared average consumption (l/100km)
	private float availableFuel;
	private int currentGear;
	private boolean engineOn;
	private float averageFuelConsumption; // avg fuel consumed (l/100km) between start and stop
	private double cruiseKm;  // the distance drove between start and stop
	private float fuelConsumed; // fuel (liters) consumed between start and stop
	private float tempFuelConsumed; // fuel (liters) consumed between changing gears
	public float adjustConsumption; // adjust the consumption  - tipical for each car model in part

	public Car(int fuelTankSize, float availableFuel, String fuelType, int gears, float consumptionPer100Km,
			String chassisNumber) {
		this.fuelTankSize = fuelTankSize;
		this.fuelType = fuelType;
		this.gears = gears;
		this.declaredConsumptionPer100Km = consumptionPer100Km;
		if (availableFuel <= fuelTankSize && availableFuel >= 0) {  // if available fuel is declared to be higher than
			this.availableFuel = availableFuel;						// the fuel tank capacity, then the available fuel is set
		}else if (availableFuel < 0) {								// to full tank capacity
			this.availableFuel = 0;									// if negative, then available fuel is set to 0
		}else {
			this.availableFuel = fuelTankSize;
		}
		this.chassisNumber = chassisNumber;
	}

	public void start() {					// upon start statistics are reset to 0
		this.engineOn = true;
		this.averageFuelConsumption = 0;
		this.cruiseKm = 0;
		this.fuelConsumed = 0;
		this.adjustConsumption = 0;
	}

	public void stop() {					// at stop the average fuel consumption for entire trip is calculated
		this.engineOn = false;
		this.averageFuelConsumption = (float)(this.fuelConsumed * 100 / this.cruiseKm);
	}

	public void shiftGear(int gear) {
		if (gear <= this.gears) {
			this.currentGear = gear;
		} else {
			System.out.println("There are maximum " + this.gears + " gears.");
		}
	}

	public void drive(double n) {
		this.cruiseKm += n;
		this.tempFuelConsumed = (float) (n * this.declaredConsumptionPer100Km/100 * (1 + this.adjustConsumption));
		this.fuelConsumed += this.tempFuelConsumed;
		this.availableFuel -= this.tempFuelConsumed;

	}

	public float getAvailableFuel() {
		return availableFuel;
	}

	public void setAvailableFuel(float availableFuel) {
		this.availableFuel = availableFuel;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public int getCurrentGear() {
		return currentGear;
	}

	public float getAverageFuelConsumption() {
		return averageFuelConsumption;
	}

	public double getCruiseKm() {
		return cruiseKm;
	}

	public float getFuelConsumed() {
		return fuelConsumed;
	}

	public float getConsumptionPer100Km() {
		return declaredConsumptionPer100Km;
	}

	public int getFuelTankSize() {
		return fuelTankSize;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getGears() {
		return gears;
	}

	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}

	public void setAverageFuelConsumption(float averageFuelConsumption) {
		this.averageFuelConsumption = averageFuelConsumption;
	}

	public void setCruiseKm(double cruiseKm) {
		this.cruiseKm = cruiseKm;
	}

	public void setFuelConsumed(float fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}

	public float getTempFuelConsumed() {
		return tempFuelConsumed;
	}

	public void setTempFuelConsumed(float tempFuelConsumed) {
		this.tempFuelConsumed = tempFuelConsumed;
	}

	public float getAdjustConsumption() {
		return adjustConsumption;
	}

	public void setAdjustConsumption(float adjustConsumption) {
		this.adjustConsumption = adjustConsumption;
	}

	public float getDeclaredConsumptionPer100Km() {
		return declaredConsumptionPer100Km;
	}

}
