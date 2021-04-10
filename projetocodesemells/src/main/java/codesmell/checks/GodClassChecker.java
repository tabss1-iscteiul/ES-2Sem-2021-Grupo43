package codesmell.checks;


import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.ReportArrayEntry;
import codesmell.report.ReportEntry;

public class GodClassChecker implements IChecker {
	
	private int maxCyclomacy = 50;
	private int maxNumberMethod =10;
	
	
	private CycloChecker cycloChecker = new CycloChecker();
	private MethodChecker methodChecker = new MethodChecker();

	private static final String CHECKER_NAME = "Long_Method";
	
	
	public GodClassChecker() {
	}

	public GodClassChecker(int maxCyclomacy, int maxNumberMethod) {
		this.maxCyclomacy = maxCyclomacy;
		this.maxNumberMethod = maxNumberMethod;
	}

	public ReportArrayEntry check(CompilationUnit compilationUnit) {

		ReportEntry cycloResult = cycloChecker.check(compilationUnit);
		ReportEntry methodResult = methodChecker.check(compilationUnit);

		ReportEntry godClassResult;
		if (Integer.valueOf(cycloResult.getCheckerValue()) > maxCyclomacy && Integer.valueOf(methodResult.getCheckerValue()) > maxNumberMethod) {
			godClassResult = new ReportEntry(CHECKER_NAME, "true");
		} else {
			godClassResult = new ReportEntry(CHECKER_NAME, "false");
		}
		ReportArrayEntry result = new ReportArrayEntry();
		result.addReportEntry(cycloResult);
		result.addReportEntry(methodResult);
		result.addReportEntry(godClassResult);
		return result;
	}

	public String getCheckerName() {
		return CHECKER_NAME;
	}
}
