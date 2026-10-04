/*
	File:	SavingsAccount.java
	Author:	Alex Burdick
	Date:	4/18/2025

 	Description: An account that has an interest rate
                 Extends Account
*/

public class SavingsAccount extends Account{
    // Class Variables
    public static final double interestPercentage = 0.02; // public so that other classes can check 
                                                          // interest percentage, but can't change it
    
    // Constructors
    
    /**
	 * Overloaded constructor
     * 
	 * @param accountNumber
	 * @param owner
	 * @param created
	 * @param balance
	 */
    public SavingsAccount(int accountNumber, Customer owner, Date created, double balance) {
        super(accountNumber, owner, created, balance); // invoke super overloaded constructor
    }

    /**
	 * Overloaded constructor
     * 
	 * @param accountNumber
	 * @param manager
	 * @param owner
	 * @param created
	 */
    public SavingsAccount(int accountNumber, Employee manager, Customer owner, Date created) {
        super(accountNumber, manager, owner, created); // invoke super overloaded constructor
    }

    /**
	 * Overloaded constructor that accepts an account object to be copied
     * 
	 * @param account
	 */
    public SavingsAccount(Account account) {
        super(account); // invoke super copy constructor
    }

    /**
     * Copy constructor written by Copilot
     * 
     * @param toCopy SavingsAccount to be copied
     */
    public SavingsAccount(SavingsAccount toCopy) {
        super(toCopy); // invoke the super class copy constructor
    }
    
    // Methods

    /**
     * Adds the interest earned to the principle
     * 
     * @return total
     */
     public double addInterest() {
        // I made the balance in Account protected instead of private so it can be changed by SavingsAccount and CheckingAccount
        return balance += balance * interestPercentage;
    }

    /**
     * Overriden toSTring
     * 
     * @return String of account with interest amounts added
     */
    @Override
    public String toString() {
		return 	super.toString() + "\nInterest % = " + interestPercentage;

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
    public SavingsAccount clone() {
        SavingsAccount cloned = new SavingsAccount(this);
        return cloned;
    }

    @Override
    public void update() {
        addInterest();
    }
}