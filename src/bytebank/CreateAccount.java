package bytebank;

import java.util.Locale;

public class CreateAccount {

	public static void main(String[] args) {		
		
		Client client = new Client();
		
		client.setName("Karin Morais");
		client.setCpf("265.458.456-06");
		client.setProfession("Developer");
		
		Account account = new Account(123, 777, client);
		
		account.deposit(100);
		
		account.setClient(client);
		
		System.out.println("The account owner is " + account.getClient().getName());
		System.out.println("The account owner profession is " + account.getClient().getProfession());
		System.out.println("Your account number is "+ account.getNumber());
		System.out.println("Your account balance is "+ String.format(Locale.GERMAN, "%,.2f", account.getBalance()));
		System.out.println();
		account.withdraw(25.65);
		
		account.getClient().setProfession("Programmer");

		System.out.println("The account owner is " + account.getClient().getName());
		System.out.println("The account owner profession is " + account.getClient().getProfession());
		System.out.println("Your account number is "+ account.getNumber());
		System.out.println("Your new balance is "+ String.format(Locale.GERMAN, "%,.2f", account.getBalance()));
		System.out.println();
		
		Client otherClient = new Client();
		client.setName("Jonathan");
		client.setCpf("265.987.321-06");
		client.setProfession("Developer");
		
		Account otherAccount = new Account(321, 666, otherClient);
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
