package collegeApplication;
/* This class is a blueprint for an Applicant. 
 * This class has no main method but is used by 
 * other classes within the program. The member
 * variables associated with this class include
 * an applicant name, id and automatic number 
 * generator. 
 * 
 * Functions that can be observed in
 * this class would include Getters and Setters
 * to perform encapsulation on the member variables
 * previously stated. 
 * 
 * A constructor is also present as well passing
 * both applicant name and id in addition to, 
 * using the super keyword to invoke the parent
 * constructor which in this instance is the 
 * Application class. Inheritance is what
 * allows this program to instantiate a constructor
 * using a superclass.
 * 
 * A method to override
 * the default toString is also in this class to
 * present information to the user whenever 
 * the need arises. 
 */
public abstract class Applicant extends Application {
	// Member variables belonging to the class 
	private String applicantName;
	private int applicantID;
	
	/* Variable declared in a static frame of reference
	 * purpose -> prolong the life of the variable for 
	 * the entire program
	 */
	// Automatically generated Applicant ID value
	static private int nextID = 1000;
	
	// Constructor with three parameters
	public Applicant(String courseName, String courseNumber, String applicantName) {
		// Super keyword to invoke the superclass / parent constructor
		super(courseName, courseNumber);
		this.applicantName = applicantName;
		// Decrement nextID every time constructor is invoked 
		this.applicantID = nextID--;
	}	// End constructor
	
	// Getters & Setters 
	// -> Perform encapsulation
	// -> Making private member variables accessible 
	public String getApplicantName() {
		return applicantName;
	}	// End get

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}	// End set

	public int getApplicantID() {
		return applicantID;
	}	// End get

	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}	// End set

	// Method to override the default toString
	@Override
	public String toString() {
		return "Personal Details = Name: " 
				+ applicantName 
				+ ", ID: " 
				+ applicantID;
	}	// End toString
	
	// Function to call upon the parent toString
	// ApplicationDetails
	public String ApplicantDetails() {
		return super.toString();
	}	// End method
	
}	// End class
