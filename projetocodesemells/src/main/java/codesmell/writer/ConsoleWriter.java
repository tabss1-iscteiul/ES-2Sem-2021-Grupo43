package codesmell.writer;

import java.util.List;
import java.util.Map;

import codesmell.report.IReportEntry;
import codesmell.report.Report;
import codesmell.report.ReportEntry;
import codesmell.report.ReportMultipleEntry;

public class ConsoleWriter implements IWriter {

	@Override
	public void write(Report report) {
		// TODO Auto-generated method stub
		for (Map.Entry<String, List<IReportEntry<?>>> item : report.getReport().entrySet()) {
			System.out.println("File: " + item.getKey());
			
			for (IReportEntry<?> e : item.getValue()) {
				if(e.isMultiEntry()) {
					ReportMultipleEntry me = (ReportMultipleEntry)e;
					for (ReportMultipleEntry.Entry en : me.getCheckerValue()) {
						System.out.printf("\t Report [%15s]: %15s - - %3s\n", e.getCheckerName(), en.getName(), en.getValue());						
						
					}
				}else {
					System.out.printf("\t Report [%15s]: %3s\n", e.getCheckerName(), e.getCheckerValue());						
				}
			}
			System.out.println("");
			
		}
	}

}
