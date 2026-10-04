import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerTests {
    // class level test instances
    Customer customerOne, customerTwo;

    @BeforeEach
    public void setup(){
        customerOne = null; // kill current instance, hand over to garbage collector
        customerTwo = null; // kill current instance, hand over to garbege collector
    }

    @Test
    public void testSetName(){
        // check to see if our setter sets the name variable correctly
        customerOne = new Customer();	            // set up test instance
		
        String expectedName = "User Tester";		// save expected name
		customerOne.setName(expectedName);	        // try to set valid value
		String actualName = customerOne.getName();	// get the name to test if it was modified

        assertEquals( expectedName, actualName );	// use assertEquals. actualName should be the same
    }

    @Test
    public void testSetEmail(){
        // check to see if setter allows valid data to pass
        customerOne = new Customer();	                // set up test instance
        String expectedEmail = "test@mail.com";         // save expected email
        customerOne.setEmail(expectedEmail);            // try to set valid value
        String actualEmail = customerOne.getEmail();    // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the same

        // check to see if our setter catches @ symbol at the beginning of the email
        customerOne = new Customer();	                // set up test instance
        expectedEmail = customerOne.getEmail();         // save expected email (default value)
        customerOne.setEmail("@testmail.com");    // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified
		// check to see if the setter allows valid data to pass

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the same

        // check to see if our setter catches @ symbol at the end of the email
        customerOne = new Customer();	                // set up test instance
        expectedEmail = customerOne.getEmail();         // save expected email (default value)
        customerOne.setEmail("testmail.com@");    // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the same

        // check to see if our setter catches @ symbol in top level domain
        customerOne = new Customer();	                // set up test instance
        expectedEmail = customerOne.getEmail();         // save expected email (default value)
        customerOne.setEmail("test.mail@com");    // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the same

        // check to see if our setter catches email with more than 64 characters before the @ symbol
        customerOne = new Customer();	                // set up test instance
        expectedEmail = customerOne.getEmail();         // save expected email (default value)
        customerOne.setEmail("1234567890.1234567890.1234567890.1234567890.1234567890.1234567890@mail.com"); // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actalEmail should be the same

        // check to see if our setter allows email with exactly 64 characters before the @ symbol
        // also check to see if it allows dots in the prefix
        customerOne = new Customer();	                // set up test instance
        expectedEmail = "1234567890.1234567890.1234567890.1234567890.12345678901234567890@mail.com"; // save expected email 
        customerOne.setEmail(expectedEmail);                         // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the same
        
        // check to see if our setter catches email with . at the beginning
        customerOne = new Customer();	                // set up test instance
        expectedEmail = customerOne.getEmail();         // save expected email (default value)
        customerOne.setEmail(".test@mail.com");   // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the same
        
        // check to see if our setter catches email with . at the end
        customerOne = new Customer();	                // set up test instance
        expectedEmail = customerOne.getEmail();         // save expected email (default value)
        customerOne.setEmail("test@mail.com.");   // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the sameprefix

        // check to see if our setter catches email with ..
        customerOne = new Customer();	                // set up test instance
        expectedEmail = customerOne.getEmail();         // save expected email (default value)
        customerOne.setEmail("test@mail..com");   // try to set invalid value
        actualEmail = customerOne.getEmail();           // get the email to test if it was modified

        assertEquals( expectedEmail, actualEmail );	    // use assertEquals. actualEmail should be the same
    }

    @Test
    public void testSetPhone(){
        // check to see if setter allows valid data to pass
        customerOne = new Customer();	                // set up test instance
        String expectedPhone = "1234567890";            // save expected phone
        customerOne.setPhone(expectedPhone);            // try to set valid value
        String actualPhone = customerOne.getPhone();    // get the phone to test if it was modified

        assertEquals( expectedPhone, actualPhone );	    // use assertEquals. actualPhone should be the same

        // check to see if our setter catches phone number with more than 10 characters
        customerOne = new Customer();	                // set up test instance
        expectedPhone = customerOne.getPhone();         // save expected phone (default value)
        customerOne.setPhone("12345678901");      // try to set invalid value
        actualPhone = customerOne.getPhone();           // get the phone to test if it was modified

        assertEquals( expectedPhone, actualPhone );	    // use assertEquals. actualPhone should be the same
    }

    @Test
	public void testCompareTo(){
		customerOne = new Customer("Test First",  "test@mail.com", "1234567890");
		customerTwo = new Customer("User Second", "test@mail.com", "1234567890");
		assertTrue(customerOne.compareTo(customerTwo) < 0);

		customerOne.setName("User Second");
		assertTrue(customerOne.compareTo(customerTwo) == 0);

		customerOne.setName("Test User");
		assertTrue(customerOne.compareTo(customerTwo) > 0);

		customerTwo.setName("Test User");
		assertTrue(customerOne.compareTo(customerTwo) == 0);

		customerOne.setName("Test X");
		assertTrue(customerOne.compareTo(customerTwo) > 1);
	
		customerTwo.setName("Test Zest");
		assertTrue(customerOne.compareTo(customerTwo) < 0);
	}

} // end class CustomerTests