package codesmell.txt;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class WriterTXT {

	public void write (int nomC, String regra1, int locC, String regra2, int wmcC, int locM, String regra3, int cycloM) {
		 try {
		      FileWriter myWriter = new FileWriter("C:\\Users\\ana_r\\Desktop\\filename.txt"); //indicar depois o caminho
		      myWriter.write(nomC + "\n");
		      myWriter.write(regra1 + "\n");
		      myWriter.write(locC + "\n");
		      myWriter.write(regra2 + "\n");
		      myWriter.write(wmcC + "\n");
		      
		      
		      myWriter.write(locM +  "\n");
		      myWriter.write(regra3 + "\n");
		      myWriter.write(cycloM +  "\n");
		      myWriter.close();
		      
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	}
	
	
	  public static void main(String[] args) {
	   WriterTXT writeT = new WriterTXT ( );
	   writeT.write(10, "AND", 10, "AND", 10, 10, "AND", 10);
	  }
	
	

	


}
