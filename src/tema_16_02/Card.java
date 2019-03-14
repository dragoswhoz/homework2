package tema_16_02;

import java.util.Scanner;

public class Card {

	private String type;
	private String issuingBank;
	private Account account;
	private String pinNumber;
	private Client cardHolder;

	public Card(String type, String issuingBank, Account account, String pinNumber, Client cardHolder) {

		this.type = type;
		this.issuingBank = issuingBank;
		this.account = account;
		this.pinNumber = pinNumber;
		this.cardHolder = cardHolder;
	}
	
/*	public Card() {

	}*/

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	public Client getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(Client cardHolder) {
		this.cardHolder = cardHolder;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public boolean setPinNumber(String pinNumber) {
		if(checkPinFormat(pinNumber)) {
		this.pinNumber = pinNumber;
		return true;
		}else {
			System.out.println("The PIN should have only four digits");
			return false;
		}
	}
	
	public boolean checkPinFormat(String newPin) {
		String pattern = "[0-9]{4}";
		return newPin.matches(pattern);
	}
	
	public void updatePin(String newPin) {
		Scanner scan = new Scanner(System.in);
		while(!setPinNumber(newPin)) {
			newPin = scan.nextLine();
		}
		System.out.println("Pin was changed");
		/*scan.close();*/
	}

	

}
