public class Driver {
    public static void main(String[] args) {
        // Instantiate objects
        Person p1 = new Person("John", "Middlecoff", "0987654321", new Date(5, 12, 1982));
        Person p2 = new Person("Colin", "Cowherd", "1234567890", new Date(10, 6, 1961));
        Customer c = new Customer(p1, new Date(4, 28, 2025), "J001");
        Employee e = new Employee(p2, new Date(8, 20, 2016), 844, "Sports");
        CheckingAccount checking = new CheckingAccount(11122, e, c, new Date(4, 28,2025), 0);
        SavingsAccount savings = new SavingsAccount(33344, e, c, new Date(4, 29, 2025), 1000);

        // Call methods
        testCheckingDeposit(checking);

        /* 
        testSavingsWithdraw(savings);
        testCheckingWithdraw(checking);
        testAccountNumber(checking);
        testCustomerID(c);
        */
    }


    public static void testCheckingDeposit(CheckingAccount checking) {
        System.out.println(" -- Test the CHECKING account DEPOSIT method --");
        
        // Deposit a valid amount
        try {
            checking.deposit(10);
            System.out.println("Balance = " + checking.getBalance());
        } catch (InvalidBalanceException e) {
            throw new RuntimeException("Test error: " + e.getMessage());
        }

        // Exceed maximum checking account balance
        try {
            checking.deposit(1000);
            System.out.println("Balance = " + checking.getBalance());
        } catch (InvalidBalanceException e) {
            throw new RuntimeException("Test error: " + e.getMessage());
        }

        // Try a negative number
        try {
            checking.deposit(-10);
            System.out.println("Balance = " + checking.getBalance());
        } catch (InvalidBalanceException e) {
            throw new RuntimeException("Test error: " + e.getMessage());
        }
    }

    public static void testSavingsWithdraw(SavingsAccount savings) {
        System.out.println("\n -- Test the SAVINGS account WITHDRAW method --");

        // Withdraw a valid amount
        try {
            savings.withdraw(10);
            System.out.println("First withdrawal balance = " + savings.getBalance());
        } catch (InvalidBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (OverdraftException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Withdraw too much
        try {
            savings.withdraw(2000);
            System.out.println("PROBLEM: this should be too much");
        } catch (InvalidBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (OverdraftException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test max number of withdrawals (valid amount)
        try {
            savings.withdraw(10);
            System.out.println("Second withdrawal balance = " + savings.getBalance());
        } catch (InvalidBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (OverdraftException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Try again, this should be too many
        try {
            savings.withdraw(10); // this should not be allow
            System.out.println("Third withdrawal should not be allowed");
        } catch (InvalidBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (OverdraftException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void testCheckingWithdraw(CheckingAccount checking) {
        System.out.println("\n -- Test the CHECKING account WITHDRAW method --");
        
        // Withdraw valid amount
        try {
            checking.withdraw(10);
            System.out.println("Balance = " + checking.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Exceed overdraft limit
        try {
            checking.withdraw(100);
            System.out.println("PROBLEM = " + checking.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void testAccountNumber(CheckingAccount checking) {
        System.out.println("\n -- Test the set ACCOUNT NUMBER method --");

        // Test incorrect set
        try {
            checking.setAccountNumber(123);
            System.out.println("PROBLEM: " + checking.getAccountNumber());
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test correct set
        try {
            checking.setAccountNumber(12345);
            System.out.println("Account #: " + checking.getAccountNumber());
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void testCustomerID(Customer c) {
        System.out.println("\n -- Test the set CUSTOMER ID method --");

        // Test customer constructor - String with too many digits
        String incorrectID = "N1234";
        Customer cust = new Customer("Nick", "Wright", "5556667777", new Date(11, 19, 1985), new Date(2, 26, 2018), incorrectID);

        // Test setter - String without letter in front
        try {
            c.setID("123");
            System.out.println("PROBLEM: id should not be " + c.getID());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Test setter - String with not enough digits
        try {
            c.setID("A12");
            System.out.println("PROBLEM: id should not be " + c.getID());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test setter - correct String
        try {
            c.setID("A123");
            System.out.println("Customer ID: " + c.getID());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
