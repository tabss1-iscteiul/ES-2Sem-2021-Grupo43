package codesmell.writer;

import java.util.Collections;
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
		int methodID = 0;
		for (Map.Entry<Report.ReportID, List<IReportEntry<?>>> item : report.getReport().entrySet()) {
			
			Report.ReportID reportID = item.getKey();
			boolean isGodClass = geIsGodClassFromEntries(item.getValue());
			int nMethodsClass = getNumberMethodsClassFromEntries(item.getValue());
			int cycloClass = getCycloClassFromEntries(item.getValue());
	
			Map<String, String> cycloMethod = geCycloMethodFromEntries(item.getValue());
			Map<String, String> lineMethod = geLineMethodFromEntries(item.getValue());
			Map<String, String> longMethod = geLongMethodFromEntries(item.getValue());
			
			for (String mehtodName : cycloMethod.keySet()) {
				System.out.println();
				System.out.print(++methodID);
				System.out.print("|");
				System.out.print(reportID.getPackageName());
				System.out.print("|");
				System.out.print(reportID.getClassName());
				System.out.print("|");
				System.out.print(mehtodName);
				System.out.print("|");
				System.out.print(nMethodsClass);
				System.out.print("|");
				System.out.print(cycloClass);
				System.out.print("|");
				System.out.print(isGodClass ? "VERDADEIRO" : "FALSO");
				System.out.print("|");
				System.out.print(cycloMethod.get(mehtodName));
				System.out.print("|");
				System.out.print(lineMethod.get(mehtodName));
				System.out.print("|");
				if (longMethod.get(mehtodName).equals("true")) {
					System.out.print("VERDADEIRO");
				}else {
					System.out.print("FALSO");
				}
				System.out.print("|");
			}
			
			
			/*for (IReportEntry<?> e : item.getValue()) {
				if(e.isMultiEntry()) {
					ReportMultipleEntry me = (ReportMultipleEntry)e;
					for (ReportMultipleEntry.Entry en : me.getCheckerValue()) {
						System.out.printf("\t Report [%15s]: %15s - - %3s\n", e.getCheckerName(), en.getName(), en.getValue());						
						
					}
				}else {
					System.out.printf("\t Report [%15s]: %3s\n", e.getCheckerName(), e.getCheckerValue());						
				}
			}
			System.out.println("");*/
			
		}
	}

	private int getCycloClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().
			filter( e -> e.getCheckerName().equals("WMC_class") ).
			findFirst().
			map( e -> Integer.valueOf(((ReportEntry)e).getCheckerValue())).
			orElse(0);
	}

	private int getNumberMethodsClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().
			filter( e -> e.getCheckerName().equals("NOM_class") ).
			findFirst().
			map( e -> Integer.valueOf(((ReportEntry)e).getCheckerValue())).
			orElse(0);
	}

	private boolean geIsGodClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().
			filter( e -> e.getCheckerName().equals("God_class") ).
			findFirst().
			map( e -> Boolean.getBoolean(((ReportEntry)e).getCheckerValue())).
			orElse(false);
	}

	private Map<String, String> geCycloMethodFromEntries(List<IReportEntry<?>> value) {
		return value.stream().
			filter( e -> e.getCheckerName().equals("CYCLO_method") ).
			findFirst().
			map( e -> ((ReportMultipleEntry)e).getCheckerValueAsMap()).
			orElse( Collections.emptyMap())
			;
	}
	
	private Map<String, String> geLineMethodFromEntries(List<IReportEntry<?>> value) {
		return value.stream().
			filter( e -> e.getCheckerName().equals("LOC_method") ).
			findFirst().
			map( e -> ((ReportMultipleEntry)e).getCheckerValueAsMap()).
			orElse( Collections.emptyMap())
			;
	}
	
	private Map<String, String> geLongMethodFromEntries(List<IReportEntry<?>> value) {
		return value.stream().
			filter( e -> e.getCheckerName().equals("Long_Method") ).
			findFirst().
			map( e -> ((ReportMultipleEntry)e).getCheckerValueAsMap()).
			orElse( Collections.emptyMap())
			;
	}
}
