package codesmell.txt;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.util.Scanner; // Import the Scanner class to read text files

public class ReaderTXT {

	public String nomC;
	public String locC;
	public String wmcC;
	public String locM;
	public String cycloM;
	public String regra1;
	public String regra2;
	public String regra3;
	
	public ReaderTXT() {
		
	}
	
	//Metodo que le o ficheiro txt com as regras guardadas pelo utilizador
	public void readFile(String path) {
		try {
		      File file = new File(path);
		      Scanner txtReader = new Scanner(file);
		      while (txtReader.hasNextLine()) {
		    	
		    	  
					nomC = txtReader.nextLine();
					regra1 = txtReader.nextLine();
					locC = txtReader.nextLine();
					regra2 = txtReader.nextLine();
					wmcC = txtReader.nextLine();

					locM = txtReader.nextLine();
					regra3 = txtReader.nextLine();
					cycloM = txtReader.nextLine();
		          System.out.println(nomC);  
		          System.out.println(regra1);
		          System.out.println(locC);
		          System.out.println(regra2);
		          System.out.println(wmcC );
		          System.out.println(locM);
		          System.out.println(regra3);
		          System.out.println(cycloM);
		    
		      }
		      	txtReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		}
		
		
	
	
	

}
