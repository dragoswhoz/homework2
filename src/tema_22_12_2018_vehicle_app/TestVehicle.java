package tema_22_12_2018_vehicle_app;

public class TestVehicle {

	public static void main(String[] args) {
		// Car car = new Car(); // This should not compile. OK

		// Car car = new Dacia(27, "oiqe0934hkkadsn"); OK // This should not compile! If I want to create a Dacia car, I will need to create an instance of a Dacia model.

		Car car = new Logan(27, "oiqe0934hkkadsn"); // Logan can extend from Dacia, while Dacia extends from Car
		car.start();

		car.shiftGear(1);

		car.drive(0.01);// drives 0.01 KMs

		car.shiftGear(2);
		

		car.drive(0.02);

		car.shiftGear(3);

		car.drive(0.5);
		

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(5);

		car.drive(10);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(3);

		car.drive(0.1);

		car.stop();
		
		Vehicle vehicle = new Golf(30, "1987ddkshik289"); //available fuel and chassis number

		vehicle.start();
		

		vehicle.drive(1);

		vehicle.stop();

		car = (Car) vehicle;
		
		car.start();
		car.shiftGear(1);
		//car.drive(100);
		car.shiftGear(5);
		car.drive(100);
		car.drive(100);
		//car.shiftGear(1);
		//car.drive(100);
		car.stop();

		float availableFuel = car.getAvailableFuel();

		float fuleConsumedPer100Km = car.getAverageFuelConsumption();
		

		System.out.println(car.getFuelConsumed());
		System.out.println(availableFuel);
		System.out.println(car.getCruiseKm());
		System.out.println(fuleConsumedPer100Km);
		

	}

}
