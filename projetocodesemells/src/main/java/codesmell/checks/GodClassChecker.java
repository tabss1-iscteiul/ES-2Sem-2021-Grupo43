
package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.ReportArrayEntry;
import codesmell.report.ReportEntry;

public class GodClassChecker implements IChecker {

	private int maxCyclomacy = 50;
	private int maxNumberMethod = 10;
	private int maxNumberLinesCode = 500;

	private CycloChecker cycloChecker = new CycloChecker();
	private MethodChecker methodChecker = new MethodChecker();
	private LineChecker lineChecker = new LineChecker();

	private static final String CHECKER_NAME = "God_class";

	public GodClassChecker() {
	}

	public GodClassChecker(int maxCyclomacy, int maxNumberMethod) {
		this.maxCyclomacy = maxCyclomacy;
		this.maxNumberMethod = maxNumberMethod;
	}
	
	public GodClassChecker(int maxCyclomacy, int maxNumberMethod, int maxNumberLinesCode) {
		this.maxCyclomacy = maxCyclomacy;
		this.maxNumberMethod = maxNumberMethod;
		this.maxNumberLinesCode = maxNumberLinesCode;
	}

	public ReportArrayEntry check(CompilationUnit compilationUnit) {

		ReportEntry cycloResult = cycloChecker.check(compilationUnit);
		ReportEntry methodResult = methodChecker.check(compilationUnit);
		ReportEntry lineResult = lineChecker.check(compilationUnit);

		ReportEntry godClassResult;
		if (Integer.valueOf(cycloResult.getCheckerValue()) > maxCyclomacy
				&& Integer.valueOf(methodResult.getCheckerValue()) > maxNumberMethod  
				&& Integer.valueOf(lineResult.getCheckerValue())> maxNumberLinesCode) {
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
