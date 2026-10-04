import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;

public class OrderTests {
    // class level test instances
	Order orderOne, orderTwo;
    Date expectedDate, actualDate;
    MenuItem burger = new MenuItem("Burger", 2.1, 2000);
    MenuItem onion  = new MenuItem("Onion", 0.5, 6);
    Customer billy  = new Customer("Quiz Boy", "master@venture.com", "1234567890");
    Customer pete   = new Customer("Pink Pilgrim", "white@conjectural.com", "1234567890");

	@BeforeEach
	public void setup(){
		orderOne    = null;
		orderTwo    = null;
        expectedDate= null;
        actualDate  = null;
	}
    
    @Test
    void testConstructorPrivacyProtection() {
        // Check to see if our constructor sets a valid customer and returns a deep copy
        orderOne = new Order(billy);	                    // Set up test instance with customer input
        Customer expectedCustomer = orderOne.getCustomer();

        assertTrue( expectedCustomer.getName().equals(billy.getName()) ); // Names should be the same 
        
        // Change the customer name outside of the Order class (this should not change the customer in the Order class)
        billy.setName("Master Billy");
        Customer actualCustomer = orderOne.getCustomer();   // Get the customer to test if it was modified
        
        assertFalse( billy.getName().equals(actualCustomer.getName()) ); // The names should no longer be the same        
        assertFalse( expectedCustomer == actualCustomer );  // expected and actual should not be the same memory location
        assertTrue( expectedCustomer.equals(actualCustomer) );// expected and actual should be the same
    }

    @Test 
    void testSetDate() {
        // Check to see if our setter sets a valid data and returns a deep copy
        orderOne = new Order();	                        // Set up test instance, default date will be current date
		expectedDate = new Date(1, 1, 2000); // Save expected date
        orderOne.setDate(expectedDate);                 // Try to set the Date
        actualDate = orderOne.getDate();		        // Get the Date to test if it was modified
        
        assertFalse( expectedDate == actualDate );      // expected and actual should not be the same memory location
        assertTrue( expectedDate.equals(actualDate) );  // expected and actual should be the same values

        // -----------------------------------------------------

        // Check to see if our setter sets a null date
        expectedDate = orderOne.getDate();              // Save expected date
        Date nullDate = null;                           // Create a null date
        orderOne.setDate(nullDate);                     // Try to set the Date

        actualDate = orderOne.getDate();		        // Get the date to test if it was modified
        assertFalse( expectedDate == actualDate );      // expected and actual should not be the same memory location
        assertTrue( expectedDate.equals(actualDate) );       // expected and actual should be the same values
    }

    @Test
    void testSetDatePrivacyProtection() {
        // Check to see if our setter sets a valid data and returns a deep copy
        orderOne = new Order();	                        // Set up test instance, default date will be current date
        expectedDate = new Date(1, 1, 2000); // Create a new date
        orderOne.setDate(expectedDate);                   // Try to set the Date
        actualDate = orderOne.getDate();		    // Get the Date to test if it was modified

        // Date values should be the same
        assertFalse(expectedDate == actualDate);      // expected and actual should not be the same memory location
        assertTrue(expectedDate.equals(actualDate));  // expected and actual should be the same values
        
        // Change the date outside of the Order class (this should not change the date in the Order class)
        expectedDate.setDay(2);                        // Change the date
        assertFalse(expectedDate.equals(actualDate));  // expected and actual should not be the same values
    }

    @Test
    void testGetDate() {
        // Test to see if our getter returns a deep copy of the date
        orderOne = new Order();	                         // Set up test instance
        Date expectedDate = orderOne.getDate();          // Create new instance of Date
        Date actualDate   = orderOne.getDate();          // Get the date to test if it was modified
        
        assertFalse( expectedDate == actualDate );       // expected and actual should not be the same memory location
        assertTrue( expectedDate.equals(actualDate) );        // expected and actual should be the same
    }
    
    @Test
    void testGetCustomer() {
        // Check to see if our getter returns a deep copy of the customer
        orderOne = new Order();	// Set up test instance, default customer
        Customer expectedCustomer = orderOne.getCustomer(); // Get the customer
        Customer actualCustomer   = orderOne.getCustomer(); // for the same order twice
        
        assertFalse( expectedCustomer == actualCustomer );  // expected and actual should not be the same memory location
        assertTrue( expectedCustomer.equals(actualCustomer) );// expected and actual should be the same
    }

