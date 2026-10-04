import java.util.InputMismatchException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ROT {
    
    public static void main(String[] args) {
        // if there are not 3 arguments, error and exit
        if (args.length != 3) {
            System.out.println("Invalid input - please enter one number, either 13 or 47.");
            System.exit(1);
        } // end if/else

        String fileName = args[0];
        String code     = args[1];
        int    rotNum   = 0;
        String line     = "";
        
        // test user input
        // test for valid string input
        if (!args[1].equals("e") && !args[1].equals("d")) {
            System.out.println("Invalid input - please enter 'e' to encode or 'd' to decode.");
            System.exit(1);
        } // end if

        // test for integer input
        try{
            rotNum = Integer.parseInt(args[2]);
        }catch(InputMismatchException ime){
            System.out.println("Invalid input - please enter one number, either 13 or 47.");
            System.exit(1);
        } // end catch

        // test for valid integer input
        if (rotNum != 13 && rotNum != 47) {
            System.out.println("Invalid input - please enter one number, either 13 or 47.");
            System.exit(1);
        } // end if

        // open file and read file to be coded
        try {
            FileReader     fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            line              = br.readLine();
            // close BufferedReader
            br.close();
        } catch (IOException ioe) {
            System.out.println("There was a problem opening the file.");
            System.exit(1);
        }

        // once validated, have text encoded
        String encodedText = applyROT(line, rotNum);
        String newfileName = "";

        // generate new file names
        int    dotIndex    = fileName.indexOf(".");
        String fileNameSub = fileName.substring(0, dotIndex);
        // set new file name base on input, then send to writeToNewFile 
        if (code.equals("e")) {
            newfileName = fileNameSub + "_encrypted" + ".txt";
            writeToNewFile(newfileName, encodedText);
        } else if (code.equals("d")) {
            int underscoreIndex  = fileNameSub.indexOf("_");
            String truncatedName = fileNameSub.substring(0, underscoreIndex);
            newfileName = truncatedName + "_decrypted" + ".txt";
        } else {
            System.out.println("Invalid input - please enter 'e' to encode or 'd' to decode.");
            System.exit(1);
        } // in if else block

        // write file with generated filename
        try {
            FileWriter     fw     = new FileWriter(newfileName);
            BufferedWriter buffer = new BufferedWriter(fw);
            buffer.write(encodedText);
            buffer.flush();
            buffer.close();
        } catch (IOException ioe) {
            System.out.println("Error opening new file.");
        } // end try catch

    } // end main
    
    
    static String rotCharacterSet(int rotnum) {
        
        // initialize variables
        String rotAlphabet = "";
        int min = 0, max = 0;
        
        // set value for min and max ASCII values depending on input
        switch (rotnum) {
            case 13:
                min = 65;  
                max = 90;
                break;
            case 47:
                min = 33;  
                max = 126;  
                break;
        } // end switch
        
        // use for loop to add ASCII values to string
        for (int i = min; i <= max; i++) {
            rotAlphabet = rotAlphabet + (char) i;
        } // end for
        
        return rotAlphabet;
    } // end rotCharacterSet


    static String applyROT(String input, int rotNum) {

        // initialize variables
        String rotAlphabet = rotCharacterSet(rotNum);
        String output = "";
        // convert input to caps for ROT13 encoding
        if (rotNum == 13) {  input = input.toUpperCase();  }
        
        // use for loop to encode input string
        for (int i = 0; i < input.length(); i++) {
            
            // get character from alphabet
            char c = input.charAt(i);
            int index = rotAlphabet.indexOf(c);

            if (index == -1) { // if the character isn't in the ROT alphabet, don't replace it and move on
                output = output + c;
                continue;
            } else { 
                // generate encoded character
                int newIndex = (index + rotNum) % rotAlphabet.length(); // wraparound
                // add encoded character to output string
                output = output + rotAlphabet.charAt(newIndex);
            } // end if
            
        } // end for

        return output;
    } // end applyROTtestfile.txt


} // end class
