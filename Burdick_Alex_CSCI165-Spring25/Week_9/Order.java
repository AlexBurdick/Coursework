import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Order {

    // =========================================
	//  PRIVATE INSTANCE VARIABLES 
    // =========================================
    private Date date;
    private Customer customer;
    private String invoiceID;
    private ArrayList<OrderItem> cart = new ArrayList<OrderItem>();

    
    // =========================================
	//  CONSTRUCTORS
    // =========================================

    /**
	 * Default constructor - accepts no arguments
	 */
    public Order(){
        this(new Customer()); // Call other constructor with a new Customer object
    }

    /**
	 * Overloaded constructor - accepts Customer
     * 
	 * @param customer  Customer class passed in
	 */
    public Order(Customer customer){ 
        // Date
        setDate(new Date()); // Sets the date to current date
        // Customer
        this.customer = new Customer(customer); // Create a copy of the Customer instance
        // invoiceID
        invoiceID = createInvoiceID(customer, date); // Create a unique invoice number
        // The cart variable will automatically be initialized to an empty ArrayList
    }

    /**
	 * Copy constructror
	 * 
	 * @param today Order object to be deep copied
	 */
	public Order(Order toCopy){
		this.date      = new Date(toCopy.date); // Create a copy of the Date instance
		this.invoiceID = toCopy.invoiceID;
        this.customer  = new Customer(toCopy.customer); // Create a copy of the Customer instance
		this.cart      = toCopy.getCart(); // Create a copy of the cart
	}


    // =========================================
	//  GETTERS & SETTERS
    // =========================================

    /**
	 * Returns a copy of the date
	 * 
	 * @return Date
	 */
    public Date getDate()  { return new Date(date); }

    /**
	 * Returns a copy of the customer
	 * 
	 * @return Customer
	 */
    public Customer getCustomer()  { return new Customer(customer); }

    /**
	 * Returns the invoiceID
	 * 
	 * @return invoiceID
	 */
    public String getInvoiceID()  { return invoiceID; }

    /**
     * Returns a copy of the cart
     * According to the Java API https://docs.oracle.com/javase/8/docs/api/,
     * the ArrayList class has a clone method but not a copy method. The clone
     * method creates a shallow copy of the ArrayList. Other resources such as
     * Baeldung, W3Schools, GeeksforGeeks, and StackOverflow suggest using a 
     * loop to create a new ArrayList and add each item to the new ArrayList.
     * 
     * @return ArrayList copy of this cart
	 */
    public ArrayList<OrderItem> getCart() {
        // Create a new ArrayList to store the copied OrderItems
        ArrayList<OrderItem> newCart = new ArrayList<OrderItem>(cart.size());

        for (OrderItem item : cart) {
            // Create a copy of the OrderItem and add it to the new ArrayList
            // and copy the MenuItem instance as well
            OrderItem cartItem = new OrderItem(new MenuItem(item.getMenuItem()), item.getQuantity());
            // Add a copy of the OrderItem instance to the new ArrayList to be returned
            newCart.add(cartItem);
        }
        return newCart;
    }

     /**
	 * Sets the the date to a copy of a specified date
     * 
     * @param date The date to set
     */
    public void setDate(Date date){ 
        if (this.date == date) return; // Identity check
        if (date == null) return; // Null check for date
        this.date = new Date(date); // Set the date to a copy of the specified date
    }


    // =========================================
	//  EXPECTED METHODS
    // =========================================

    /**
     * Returns a string of all the values
     * 
     * @return String of all the values
     */
    public String toString(){
        return "Invoice ID: " + invoiceID + "\n" +         // invoiceID is already a String
               "Customer: " + customer.toString() + "\n" + // use Customer class toString method
               "Date: " + date.toString() + "\n" +         // use Date class toString method
               "Cart: " + cart.toString();                 // use ArrayList class toString method
    }

    /**
     * Returns true if the two object are deep equals
     * 
     * @return boolean true if all Fail conditions are false - guaranteed equality
     */
    public boolean equals(Order other){
        if (this == other)return true;	// Identity check
        if (other == null)return false;	// Null check

        return	this.date.equals(other.date)	      && // date should be the same
				this.customer.equals(other.customer)  && // cstomer should be the same
				this.invoiceID.equals(other.invoiceID)&& // invoiceID should be the same
                this.cart.equals(other.cart);			 // cart should be the same
    }

    /**
     * Compares Order objects based on date
     * 
     * @return int based on Date object compareTo method
     */
    public int compareTo(Order other){
        if (this == other)return 0;		// Identity check
        if (other == null)return -1;	// Null check

        // Compare the dates
        return date.compareTo(other.date);
    }


    // =========================================
	//  CART METHODS
    // =========================================

    /**
     * Adds one item to the cart.
     * If the item already exists in the cart, it will update the quantity.
     * 
     * @param item The OrderItem to add
     */
    public void addItem(MenuItem item){
        if (item == null) return; // Null check for item
        
        // Loop through the cart and add to an item if it equals the item passed in
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getMenuItem().equals(item)) { // If the MenuItem already exists in the cart
                cart.get(i).updateQuantity(1);      // Add one to the quantity of the OrderItem
                return;
            }
        }
        // If the item did not exist in the cart
        cart.add(new OrderItem(item, 1)); // add the new OrderItem to the cart with default quantity of 1
    }

    /**
     * Adds a specified number of items to the cart,
     * If the item already exists in the cart, it will update the quantity.
     * 
     * @param item The OrderItem to add
     * @param quantity The number of items to add
     */
    public void addItem(MenuItem item, int num){
        if (item == null) return; // Null check for item
            
        // Loop through the cart and add to an item if it equals the item passed in
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getMenuItem().equals(item)) {   // If the MenuItem already exists in the cart
                cart.get(i).updateQuantity(num);// add input number to the quantity of the OrderItem
                return;
            }
        }
        // If the item did not exist in the cart
        cart.add(new OrderItem(item, num)); // add the new OrderItem to the cart with input quantity
    }

    /**
     * Removes an item from the cart
     * 
     * @param item The OrderItem to add
     * @return OrderItem - The removed item
     */
    public OrderItem removeItem(MenuItem item){
        // Loop through the cart an item if it equals the item passed in
        for (OrderItem orderItem : cart) {
            if (orderItem.getMenuItem().equals(item)) { // If the MenuItem already exists in the cart
                cart.remove(orderItem); // Remove the OrderItem from the cart
                return orderItem; // Return the removed OrderItem
            }
        }
        return null; // If the item was not found, return null
    }
    

    // =========================================
    //  CALCULATION METHODS
    // =========================================

    /**
     * Calculates the total price of the items in the cart
     * 
     * @return double The total price
     */
    public double calculateTotal() {
        double total = 0.0; // Create a variable to store the total
        for (OrderItem item : cart) { // Loop through the OrderItems in the cart
            total += item.getMenuItem().getPrice() * item.getQuantity(); // Add the price of each item to the total
        }
        return total;
    }

    /**
     * Calculates the total calories of the items in the cart
     * 
     * @return int The total calories
     */
    public int calculateCalories() {
        int total = 0; // Create a variable to store the total
        for (OrderItem item : cart) { // Loop through the OrderItems in the cart
            total += item.getMenuItem().getCalories() * item.getQuantity(); // Add the calories of each item to the total
        }
        return total;
    }

    /**
     * Calculates the tax on the price of the items in the cart
     * 
     * @return double The tax
     */
    public double calculateTax(double total) {
        double tax = total * 0.06; // Tax at 6%
        return tax;
    }


    // =========================================
    //  OUTPUT METHODS
    // =========================================

    /**
	 * Foramt the order and write it to a file (receipt)
	 */
    public void writeToFile(){
        // Create variables to store numbers
		double subtotal = calculateTotal();       // Price
		int    calories = calculateCalories();    // Calories
		double tax      = calculateTax(subtotal); // Tax
		double total    = subtotal + tax;	      // Calculate the total price (subtotal + tax)
		
		// 	Use the createInvoiceID method to generate a unique invoice number (modify if you want)
		String receipt = String.format(
			"-- RECEIPT --\n" +
			"Invoice #: " + createInvoiceID(customer, date) + "\n" +
            "Date: " + date + "\n" +
            "\n" +
            formatOrder(cart) + // Builds the order section of the receipt including separators
            "Total calories: %d" +"\n\n" +
            "Subtotal:  %.2f\n" +
            "Sales tax: %.2f\n" +
            "Total:     %.2f\n",
            calories, subtotal, tax, total // Object args for String.format
            );

        // Print the receipt to the console
		System.out.println("\n" + receipt);

		// Write the receipt to a file, try/catch suggested by copilot
		try {
			FileWriter writer = new FileWriter(invoiceID + ".txt");	// Create a FileWriter object
			writer.write(receipt);						            // Write the receipt to the file
			writer.close();										    // Close the file
            System.out.println("Receipt saved as " + invoiceID + ".txt"); // Print a success message
		} catch (IOException e) {								    // Catch the IOException
			System.out.println("An error occurred while writing to the file."); // Print an error message
			e.printStackTrace();								    // Print the stack trace
		}
	}


    // =========================================
    //  PRIVATE HELPER METHODS
    // =========================================

    /**
     * Format the menu items of the order for the receipt
     * 
     * @param cart The ArrayList of OrderItems
     * @return String formatted order
     */
    private static String formatOrder(ArrayList<OrderItem> cart){
		// Get numbers for dynamic formatting
        // Get the maximum length of the item names
        int maxLength = 0; // Initialize maxLength to 0
        for(OrderItem item : cart){
            int length = item.getMenuItem().getName().length(); // Get the length of the item name
            if (length > maxLength) {                           // If the length is greater than maxLengt
                maxLength = length;                             // update maxLength if the current length is greater
            }
        }

        // Create header for the order section of the receipt
        String receipt = String.format("%-" + maxLength + "s %5s %7s | %7s\n", "Item", "Qty", "Price", "Total");
		
		// Construct the separator
		String separator = "";
		for(int i = 1; i < receipt.length(); i++)
			separator += "=";
        // Add separator to the receipt
		receipt += separator + '\n';

		// Loop through the order and add each item to the receipt
		for(OrderItem item : cart){
			// Receipt variables for code readability
            String itemName  = item.getMenuItem().getName();  // Get name of the item
            int    itemQty   = item.getQuantity();            // Get quantity of the item
            double itemPrice = item.getMenuItem().getPrice(); // Get price of the item
            double itemTotal = itemPrice * itemQty;           // Get total price of the item
            
            // Format the item and add it to the receipt
            receipt += String.format("%-" + maxLength + "s %5d %7.2f | %7.2f\n", 
                                     itemName, itemQty, itemPrice, itemTotal); // Object args for String.format
		}
        
        // Add another separator
		receipt += separator + '\n';
        
		return receipt;
	}
    
    /**
	 * Creates a (mostly) unique invoice number from the Customer data and the Date
	 * 
	 * @param customer	The customer object
	 * @param today		The date object
	 * @return			the invoice number
	 */
    private static String createInvoiceID(Customer customer, Date date){
		/*
			first two initials of the customer’s first name, converted to uppercase
			first two initials of the customer’s last name, converted to uppercase
			Unicode value of the first character of the first name
			Unicode value of the first character of the last name
			Add them together and multiply by the length of the full name
			Concatenate this ID to the initials described above
			Concatenate the day, month, hour and minute with no punctuation
		*/
        
        // Validation of the customer name
        String name = customer.getName();
        if (name.indexOf(" ") == -1)  // If there is no space in the name
            name = name + " " + name; // add a space and repeat the name (solution suggested by Copilot)
        
        // Get the first two initials of the first and last name
        String firstInits  = name.substring(0, 2).toUpperCase();
        String secondInits = name.substring(name.lastIndexOf(" ") + 1, name.lastIndexOf(" ") + 3).toUpperCase();
        // Get the first character of each
        char firstChar     = firstInits.charAt(0);
        char secondChar    = secondInits.charAt(0);
        // Get the unicode values of the first and second chars
        // and multiply by the length of the full name
        int firstUnicode   = (int) firstChar;
        int secondUnicode  = (int) secondChar;
        int id             = (firstUnicode + secondUnicode) * name.length();
        // Concatenate the 
        String invoiceID   = firstInits + secondInits + Integer.toString(id) + date.getDay() + date.getMonth() + date.getYear();
        
        return invoiceID; // Return the invoice number
    }


} // end class Order