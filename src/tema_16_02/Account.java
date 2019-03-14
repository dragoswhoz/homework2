package tema_16_02;

import java.math.BigDecimal;

public class Account {
	private String currency;
	private String accountNumber;
	private double balance;

	public Account(String currency, String accountNumber, double balance) {
		this.currency = currency;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount deposited should be greater than 0");
		}
		balance += amount;
		System.out.println(amount + " was deposited");

	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount withdrawn should be greater than 0");
		}
		if (amount <= balance) {
			balance -= amount;
			System.out.println(amount + " was withdrawn");
		} else {
			System.out.println("Insuficient funds");
		}
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
