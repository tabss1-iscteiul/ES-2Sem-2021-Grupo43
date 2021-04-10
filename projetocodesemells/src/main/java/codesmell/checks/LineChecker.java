package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import codesmell.report.ReportEntry;

public class LineChecker implements IChecker {

	private static final String CHECKER_NAME = "LOC_class";
	private int counter = 0;

	public ReportEntry check(CompilationUnit compilationUnit) {

		counter = compilationUnit.toString().split("\n").length;

		return new ReportEntry(CHECKER_NAME, String.valueOf(counter));
	}

	public String getLineName() {
		return CHECKER_NAME;
	}

	public int getLineClassCounter() {
		return counter;
	}

}
