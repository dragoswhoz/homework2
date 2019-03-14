package tema_16_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
	private static int displayWidth = 80;

	private static String option1 = "1.Check Balance";
	private static String option2 = "2.Withdraw";
	private static String option3 = "3.Deposit";
	private static String option4 = "4.Change Pin";
	private static String option5 = "5.Cancel";

	public static void start() {
	//	ATM app = new ATM();
		showWelcomeScreen();
		BankSystem bankDatabase = new BankSystem();
	//	insertCard(bankDatabase.card1);
		


	}

	public static void insertCard(Card card) {
		if (readCard(card)) {
			executeOption(card);
		}

	}

	private static boolean readCard(Card card) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter PIN number");
		int countPinTries = 0;
		while (countPinTries < 3) {
			String eneterdPin = scan.next();
			if (checkIfPinIsCorrect(eneterdPin, card.getPinNumber())) {
				System.out.println("Welcome " + card.getCardHolder() + ", please choose what you want to do:\n\n\n");
				displayOptions();
				return true;
			}
			System.out.println("Entered PIN is incorect, you have " + (3 - ++countPinTries) + "more tries.");
			if (countPinTries == 3) {
				System.out.println(
						"You have entered incorrect PIN 3 times. Your card is blocked. Please contact call center");

			}

		}
		// scan.close();
		return false;

	}

	private static void displayOptions() {

		printHorizontalLine();
		printVerticalLine();
		printVerticalLine();
		printVerticalLine();
		printOptionsLine(option1, option2);

		printVerticalLine();
		printVerticalLine();
		printVerticalLine();
		printOptionsLine(option3, option4);

		printVerticalLine();
		printVerticalLine();
		printVerticalLine();
		printOptionsLine("", option5);
		printHorizontalLine();

	}

	private static void printVerticalLine() {
		String formatVerticalLine = "%-" + (displayWidth - 1) + "c%c%n";
		System.out.printf(formatVerticalLine, '|', '|');
	}

	private static void printHorizontalLine() {
		String line = new String(new char[displayWidth]).replace('\0', '-');
		System.out.println(line);
	}

	private static void printOptionsLine(String option1, String option2) {
		System.out.printf("%-" + (displayWidth - option2.length()) + "s%s%n", option1, option2);

	}

	private static boolean checkIfPinIsCorrect(String enterPin, String pin) {
		if (enterPin.equals(pin)) {
			return true;
		}
		return false;
	}

	private static void executeOption(Card card) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
		
			try {
				byte selectedOption = scan.nextByte();
				scan.nextLine();
				

				switch (selectedOption) {
				case 1:
					System.out.println("Your balance is " + card.getAccount().getBalance());
					break;
				case 2:
					System.out.println("Please enter the amount you want to withdraw.");
					executeOption2(card, scan);
					break;
					
				case 3:
					System.out.println("Please enter the amount you want to deposit.");
					executeOption3(card, scan);
					break;

				case 4:
					System.out.println("Please enter the new PIN number");
					String newPin = scan.nextLine();
					card.updatePin(newPin);
					break;
				
				case 5:
					showWelcomeScreen();
					return;

				default:
					System.out.println("Please choose a correct option");
					displayOptions();
				//	return;
				}
				System.out.println("Please choose an operation");
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number coresponding to an option");
				displayOptions();
				scan.next();
			}
		}

	}

	private static void executeOption2(Card card, Scanner scan) {
		while (true) {
			try {
				double amount = Double.parseDouble(scan.nextLine());
				card.getAccount().withdraw(amount);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println("Please enter a valid amount");
			}

		}
	}
	
	private static void executeOption3(Card card, Scanner scan) {
		while (true) {
			try {
				double amount = Double.parseDouble(scan.nextLine());
				card.getAccount().deposit(amount);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println("Please enter a valid amount");
			}

		}
	}
	
	private static void showWelcomeScreen() {
		System.out.println("Welcome, please insert card");
	}
}
