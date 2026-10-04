import java.io.File;
import java.util.Scanner;

public class CommonExceptions {
	public static void main(String[] args) {
		/*
			UNCHECKED EXCEPTIONS.
			Writing a handler is not forced by the compiler
			These types of exceptions are generally the result of bad programming
		*/

		//int x = 2 / 0; // ArithmeticException

		String str = null;
		//System.out.println(str.toString()); // throws NullPointerException

		int[] array = new int[5];
		//array[5] = 0;	// throws ArrayIndexOutOfBoundsException

		//numberFormat();

		try{
			arrayIndex();
		}
		catch(ArrayIndexOutOfBoundsException ar){
			System.out.println("Problem wth the array");
		}

		System.out.println("Run the rest of the program");

		/*
			CHECKED EXCEPTIONS: Catch or Specify
			Compiler will enforce dealing with these exceptions
			You should either
				Write a handler
				Throw the exception
			Problems that are generally external to the application
			These should be anticiapted and recoverable
		*/

		File file = new File("filename.txt");
		//Scanner scanner = new Scanner(file); // Scanner(File) throws a checked exception

	}

	public static void numberFormat(){
		String s = "abc";
		int i = Integer.parseInt(s); // throws NumberFormatException
	}

	// this method chooses not handle the exception and throws
	// the exception "up the call stack" to the caller
	public static void arrayIndex() throws ArrayIndexOutOfBoundsException{
		int[] array = new int[5];
		array[5] = 0;	// pass responsibility to caller
	}

}
