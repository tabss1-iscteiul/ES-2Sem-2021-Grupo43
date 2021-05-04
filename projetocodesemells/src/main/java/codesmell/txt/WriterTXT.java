package codesmell.txt;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors



public class WriterTXT {

	
	  public static void main(String[] args) {
	    try {
	      FileWriter myWriter = new FileWriter("filename.txt");
	      myWriter.write("Numero NOM_CLASS\n");
	      myWriter.write("AND\n");
	      myWriter.write("Numero LOC_CLASS\n");
	      myWriter.write("AND\n");
	      myWriter.write("Numero WMC_CLASS\n");
	      
	      
	      myWriter.write("Numero LOC_METHOD\n");
	      myWriter.write("AND\n");
	      myWriter.write("Numero CYCLO_METHOD\n");
	      myWriter.close();
	      
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	
	


}
