/*
	File:	BankDriver.java
	Author:	Alex Burdick
	Date:	4/19/2025

 	Description: The driver class for the Bank project
*/

public class BankDriver {
    
    public static void main(String args[]) {
        // Declare some test instances
        Person   p1 = new Person("Arthur", "Hastings", "1231231234", new Date(4, 13, 1895));
        Person   p2 = new Person("Hercules", "Poirot", "1234567890", new Date(6, 25, 1900));
        Person   p3 = new Person("Eliza", "Dunn", "5558901234", new Date(11, 16, 1871));
        Person   p4 = new Person("Johnny", "Waverly", "5553456789", new Date(8, 18, 1925));
        Person   p5 = new Person("Miss", "Lemon", "5555551234", new Date(7, 15, 1880));
        Employee e1 = new Employee(p1, new Date(11, 28, 1928), 121, "Investigations");
        Employee e2 = new Employee(p2, new Date(2, 5, 1928), 434, "Investigations");
        Customer c1 = new Customer(p3, new Date(6, 1, 1931), "1234");
        Customer c2 = new Customer(p4, new Date(1, 6, 1932), "4321");
        Customer c3 = new Customer(p5, new Date(9, 10,1932), "6065");
        Account  a1 = new Account(10001, e1, c1, new Date(10, 4, 1896));
        Account  a2 = new Account(10002, e2, c2, new Date(3, 15,1930));
        CheckingAccount checking = new CheckingAccount(a1);
        SavingsAccount  savings  = new SavingsAccount(a2);
        Account         account  = new Account(10003, c3, new Date (9, 10,1932), 300);
        
        // set values to balances
        checking.deposit(Math.abs(CheckingAccount.overdraftLimit));
        savings.deposit(200);

        // intitialize Bank object
        Bank bank = new Bank();
        // add accounts to banks accounts arraly list
        bank.openAccount(checking);
        bank.openAccount(savings);
        bank.openAccount(account);
        // print the accounts as they are before modification
        System.out.println(bank); // calls the toStrings of each of the classes

        // update all instances of various accounts in bank
        // this should put the balance exactly at the overdraft limit
        bank.getAccounts().get(0).withdraw(Math.abs(CheckingAccount.overdraftLimit) * 2); // this is ca
        bank.updateAccounts();

        System.out.println(bank); // calls the toStrings of each of the classes
    }
}