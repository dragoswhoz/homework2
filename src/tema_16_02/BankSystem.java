package tema_16_02;

public class BankSystem {
	
	Client dragosPirvu = new Client("Dragos", "Pirvu");
	Account account1 = new Account("RON", "RO35INGB0000999965422136", 200);
	Card card1 = new Card("VISA", "ING", account1, "1234", dragosPirvu);
	
	
	
	

}
