import java.util.Scanner;

// import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FoodTruck{
    public static void main(String[] args){
        // declare arrays for menu items, prices, and quantities
        String[] food     = new String[3];
        Double[] price    = new Double[3];
        int[]    quantity = new int[3];


        // OPEN AND READ MENU.TXT FILE
        // read menu.txt file into arrays
        try{
            File menu = new File("menu.txt");
            Scanner fileScanner = new Scanner(menu);
            
            // loop through lines of file and read into arrays
            int index = 0;
            while(fileScanner.hasNextLine()){
                food[index] = fileScanner.nextLine();
                price[index] = fileScanner.nextDouble();
 
                // check for end of file and skip newline character
                if(fileScanner.hasNext()){
                    fileScanner.skip("\n");
                } // end if

                index++;
            } // end while loop

            // close scanner
            fileScanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        } // end try-catch block


        // GET USER INPUT
        // construct scanner for user input from command line
        Scanner input = new Scanner(System.in);

        // get user input for user information
        System.out.println("Welcome to the CS food truck");
        System.out.print("Enter you full name: ");
        String name = input.nextLine();        
        
        System.out.println("\nEnter the quantity of each item\n===============================");
        // loop through arrays and accept user input for quantity
        for(int i = 0; i < 3; i++){
            System.out.printf("%s - %.2f: ", food[i], price[i]);
            quantity[i] = input.nextInt();
        } // end for loop
        System.out.println();


        // CREATE INVOICE
        // get local time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
        String invoiceDate = dateTimeString.substring(3, 5) + 
                             dateTimeString.substring(0, 2) + 
                             dateTimeString.substring(11, 13) + 
                             dateTimeString.substring(14, 16);
        
        // formulate invoice number
        // strings
        String firstInits  = name.substring(0, 2).toUpperCase();
        String secondInits = name.substring(name.lastIndexOf(" ") + 1, name.lastIndexOf(" ") + 3).toUpperCase();
        String initials    = firstInits + secondInits;
        char firstChar     = firstInits.charAt(0);
        char secondChar    = secondInits.charAt(0);
        // numbers
        int firstUnicode   = (int) firstChar;
        int secondUnicode  = (int) secondChar;
        int sumUnicode     = firstUnicode + secondUnicode;
        int nameLength     = name.length();
        int productNum     = sumUnicode * nameLength;
        String invoiceNum  = initials + Integer.toString(productNum) + invoiceDate;

        // calculate subtotal cost
        double subtotal = 0;
        for(int i = 0; i < 3; i++){
            subtotal += price[i] * quantity[i];
        } // end for loop

        // calculate total cost with tax
        double salesTax = 6.25;
        double taxRate = salesTax / 100;
        double total = subtotal * (1 + taxRate);
        double tax = subtotal * taxRate;
        // round and format totals to 2 decimal places
        BigDecimal bdTotal = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        BigDecimal bdTax = new BigDecimal(tax).setScale(2, RoundingMode.HALF_UP);
        double roundedTotal = bdTotal.doubleValue();
        double roundedTax = bdTax.doubleValue();

        // build invoice text
        // declare varialbes for header text
        String item = "Item", amount = "Quantity", cost = "Price", totalcost = "Total";
        String invoiceText = String.format(
            "Invoice #:  " + invoiceNum + "\n" +
            "Date:       " + dateTimeString.substring(0,10) + "\n" +
            "Time:       " + dateTimeString.substring(11) + "\n" +
            
            "\n%-35s %8s %8s %8s\n" + 
            "==============================================================\n" +
            "%-35s %8d %8.2f %8.2f\n" + 
            "%-35s %8d %8.2f %8.2f\n" + 
            "%-35s %8d %8.2f %8.2f\n" + 
            "==============================================================\n" +
            "Subtotal %53.2f\n" +
            salesTax + " Sales tax %47.2f\n" +
            "Total %56.2f\n",
            // object args for String.format
            item, amount, cost, totalcost, 
            food[0], quantity[0], price[0], price[0] * quantity[0],
            food[1], quantity[1], price[1], price[1] * quantity[1],
            food[2], quantity[2], price[2], price[2] * quantity[2],
            subtotal, roundedTax, roundedTotal
            );
        
        System.out.println(invoiceText);

        // Write invoice to file
        String filename = invoiceNum + ".txt";
        try{
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(invoiceText);
            fileWriter.close();
        }
        catch (Exception e){
            System.out.println("There was a problem writing to the file");
            e.printStackTrace();
        } // end try-catch block

    } // end of main

} // end of class FoodTruck
