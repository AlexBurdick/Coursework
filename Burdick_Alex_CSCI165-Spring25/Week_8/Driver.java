/*
 * This class is the driver class for the Food Truck application.
 * 
 * You have been provided with a bit of starter code to help you get started.
 * You are only responsible for completing one single order.
 * If you'd like to process multiple orders, you can do so in the main method.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver{

	public static void main(String[] args) {
		// TO DO: call the loadMenuItems method and store the returned ArrayList in a variable
		ArrayList<MenuItem> menuItems = loadMenuItems("products.txt");	

		// get local time
        LocalDateTime now = LocalDateTime.now(); // get the current date and time
		String dateTimeString = now.toString();  // convert date to string so it can be parsed
        
		// parse the date and time string and store the values as integers
		int day   = Integer.parseInt(dateTimeString.substring(8, 10));
		int month = Integer.parseInt(dateTimeString.substring(5, 7));
		int year  = Integer.parseInt(dateTimeString.substring(0, 4));
		String time = dateTimeString.substring(11, 19);

		// TO DO: Insantiate a Date object to store the Date of the order
		//		  Use techniques from an earlier lab to get the current date and timemonth, day, year
		Date today = new Date(month, day, year); // create a new Date object);

		// TO DO: Create a simple system to process an order. Decompose the problem into smaller steps/methods
		// You can use the following steps as a guide:
		//		1. Print a welcome message
		//		2. Prompt the user to enter their information (should be a method that returns a Customer object)
		//		3. Prompt the user to enter the items they'd like to order (should be a method that returns an ArrayList of MenuItems)
		//			a. Create an ArrayList to store the items the user has ordered (shopping cart)
		//			b. The shopping cart should hold MenuItems
		//		4. Print the order (should be a method that takes the Customer object, the ArrayList of MenuItems, and the Date object)
		
		//1. Print a welcome message
		System.out.println("It's food time! Please enter the following information - ");
		//2. Prompt the user to enter their information
		Customer customer = getCustomerInfo();
		//3. Prompt the user to enter the items they'd like to order
		ArrayList<MenuItem> shoppingCart = getOrder(menuItems);
		//4. Print the order
		printOrder(shoppingCart, customer, today);
	}

	/**
	 * Prompt user for input and store it in an ArrayList to be returned
	 * 
	 * @return customer  User's information in Customer object
	 */
	public static Customer getCustomerInfo(){
		Scanner scanner = new Scanner(System.in); // scanner to get user input

		// store customer info to be used in the customer object
		System.out.print("Name: ");
		String name  = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Phone: ");
		String phone = scanner.nextLine();
		
		Customer customer = new Customer(name, email, phone);
		
		return customer;
	}

	/**
	 * Prompt user for input and store it in an ArrayList to be returned
	 * 
	 * @param menuItems	The array list of menu items from the file
	 * @return order	The array list of menu items the user has ordered
	 */
	public static ArrayList<MenuItem> getOrder(ArrayList<MenuItem> menuItems){ // code suggested by copilot
		// declare variables
		Scanner scanner = new Scanner(System.in);
		ArrayList<MenuItem> order = new ArrayList<MenuItem>();
		String choice = "";
		
		// loop until the user enter 'done'
		while(!choice.equalsIgnoreCase("done") && !choice.equalsIgnoreCase("d")){
			// print the menu that the user can choose from
			System.out.println("Menu Items:");
			printMenu(menuItems);

			// prompt the user to enter an item
			System.out.print("Enter item name (or 'done' to finish): ");
			choice = scanner.nextLine();
			
			// loop through the menu items to find a match to the item the user entered
			for(MenuItem item : menuItems){
				if(item.getName().equalsIgnoreCase(choice)){
					order.add(item);
					break;
				}
			}
		}
		scanner.close();

		return order;
	}

	/**
	 * Load the menu items from a file and store them in an ArrayList
	 * 
	 * @param filename		The name of the file to read
	 * @return menuItesm	The array list of menu items
	 */
	public static ArrayList<MenuItem> loadMenuItems(String filename){
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();	// Create an ArrayList to store the menu items
	
		try{
			File file		= new File(filename);	// Create a File object
			Scanner scanner	= new Scanner(file);	// Create a Scanner object to read the file
			scanner.useDelimiter(",|\\n");			// Change delimiter to comma and new line character
			while(scanner.hasNextLine()){			// Loop through the file
				// TO DO:
				// 	Read the line and split into tokens
				// 	Instantiate a MenuItem object using the line data
				// 	add it to the ArrayList
				String name = scanner.next();
				double price = scanner.nextDouble();
				int calories = scanner.nextInt();
				//scanner.nextLine();	// consumre the new line character
				MenuItem item = new MenuItem(name, price, calories);
				menuItems.add(item);
			}
		}
		catch(FileNotFoundException e){	// Catch the FileNotFoundException
			System.out.println("File not found: " + filename);	// Print an error message
		}
		return menuItems;	// Return the ArrayList
	}

	/**
	 * Output the menu items to the console
	 * 
	 * @param menuItems	The array list of items on the menu from the file
	 */
	public static void printMenu(ArrayList<MenuItem> menuItems){
		// TO DO:
		// 	Loop through the ArrayList and print each MenuItem object
		// 	If you have a toString method in the MenuItem class, you can use it here
		// 	Otherwise, you can print the individual attributes of the MenuItem object
		for (MenuItem item : menuItems){
			System.out.println(item.toString());
		}
	}

	/**
	 * Load the menu items from a file and store them in an ArrayList
	 * 
	 * @param order		The arry list of menu items the user has ordered
	 * @param customer	The customer object with the user's information that they entered
	 * @param today		The date object
	 */
	public static void printOrder(ArrayList<MenuItem> order, Customer customer, Date today){
		// TO DO:
		// 	output a nest receipt
		// loop through the order and add up the price and calories
		double subtotal = 0;		// store the price
		int    totalCalories = 0;	// store the calories
		for(MenuItem item : order){
			subtotal	  += item.getPrice();	// add the price of each item to the subtotal
			totalCalories += item.getCalories();// add the calories of each item to the total
		}

		// calculate the tax and total
		double tax   = subtotal * 0.06;	// calculate the tax (6% of the subtotal)
		double total = subtotal + tax;	// calculate the total (subtotal + tax)
		
		// 	Use the getInvoiceNumber method to generate a unique invoice number (modify if you want)
		String receipt = String.format(
			"**RECEIPT**\n" +
			"Invoice #: " + getInvoiceNumber(customer, today) + "\n" +
            "Date: " + today + "\n" +
            "\n" +
            formatOrder(order) + // builds the order section of the receipt including separators
            "Subtotal:  %.2f\n" +
            "Sales tax: %.2f\n" +
            "Total:     %.2f\n",
            subtotal, tax, total // object args for String.format
            );

		System.out.println(receipt);
		// write the receipt to a file, try/catch suggested by copilot
		try {
			FileWriter writer = new FileWriter("receipt.txt");	// Create a FileWriter object
			writer.write(receipt);								// Write the receipt to the file
			writer.close();										// Close the file
		} catch (IOException e) {								// Catch the IOException
			System.out.println("An error occurred while writing to the file."); // Print an error message
			e.printStackTrace();								// Print the stack trace
		}
	}
	
	/**
	 * Create a formatted string of the menu items the user has ordered to add to the receipt
	 * 
	 * @param order		The arry list of menu items the user has ordered
	 * @return receipt	The formatted string of the menu items the user has ordered, including total calories
	 */
	public static String formatOrder(ArrayList<MenuItem> order){
		// create the header for order section of the receipt
		String receipt = String.format("%-20s %5s %7s | %7s\n", "Item", "Qty", "Price", "Total");
		
		// construct the separator
		String separator = "";
		for(int i = 1; i < receipt.length(); i++)
			separator += "=";
		receipt += separator + '\n';	// add the separator to the receipt

		// loop through the order and add each item to the receipt
		for(MenuItem item : order){
			receipt += String.format("%-20s %5d %7.2f | %7.2f\n", item.getName(), 1, item.getPrice(), item.getPrice());
		}
		receipt += separator + '\n';	// add the separator to the receipt

		return receipt;
	}

	/**
	 * Creates a (mostly) unique invoice number from the Customer data and the Date
	 * 
	 * @param customer	The customer object
	 * @param today		The date object
	 * @return			the invoice number
	 */
	public static String getInvoiceNumber(Customer customer, Date today){
		/*
			first two initials of the customer’s first name, converted to uppercase
			first two initials of the customer’s last name, converted to uppercase
			Unicode value of the first character of the first name
			Unicode value of the first character of the last name
			Add them together and multiply by the length of the full name
			Concatenate this ID to the initials described above
			Concatenate the day, month, hour and minute with no punctuation
		*/
		String invoiceNumber = "";										// Create a variable to store the invoice number

		// **CORRECTION** code to account for default values (name = 'unknown')
		if(customer.getName().equals("unknown")){						// check if the name is unknown
			String name = customer.getName();
			String firstInitials= name.substring(0, 2).toUpperCase();	// Get the first two initials of the first name
			int firstUnicode 	= (int)name.charAt(0);					// Get the Unicode value of the first character of the first name
			int id = (firstUnicode + firstUnicode) * customer.getName().length();// Calculate the ID
			invoiceNumber = firstInitials + firstInitials + id;				// Concatenate the initials and ID
			invoiceNumber += today.getDay() + today.getMonth();				// Concatenate the date (add the time in if you want)
			return invoiceNumber;											// return unknown
		}

		String[] name = customer.getName().split(" ");					// Get the first name
		String firstInitials= name[0].substring(0, 2).toUpperCase();	// Get the first two initials of the first name
		String lastInitials = name[1].substring(0, 2).toUpperCase();	// Get the first two initials of the last name
		int firstUnicode 	= (int)name[0].charAt(0);					// Get the Unicode value of the first character of the first name
		int lastUnicode 	= (int)name[1].charAt(0);					// Get the Unicode value of the first character of the last name
		int id = (firstUnicode + lastUnicode) * customer.getName().length();// Calculate the ID
		invoiceNumber = firstInitials + lastInitials + id;				// Concatenate the initials and ID
		invoiceNumber += today.getDay() + today.getMonth();				// Concatenate the date (add the time in if you want)
		return invoiceNumber;											// Return the invoice number
	}
}