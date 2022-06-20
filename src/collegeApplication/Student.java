package collegeApplication;
/* This is a blueprint class for an Student.
 * This class has no main method. This class 
 * inherits from Applicant. Essentially, all 
 * of the variables and methods that make 
 * up the Applicant class can be accessed 
 * within the context of the student class.
 *  
 * A constructor is present so that whenever 
 * a student object needs to be constructed 
 * the constructor can be invoked with the 
 * appropriate values passed. Super keyword 
 * can be observed within the constructor. 
 * This is to allow the constructor of this 
 * class to invoke the constructor of the 
 * superclass, which is Applicant.
 * 
 * Getters and Setters used in this class to
 * perform encapsulation on the single member 
 * variable present in this class. toString method 
 * also present to override the default toString 
 * method so that information can be presented 
 * to the user. 
 */
public class Student extends Applicant{
	/* Private member variable
	 * Private = Secure
	 * Information pertains to data relating to a student 
	 */
	private String studentAddress;
	
	// Constructor with four parameters
	public Student(String courseName, String courseNumber, String applicantName, String studentAddress) {
		super(courseName, courseNumber, applicantName);
		this.studentAddress = studentAddress;
	}	// End constructor

	/* Getters & Setters
	 * -> Perform encapsulation
	 * -> Wrapping of private fields in methods to make more accessible
	 */
	public String getStudentAddress() {
		return studentAddress;
	}	// End get

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}	// End set

	// Method to override the default toString
	@Override
	public String toString() {
		return  super.toString()
				+ ", Address: " 
				+ studentAddress;
	}	// End toString
	
	// Method to invoke the parent toString of this particular class
	public String ApplicantDetails() {
		return super.ApplicantDetails();
	}	// End method	

}	// End class 
