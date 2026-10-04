public class ExceptionDriver {

	public static void main(String[] args) {
		
		ExceptionTest et = new ExceptionTest();

		//et.tryDivideNoCheck(2, 0);		// call method that has an error, Program will crash here

		//et.tryDivideLocalCheck(2, 0); 	// method checks for error, but has a fixed response
		
		//et.tryDivideLocalException(2, 0);	// method uses exception handling. Prevents crash
											// and communicates more descriptive info about issue
											// response still fixed

		try{
			et.tryDivideButThrowException(2, 0); 	// method signals that an exception occured. Allows "caller"
													// to decide how to handle the error
		}catch(ArithmeticException ae){
			System.out.println("Define custom response to exception");
		}

		try{
			et.tryDivideButThrowExplicitException(2, 0); 	// method signals that an exception occured. Allows "caller"
															// to decide how to handle the error
		}catch(ArithmeticException ae){
			System.out.println(ae.getMessage());
			ae.printStackTrace();
		}
		
		try{
			et.tryDivideButThrowCustomException(2, 0); 		// method signals that an exception occured. Allows "caller"
															// to decide how to handle the error
		}catch(DivisionByZeroException ae){
			System.out.println(ae.getMessage());
			ae.printStackTrace();
		}
		
		//et.tryDivideButThrowCustomException(2, 0); 


		System.out.println("Method call was successful");
	}
	
}
