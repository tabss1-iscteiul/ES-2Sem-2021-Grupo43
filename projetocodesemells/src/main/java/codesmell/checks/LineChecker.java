package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import codesmell.report.ReportEntry;

public class LineChecker implements IChecker {

	private static final String CHECKER_NAME = "LOC_class";

	public ReportEntry check(CompilationUnit compilationUnit) {

		int counter = compilationUnit.toString().split("\n").length;

		return new ReportEntry(CHECKER_NAME, String.valueOf(counter));
	}

	public String getCheckerName() {
		return CHECKER_NAME;
	}
}
