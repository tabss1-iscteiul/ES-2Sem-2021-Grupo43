package codesmell.writer;



import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import codesmell.report.Report;

public class ExcelWriter implements IWriter {

	@Override
	public void write(Report report) {
		List<Row> listRows = new ArrayList<Row>();
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//Nome da página do excell
		HSSFSheet sheet = workbook.createSheet("Code Semells"); 
		
		//primeira linha 
		HSSFRow rowhead = sheet.createRow((short)0);
		
		
		
		
		
		
	}

}
