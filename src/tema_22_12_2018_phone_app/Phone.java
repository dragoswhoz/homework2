package tema_22_12_2018_phone_app;

public interface Phone {
	void addContact(String no, String phoneNumber, String firstName, String lastName);
	void listContacts();
	void sendMessage(String phoneNumber, String messageContent);
	void listMessages(String phoneNumber);
	void call(String phoneNumber);
	void viewHistory();
	void turnOff();
	void turnOn();
	

}
