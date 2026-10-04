public class ExceptionTest {

	public double tryDivideNoCheck(int a, int b){
		// no error checking at all. Program could crash here
		return a / b;
	}

	public double tryDivideLocalCheck(int a, int b){
		// local error checking, but response is fixed
		// check for error first
		if(b == 0){
			System.out.println("Cannot divide by zero");
			return 0;
		}
		return a / b;
	}

	public double tryDivideLocalException(int a, int b){
		// local error checking using try/catch
		// "try" to execute the code
		// program is prevented from crashing
		// we can analyze the stack trace and other exception meta data
		// response still fixed
		try{
			return a / b;
		}catch(ArithmeticException nfe){
			System.out.println("Exception Caught");
			System.out.println(nfe.getMessage());
			nfe.printStackTrace();
		}
		return 0;
	}

	public double tryDivideButThrowException(int a, int b) throws ArithmeticException{
		// simply throw the exception if it occurs
		// this separates the error causing code from the response
		// allows users of the method to define their own response
		return a / b;
	}

	public double tryDivideButThrowExplicitException(int a, int b) throws ArithmeticException{
		// test for error condition and explicitly throw the "built in" exception
		// pass a custom message to the exception constructor
		if(b == 0) throw new ArithmeticException("Hey buddy . . . can't divide by zero. Dummy");
		return a / b;
	}

	public double tryDivideButThrowCustomException(int a, int b) throws DivisionByZeroException{
		// test for error condition and explicitly throw a custom exception
		// pass a custom message to the exception constructor
		if(b == 0) throw new DivisionByZeroException("Cannot divide by zero");
		return a / b;
	}

	
}
