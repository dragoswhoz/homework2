package tema_16_02;

import java.util.Scanner;

public class ATMrunner {
	private static BankSystem banksystem = new BankSystem();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ATM.start();
		ATM.insertCard(banksystem.card1);
		scan.close();

	}

}
