package bytebank;

public class Account {

	private double balance;
	private int agency;
	private int number;
	private Client client;
	
	
	public void deposit(double value) {
		if (value < 0) {
			System.out.println("Negative values are not permitted!");
			return;
		}
		this.balance += value;
	}
	
	public boolean withdraw(double value) {		
		if (this.balance < value) {
			return false;
		}
		
		this.balance -= value;
		return true;
	}
	
	public boolean transfer(double value, Account targetAccount) {
		if (this.balance < value) {
			return false;
		}
		
		if (this.withdraw(value)) {
			targetAccount.deposit(value);
			return true;
		}
		
		return false;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		if (number < 1) {
			System.out.println("Negative values are not permitted!");
			return;
		}
		this.number = number;
	}
	
	public int getAgency() {
		return this.agency;
	}
	
	public void setAgency(int agency) {
		if (agency < 1) {
			System.out.println("Negative values are not permitted!");
			return;
		}
		this.agency = agency;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
}
