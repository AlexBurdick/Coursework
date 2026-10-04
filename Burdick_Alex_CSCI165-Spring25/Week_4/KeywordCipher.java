import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class KeywordCipher
{
    // global variables for use in multiple methods
    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // main takes three arguments
    // - the file name
    // - the intended keyword
    // - 'e' or 'd' for encode or decode

    public static void main(String[] args)
    {   
        // open and read file for with args
        String fileName = args[0];
        String fileText = readInputFile(fileName).toUpperCase(); // call method below to open and read file
        String codeFlag = args[2];
        
        // declare variables
        String inputKey       = args[1];
        String keyWord        = prepareKeyWord(inputKey.toUpperCase());
        String cipherAlphabet = generateCipherAlphabet(keyWord);
        
        // call method based on code flag
        if (codeFlag.equals("e")) {
            String encipheredText = encipher(cipherAlphabet, fileText);
            // send the enciphered text to a new file
            writeToNewFile(encipheredText);
        } else if (codeFlag.equals("d")) {
            String decipheredText = decipherText(cipherAlphabet, fileText);
            // send the enciphered text to a new file
            writeToNewFile(decipheredText);
        } else {
            System.out.println("Please enter e for encoding or d for decoding");
        }

        System.out.println(inputKey);
        System.out.println(keyWord);
        System.out.println(cipherAlphabet);
        
    } // end of main
    

    static String prepareKeyWord(String input)
    {
        // declare variables
        char[]               letters     = input.toCharArray();
        char[]               usedLetters = new char[letters.length];
        ArrayList<Character> keyLetters  = new ArrayList<Character>();

        // loop through letters and remove duplicates
        for (char c : letters)
        {
            // nested loop to check if letter was already in input word
            boolean isUsed = false; // copilot added boolean to run loop even when array is empty
            for (char used : usedLetters) {
                if (c == used) {
                    isUsed = true;
                    break;
                } // end if
            } // end for loop
            if (!isUsed) {
                keyLetters.add(c);
                usedLetters[keyLetters.size() - 1] = c;
            } // end if
        } // end for loop

        // create string keyword to return
        StringBuilder sb = new StringBuilder();
        // add characters from letters to string builder
        for (Character ch : keyLetters)
        {  sb.append(ch);  }
        // create string from string builder
        String keyWord = sb.toString();
        
        return keyWord;

    } // end prepareKeyWord


    static String generateCipherAlphabet(String keyWord)
    {
        // declare variables
        char[] alphabetChars = ALPHABET.toCharArray();

        // create arraylist for cipherAlphabet
        ArrayList<Character> cipherAlphabet = new ArrayList<Character>();
        for (int i = 0; i < keyWord.length(); i++)
        {  cipherAlphabet.add(keyWord.charAt(i));  }
        
        // create cipher alphabet
        for (char c : alphabetChars)
        {
            // nested loop to check if letter was already in cipher alphabet
            boolean isUsed = false;
            for (char used : cipherAlphabet) {
                if (c == used) {
                    isUsed = true;
                    break;
                }
            }
            if (!isUsed) {
                cipherAlphabet.add(c);
                //usedLetters[keyLetters.size() - 1] = c;
            }
        } // end outer loop
        
        // create string cipher alphabet to return
        StringBuilder sb = new StringBuilder();
        for (Character ch : cipherAlphabet)  { sb.append(ch); }
        String cipherString = sb.toString();
        
        return cipherString;

    } // end generateCipherAlphabet


    static String encipher(String cipherAlphabet, String inputText)
    {
        // remove white spaces
        String workText = inputText.replaceAll("\\s", ""); // regex for space removal found from Brave AI search
        
        // declare variables
        String  encipheredText = "";    // string to be built and returned
        int     spaceCounter   = -1;    // for inserting whitespaces, set to -1 so it bacn be incremented to 0 on first pass through
        boolean spacer         = false; // for inserting whitespaces, set to false so it doesn't add whitespace on the first pass through

        // use for loop to encode input string
        for (int i = 0; i < workText.length(); i++)
        {
            // keep counter for adding whitespace every 5 places
            spaceCounter++;
            if (spaceCounter % 5 == 0) {
                if (spacer) {
                    encipheredText = encipheredText + " ";
                    spaceCounter = -1;
                    spacer = false;
                } else { spacer = true; }  
            }

            // get character from alphabet and index in alphabet
            char c = workText.charAt(i);
            int index = ALPHABET.indexOf(c);

            if (index == -1) {
                encipheredText = encipheredText + c;
                continue;
            } else { 
                // add encoded character to enciphered text
                encipheredText = encipheredText + cipherAlphabet.charAt(index);
            } // end if
                    
        } // end for

        return encipheredText;
    }


    static String decipherText(String cipherAlphabet, String inputText)
    {
        // declare variables
        String decipheredText = "";
        
        for (int i = 0; i < inputText.length(); i++)
        {
            // get character from the text and the index of that character in cipher alphabet
            char c = inputText.charAt(i);
            int index = cipherAlphabet.indexOf(c);

            if (index == -1) {
                decipheredText = decipheredText + c;
                continue;
            } else { 
                // add encoded character to enciphered text
                decipheredText = decipheredText + ALPHABET.charAt(index);
            } // end if
                    
        } // end for

        return decipheredText;
    }


    static String readInputFile(String fileName){
        // declare variables
        String fileText = "";

        // try to open the filw and read it into a variable
        try {
            FileReader     fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            fileText = br.readLine();
            
            // close BufferedReader
            br.close();

        } catch (IOException ioe) {
            System.out.println("There was a problem opening the file.");
            System.exit(1);
        }

        return fileText;
    } // end readInputFile


    static void writeToNewFile(String encodedText) {
        // creates a new file called enciphered_file.txt
        try {
            FileWriter     fw     = new FileWriter("enciphered_file.txt");
            BufferedWriter buffer = new BufferedWriter(fw);
            
            buffer.write(encodedText);
            buffer.flush();
            buffer.close();

        } catch (IOException ioe) {
            System.out.println("Error opening new file.");
        } // end try catch

    } // end writeToNewFile


} // end class KeywordCipher