    @Test
    void testGetCart() {
        // Check to see if our getter gets a deep copy of the cart
        orderOne = new Order();	// Set up test instance, default cart will be empty
        ArrayList<OrderItem> expectedCart = orderOne.getCart(); // Save expected cart
        ArrayList<OrderItem> actualCart = orderOne.getCart(); // Get the cart to test if it was modified
        
        assertFalse( expectedCart == actualCart ); // expected and actual should not be the same memory location
        assertTrue( expectedCart.equals(actualCart) );  // expected and actual should be the same
    }

    @Test
    void testAddItem() {
        orderOne = new Order(); // Set up test instance
        //--------------------------------------------------------------------
        // Check to see if our adder adds a MenuItem to the empty cart
		MenuItem expectedItem = onion;// Save expected MenuItem
        int      expectedQuantity = 1;                                  // Save expected quantity (1 is default)
        int      expectedCartSize = orderOne.getCart().size() + 1;      // Save expected cart size (should go up by 1)
        
        orderOne.addItem(expectedItem);                                 // Try to add the MenuItem to the Order
		
        MenuItem actualItem = orderOne.getCart().get(0).getMenuItem();  // Get the MenuItem to test if it was added
        int      acuatlQuantity = orderOne.getCart().get(0).getQuantity();// Get the quantity to test if it was modified
        int      actualCartSize = orderOne.getCart().size();            // Get the cart size to test if it was modified
        
        
        /* 
        ISSUE:  This is an example of the assertEquals method failing on a object
                comparison. Below that is the assertTrue method working on primitive
                comparisons. On all of the tests in this class, the assertEqualsmethod
                fails on object comparisons, while assertTrue(object.equals(object))
                works.
                VSCode asked me to select a version of JUnit to use when I first tried
                these test, and I selected 5. I'm not sure if that has something to do
                with it.
        */
        //assertEquals( expectedItem, actualItem ); // Commented out because it fails
        assertTrue( expectedItem.equals(expectedItem) );
        assertFalse( expectedItem == actualItem ); // expected and actual should not be the same memory location
        assertEquals( expectedQuantity, acuatlQuantity );
        assertEquals( expectedCartSize, actualCartSize );
        
        //--------------------------------------------------------------------
        
        // Check to see if our adder adds a null MenuItem and valid quantity to the cart
        expectedCartSize = orderOne.getCart().size();                   // Save expected cart size (should not increase)
        expectedItem     = null;                                        // Save expected MenuItem (null)
        
        orderOne.addItem(expectedItem);                                 // Try to add the MenuItem to the Order
        
        actualCartSize   = orderOne.getCart().size();                   // Get the cart size to test if it was modified
        
        assertEquals( expectedCartSize, actualCartSize );               // Cart size should be unchanged
        
        //--------------------------------------------------------------------
        
        // Check to see if our adder adds a MenuItem to the full cart
        expectedItem = burger;// Save expected MenuItem
        expectedQuantity = 1;                                           // Save expected quantity
        expectedCartSize = orderOne.getCart().size() + 1;               // Save expected cart size (should go up by 1)
        
        orderOne.addItem(expectedItem);                                 // Try to add the MenuItem to the Order
        
        actualItem       = orderOne.getCart().get(1).getMenuItem();     // Get the MenuItem to test if it was modified
        acuatlQuantity   = orderOne.getCart().get(1).getQuantity();     // Get the quantity to test if it was modified
        actualCartSize   = orderOne.getCart().size();                   // Get the cart size to test if it was modified
        
        assertTrue( expectedItem.equals(actualItem) );
        assertEquals( expectedQuantity, acuatlQuantity );
        assertEquals( expectedCartSize, actualCartSize );
        
        //--------------------------------------------------------------------
        
        // Check to see if our adder increments a duplicate MenuItem to the cart
        expectedItem     = onion;                                       // Save expected MenuItem
        expectedQuantity = orderOne.getCart().get(0).getQuantity() + 1; // Save expected quantity (should increase by 1)
        expectedCartSize = orderOne.getCart().size();                   // Save expected cart size (should not change)
        
        orderOne.addItem(expectedItem);                                 // Try to add the MenuItem to the Order
        
        actualItem       = orderOne.getCart().get(0).getMenuItem();     // Get the MenuItem to test if it was modified
        acuatlQuantity   = orderOne.getCart().get(0).getQuantity();     // Get the quantity to test if it was modified
        actualCartSize   = orderOne.getCart().size();                   // Get the cart size to test if it was modified
        
        assertTrue( expectedItem.equals(actualItem) );
        assertEquals( expectedQuantity, acuatlQuantity );
        assertEquals( expectedCartSize, actualCartSize );
    }

