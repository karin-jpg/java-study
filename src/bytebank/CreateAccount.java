package bytebank;

import java.util.Locale;

public class CreateAccount {

	public static void main(String[] args) {		
		
		Account account = new Account();
		
		account.setAgency(123);
		account.setNumber(777);				
		account.deposit(100);
		
		Client client = new Client();
				
		client.setName("Karn Morais");
		client.setCpf("265.458.456-06");
		client.setProfession("Developer");
		
		account.setClient(client);
		
		System.out.println("Your account number is "+ account.getNumber());
		System.out.println("Your account balance is "+ String.format(Locale.GERMAN, "%,.2f", account.getBalance()));
		System.out.println();
		account.withdraw(25.65);

		System.out.println("Your account number is "+ account.getNumber());
		System.out.println("Your new balance is "+ String.format(Locale.GERMAN, "%,.2f", account.getBalance()));
		System.out.println();
		
		Account otherAccount = new Account();
		otherAccount.deposit(20);
		
		boolean successTransfer = account.transfer(1000, otherAccount);
		
		if (successTransfer) {
			System.out.println("Transfer made successfully!");
		} else {
			System.out.println("Error when performing the transfer");
		}
		
		
		System.out.println("Your new balance is "+ String.format(Locale.GERMAN, "%,.2f", account.getBalance()));
		
	}
}
