/*
	File:	SavingsAccountTest.java
	Author:	Alex Burdick
	Date:	4/18/2025

 	Description: Tests for methods in the SavingsAccount class.
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavingsAccountTest {

    // Member and parent objects
    Person personOne   = new Person("Arthur", "Hastings", "1231231234", new Date(4, 13, 1895));
    Person personTwo   = new Person("Hercules", "Poirot", "1234567890", new Date(6, 25, 1900));
    Person personThree = new Person("Eliza", "Dunn", "5558901234", new Date(11, 16, 1871));
    Person personFour  = new Person("Johnny", "Waverly", "5553456789", new Date(8, 18, 1925));
    Employee employeeOne = new Employee(personOne, new Date(11, 28, 1928), 121, "Investigations");
    Employee employeeTwo = new Employee(personTwo, new Date(2, 5, 1928), 434, "Investigations");
    Customer customerOne = new Customer(personThree, new Date(6, 1, 1931), "1234");
    Customer customerTwo = new Customer(personFour, new Date(1, 6, 1932), "4321");
    Account accountOne = new Account(10001, employeeOne, customerOne, new Date(10, 4, 1896));
    Account accountTwo = new Account(10002, employeeTwo, customerTwo, new Date(3, 15,1930));

    // Instatiate test variables
    SavingsAccount savingsAccountOne, savingsAccountTwo; // SavingsAccount objects (null pointer until initialized with "new")

    @BeforeEach
    public void setup() {
        savingsAccountOne = null; // clear object data before next test
        savingsAccountTwo = null; // clear object data before next test
    }

    @Test
    void testCopyContructor() {
        savingsAccountOne = new SavingsAccount(accountOne);
        savingsAccountTwo = new SavingsAccount(savingsAccountOne);
        assertEquals(savingsAccountOne, savingsAccountTwo);

        // call clone methods
        SavingsAccount savingsAccountThree = savingsAccountTwo.clone();
        assertEquals(savingsAccountThree, savingsAccountTwo);
    }

    @Test
    void testAddInterest() {
        savingsAccountOne = new SavingsAccount(accountOne); // instatiate test SavingsAccount
        double balance = savingsAccountOne.getBalance(); // get the current balance of savingsAccountOne
        double expectedTotal = balance + (balance * SavingsAccount.interestPercentage); // calculate the expected total
        double actualTotal = savingsAccountOne.addInterest(); // run the interest calculation

        assertEquals(expectedTotal, actualTotal); // should be the same
    }

    @Test
    void testEquals() {
        
        // owner
        savingsAccountOne = new SavingsAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        savingsAccountTwo = new SavingsAccount(10000, employeeOne, customerTwo, new Date(12, 9, 1930));
        assertFalse(savingsAccountOne.equals(savingsAccountTwo)); // should no longer be the same

        // dateCreated
        // This isn't tested by the equals method in the Account class so it should not affect result
        savingsAccountOne = new SavingsAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        savingsAccountTwo = new SavingsAccount(10000, employeeOne, customerOne, new Date(12, 9, 1931));
        assertTrue(savingsAccountOne.equals(savingsAccountTwo)); // should be the same

        // accountManager
        savingsAccountTwo.setManager(employeeTwo); // change the manager of one savings account
        assertFalse(savingsAccountOne.equals(savingsAccountTwo)); // should no longer be the same

        // accountNumber
        savingsAccountOne = new SavingsAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        savingsAccountTwo = new SavingsAccount(10001, employeeOne, customerOne, new Date(12, 9, 1930));
        assertFalse(savingsAccountOne.equals(savingsAccountTwo)); // should no longer be the same

        // balance
        savingsAccountOne = new SavingsAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        savingsAccountTwo = new SavingsAccount(10000, employeeOne, customerOne, new Date(12, 9, 1930));
        savingsAccountTwo.balance = 1; // change the balance of one savings account
        assertFalse(savingsAccountOne.equals(savingsAccountTwo)); // should no longer be the same

        // Not testing interest rate as it it static and final
    }
}