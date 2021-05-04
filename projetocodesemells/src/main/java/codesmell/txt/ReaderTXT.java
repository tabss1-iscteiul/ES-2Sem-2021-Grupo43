package codesmell.txt;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReaderTXT {

	
	public void readFile(String path) {
		try {
		      File file = new File(path);
		      Scanner txtReader = new Scanner(file);
		      while (txtReader.hasNextLine()) {
		    	
		    	  int nomC = txtReader.nextInt();
		          String regra1 = txtReader.next();
		          int locC = txtReader.nextInt();
		          String regra2 = txtReader.next();
		          int wmcC = txtReader.nextInt();
		          
		          int locM = txtReader.nextInt();
		          String regra3 = txtReader.next();
		          int cycloM = txtReader.nextInt();
		         	         
		    	  
		    	  System.out.println("Classes");
		    	  System.out.println(nomC + "\n" + regra1 + "\n" + locC + "\n" + regra2 + "\n" +wmcC + "\n" );
		    	  
		    	  
		    	  System.out.println("Métodos");
		    	  System.out.println(locM + "\n" + regra3 + "\n" + cycloM + "\n"  );
		    	  break;
		        //String data = myReader.nextLine();
		        //System.out.println(data);
		      }
		      txtReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		}
		
		
	
	
	
	  public static void main(String[] args) {
		  ReaderTXT readT = new ReaderTXT ( );
		  readT.readFile("C:\\Users\\ana_r\\Desktop\\filename.txt");
	  }

}
