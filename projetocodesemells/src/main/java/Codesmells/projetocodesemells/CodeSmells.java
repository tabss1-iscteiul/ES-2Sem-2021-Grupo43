package Codesmells.projetocodesemells;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CodeSmells {
	
	private File file;
	private String path;
	
	public CodeSmells() throws IOException{
		this.path = "C:/Users/TOSHIBA/Documents/codesmells/Code_Smells.xlsx" ;
		this.file = new File(path);
		readExcell();
	}
	
	
	public void readExcell() throws IOException {
		
		FileInputStream input = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.print(cell.toString()+ " ; ");
			}
			System.out.println();
		}
		workbook.close();
		input.close();
		
	}
	
	
    public static void main( String[] args )throws IOException{
       new CodeSmells();
    }
}