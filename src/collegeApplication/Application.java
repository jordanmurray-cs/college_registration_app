package collegeApplication;
/* This is a blueprint class for an Application. 
 * This class has no main method. The Application
 * class has two private fields belonging to it
 * which are course name and course number. 
 * Encapsulation is needed to access the private
 * field so Getters and Setters can be observed
 * within this class. A constructor and a 
 * toString can also be observed within this class.
 * 
 * In the context of this program, this class 
 * essentially acts as the parent class to many 
 * of the other sub classes that can be seen in
 * the program. Can be viewed almost as a tree
 * with this class situated at the top and all
 * the other classes preceding it.
 */
public abstract class Application {
	/* Private = Secure
	 * Members variables -> Belong to the class
	 */
	private String courseName, courseNumber;
	
	// Constructor with two parameters
	public Application(String courseName, String courseNumber) {
		this.courseName = courseName;
		this.courseNumber = courseNumber;
	}	// End constructor

	/* Getters & Setters
	 * -> Perform encapsulation
	 * -> Wrapping private fields in methods to make them accessible
	 */
	public String getCourseName() {
		return courseName;
	}	// End get

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}	// End set

	public String getCourseNumber() {
		return courseNumber;
	}	// End get

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}	// End set
	
	// Method to override the default toString
	@Override
	public String toString() {
		return "Application Details = Course Name: " 
				+ courseName 
				+ ", Course Number: " 
				+ courseNumber;
	}	// End toString	
	
}	// End class
