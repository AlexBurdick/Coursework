/*
	File:	Bank.java
	Author:	Alex Burdick
	Date:	4/18/2025

 	Description: An account that has an interest rate
                 Extends Account
*/

import java.util.ArrayList;

public class Bank {

	// Class variables
	public static enum ACCOUNT_TYPE {ACCOUNT, SAVINGS, CHECKING};
	private static final double dividendPercentage = 0.01;

    // Private instance variables
	private ArrayList<Account> accounts; // Declare an ArrayList of Account objects

    // Constructors
	
	/**
	 * No argument constructor
	 */
    public Bank() {
        accounts = new ArrayList<>(); // Initialize the ArrayList
    }

	// Getters

	/**
	 * 
	 * @return accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	// Methods

	/**
	 * Updates each account in the array list, calling overriden update method of the account's class
	 */
	public void updateAccounts() {
		for (Account account : accounts) {
			account.update(); // calls the update method of the account's class
		}
	}

	/**
	 * Adds an account to the accounts array list
	 * 
	 * @param account
	 */
	public void openAccount(Account account) {
		// adds the a copy of the account object to the array
		accounts.add(account.clone()); // invokes the overriden clone method of the acccount's class
	}

	/**
	 * Adds an account to the accounts array list
	 * Switch created by Copilot
	 * 
	 * @param accountNumber
	 * @param owner
	 * @param created
	 * @param balance
	 * @param type
	 */
	public void openAccount(int accountNumber, Customer owner, Date created, double balance, ACCOUNT_TYPE type) {
		switch (type) {
			case ACCOUNT:
				accounts.add(new Account(accountNumber, owner, created, balance));
				break;
			case SAVINGS:
				accounts.add(new SavingsAccount(accountNumber, owner, created, balance));
				break;
			case CHECKING:
				accounts.add(new CheckingAccount(accountNumber, owner, created, balance));
				break;
			default:
				System.err.println("Invalid account type.");
		}
	}

	/**
	 * Adds an account to the accounts array list
	 * Switch created by Copilot
	 * 
	 * @param accountNumber
	 * @param owner
	 * @param created
	 * @param balance
	 * @param type
	 */
	public void openAccount(int accountNumber, Employee manager, Customer owner, Date created, ACCOUNT_TYPE type) {
		switch (type) {
			case ACCOUNT:
				accounts.add(new Account(accountNumber, manager, owner, created));
				break;
			case SAVINGS:
				accounts.add(new SavingsAccount(accountNumber, manager, owner, created));
				break;
			case CHECKING:
				accounts.add(new CheckingAccount(accountNumber, manager, owner, created));
				break;
			default:
				System.err.println("Invalid account type.");
		}
	}

	/**
	 * Removes an account to the accounts array list
	 * 
	 * @param accountNumber
	 */
	public void closeAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber)
				accounts.remove(account);
		}
	}

	/**
	 * Calculates the dividend and adds it to each account
	 */
	public void addDividend() {
		for (Account account : accounts) {
			// use the deposit method of the account class to add the dividend amount
			account.deposit(account.getBalance() * dividendPercentage);
		}
	}

	// Overriden Methods

	/**
	 * toString
	 * 
	 * @return Strings of all of the accounts
	 */
	public String toString() {
		String allAccounts = ""; // initialize String

		for (Account account : accounts)
			allAccounts += ("\n" + account.toString() + "\n"); // call the overriden toString of the account's class

		return allAccounts;
	}
}
