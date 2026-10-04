// Import the correct Calendar class here
import java.util.Calendar;

public class UTC{

	// constants for raw time conversion
	// these must be static because they will be called from a "static context" => main
	static final int MILLISECONDS	= 1;
	static final int MIL_PER_SEC	= MILLISECONDS * 1000;
	static final int MIL_PER_MIN	= MIL_PER_SEC  * 60;
	static final int MIL_PER_HOUR	= MIL_PER_MIN  * 60;
	static final int MIL_PER_DAY	= MIL_PER_HOUR * 24;

	public static void main(String[] args) {

		// FORMAT ONE: write Calendar code here. Research API for details
		long millis = System.currentTimeMillis();
		System.out.println(millis);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
		System.out.println();
		
		// FORMAT TWO: write raw time conversion code here. Research API for details
		long millisecond = System.currentTimeMillis();
		
		// Date math
		int hours = (int) (millisecond / MIL_PER_HOUR) % 24;
		int minutes = (int) (millisecond / MIL_PER_MIN) % 60;
		int seconds = (int) (millisecond / MIL_PER_SEC) % 60;
		System.out.printf("GMT - %d:%d:%d\n" , hours, minutes, seconds);

		// get the command line argument, convert to an integer, and then perform the math.
		String input = args[0];
		int offset = Integer.parseInt(input);
		int localHour = (int) ((millisecond / MIL_PER_HOUR) + offset) % 24;
		System.out.printf("%d:%d:%d\n" , localHour, minutes, seconds);

	} // end main
} // end UTC