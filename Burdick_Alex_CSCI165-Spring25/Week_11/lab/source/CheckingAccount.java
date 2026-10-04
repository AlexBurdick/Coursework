/*
	File:	CheckingAccount.java
	Author:	Alex Burdick
	Date:	4/18/2025

 	Description: An account that has an overdraft limit
                 Extends Account
*/

public class CheckingAccount extends Account{
    // Class Varialbes
    public static final double overdraftLimit = -50.0; // public so that other classes can check 
                                                       // overdraft limit, but can't change it
    
    // Constructors
    
    /**
	 * Overloaded constructor
     * 
	 * @param accountNumber account number
	 * @param owner         Customer who owns the account
	 * @param created       Date checking account was created
	 * @param balance       dollar amount in the checking account
	 */
    public CheckingAccount(int accountNumber, Customer owner, Date created, double balance) {
        super(accountNumber, owner, created, balance); // invoke super overloaded constructor
    }

    /**
	 * Overloaded constructor
     * 
	 * @param accountNumber account number
	 * @param manager       Employee assigned to manage checking account
	 * @param owner         Customer who owns the checking account
	 * @param created       Date checking account was created
	 */
    public CheckingAccount(int accountNumber, Employee manager, Customer owner, Date created) {
        super(accountNumber, manager, owner, created); // invoke super overloaded constructor
    }

    /**
	 * Overloaded constructor that accepts account object
     * 
	 * @param account Account to be copied
	 */
    public CheckingAccount(Account account) {
        super(account); // invoke super copy constructor
    }

    /**
     * Copy constructor written by Copilot
     * 
     * @param toCopy CheckingAccount to be copied
     */
    public CheckingAccount(SavingsAccount toCopy) {
        super(toCopy); // invoke the super class copy constructor
    }

    // Methods

    /**
     * Adds the interest earned to the principle
     * 
     * @return true if the acount balance is less than 0 but greater than the overdraftLimit;
     */
    public boolean isInOverdraft() {
        if (balance < 0) // check balance is less than 0
            return true;
        return false; // if the balance is greater than or equal to 0
    }

    @Override
    public void withdraw(double sum) {
        if (sum > 0) { // must withdraw positive amount

            // don't allow the withdrawal if it would make the account balance less than the overdraft limit
            double difference = this.balance - sum; // store the difference
            if (difference < overdraftLimit) // check if the withdrawal will be more than the overdraft limit
                System.err.println("CheckingAccount.withdraw(...): account would be overdrawn past the limit.");
            else this.balance -= sum;
        }
        else
            System.err.println("Account.withdraw(...): cannot withdraw negative amount.");
	}

    /**
     * Overriden toString
     * 
     * @return String of account with overdraft limit amounts added
     */
    @Override
    public String toString() {
		return 	super.toString() + "\nOverdraft Limit = " + overdraftLimit;

    }

    /**
     * Overriden equals method
     * 
     * @return true if the objects are deep equals
     */
    @Override
    public boolean equals(Object obj) {
        // There are no instance variables to check, so the super equals will do all the checking
        if (!super.equals(obj)) return false; // super check
		return true;
    }

    /**
	 * Overriden clone that invokes the copy constructor
     * 
	 * @return a copy of this
	 */
    @Override
    public CheckingAccount clone() {
        CheckingAccount cloned = new CheckingAccount(this);
        return cloned;
    }

    @Override
    public void update() {
        if (isInOverdraft()) System.out.println("Account " + getAccountNumber() + " is overdrawn.");
    }
}
