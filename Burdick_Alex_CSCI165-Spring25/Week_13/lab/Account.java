/*
	File:	Account.java
	Author:	Ken Whitener
	Date:	4/15/2024

 	A class for bank accounts.
	This class provides the basic functionality of accounts.
	It allows deposits and withdrawals but not overdraft limits or interest rates.
*/

public class Account
{
	private Customer	owner;			// the owner of the account
	private Employee	accountManager;	// the manager of the account
	private Date		dateCreated; 	// date the account was created
	private int 		accountNumber;	// The account number
	protected double 	balance;  		// The current balance
    
	// Constructors

	//
	/**
	 * Constructor that takes the account number, customer who owns the account,
	 * date the account was created, and be balance the account should start with.
	 * 
	 * @param accountNumber
	 * @param owner
	 * @param created
	 * @param balance
	 */
	public Account(int accountNumber, Customer owner, Date created, double amount){
		this.accountNumber 	= accountNumber;
		this.owner			= new Customer(owner);
		this.dateCreated	= new Date(created);
		balance				= amount;
	}

	/**
	 * Overloaded constructor that also takes the employee assigned to the account
	 * 
	 * @param accountNumber
	 * @param manager
	 * @param owner
	 * @param created
	 */
	public Account(int accountNumber, Employee manager, Customer owner, Date created){
		this(accountNumber, owner, created, 0);		// call to overloaded constructor
		
		if (manager != null) // null check
			accountManager = new Employee(manager);// privacy protection
	}

	/**
	 * Overloaded constructor that accepts all fields
	 * 
	 * @param accountNumber
	 * @param manager
	 * @param owner
	 * @param created
	 */
	public Account(int accountNumber, Employee manager, Customer owner, Date created, double amount){
		this(accountNumber, owner, created, amount);		// call to overloaded constructor
		
		if (manager != null) // null check
			accountManager = new Employee(manager);// privacy protection
	}

	/**
	 * Copy constructor
	 * 
	 * @param toCopy Account to be copied
	 */
	public Account(Account toCopy) {
		this((int) toCopy.getAccountNumber(), // cast to an int (it was already an int before the getter)
              toCopy.getManager(), 
              toCopy.getOwner(), 
              toCopy.getDateCreated()); // invoke the overloaded constructor
        balance = toCopy.getBalance(); // set the balance
	}


	// Methods

	/**
	 * 
	 * @param amount
	 */
	public void deposit(double amount) throws InvalidBalanceException {
		if (amount > 0) balance += amount;
		else System.err.println("Account.deposit(...): cannot deposit negative amount.");    
	}

	/**
	 * 
	 * @param amount
	 */
	public void withdraw(double amount) throws InvalidBalanceException, OverdraftException {
		if (amount > 0) balance -= amount;
		else System.err.println("Account.withdraw(...): cannot withdraw negative amount.");
	}

	public void transferTo(Account otherAccount, double amount){
		if(this.owner.equals(otherAccount.owner) && amount < this.balance) {
			try { // try catch added by Copilot
				otherAccount.deposit(amount);
			} catch (InvalidBalanceException e) {
				System.err.println("Transfer failed: " + e.getMessage());
			}
		}
	}

	/**
	 * Set the account number, make sure it is 5 digit number
	 * 
	 * @param n account number to be tested
	 */
	public void setAccountNumber(int n) throws InvalidAccountNumberException {
		if (n >= 10000 && n <= 99999)
			accountNumber = n;
		else throw new InvalidAccountNumberException("The account number must be 5 digits.");
	}

	/**
	 * 
	 * @return the current balance
	 */
	public double getBalance(){
		return this.balance;
	}

	/**
	 * 
	 * @return the account number
	 */
	public double getAccountNumber(){
		return this.accountNumber;
	}

	/**
	 * 
	 * @param manager
	 */
	public void setManager(Employee manager){
		this.accountManager = new Employee(manager);	// privacy protection
	}

	/**
	 * 
	 * @return The account manager for this account
	 */
	public Employee getManager(){
		if (this.accountManager == null) // null check
			return null;
		return new Employee(this.accountManager);		// privacy protection
	}

	/**
	 * 
	 * @return The date the account was created
	 */
	public Date getDateCreated(){	
		return new Date(dateCreated);					// privacy protection
	}

	/**
	 * 
	 * @return The account owner
	 */
	public Customer getOwner(){
		return new Customer(this.owner);				// privacy protection
	}

	/**
	 * Placeholder method to be overriden by sub classes
	 * Maybe the Account class should be abstract?
	 * The Super class Account has a method called update that does nothing. This is so the
	 * two sub classes can use overriden update methods.
	 */
	public void update() {}

	@Override
	public String toString() {
		return 	"Account Number: " 	+ accountNumber	+ 
				"\nOpened: "		+ dateCreated	+	// calls Date.toString
				"\nOwner: "			+ owner 		+ 	// calls Customer.toString
				"\nManager: "		+ accountManager+	// calls Employee.toString
				"\nBalance: "		+ balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;	// identity check
		if (obj == null)					return false;	// null check
		if (getClass() != obj.getClass())	return false;	// origin check

		Account other = (Account) obj;						// down cast

		if (accountManager == null) {
			if (other.accountManager != null)
				return false;
		} else if (!accountManager.equals(other.accountManager))	// calls Employee.equals (composition)
			return false;
		if (accountNumber != other.accountNumber)					// check account number (primitive)
			return false;
		if (balance != other.balance)								// check balance (primitive)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))						// calls Customer.equals (composition)
			return false;
		return true;
	}

	/**
	 * Overriden clone that invokes the copy constructor
     * 
	 * @return a copy of this
	 */
    @Override
    public Account clone() {
        Account cloned = new Account(this);
        return cloned;
    }
}
