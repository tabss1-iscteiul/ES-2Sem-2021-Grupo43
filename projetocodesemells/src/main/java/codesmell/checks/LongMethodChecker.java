package codesmell.checks;

import java.util.Map;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.ReportArrayEntry;
import codesmell.report.ReportMultipleEntry;

public class LongMethodChecker implements IChecker {//code smells para metodos
	private CycloMethodChecker cycloMethod = new CycloMethodChecker();
	private LineMethodChecker lineMethodChecker = new LineMethodChecker();

	private int lineCodeMethod = 50;
	private int maxCiclomacyMethod = 10;
	private String regra3;
	
	private static final String CHECKER_NAME = "Long_Method";

	public LongMethodChecker() {
	}

	//Construtor que recebe as regras para definir se é long method ou nao
	
	public LongMethodChecker(int lineCodeMethod, int maxCiclomacyMethod, String regra3) {
		this.lineCodeMethod = lineCodeMethod;
		this.maxCiclomacyMethod = maxCiclomacyMethod;
		this.regra3=regra3;
	}

	//Metodo que verifica se é long method ou nao
	public ReportArrayEntry check(CompilationUnit compilationUnit) {

		ReportMultipleEntry cycloResult = cycloMethod.check(compilationUnit);
		ReportMultipleEntry lineMethodResult = lineMethodChecker.check(compilationUnit);

		Map<String, String> cycloResultMap = cycloResult.getCheckerValueAsMap();
		Map<String, String> lineMethodResultMap = lineMethodResult.getCheckerValueAsMap();
		ReportMultipleEntry longMethodResult = new ReportMultipleEntry(CHECKER_NAME);

		for (String methodName : cycloResultMap.keySet()) {
			String cycloResultForMethod = cycloResultMap.get(methodName);
			String lineMethodResultForMethod = lineMethodResultMap.get(methodName);

			if (regra3 == "AND") {
				if (Integer.valueOf(lineMethodResultForMethod) > lineCodeMethod
						&& Integer.valueOf(cycloResultForMethod) > maxCiclomacyMethod) {
					longMethodResult.addEntry(methodName, "true");
				} else {
					longMethodResult.addEntry(methodName, "false");
				}
			}
			
			if (regra3 == "OR") {
				if (Integer.valueOf(lineMethodResultForMethod) > lineCodeMethod
						|| Integer.valueOf(cycloResultForMethod) > maxCiclomacyMethod) {
					longMethodResult.addEntry(methodName, "true");
				} else {
					longMethodResult.addEntry(methodName, "false");
				}
			}

		}
		ReportArrayEntry result = new ReportArrayEntry();
		result.addReportEntry(cycloResult);
		result.addReportEntry(lineMethodResult);
		result.addReportEntry(longMethodResult);
		return result;
	}

	public String getCheckerName() {
		return CHECKER_NAME;
	}
}
