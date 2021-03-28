package codesmell.writer;

import java.util.List;
import java.util.Map;
import codesmell.report.Report;
import codesmell.report.ReportEntry;

public class ConsoleWriter implements IWriter {

	@Override
	public void write(Report report) {
		// TODO Auto-generated method stub
		for (Map.Entry<String, List<ReportEntry>> item : report.getReport().entrySet()) {
			System.out.println("File: " + item.getKey());
			
			for (ReportEntry e : item.getValue()) {
				System.out.printf("\t Report [%15s]: %3s\n", e.getCheckerName(), e.getCheckerValue());						
			}
			System.out.println("");
			
		}
	}

}
