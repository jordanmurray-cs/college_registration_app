package collegeApplication;
/* This class has no main method. This class 
 * inherits from the Student Holder class. Main 
 * reason for the inheritance is to improve 
 * overall modularity of the program by having 
 * the container, or the Array List in this instance, 
 * in a separate class. As well as that, if 
 * improvements to the program where ever to be made 
 * for example, linking the application to a 
 * database, a separate class pertaining to 
 * all of the relevant database logic would be 
 * extremely useful. 
 *  
 * The main body of this class however is, essentially, 
 * the complete logical functionality that underlies 
 * the complete program. The sub-menus that can be 
 * observed while the program is running i.e., the edit 
 * details window, view details window etc, are all 
 * contained within this class. As well as, general 
 * functions that provide a means for text validation 
 * within the program. Text validation including checking 
 * if the user has entered Integers, Strings, Dates etc.
 * 
 * The constructor is used in a relative new way to myself 
 * within this class. The constructors main purpose whenever 
 * called upon is to assess which sub-menu to send the user to, 
 * all sub-menus are contained in the class as previously stated.
 * 
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuOperations extends StudentsHolder {
	// Preferred date format for data entries 
	private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	// Integer variable representing that student search is invalid
	private final int invalidIndex = -1;
	
	/* MenuOperations constructor 
	 * -> Takes menu choice as parameter
	 * -> Ever time a object is made, user is directed to
	 * 	that function component of the program 
	 */
	public MenuOperations(String menuChoice) throws ParseException{
		switch(menuChoice) {
		case "1":
			// If there array is empty, return. Nothing to show
			if(allStudents.isEmpty()) return;
			
			// Redirect user to viewDetails menu
			viewDetails(); 
			break;
			
			
		case "2":
			// Redirect user to editDetails menu
			editDetails();
			break;
			
		case "3":
			// Prompt user to register a student 	
			registerStudent();
			break;
			
		case "4":
			try {
				/* If option 4 is chosen from the Menu Operations list
				 * the user is directed towards the file management
				 * interface located in a separate class 
				 * -> Create a new object of FileManagement
				 * -> Use dot operator to redirect user to the interface method
				 */
				new FileManagement().FileManagementInterface();
			}	// End try
			
			catch (Exception e) {
				System.out.println("Error: " + e);
			}	// End catch
			
			break;
			
		case "5": 
			// Display termination date of program -> Replicate real time ATM simulation data
			TransitionMessage("Goodbye", 100);
			// Creating a Data Formatter object from the Java standard library 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			// Creating a Date object from the Java standard library  
			Date date = new Date();  
			
			System.out.println("\nTERMINATED AT: " + formatter.format(date));
			System.exit(0);
			break;
			
		case "6":
			 allStudents.add(new Student("Computer Science", "001", "Jordan Murray", "24 Whitehall Lane"));
			 allStudents.add(new Student("Business Studies", "201", "Shauna Kavanagh", "99 Crumlin Road"));
			 allStudents.add(new Student("Civil Engineering", "121", "Ryan Murphy", "23 Lakeside Park"));
			 allStudents.add(new Student("Child Care", "188", "Alex Turner", "55 Coolock Green"));
			 allStudents.add(new MatureStudent("Engineering", "331", "Mike Smith", "88 Clarehall Road", "1996-06-01"));
			 allStudents.add(new MatureStudent("Teaching", "104", "Thomas Matthews", "23 Coolock Green","1997-02-02"));
			System.out.println("test data successfully entered....");
			for(int i = 0; i < allStudents.size(); i++) {
				System.out.println(allStudents.get(i).toString());
			}	// End for
			
			break;
			
		default: 
			// If option is chosen that is not specified in the menu
			System.out.println("Invaild Option");
			break;
			
		}	// End switch
		
	}	// End method
	
	
	// Method to register a Student
	public void registerStudent() throws ParseException {
		System.out.println("**PRESS 'Q' to quit at anytime**");
		
		// Prompt user to enter course name
		System.out.println("Please enter course name: ");
		System.out.print(pre);
		String courseName = ValidateText(input.next());
		if(courseName.toLowerCase().matches("q")) return;
		
		// Prompt user to enter course number
		System.out.println("Please enter course number: ");
		System.out.print(pre);
		String courseNumber = ValidateInt(input.next());
		if(courseNumber.toLowerCase().matches("q")) return;
		
		// Prompt user to enter student name		
		System.out.println("Please enter student name: ");
		System.out.print(pre);
		String studentName = ValidateText(input.next());
		if(studentName.toLowerCase().matches("q")) return;
		
		// Prompt user to enter student address
		System.out.println("Please enter student address: ");
		System.out.print(pre);
		String studentAddress = ValidateText(input.next());
		if(studentAddress.toLowerCase().matches("q")) return;
		
		// Prompt user to enter student DOB
		System.out.println("Please enter student DOB: ");
		System.out.print(pre);
		String DOB = input.next();
		if(DOB.toLowerCase().matches("q")) return;
		String DOBenter = validateDate(DOB);	
		
		/* Conditional statement to check if a mature student has been entered 
		 * Calls function to perform the check 
		 * -> parameter being the variable were the DOB was taken in
		 */

		if(checkMatureStudent(DOBenter)){
			// If the student is a mature student, parse input to Date object
			Date DOBtoDate = convertStringtoDate(DOBenter);
			
			/* Format that Date object with our desired date format
			 * -> Store is as a String
			 */
			String formatDate = format.format(DOBtoDate);
			
			/* Add the student to the ArrayList
			 * -> Create an instance of mature student
			 * -> Pass all the values that the user entered 
			 */

			allStudents.add(new MatureStudent(courseName, courseNumber, studentName, studentAddress, formatDate));
			
		}	// End if
		
		else {
			 allStudents.add(new Student(courseName, courseNumber, studentName, studentAddress));
		}	// End else
		
		System.out.println("***STUDENT SUCESSFULLY REGISTERED***");
		
	}	// End method
	
	/* Method to check if date qualifies as mature student date
	 * Returns true if the students date qualifies as a mature student
	 * Returns false otherwise
	 * -> Takes String student as parameter -> represents students date
	 */
	public boolean checkMatureStudent(String student) throws ParseException {
		/* Temporally convert the students date to a Date object
		 * As well as, convert the mature student threshold date into a Date object 
		 * If the student date is before the threshold: 
		 * -> Return true, else return false
		 */

		if(convertStringtoDate(student).before(convertStringtoDate("1998-01-01"))) {
			return true;
		}	// End if 
		else {
			return false;
		}	// End else 
		
	}	// End if
	
	/* Method to convert String to Date
	 * -> Returns the date in the preferred date format
	 * -> Returns as Date object 
	 */
	public Date convertStringtoDate(String newDate) throws ParseException {
		return format.parse(newDate);
	}	// End method	

	
	/* Boolean function to valid user input with Dates
	 * If the date entered by any user matches the format:
	 * -> Return true, else return false
	 */
	public boolean isValidDate(String input) {
		// If it can parse it, return true else return false 
		try {
	         format.parse(input);
	         return true;
	     }	// End try
	     
	     catch(ParseException e){
	          return false;
	          
	     }	// End catch
	     
	}	// End method
	
	// Method containing all functionality relating to the edit details window
	public void editDetails(){
		// Stores user input
		String checkID;
		
		// When searching for studentID -> Stores it in this variable
		int studentIndex;
	
		while (true) {
			// Display the options available to the user
			System.out.println(lineBr);
			System.out.println("***EDIT DETAILS WINDOW***\n");
			System.out.println("1.View Application Details" 
					+ "\n2.View Personal Details"
					+ "\n3.Change Application Details" 
					+ "\n4.Change Personal Details" 
					+ "\n5.Quit");
			System.out.println(lineBr);
			System.out.print("> ");
			
			// Switch takes Scanner.next() as parameter
			switch (input.next()) {
			case "1":
				// Print the Application details
				for(int i = 0; i < allStudents.size(); i++) {
					// ApplicationDetails()
					System.out.println(allStudents.get(i).ApplicantDetails());
				}	// End for
				break;
				
			case "2":
				// Print the Personal Details 
				for(int i = 0; i < allStudents.size(); i++) {
					System.out.println(allStudents.get(i).toString());
				}	// End for				
				break;
				
			case "3":
				System.out.println("Please enter applicant ID: ");
				System.out.print(pre);
				// Validate that the user has entered an Integer
				checkID = ValidateInt(input.next());
				
				// Verify that the ID is correct
				studentIndex = verifyID(checkID);
				
				// If function returns -1 -> No student by that ID entered
				if(studentIndex == invalidIndex) {
					System.out.println("***ID DOES NOT EXIST***\nPlease re-check and try again");			
				}	// End if 
				else {
					// If the ID entered matches then call method to change application details
					changeApplicationDetails(studentIndex);
				}	// End else
				
				break;
				
			case "4":
				System.out.println("Please enter applicant ID: ");
				System.out.print(pre);
				// Validate that the user has entered an Integer
				checkID = ValidateInt(input.next());
				
				// Verify that the ID is correct
				studentIndex = verifyID(checkID);
				
				// If function returns -1 -> No student by that ID entered
				if(studentIndex == invalidIndex) {
					System.out.println("***ID DOES NOT EXIST***\nPlease re-check and try again");			
				} else {
					// If the ID entered matches then call method to change personal details
					changePersonalDetails(studentIndex);
				}
				break;
								
			case "5":
				return;
				
			default: 
				// If input is entered that is not already specified
				System.out.println("Invalid option.\nPlease re-check and try again");
				break;
				
			}	// End switch
			
		}	// End while
		
	}	// End method
	
	/* Method to verify that an ID entered matches a students ID 
	 * -> Return the index of that student in the ArrayList
	 * -> Returns -1 if no student is found
	 */
	public int verifyID(String ID) {
		for(int i = 0; i < allStudents.size(); i++) {
			if(allStudents.get(i).getApplicantID() == Integer.parseInt(ID)) {
				//Return the index of the Student in the array
				return i;
			}	// End if
			
		}	// End for
		
		// Return -1 if studentID is not found
		return invalidIndex;
		
	}	// End method
	
	/* Method to change personal details of students
	 * Takes the index of the student in the array
	 */
	public void changePersonalDetails(int studentIndex) {
		// Get & store the student at the index provided
		Student student =  allStudents.get(studentIndex);
		
		while (true) {
			System.out.println(lineBr);
			System.out.println("***EDIT PERSONAL DETAILS***\n");
			System.out.println("What details would you like to change: ");
			System.out.println("1.Applicant Name\n2.Applicant ID\n3.Student Address\n4.Student DOB\n5.Show personal details\n6.Quit");
			System.out.println(lineBr);
			System.out.print("> ");
			
			switch (input.next()) {
			case "1":
				System.out.println("Enter new applicant name: ");
				System.out.print(pre);
				/* Let the user entered a new name
				 * -> Validate that a String is being entered
				 * -> Use a Setter to set the name
				 */
				student.setApplicantName(ValidateText(input.next()));
				break;
				
			case "2":
				System.out.println("Enter the new Applicant ID: ");
				System.out.print(pre);
				/* Validate that integer has been entered by user
				 * Parse the user input to integer once integer has been entered
				 */
				int newID = Integer.parseInt(ValidateInt(input.next()));
				
				// Variable to check if ID already exists or not in the array
				boolean allowIDChange = true;
				
				for(int i = 0; i < allStudents.size(); i++) {
					// Condition to check all IDs in array to the users input
					if(allStudents.get(i).getApplicantID() == newID) allowIDChange = false;
					
				}	// End for
				
				// If the variable is true allow the change if false deny
				if(allowIDChange) {
					student.setApplicantID(newID);
					System.out.println("***NEW ID SET***");
				}	// End if 
				else {
					System.out.println("***ID ALREADY IN USE***\n**Please re-check and try again**");
				}	// End else
			
				break;
				
			case "3":
				System.out.println("Enter the new student address: ");
				System.out.print(pre);
				// Validate method to ensure String is being entered
				student.setStudentAddress(ValidateText(input.next()));
				break;
				
			case "4":
				/* --
				 * NOTE: All Mature Students are Students,
				 * But not all Students are Mature Students
				 * --
				 * ........
				 * If we can cast the current Student as a 
				 * Mature Student and be successful then this
				 * acts almost as a validation check to see
				 * if the current student invoking the changes
				 * is a mature student or not. Ultimately, 
				 * so the user can change the DOB.
				 * ........
				 * If the 'try' is successful in casting the
				 * student, then the rest of the operations that
				 * follow can operate. 
				 * ........
				 * If the 'catch' is executed due to failure in
				 * casting the Student to Mature Student well, 
				 * then we know it's a Student and not a Mature
				 * within the context of this method. We prompt
				 * the user that this particular option to
				 * applicable to this student.
				 */
				
				// FIXME:USE instance Of next time
				try{
					// Cast the current Student to Mature Student
					MatureStudent mature = (MatureStudent) student;
					System.out.println("Enter the new DOB for the student:");
					System.out.print(pre);
					
					// Validate that the date enter is a valid date
					String newDate = validateDate(input.next());
					
					// Method to ensure that the new date entered validates as a Mature Student
					if(checkMatureStudent(newDate)) {
						// Set the Mature Students Date using a Getter 
						mature.setDOB(newDate);
					}	// End if 
					else {
						System.out.println("***This student is a mature student***\n***Please enter a mature student date***\n***No changes made***");
					}	// End else
						
				} catch(Exception e) {
					System.out.println("***Option not applicable to this student***");
				}	// End catch
				
				break;

			case "5":
				// Print the students information 
				System.out.println(student.toString());
				break;
				
			case "6":
				return;
				
			default:
				// If the user enters input not specified in the menu
				System.out.println("Invalid Option.\nPlease re-check and try again");
				break;
				
			}	// End switch
			
		}	// End while
		
	}	// End method
	
	// Method to change the Application Details of a given student
	// Takes the index of the Student in the array
	public void changeApplicationDetails(int studentIndex) {
		// Get & store the student at the index provided
		Student student =  allStudents.get(studentIndex);
		
		while (true) {
			System.out.println(lineBr);
			System.out.println("***EDIT APPLICATION DETAILS***\n");
			System.out.println("What details would you like to change: ");
			System.out.println("1.Course Name\n2.Course Number\n3.Show Application Details\n4.Quit");
			System.out.println(lineBr);
			System.out.print("> ");
			switch (input.next()) {
			case "1":
				System.out.println("Enter new course name: ");
				System.out.print(pre);
				
				// Validate that String is being entered
				// Use a Setter to set the course name
				student.setCourseName(ValidateText(input.next()));
				break;

			case "2":
				System.out.println("Enter new course number: ");
				System.out.print(pre);
				
				// Validate that integer is being entered
				// Use a Setter to set the course number
				student.setCourseNumber(ValidateInt(input.next()));
				break;

			case "3":
				// Print the Application details of the Student
				// ApplicationDetails()
				System.out.println(student.ApplicantDetails());
				break;

			case "4":
				return;

			default:
				// If the user enters input not specified in the menu
				System.out.println("Invalid Option.\nPlease re-check and try again");
				break;
				
			}	// End switch
			
		}	// End while
		
	}	// End method
	
	// Method to view different details within the array
	public void viewDetails(){
		while (true) {
			System.out.println(lineBr);
			System.out.println("***VIEW DETAILS WINDOW***\n");
			System.out.println("1.View Course Names\n2.View Course IDs\n3.Quit");
			System.out.println(lineBr);
			System.out.print("> ");
			switch (input.next()) {
			case "1":
				for (int i = 0; i <  allStudents.size(); i++) {
					// Print all the course names in the array
					System.out.println(allStudents.get(i).getCourseName());
					
				}	// End for
				break;

			case "2":
				for (int i = 0; i <  allStudents.size(); i++) {
					// Print all the course IDs in the array
					System.out.println( allStudents.get(i).getApplicantID());
				}	// End for
				break;
			case "3":
				return;

			default:
				// If the user enters input not specified in the menu
				System.out.println("Invalid Option.\nPlease re-check and try again");
				break;
				
			}	// End switch
			
		}	// End while
		
	}	// End method
	
	// Validate date format
	public String validateDate(String date) throws ParseException {
		while(!isValidDate(date)) {
			System.out.println("Please enter date in format YYYY-MM-DD: ");
			System.out.print(pre);
			date = input.next();
		}	// End while
		
		return date;
	}	// End method
	
	/* Method to validate that an integer is entered.
	 * Returns String as parsing to Integer is not
	 * required with every call of this function
	 */
	public String ValidateInt(String value) {
		// Checks if the user wants to quit current functionality 
		if(value.toLowerCase().matches("q")) {
			return value; 
		}	// End if
		
		// Loop runs only if input entered does not match numbers
		while(!value.matches("\\d+")) {
			System.out.println("Please enter a number");
			System.out.print(pre);
			// Let the user enter input again 
			value = input.next();
		}	// End while
		
		return value;
	}	// End method
	
	// Method to validate String entries
	public String ValidateText(String value) {
		// Loop only runs if just numbers are entered
		while(value.matches("\\d+")) {
			System.out.println("Numbers only are invalid\nTry Again: ");
			System.out.print(pre);
			
			// Let the user enter input again 
			value = input.next();
		}	// End while
		
		return value;
		
	}	// End method
	
}	// End class
