/*
	File:	Driver.java
	Author:	Alex Burdick
	Date:	4/16/2025

 	Description: Driver for the Bank application.
*/

public class Driver {

    public static void main(String args[]) {
        // Instatiate a Person object with no null values for testing
        Person personOne = new Person("New", "Person", "1231231234", new Date(11, 10, 1967));

        //demoEmployee(personOne);
        //demoCustomer(personOne);
        //demoAccount(personOne);
        demoSavings(personOne);
        demoChecking(personOne);

    } // end main

    public static void demoEmployee(Person personOne) {
        System.out.println("-- EMPLOYEE TEST --" + "\n");

        /* The no argument constructor will below have null pointers in person, date, and department.
         * I decided to remove the no argument constructor as I don't want to allow an Employee object
         * without at least the name fields. */                             
        //Employee employee    = new Employee()employeeTwo;     
        
        Employee employeeOne  = new Employee( personOne,
                                              new Date(5, 30, 1980),
                                              6789,
                                              "Accounting"); // No null values
        
        /* Using the constructor that takes all fields for Employee, but not all fields for Person. There will
         * be null pointers for the member objects in Person e.g. Date DOB. There is also a null value for 
         * phoneNumber which would cause an error. I set a defualt value for phoneNumber so it won't be null. */                       
        Employee employeeTwo   = new Employee(new Person("New", "Person"),
                                                         new Date(1, 1, 1970), 
                                                         1234, 
                                                         "Sales");    
        
        // This will also have null pointers in Date objects and custID.
        Employee employeeThree = new Employee("Test", "User");
        
        /* The copy constructor will get null pointer errors when using trying to call the setters of objects that
         * are null, the Date fields in this case. */
        Employee employeeFour  = new Employee(employeeThree);
        /* When an instance of the Person class is created, it will have a null pointer in the Date objects if they
         * are not explicity set by the constructor. This would then cause null pointer errors when using trying to 
         * use Date methods like the getters and setters (as in the copy constructor).
         * To use the copy constructor I updated the Date setter methods in Person, Customer, and Employee classes 
         * to account for nulls. I didn't change the Date class because that may be used in other contexts which
         * should not have a Date or should have default values.
         * 
         * The copy constructor was also failing to copy the String value phoneNumber. The copy constructor called 
         * getPhoneNumber on the instance of Person to be copied, which returned a formatted String longer than 10
         * characters. Then the overloaded constructer passed the formatted String to setPhoneNumber, which ignored
         * because it was too long and set the phoneNumber of the new instance to the default value. To fix this I
         * added a new getter that just returned the phoneNumber unformatted for use in the copy constructor.
         */
                  
        //System.out.println(employee);
        /* Encouters null pointer when trying to execute "String.length()" in Person setPhoneNumber
         * Attempts to call any of the others' toString have the same problem because the Person
         * object instance variables are all defaulting to null.
         */
        
        /* employeeOne will have non-null values in all fields, including super class and member object fields. 
         * employeeTwo will have a null for super class fields DOB and the the default value for phoneNumber.
         * employeeThree will have a null for super class fields DOB and the the default value for phoneNumber, as
         * well as a null for hireDate and department. employeeFour is the same as employeeThree.
         */
        System.out.println("1:\n" + employeeOne + "\n");
        System.out.println("2:\n" + employeeTwo + "\n");
        System.out.println("3:\n" + employeeThree + "\n");
        System.out.println("4:\n" + employeeFour + "\n");
    }

    public static void demoCustomer(Person personOne) {
        System.out.println("-- CUSTOMER TEST --" + "\n");
        
        // Instantiate Customer using the all fields constructor
        Customer customerOne = new Customer("Buyer", 
                                            "Beware", 
                                            "5553334124", 
                                            new Date(2,2,2000), 
                                            new Date(12, 14, 2015), 
                                            "id123"
                                           ); // no null values
        
        // Constructor accepting Person object as argument.
        Customer customerTwo = new Customer(personOne, new Date(), "0000");
        
        // customerOne will have no null values or defualt values
        // customerTwo joinedDate will be the default set by the Date class - 1/1/1000.
        System.out.println(customerOne + "\n");
        System.out.println(customerTwo + "\n");
    }

    public static void demoAccount(Person personOne) {
        System.out.println("-- ACCOUNT TEST --" + "\n");

        Employee employeeOne  = new Employee(personOne,
                                new Date(5, 30, 1980),
                                6789,
                                "Accounting"); // no null values

        Customer customerOne = new Customer("Buyer", 
                                            "Beware", 
                                            "5553334124", 
                                            new Date(2,2,2000), 
                                            new Date(12, 14, 2015), 
                                            "id123"
                                           ); // no null values
        
        // Instantiate Account objects
        Account accountOne = new Account(10001, customerOne, new Date(9,10, 2022), 100.00);
        Account accountTwo = new Account(10002, employeeOne, customerOne, new Date(3, 2, 2019));

        System.out.println(accountOne + "\n");
        System.out.println(accountTwo + "\n");
    }

    public static void demoSavings(Person personOne) {

    }

    public static void demoChecking(Person personOne) {

    }


} // end Driver class