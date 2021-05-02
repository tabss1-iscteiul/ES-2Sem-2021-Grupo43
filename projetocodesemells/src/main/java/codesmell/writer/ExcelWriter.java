package codesmell.writer;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import codesmell.checks.LineChecker;
import codesmell.checks.MethodChecker;
import codesmell.report.IReportEntry;
import codesmell.report.Report;
import codesmell.report.ReportEntry;
import codesmell.report.ReportMultipleEntry;

public class ExcelWriter implements IWriter {

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
			HSSFRow firstLine = sheet.createRow((short) 0);
			firstLine.createCell(0).setCellValue("MethodID");
			firstLine.createCell(1).setCellValue("package");
			firstLine.createCell(2).setCellValue("class");
			firstLine.createCell(3).setCellValue("method");
			firstLine.createCell(4).setCellValue("NOM_class");
			firstLine.createCell(5).setCellValue("LOC_class");
			firstLine.createCell(6).setCellValue("WMC_class");
			firstLine.createCell(7).setCellValue("is_God_Class");
			firstLine.createCell(8).setCellValue("LOC_method");
			firstLine.createCell(9).setCellValue("CYCLO_method");
			firstLine.createCell(10).setCellValue("is_Long_Method");
			// primeira linha
			//HSSFRow rowhead = sheet.createRow((short) 0);


			int index = 1;

			for (Map.Entry<Report.ReportID, List<IReportEntry<?>>> item : report.getReport().entrySet()) {
				Report.ReportID reportID = item.getKey();
				String isGodClass = geIsGodClassFromEntries(item.getValue());
				int lineClass = getlineClassFromEntries(item.getValue());
				int nMethodsClass = getNumberMethodsClassFromEntries(item.getValue());
				int cycloClass = getCycloClassFromEntries(item.getValue());
				
				Map<String, String> cycloMethod = geCycloMethodFromEntries(item.getValue());
				Map<String, String> lineMethod = geLineMethodFromEntries(item.getValue());
				Map<String, String> longMethod = geLongMethodFromEntries(item.getValue());

				for (String mehtodName : cycloMethod.keySet()) {
					HSSFRow row = sheet.createRow((short) index);
					
					row.createCell(0).setCellValue(index++);
					row.createCell(1).setCellValue(reportID.getPackageName());
					row.createCell(2).setCellValue(reportID.getClassName());
					row.createCell(3).setCellValue(mehtodName);
					row.createCell(4).setCellValue(nMethodsClass);
					row.createCell(5).setCellValue(lineClass);
					row.createCell(6).setCellValue(cycloClass);
					if (isGodClass.equals("true")) {
						row.createCell(7).setCellValue("VERDADEIRO");
					} else {
						row.createCell(7).setCellValue("FALSO");
					}
					row.createCell(8).setCellValue(cycloMethod.get(mehtodName));
					row.createCell(9).setCellValue(lineMethod.get(mehtodName));
					if (longMethod.get(mehtodName).equals("true")) {
						row.createCell(10).setCellValue("VERDADEIRO");
					} else {
						row.createCell(10).setCellValue("FALSO");
					}
				}
			}
			

			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\TOSHIBA\\Documents\\teste\\Code_Smells.xls");

			workbook.write(fileOut);

			fileOut.close();

			workbook.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	private int getlineClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("LOC_class")).findFirst()
				.map(e -> Integer.valueOf(((ReportEntry) e).getCheckerValue())).orElse(0);
	}
	
	
	private int getCycloClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("WMC_class")).findFirst()
				.map(e -> Integer.valueOf(((ReportEntry) e).getCheckerValue())).orElse(0);
	}

	private int getNumberMethodsClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("NOM_class")).findFirst()
				.map(e -> Integer.valueOf(((ReportEntry) e).getCheckerValue())).orElse(0);
	}

	private String geIsGodClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("God_class")).findFirst()
				.map(e -> (((ReportEntry) e).getCheckerValue())).get();
	}

	private Map<String, String> geCycloMethodFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("CYCLO_method")).findFirst()
				.map(e -> ((ReportMultipleEntry) e).getCheckerValueAsMap()).orElse(Collections.emptyMap());
	}

	private Map<String, String> geLineMethodFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("LOC_method")).findFirst()
				.map(e -> ((ReportMultipleEntry) e).getCheckerValueAsMap()).orElse(Collections.emptyMap());
	}

	private Map<String, String> geLongMethodFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("Long_Method")).findFirst()
				.map(e -> ((ReportMultipleEntry) e).getCheckerValueAsMap()).orElse(Collections.emptyMap());
	}

}
