package codesmell.checks;

import java.util.Map;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.ReportArrayEntry;
import codesmell.report.ReportMultipleEntry;


public class LongMethodChecker implements IChecker {
	private CycloMethodChecker cycloMethod = new CycloMethodChecker();
	private LineMethodChecker lineMethodChecker = new LineMethodChecker();

	private static final String CHECKER_NAME = "Long_Method";

	public ReportArrayEntry check(CompilationUnit compilationUnit) {

		ReportMultipleEntry cycloResult = cycloMethod.check(compilationUnit);
		ReportMultipleEntry lineMethodResult = lineMethodChecker.check(compilationUnit);
		
		Map<String,String> cycloResultMap = cycloResult.getCheckerValueAsMap();
		Map<String,String> lineMethodResultMap = lineMethodResult.getCheckerValueAsMap();
		ReportMultipleEntry  longMethodResult = new ReportMultipleEntry(CHECKER_NAME);
		
		
		for (String methodName :  cycloResultMap.keySet()) {
			String cycloResultForMethod = cycloResultMap.get(methodName);
			String lineMethodResultForMethod = lineMethodResultMap.get(methodName);
			
			if (Integer.valueOf(lineMethodResultForMethod) > 50 && Integer.valueOf(cycloResultForMethod) > 10) {
				longMethodResult.addEntry(methodName, "true");
			}else {
				longMethodResult.addEntry(methodName, "false");
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