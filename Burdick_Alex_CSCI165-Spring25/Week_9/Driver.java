/* 
This class is the driver class for the Food Truck application.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver{

	public static void main(String[] args) {
		// Print a welcome message
		System.out.println("Welcome to the Food Truck application");

		// Call the loadMenuItems method and store the returned ArrayList in a variable
		ArrayList<MenuItem> menuItems = loadMenuItems("products.txt");
		
		// Loop until the user enters 'done'
		boolean done = false; // Flag to change to end the loop
		while(!done){
			// Process an order:
			//1. Print a welcome message
			System.out.println("Enter customer information - ");
			//2. Prompt the user to enter their information
			Customer customer = getCustomerInfo();
			//3. Prompt the user to enter the items to order
			ArrayList<MenuItem> shoppingCart = getOrder(menuItems);
			//4. Create an Order object using the customer and shopping cart
			Order order = new Order(customer);
			for (MenuItem item : shoppingCart)
				order.addItem(item);
			//5. Print the order summary
			order.writeToFile();
			//6. Ask the user if they want to process another order
			System.out.print("Do you want to process another order? (y/n): "); // Prompt user for input
			Scanner scanner = new Scanner(System.in); // Get user input
			String choice = scanner.nextLine(); // Read the input
			// Check if the input is 'y' or 'n'
			// If 'y', continue the loop, if 'n', end the loop
			// If neither, print an error message and ask again
			if(choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")){
				done = true; // Set the flag to true to end the loop
				scanner.close(); // Close the scanner
			}
			else if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes"))
				done = false; // Set the flag to false to continue the loop
			else
				System.out.println("Invalid input. Please enter 'y' or 'n'.");
		} // end while
		
		// Print a goodbye message
		System.out.println("Thank you for using the Food Truck application. Goodbye!");
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
				// 	Read the line and split into tokens
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
	 * Prompt user for input and store it in an ArrayList to be returned
	 * 
	 * @return customer  User's information in Customer object
	 */
	public static Customer getCustomerInfo(){
		Scanner scanner = new Scanner(System.in); // scanner to get user input, it is closed later

		// store customer info to be used in the customer object
		System.out.print("Full Name: ");
		String name  = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Phone: ");
		String phone = scanner.nextLine();
		
		return new Customer(name, email, phone); // Create and return a new Customer object using the user input
	}

	/**
	 * Prompt user for input and store it in an ArrayList to be returned
	 * 
	 * @param menuItems	The array list of menu items from the file
	 * @return order	The array list of menu items the user has ordered
	 */
	public static ArrayList<MenuItem> getOrder(ArrayList<MenuItem> menuItems){ // code suggested by copilot
		// Declare variables
		Scanner scanner = new Scanner(System.in);
		ArrayList<MenuItem> order = new ArrayList<MenuItem>();
		String choice = "";
		
		// Loop until the user enter 'done'
		while(!choice.equalsIgnoreCase("done") && !choice.equalsIgnoreCase("d")){
			// Print the menu that the user can choose from
			System.out.println("Menu Items:");
			printMenu(menuItems);

			// Prompt the user to enter an item
			System.out.print("Enter item name and quantity (or 'done' to finish): ");
			choice = scanner.nextLine();
			
			// Loop through the menu items to find a match to the item the user entered
			for(MenuItem item : menuItems){
				if(item.getName().equalsIgnoreCase(choice)){
					order.add(item);
					break;
				} // end if
			} // end for
		} // end while
		return order;
	}

	/**
	 * Output the menu items to the console
	 * 
	 * @param menuItems	The array list of items on the menu from the file
	 */
	public static void printMenu(ArrayList<MenuItem> menuItems){
		// 	Loop through the ArrayList and print each MenuItem object
		for (MenuItem item : menuItems){
			System.out.println(item.toString());
		}
	}
	
} // end class Driver