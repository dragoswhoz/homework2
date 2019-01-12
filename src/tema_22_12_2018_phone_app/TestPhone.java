package tema_22_12_2018_phone_app;

public class TestPhone {

	public static void main(String[] args) {
		MobilePhone phone = new SamsungGalaxyS6(10, "1235559999888");
		phone.getBatteryLife();
		phone.getImei();
		phone.turnOn();
		phone.addContact("1", "0740152134", "Dragos", "Pirvu");
		phone.addContact("2", "0786577788", "Marian", "Voicu");
		phone.listContacts();
		phone.sendMessage("0740152134", "Buna");
		phone.sendMessage("0786577788", "Ce faci?");
		phone.charge(100);
		phone.listMessages("0786577788");
		phone.call("0786577789");
		phone.viewHistory();
		System.out.println(phone.getAvailableBatteryLife());
		
	}

}
