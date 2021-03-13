package Codesmells.projetocodesemells;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CodeSmells {

	public void writeExcell() {

		try {
			Workbook workbook = new XSSFWorkbook();
			
			Sheet sh = workbook.createSheet("Invoices");

			String[] collumHeadings = { "Item id", "Item Name", "Qty", "Item Price", "Sold Date" };

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 12);
			headerFont.setColor(IndexedColors.BLACK.index);

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFont(headerFont);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

			Row headerRow = sh.createRow(0);

			for (int i = 0; i < collumHeadings.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(collumHeadings[i]);
				cell.setCellStyle(headerStyle);
			}



			for (int i = 0; i < collumHeadings.length; i++) {
				sh.autoSizeColumn(i);
			}
			Sheet sh2 = workbook.createSheet("Second");

			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\TOSHIBA\\Documents\\teste\\invoices.xls");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
			System.out.println("Completed");

		} catch (Exception e) {

		}

	}

	
	
	
	public static void main(String[] args) {
		new CodeSmells().writeExcell();
	}
}