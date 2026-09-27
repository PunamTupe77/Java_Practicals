package com.punam;

class BankAccount{
	private double balance;
	
	public BankAccount(double initialBalance) {
		if(initialBalance >= 0) {
			this.balance = initialBalance;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(Double amount) {
	    if(amount > 0) {
	    	balance = balance + amount;
	    	System.out.println("Amount Deposited Successfully " +amount);
	    }
	    else {
	    	System.out.println("Invalid deposit");
	    }
	}
}
public class EncapsulationExample {

	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount(500);
		
		myAccount.setBalance(100.0);
		System.out.println("Current balance: "+myAccount.getBalance());
	}

}