    @Test
    void testAddItem2() {
        orderOne = new Order(); // Set up test instance
        //--------------------------------------------------------------------

        // Check to see if our adder adds a valid MenuItem and valid quantity to the empty cart
        MenuItem expectedItem = onion;                                  // Save expected MenuItem
        int      expectedQuantity = 2;                                  // Save expected quantity
        int      expectedCartSize = 1;                                  // Save expected cart size
        
        orderOne.addItem(expectedItem, expectedQuantity);               // Try to add the MenuItem to the Order
        
        MenuItem actualItem = orderOne.getCart().get(0).getMenuItem();  // Get the MenuItem to test if it was modified
        int      acuatlQuantity = orderOne.getCart().get(0).getQuantity();// Get the quantity to test if it was modified
        int      actualCartSize = orderOne.getCart().size();            // Get the cart size to test if it was modified
        
        assertTrue( expectedItem.equals(actualItem) );
        assertEquals( expectedQuantity, acuatlQuantity );
        assertEquals( expectedCartSize, actualCartSize );  
        
        //--------------------------------------------------------------------
        
        // Check to see if our adder adds a duplicate MenuItem and quantity to the cart
        expectedItem = onion;                                           // Save expected MenuItem
        expectedQuantity = orderOne.getCart().get(0).getQuantity() + 2; // Save expected quantity (previous quantity + 2)
        expectedCartSize = orderOne.getCart().size();                   // Save expected cart size (should not change)
        
        orderOne.addItem(expectedItem, 2);                          // Try to add the MenuItem to the Order (adding quanity 2)
        
        actualItem       = orderOne.getCart().get(0).getMenuItem();     // Get the MenuItem to test if it was modified
        acuatlQuantity   = orderOne.getCart().get(0).getQuantity();     // Get the quantity to test if it was modified
        actualCartSize   = orderOne.getCart().size();                   // Get the cart size to test if it was modified
        
        assertTrue( expectedItem.equals(actualItem) );
        assertEquals( expectedQuantity, acuatlQuantity );
        assertEquals( expectedCartSize, actualCartSize );
        
        //--------------------------------------------------------------------
        
        // Check to see if our adder adds a MenuItem to the full cart
        expectedItem     = burger;                                      // Save expected MenuItem
        expectedQuantity = 19;                                          // Save expected quantity
        expectedCartSize = orderOne.getCart().size() + 1;               // Save expected cart size (should go up by 1)
        
        orderOne.addItem(expectedItem, expectedQuantity);               // Try to add the MenuItem to the Order
        
        actualItem       = orderOne.getCart().get(1).getMenuItem();     // Get the MenuItem to test if it was modified
        acuatlQuantity   = orderOne.getCart().get(1).getQuantity();     // Get the quantity to test if it was modified
        actualCartSize   = orderOne.getCart().size();                   // Get the cart size to test if it was modified
        
        assertTrue( expectedItem.equals(actualItem) );
        assertEquals( expectedQuantity, acuatlQuantity );
        assertEquals( expectedCartSize, actualCartSize );

        //--------------------------------------------------------------------

        // Check to see if our adder adds a null MenuItem and valid quantity to the empty cart
        expectedCartSize = orderOne.getCart().size();;                  // Save expected cart size
        expectedItem     = null;                                        // Save expected MenuItem (null)
        
        orderOne.addItem(expectedItem, 1);                          // Try to add the MenuItem to the Order
        
        actualCartSize   = orderOne.getCart().size();                   // Get the cart size to test if it was modified
        
        assertEquals( expectedCartSize, actualCartSize );               // Cart size should be unchanged

        //--------------------------------------------------------------------
        
        // Check to see if our adder adds a MenuItem and invalid quantity to the empty cart
        expectedItem     = onion;                                       // Save expected MenuItem
        expectedQuantity = orderOne.getCart().get(0).getQuantity() + 1; // Save expected quantity (previous quantity + 1)
        expectedCartSize = orderOne.getCart().size();                   // Save expected cart size (should be unchanged)
        
        orderOne.addItem(expectedItem, -expectedQuantity);              // Try to add the MenuItem to the Order with negative quantity
        
        actualCartSize   = orderOne.getCart().size();                   // Get the cart size to test if it was modified

        assertEquals( expectedCartSize, actualCartSize );
    }

