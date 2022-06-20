package collegeApplication;
/* This class stores the ArrayList where
 * all of our Student objects are stored.
 */
import java.util.Scanner;
import java.util.ArrayList;
public class StudentsHolder {
	// NOTE: .useDelimiter is used to allow input with spaces
	// e.g., Without delimiter: Computer, With delimiter: Computer Science
	// Scanner to allow input from the user
	static Scanner input = new Scanner(System.in).useDelimiter("\n");
	
	// ArrayList that stores type Student
	static ArrayList<Student> allStudents = new ArrayList<>();
	
	static String lineBr = "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
	
	static String pre = "> ";
	
	static void TransitionMessage(String message, int speed) {
		for(int i = 0; i < message.length(); i++ ) {
			// Try & Catch statement -> contain an errors that might occur 
			try {
				// Each iteration of the for loop a single character of the message will display
				System.out.print(message.charAt(i));
				Thread.currentThread();
				// The current running thread sleeps for 100ms
				Thread.sleep(speed);
			}	// End try
			
			catch(Exception e) {
				// If the program catches an error it will display it in the console
				System.out.println(e);
			}	// End catch
			
		}	// End for		
		
	}	// End method

}	// End class
