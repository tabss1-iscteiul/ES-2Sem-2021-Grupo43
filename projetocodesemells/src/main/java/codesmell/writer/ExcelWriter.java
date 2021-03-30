package codesmell.writer;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import codesmell.checks.LineChecker;
import codesmell.checks.MethodChecker;
import codesmell.report.Report;

public class ExcelWriter implements IWriter {
	private LineChecker line;
	private MethodChecker method;

	@Override
	public void write(Report report) {
		try {
			List<Row> listRows = new ArrayList<Row>();

			HSSFWorkbook workbook = new HSSFWorkbook();

			// Nome da página do excell
			HSSFSheet sheet = workbook.createSheet("Code Semells");

			// primeira linha
			HSSFRow rowhead = sheet.createRow((short) 0);

			// células da primeira linha
			rowhead.createCell(0).setCellValue(line.getLineName());
			rowhead.createCell(1).setCellValue(method.getMethodName());

			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\TOSHIBA\\Documents\\teste\\Code_Smells.xls");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
