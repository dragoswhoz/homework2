package tema_16_02;

import java.util.*;

public class Client {
	private String firstName;
	private String lastName;
	private Set<Account> accounts = new HashSet<>();

	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return  firstName + " " + lastName ;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}
	
	
	

}
