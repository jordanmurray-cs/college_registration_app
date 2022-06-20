package collegeApplication;
/* This class has no main method. This 
 * class inherits from the Student Holder 
 * class. Main purpose really being to 
 * access both the Array List that holds 
 * all of the students as well as, to 
 * access the Scanner class to allow input 
 * from the user. This class acts as a 
 * functional interface for the user to 
 * intact some basic CRUD functionality 
 * with a file. The contents of the file 
 * in this instance is going to be all 
 * the students that are contained are 
 * within the Array List in the separate 
 * class.
 * 
 * Many methods can be found within the body 
 * of this class. Methods pertaining basic file 
 * management functionality including adding 
 * file, deleting, checking exists and the general 
 * interface to interact with all of the 
 * functionality.
 * 
 */
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagement extends StudentsHolder {
	// Everything that will be written to the external file will be kept here
    private String fileContents = "";
    
    // This will be name of the file
    private String fileName = "All-Students";
    
    // The full path to the file will be stored here 
	private Path path = Paths.get(fileName);
	
	// Method to allow a file to be created whenever called
	private void createFile() throws IOException {
	    try {
	    	// Only runs if the file does not exist
	    	if(!checkExists(path)) {
			    for(int i = 0; i < allStudents.size(); i++) {
			    	// Each students information were adding to the variable file contents
			    	fileContents += allStudents.get(i).toString() + "\n";
			    }	// End for
			    
			    // Create the file using BufferWriter 
			    /* Create a new instance of BufferWriter,
			     * pass a new instance of file writer as 
			     * it's parameter
			     */
			    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			    
			    /* Insert everything that is contained within the variable of 
			     * file contents, into the file itself 
			     */
			    writer.write(fileContents);
			    
			    // Close the file
			    writer.close();
			    
			    // Print that the file has been successfully created, display location also
			    System.out.println("\n***File successfully wrote***\n");
			    System.out.println("FILENAME: " 
			    		+ fileName 
			    		+ "\nLOCATION: " 
			    		+ path.toAbsolutePath() + "\n");
			    
	    	}	// End if
	    	
	    	// Else statement executed if the file already exists
	    	else {
	    		System.out.println("\n***FILE ALREADY EXISTS***\n");
	    	}	// End else
		    
	    }	// End try 
	    
	    catch(IOException e){
	    	System.out.println("Something occurred: " + e);
	    	
	    }	// End catch
	    
	}	// End method
	
	// Method that returns true if file exists, returns false otherwise
	// Takes the path the file as a parameter
	private boolean checkExists(Path filePath) {
		if(Files.exists(filePath)) return true; else return false;
	}	// End method
	
	// Method to delete the file
	// Takes the path to the file as parameter
	public void deleteFile(Path filePath) {
		try {
			Files.delete(filePath);
		}	// End try
		
		catch(Exception e) {
			System.out.println(e);
		}	// End catch
		
	}	// End method
	
	// This is the main interface that the user will see
	// Allow functionality pertaining to file management is performed here 
	public void FileManagementInterface() {		
		// While loop only runs if true
		while (true) {
			System.out.println(lineBr);
			System.out.println("***FILE MANAGEMENT***\n");
			System.out.println("1.Create File\n2.Check File Exists\n3.Open File\n4.Delete File\n5.Quit");
			System.out.println(lineBr);
			System.out.print(pre);
			
			// Switch statement with parameter being user input
			switch (input.next()) {
			case "1":
				// Try create the file
				try { createFile(); }	// End try 
				catch (Exception e) { System.out.println(e); }	// End catch
				break;

			case "2":
				// If the file exists at the given path
				if (checkExists(path)) {
					System.out.println("\n***FILE EXISTS***\n");
					
					// Display the file name and the path to the file to the user 
					System.out.println("\nFILENAME: " + fileName + "\nLOCATION: " + path.toAbsolutePath() + "\n");
				}	// End if 
				
				else { System.out.println("\n***FILE DOES NOT EXIST***\n"); }	// End else
				break;
				
			case "3":
				try{  
					//constructor of file class having file as argument  
					File file = new File(String.valueOf(path));
					
					//check if Desktop is supported by Platform or not  
					if(!Desktop.isDesktopSupported()){  
						System.out.println("not supported");  
						return;  
					}	// End if
					
					Desktop desktop = Desktop.getDesktop();
					//checks file exists or not
					if(file.exists()) 
						//opens the specified file
						System.out.println("\nOpening file...\n");
						desktop.open(file);		
				}	// End try  
				
				catch(Exception e) { System.out.println(e); }	// End catch
				break;
				
			case "4":
				try {
					// If the file exists, delete it
					if(checkExists(path)) {
						// Delete the file at the specific path
						Files.delete(path);
						System.out.println("\n***FILE DELETED***\n");
					}	// End if
					
					else { System.out.println("\n***FILE DOES NOT EXIST***\n"); }	// End else

				}	// End try 
				
				catch (IOException e) { e.printStackTrace(); }	// End catch
				break;
				
			case "5":
				return;
				
			default:
				// Default runs option is chosen that is not specified
				System.out.println("Invalid option");
				break;

			}	// End switch
			
		}	// End while
		
	}	//  End method
	
}	// End class
