package com.jspiders.multithreading.resource;

public class Account {
	private int balance;
	
	public Account(int balance) {
		this.balance=balance;
	}
	public int checkBalance(){
		return balance;
	}
	public synchronized void deposit(int amount) {
		System.out.println("trying to deposit "+amount);
		balance += amount;
		System.out.println("Deposit successfull");
		System.out.println("Account balance : "+ checkBalance());
	}
	public synchronized void withdraw(int amount) {
		System.out.println(" trying to withdra amount "+amount+" RS");
		
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Withdra Successfull");
			System.out.println("Account balance is: "+ checkBalance());
		}
		else {
			System.out.println("Insufficient balance");
		}
	}

}
