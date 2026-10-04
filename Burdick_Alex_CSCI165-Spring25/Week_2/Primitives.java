public class Primitives{

    public static void main (String[] args){
        
        // 1. 
        // Declaring all primitive types   
        byte u = 1;
        short v = 2;
        int w = 3;
        long x = 4L;
        float y = 5.5f;
        double z = 6.06d;
        char a = 'a';
        boolean t = true;

        // Printing using printf()
        System.out.println("Printing using printf()");
        System.out.printf("byte: %d%n", u);
        System.out.printf("short: %d%n", v);
        System.out.printf("int: %d%n", w);
        System.out.printf("long: %d%n", x);
        System.out.printf("float: '%3.1f'%n", y);
        System.out.printf("double: '%4.2f'%n", z);
        System.out.printf("char: %c%n", a);
        System.out.printf("boolean: %b%n", t);
        System.out.println();
        
        // 2.
        // Implicit widening casts
        byte b = 1;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        System.out.println("Implicit widening casts");
        System.out.printf("byte: %d%n", b);
        System.out.printf("short: %d%n", s);
        System.out.printf("int: %d%n", i);
        System.out.printf("long: %d%n", l);
        System.out.printf("float: '%3.1f'%n", f);
        System.out.printf("double: '%4.2f'%n%n", d);

        // Explicit narrowing casts
        double d1 = 1.01;
        float f1 = (float) d1;
        long l1 = (long) f1;
        int i1 = (int) l1;
        short s1 = (short) i1;
        byte b1 = (byte) s1;

        System.out.println("Explicit narrowing casts");
        System.out.printf("double: '%4.2f'%n", d1);
        System.out.printf("float: '%3.1f'%n", f1);
        System.out.printf("long: %d%n", l1);
        System.out.printf("int: %d%n", i1);
        System.out.printf("short: %d%n", s1);
        System.out.printf("byte: %d%n", b1);
        System.out.println();

        // 3.
        // int MAX_VALUE and MIN_VALUE
        int var1 = Integer.MAX_VALUE;
        int var2 = Integer.MIN_VALUE;

        System.out.printf("The maximum value an integer type can be is %d%n", var1);
        System.out.printf("The minimum value an integer type can be is %d%n", var2);
        System.out.println();
    
        // 4.
        // long MAX_VALUE and MIN_VALUE
        long var3 = Long.MAX_VALUE;
        long var4 = Long.MIN_VALUE;

        System.out.printf("The maximum value a long type can be is %d%n", var3);
        System.out.printf("The minimum value a long type can be is %d%n", var4);
        
        long var5 = var3 - var1;
        System.out.printf("The difference between the long max value and the int max value is %d%n%n", var5);

        // 5.
        // Command line arguments
        System.out.println("Command line arguments");
        
        int input = Integer.parseInt(args[0]);

        for (int counter = 1; counter <= 4; counter++){
            int exponentiation = (int) Math.pow(input, counter);
            System.out.println(input + " to the power of " + counter + " = " + exponentiation);
        }

        System.out.println();
        
        // 6.
        // Rounding methonds
        System.out.println("Rounding methods");

        int dividend = Integer.parseInt(args[1]);
        int divisor = Integer.parseInt(args[2]);

        // Division
        int floorQuotient = Math.floorDiv(dividend, divisor);
        int quotient = dividend / divisor;

        // Modulus
        int fm = Math.floorMod(dividend, divisor);
        int m = dividend % divisor;

        System.out.printf("Quotient with floor method = %d%n", floorQuotient);
        System.out.printf("Quotient with operator = %d%n", quotient);
        System.out.printf("Modulus with floor method = %d%n", fm);
        System.out.printf("Modulus with operator = %d%n", m);

    } // end main
} // end Primitives