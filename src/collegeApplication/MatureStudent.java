package collegeApplication;
/* This is a blueprint class for an Mature Student. 
 * This class has no main method. This class inherits 
 * from the Student class. So given that inheritance 
 * is at play here with Mature Student inheriting from 
 * Student, all the behaviour and attributes associated 
 * with student can be accessed in this class.
 *  
 * When the constructor that resides in this class is 
 * invoked, it inherently invokes the Student 
 * constructor which is the superclass in this instance.
 * This is done through proper use of the super keyword
 * that is present in this classes constructor.
 * 
 * Getters & Setters are used in this class to perform 
 * encapsulation on the private field that resides in 
 * this class. A toString method is also present that 
 * overrides the default toString method.
 */

public class MatureStudent extends Student{
	/* Private member variable
	 * Private = Secure
	 */
	private String DOB;
	
	// Constructor with five parameters
	public MatureStudent(String courseName, String courseNumber, String applicantName, String studentAddress, String DOB) {
		super(courseName, courseNumber, applicantName, studentAddress);
		this.DOB = DOB;
	}	// End constructor

	/* Getters & Setters
	 * -> Perform encapsulation
	 * -> Wrapping of private fields in methods to make more accessible
	 */
	public String getDOB() {
		return DOB;
	}	// End get

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}	// End set
	
	// Method to override the default toString
	@Override
	public String toString() {
		return 	super.toString()
				+ ", DOB: "
				+ DOB; 
	}	// End toString
	
	// Method to invoke the parent toString of this particular class
	public String ApplicantDetails() {
		return super.ApplicantDetails();
	}	// End method	
	
}	// End class 