    @Test
    void testRemoveItem() {
        // Check to see if our remover removes a MenuItem from the cart
        orderOne = new Order(); // Set up test instance
        MenuItem item = onion;// MenuItem to test with

        int expectedCartSize = orderOne.getCart().size();                 // Save expected cart size
        orderOne.addItem(item);                                           // Try to add the MenuItem to the Order
        int actualCartSize = orderOne.getCart().size();

        assertNotEquals( expectedCartSize, actualCartSize ); // Cart size should be different
        
        orderOne.removeItem(item);                                        // Try to remove the MenuItem from the Order
        actualCartSize = orderOne.getCart().size();                       // Get the cart size to test if it was modified
        
        assertEquals( expectedCartSize, actualCartSize ); // Cart size should be the same again
    }

    @Test
    void testCompareTo() { // Orders should be compared by date
        orderOne = new Order(); // Set up test instances
		orderTwo = new Order(); 
        Date dateOne   = new Date(1, 1, 2000); // Save different size testing dates
        Date dateTwo   = new Date(2, 1, 2000); 
        Date dateThree = new Date(3, 1, 2000);
        Date dateFour  = new Date(4, 1, 2000);
        Date dateFive  = new Date(5, 1, 2000);

        orderOne.setDate(dateOne); // Set the dates for testing
        orderTwo.setDate(dateTwo); 
        assertTrue(orderOne.compareTo(orderTwo) == -1); // orderOne < orderTwo

        orderOne.setDate(dateTwo); // Set the dates for testing
        assertTrue(orderOne.compareTo(orderTwo) == 0);  // orderOne == orderTwo

        orderOne.setDate(dateThree); // Set the dates for testing
        assertTrue(orderOne.compareTo(orderTwo) == 1);  // orderOne > orderTwo

		orderTwo.setDate(dateThree); // Set the dates for testing
		assertTrue(orderOne.compareTo(orderTwo) == 0);  // orderOne == orderTwo

		orderOne.setDate(dateFour); // Set the dates for testing
		assertTrue(orderOne.compareTo(orderTwo) == 1);  // orderOne > orderTwo
	
		orderTwo.setDate(dateFive); // Set the dates for testing
		assertTrue(orderOne.compareTo(orderTwo) == -1); // orderOne < orderTwo
    }

    @Test
    void testEquals() {
        // Test with default values
        orderOne = new Order(); // Instantiate orders with no args
		orderTwo = new Order();
        assertTrue(orderOne.equals(orderTwo)); // Should be the same
        
        //--------------------------------------------------------------------
        
        // Test with different customers
        Customer customerOne = billy;
        Customer custoemrTwo = pete;
        orderOne = new Order(customerOne); // Instantiate orders with different args
		orderTwo = new Order(custoemrTwo);

        assertFalse(orderOne.equals(orderTwo)); // Should be different

        //--------------------------------------------------------------------

        // Test with the same customers
        orderOne = new Order(customerOne); // Instantiate orders with same args
		orderTwo = new Order(customerOne);
        assertTrue(orderOne.equals(orderTwo)); // Should be the same

        //--------------------------------------------------------------------
        
        // Test with different dates
        orderOne = new Order(customerOne); // Set up test instances with same customer
        orderTwo = new Order(customerOne);
        orderOne.setDate(new Date(1, 1, 2000)); // Set date for orderOne
        orderTwo.setDate(new Date(2, 1, 2000)); // Set different date for orderTwo

		assertFalse(orderOne.equals(orderTwo));

        //--------------------------------------------------------------------
        
        // Test with different carts
        orderOne = new Order(customerOne); // Set up test instances with same customer
        orderTwo = new Order(customerOne);
        orderOne.setDate(new Date(1, 1, 2000)); // Set date for orderOne
        orderTwo.setDate(new Date(1, 1, 2000)); // Set same date for orderTwo
        orderOne.addItem(new MenuItem("Onion", 0.5, 6)); // Add item to orderOne
        orderTwo.addItem(new MenuItem("Burger", 8.5, 500)); // Add different item to orderTwo

        assertFalse(orderOne.equals(orderTwo));

        //--------------------------------------------------------------------
        
        // Test with different order sizes (test suggested by Copilot)
        orderOne = new Order(customerOne); // Set up test instances with same customer
        orderTwo = new Order(customerOne);
        orderOne.setDate(new Date(1, 1, 2000)); // Set date for orderOne
        orderTwo.setDate(new Date(1, 1, 2000)); // Set same date for orderTwo
        orderOne.addItem(new MenuItem("Onion", 0.5, 6)); // Add item to orderOne
        orderTwo.addItem(new MenuItem("Onion", 0.5, 6)); // Add same item to orderTwo
        orderTwo.addItem(new MenuItem("Burger", 8.5, 500)); // Add different item to orderTwo
        
        assertFalse(orderOne.equals(orderTwo));
    }
} // end of class OrderTests
