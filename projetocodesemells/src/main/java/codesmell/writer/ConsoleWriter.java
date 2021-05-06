package codesmell.writer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import codesmell.report.IReportEntry;
import codesmell.report.Report;
import codesmell.report.ReportEntry;
import codesmell.report.ReportMultipleEntry;

public class ConsoleWriter implements IWriter {
	
	private int counterClasses = 0;
	private int countLines = 0;
	private int countMethods =0;
	private int counterPackages = 0;
	//para escrever na consola do java para saber que esta a funcionar 
	
	@Override
	public void write(Report report) {
		int methodID = 0;
		for (Map.Entry<Report.ReportID, List<IReportEntry<?>>> item : report.getReport().entrySet()) {

			Report.ReportID reportID = item.getKey();
			// boolean isGodClass = geIsGodClassFromEntries(item.getValue());
			String isGodClass = geIsGodClassFromEntries(item.getValue());
			int lineClass = getlineClassFromEntries(item.getValue());
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
				System.out.print(lineClass);
				System.out.print("|");
				System.out.print(cycloClass);
				System.out.print("|");
				// System.out.print(isGodClass ? "VERDADEIRO" : "FALSO");
				if (isGodClass.equals("true")) {
					System.out.print("VERDADEIRO");
				} else {
					System.out.print("FALSO");
				}
				System.out.print("|");
				System.out.print(cycloMethod.get(mehtodName));
				System.out.print("|");
				System.out.print(lineMethod.get(mehtodName));
				System.out.print("|");
				if (longMethod.get(mehtodName).equals("true")) {
					System.out.print("VERDADEIRO");
				} else {
					System.out.print("FALSO");
				}
				System.out.print("|");
			}
		}
	}

	private  int getlineClassFromEntries(List<IReportEntry<?>> value) {
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

	private String geIsGodClassFromEntries(List<IReportEntry<?>> value) {
		return value.stream().filter(e -> e.getCheckerName().equals("God_class")).findFirst()
				.map(e -> (((ReportEntry) e).getCheckerValue())).get();
	}

	public int counterClasses(Report report) {
		for (Map.Entry<Report.ReportID, List<IReportEntry<?>>> item : report.getReport().entrySet()) {
			String classes = item.getKey().getClassName();
			counterClasses++;
		}
		return counterClasses;
	}

	public int counterLinesByMethod(Report report) {
		int counterLineMethods = 0;
		for (Map.Entry<Report.ReportID, List<IReportEntry<?>>> item : report.getReport().entrySet()) {
			Map<String, String> lineMethods = geLineMethodFromEntries(item.getValue());
			for (String lineMethod : lineMethods.keySet()) {
				counterLineMethods = Integer.valueOf(lineMethods.get(lineMethod));
				countLines += counterLineMethods;
			}
		}
		System.out.println(countLines);
		return countLines;
	}
	
	public int counterPackages(Report report) {
		Map<String, String> mapTest = new HashedMap<String, String>(); 
		for (Map.Entry<Report.ReportID, List<IReportEntry<?>>> item : report.getReport().entrySet()) {
			mapTest.put(item.getKey().getPackageName(), item.getKey().getClassName());
		}
		for (String p : mapTest.keySet()){
			counterPackages ++;
			
		}
		return counterPackages;
	}
	
	public int counterMethods(Report report) {
		for (Map.Entry<Report.ReportID, List<IReportEntry<?>>> item : report.getReport().entrySet()) {
			Map<String, String> cycloMethod = geCycloMethodFromEntries(item.getValue());
			for (String cycloMethods : cycloMethod.keySet()) {
				countMethods ++;
			}
		}
		return countMethods;
	}
}
