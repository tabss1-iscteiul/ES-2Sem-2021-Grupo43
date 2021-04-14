package codesmell.writer;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import codesmell.checks.CycloChecker;
import codesmell.checks.CycloMethodChecker;
import codesmell.checks.LineChecker;
import codesmell.checks.LineMethodChecker;
import codesmell.checks.MethodChecker;
import codesmell.report.Report;

public class ExcelWriter implements IWriter {
	private CycloChecker cycloClass;
	private CycloMethodChecker cycloMethod;
	private LineChecker lineChecker;
	private LineMethodChecker lineMethodChecker;
	private MethodChecker numMethods;
	

	@Override
	public void write(Report report) {
		try {
			
			// Lista linhas
			List<Row> listRows = new ArrayList<Row>();

			// Lê e escreve ficheiros excel
			HSSFWorkbook workbook = new HSSFWorkbook();

			// Nome da página do excell
			HSSFSheet sheet = workbook.createSheet("Code Smells");

			// primeira linha EXEMPLOOOOO
			HSSFRow firstLine = sheet.createRow((short)0);
			firstLine.createCell(0).setCellValue("MethodID");
			firstLine.createCell(1).setCellValue("method");
			firstLine.createCell(2).setCellValue("NOM_class");
			firstLine.createCell(3).setCellValue("LOC_class");
			firstLine.createCell(4).setCellValue("WMC_class");
			firstLine.createCell(5).setCellValue("is_God_Class");
			firstLine.createCell(6).setCellValue("CYCLO_method");
			firstLine.createCell(7).setCellValue("is_Long_Method");
			
			
			
			
			// células da primeira linha
			
			
			int index = 1;
			HSSFRow row = sheet.createRow((short) index);
			
			
		/*	
			 Row row = null;
		        while (rs.next()) {
		            //
		            if ( sheetCount <= 1000000 ) {
		                row = sheet.createRow(index);
		                index++;
		            }
		            if ( sheetCount > 1000000 && sheetCount <= 2000000) {
		                row = sheet2.createRow(index2);
		                index2++;
		            }
		            if ( sheetCount > 2000000 && sheetCount <= 3000000) {
		                row = sheet3.createRow(index3);
		                index3++;
		            }
		        }
		          */  
			
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\TOSHIBA\\Documents\\teste\\Code_Smells.xls");
			
			workbook.write(fileOut);
			
			fileOut.close();
			
			workbook.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
