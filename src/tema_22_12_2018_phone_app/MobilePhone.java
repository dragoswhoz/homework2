package tema_22_12_2018_phone_app;

import java.util.ArrayList;
import java.time.*;

public abstract class MobilePhone implements Phone {

	private final double batteryLife;
	private double availableBatteryLife;
	private String color;
	private String material;
	private final String imei;
	private boolean isOn;
	private ArrayList<Contact> phonebook = new ArrayList<>();
	private ArrayList<Message> messages = new ArrayList<>();
	private ArrayList<String> history = new ArrayList<>();

	public MobilePhone(double batteryLife, String imei) {
		this.batteryLife = batteryLife;
		this.imei = imei;
		this.availableBatteryLife = this.batteryLife;

	}

	@Override
	public void addContact(String no, String phoneNumber, String firstName, String lastName) {
		if (isOn == true) {
			Contact contact = new Contact(no, phoneNumber, firstName, lastName);
			this.phonebook.add(contact);
		} else {
			System.out.println("The phone is off, please turn it on");
		}
	}

	@Override
	public void listContacts() {
		if (isOn == true) {
			for (Contact contact : phonebook) {
				System.out.print(contact.getNo() + " ");
				System.out.print(contact.getFirstName() + " ");
				System.out.print(contact.getLastName() + " ");
				System.out.println(contact.getPhoneNumber());
			}
		} else {
			System.out.println("The phone is off, please turn it on");
		}
	}

	@Override
	public void sendMessage(String phoneNumber, String messageContent) {

		if (isOn == true) {
			Message message = new Message(phoneNumber, messageContent);
			this.messages.add(message);
			ZonedDateTime currentTime = ZonedDateTime.now();
			this.history.add(currentTime + " - sent message to " + listEntry(phoneNumber));
			this.availableBatteryLife = this.availableBatteryLife - 1;
			if (this.availableBatteryLife <= 0) {
				this.availableBatteryLife = 0;
				turnOff();
			}
		} else {
			System.out.println("The phone is off, please turn it on");
		}

	}

	@Override
	public void listMessages(String phoneNumber) {
		if (isOn == true) {
			for (Message message : messages) {
				if (message.getPhoneNumber().equals(phoneNumber)) {
					System.out.println(message.getMessageContent());
				}
			}
		} else {
			System.out.println("The phone is off, please turn it on");

		}

	}

	@Override
	public void call(String phoneNumber) {
		if (isOn == true) {
			ZonedDateTime currentTime = ZonedDateTime.now();
			this.availableBatteryLife = this.availableBatteryLife - 2;
			this.history.add(currentTime + " - called " + listEntry(phoneNumber));
			if (this.availableBatteryLife <= 0) {
				this.availableBatteryLife = 0;
				turnOff();
			}
		} else {
			System.out.println("The phone is off, please turn it on");
		}

	}

	@Override
	public void viewHistory() {
		for (String entry : history) {
			System.out.println(entry);
		}

	}

	public void turnOn() {
		if (availableBatteryLife > 0) {
			this.isOn = true;
		} else {
			System.out.println("Please charge the phone");
		}
	}

	public void turnOff() {
		this.isOn = false;

	}

	public void charge(int precentage) {
		if (precentage > 0 && precentage <= 100) {
			this.availableBatteryLife = precentage / 100 * this.batteryLife;
		} else {
			System.out.println("The precentage charged should be between more than 0 and less or equal than 100");
		}
	}

	public String listEntry(String phoneNumber) {
		for (Contact contact : phonebook) {
			if (contact.getPhoneNumber().equals(phoneNumber)) {
				String contactFullName = contact.getFirstName() + " " + contact.getLastName();
				return contactFullName;
			}
		}

		return phoneNumber;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getBatteryLife() {
		return batteryLife;
	}

	public String getImei() {
		return imei;
	}

	public double getAvailableBatteryLife() {
		return availableBatteryLife;
	}

	public boolean getIsOn() {
		return isOn;
	}

}
