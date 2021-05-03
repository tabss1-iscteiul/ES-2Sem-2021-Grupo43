package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import codesmell.report.ReportEntry;

public class LineChecker implements IChecker {
	private static final String CHECKER_NAME = "LOC_class";// calculo das linhas de codigo da classe
	
	public ReportEntry check(CompilationUnit compilationUnit) {
		
		int result = compilationUnit.toString().split("\n").length;
		
		return new ReportEntry(CHECKER_NAME, String.valueOf(result));
	}
	
	@Override
	public String getCheckerName() {
		return CHECKER_NAME;
	}
}
