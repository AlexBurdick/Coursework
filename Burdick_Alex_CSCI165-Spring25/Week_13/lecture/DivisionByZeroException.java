public class DivisionByZeroException extends Exception{
	
	// this is a "checked" exception
	// compiler will force handling or code will not build
	DivisionByZeroException(String customMessage){
		super(customMessage);
	}
	
}
