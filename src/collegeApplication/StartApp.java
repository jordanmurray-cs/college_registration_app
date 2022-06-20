package collegeApplication;
/* This class has the main method. 
 * Within this class is where our 
 * application is going to be first 
 * executed. From the users point of 
 * view, this is where the home menu 
 * options is located. All of the 
 * options that are displayed in this 
 * class, their corresponding 
 * functionality is stored within 
 * a separate class.
 */

import java.text.ParseException;
import java.util.Scanner;
public class StartApp {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		StudentsHolder.TransitionMessage("+-+Welcome to College Registration App-+-", 65);
		
		// Our main functional operations loop
		while(true) {
			System.out.println("\n" + StudentsHolder.lineBr);
			System.out.println("\n***HOME WINDOW***\n");
			
			// Display all of the options to the user
			System.out.println("1.View Course Details"
					+ "\n2.Edit Course / Personal Details"
					+ "\n3.Register Student" 
					+ "\n4.Write to File"
					+ "\n5.Exit System"
					);
			System.out.println(StudentsHolder.lineBr);
			System.out.print(StudentsHolder.pre);
			
			try {
				// Create object of class MenuOperations
				// Create new Scanner object as parameter to allow user input
				new MenuOperations(new Scanner(System.in).next());
			}	// End try 
			catch (ParseException e) {
				e.printStackTrace();
			}	// End catch
			
		}	// End while

	}	// End main 
	

}	// End class
