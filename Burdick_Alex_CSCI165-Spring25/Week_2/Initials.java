public class Initials {
    public static void main(String args[]){
        
        String name = args[0];
        int space = name.indexOf(" ");

        // Get initials
        char initial1 = name.charAt(0);
        char initial2 = name.charAt(space + 1);
        System.out.printf("Initials: %c.%c.\n", initial1, initial2);
        
        // Get unicod value
        int unicodeValue1 = (int) initial1;
        int unicodeValue2 = (int) initial2;
        System.out.printf("%c=%d, ", initial1, unicodeValue1);
        System.out.printf("%c=%d\n", initial2, unicodeValue2);

        // Get the sum of the unicode values
        int sum = unicodeValue1 + unicodeValue2;
        System.out.printf("Sum of unicode values: %d\n", sum);

        // Concatinate the initials
        String initials = "" + initial1 + initial2;
        System.out.println(initials);

    } // end main
} // end Initials
