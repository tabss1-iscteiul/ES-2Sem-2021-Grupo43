package codesmell.writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel {

	private static String[] columns = {"MethodID", "package", "class", "method", "NOM_class", "LOC_class", "WMC_class", 
			"is_God_Class", "LOC_method", "CYCLO_method", "is_Long_Method"};
	
	private static List<Row> rows = new ArrayList<Row>();
	
	public static void main(String[] args) {
		
		//for para correr as linhas
		
		Workbook worbook = new XSSFWorkbook();
		
		Sheet sheet = worbook.createSheet("Row");
		
		Row headerRow = sheet.createRow(0);
		
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}
		
		int rowNum = 1;
		//for (Col rows : rows) {

	/*	for (Col rows : rows) {

			Row row = sheet.createRow(rowNum);
			///row.createCell(0).setCellValue(row.MethodID);
			
		
		}*/
		
	}
		
		
}


