package codesmell.txt;


import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors



public class WriterTXT {

	//Metodo que escreve num ficheiro txt as regras que o utilizador pretende guardar
	public void write (int nomC, String regra1, int locC, String regra2, int wmcC, int locM, String regra3, int cycloM, String destino) {
		 try {
		     FileWriter writeTXT= new FileWriter(destino);
		     
			//indicar depois o caminho
		      writeTXT.write(nomC + "\n");
		      writeTXT.write(regra1 + "\n");
		      writeTXT.write(locC + "\n");
		      writeTXT.write(regra2 + "\n");
		      writeTXT.write(wmcC + "\n");
		      
		      
		      writeTXT.write(locM +  "\n");
		      writeTXT.write(regra3 + "\n");
		      writeTXT.write(cycloM +  "\n");
		      writeTXT.close();
		      
		      
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	}
	
	
	
	

	


}
