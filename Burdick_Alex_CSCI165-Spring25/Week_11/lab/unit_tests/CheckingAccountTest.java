/*
	File:	CheckingAccountTest.java
	Author:	Alex Burdick
	Date:	4/19/2025

 	Description: Tests for methods in the CheckingAccount class.
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckingAccountTest {
    
    // Member and parent objects
    Person personOne     = new Person("Arthur", "Hastings", "1231231234", new Date(4, 13, 1895));
    Person personTwo     = new Person("Hercules", "Poirot", "1234567890", new Date(6, 25, 1900));
    Person personThree   = new Person("Eliza", "Dunn", "5558901234", new Date(11, 16, 1871));
    Person personFour    = new Person("Johnny", "Waverly", "5553456789", new Date(8, 18, 1925));
    Employee employeeOne = new Employee(personOne, new Date(11, 28, 1928), 121, "Investigations");
    Employee employeeTwo = new Employee(personTwo, new Date(2, 5, 1928), 434, "Investigations");
    Customer customerOne = new Customer(personThree, new Date(6, 1, 1931), "1234");
    Customer customerTwo = new Customer(personFour, new Date(1, 6, 1932), "4321");
    Account accountOne   = new Account(10001, employeeOne, customerOne, new Date(10, 4, 1896));
    Account accountTwo   = new Account(10002, employeeTwo, customerTwo, new Date(3, 15,1930));

    // Instatiate test variables
    CheckingAccount checkingAccountOne, checkingAccountTwo; // CheckingAccount objects (null pointer until initialized with "new")

    @BeforeEach
    public void setup() {
        checkingAccountOne = null; // clear object data before next test
        checkingAccountTwo = null; // clear object data before next test
    }

    @Test
    void testCopyContructor() {
        // invoke copy constructor
        checkingAccountOne = new CheckingAccount(accountOne);
        checkingAccountTwo = new CheckingAccount(checkingAccountOne);
        assertEquals(checkingAccountOne, checkingAccountTwo);

        // call clone methods
        CheckingAccount checkingAccountThree = checkingAccountTwo.clone();
        assertEquals(checkingAccountThree, checkingAccountTwo);
    }

    @Test
    void testIsInOverdraft() {
        checkingAccountOne = new CheckingAccount(accountOne);

        checkingAccountOne.balance = 0; // amount is abouve overdraft limit
        assertFalse(checkingAccountOne.isInOverdraft()); // should not be in overdraft

        checkingAccountOne.balance = CheckingAccount.overdraftLimit; // amount is equal to overdraft limit
        assertTrue(checkingAccountOne.isInOverdraft()); // should be in overdraft

        checkingAccountOne.balance = CheckingAccount.overdraftLimit - 1; // amount is less than overdraft limit
        assertTrue(checkingAccountOne.isInOverdraft()); // should be in overdraft
    }

    @Test
    void testWithdraw() {
        checkingAccountOne = new CheckingAccount(accountOne);
        // amount to withdraw is the absolute value of the overdraft limit
        double withdrawal = Math.abs(CheckingAccount.overdraftLimit);
        // amount in the checking account is the absolute value of the overdraft limit
        checkingAccountOne.balance = Math.abs(CheckingAccount.overdraftLimit);
        
        double expectedBalance = checkingAccountOne.balance - withdrawal; // difference is 0
        checkingAccountOne.withdraw(withdrawal);
        double actualBalance = checkingAccountOne.balance; // difference should be 0, greater than overdraft limit
        assertEquals(expectedBalance, actualBalance);

        expectedBalance = checkingAccountOne.balance - withdrawal; // different is overdraft limit
        checkingAccountOne.withdraw(withdrawal);
        actualBalance = checkingAccountOne.balance; // difference should be equal to overdraft limit
        assertEquals(expectedBalance, actualBalance);

        expectedBalance = checkingAccountOne.balance; // balance should not change this time
        checkingAccountOne.withdraw(withdrawal); // should not allow withdrawal
        actualBalance = checkingAccountOne.balance; // should not be less than overdraft limit
        assertEquals(expectedBalance, actualBalance); // should be the same (unchanged)
    }

    @Test
    void testEquals() {
        // owner
        checkingAccountOne = new CheckingAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        checkingAccountTwo = new CheckingAccount(10000, employeeOne, customerTwo, new Date(12, 9, 1930));
        assertFalse(checkingAccountOne.equals(checkingAccountTwo)); // should no longer be the same

        // dateCreated
        // This isn't tested by the equals method in the Account class so it should not affect result
        checkingAccountOne = new CheckingAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        checkingAccountTwo = new CheckingAccount(10000, employeeOne, customerOne, new Date(12, 9, 1931));
        assertTrue(checkingAccountOne.equals(checkingAccountTwo)); // should be the same

        // accountManager
        checkingAccountTwo.setManager(employeeTwo); // change the manager of one savings account
        assertFalse(checkingAccountOne.equals(checkingAccountTwo)); // should no longer be the same

        // accountNumber
        checkingAccountOne = new CheckingAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        checkingAccountTwo = new CheckingAccount(10001, employeeOne, customerOne, new Date(12, 9, 1930));
        assertFalse(checkingAccountOne.equals(checkingAccountTwo)); // should no longer be the same

        // balance
        checkingAccountOne = new CheckingAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        checkingAccountTwo = new CheckingAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        checkingAccountTwo.balance = 1; // change the balance of one savings account
        assertFalse(checkingAccountOne.equals(checkingAccountTwo)); // should no longer be the same

        // Not testing overdraft limit as it it static and final
    }
}