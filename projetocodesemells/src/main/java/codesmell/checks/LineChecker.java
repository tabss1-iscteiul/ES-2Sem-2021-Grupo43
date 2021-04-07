package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import codesmell.report.ReportEntry;

public class LineChecker implements IChecker {
	
	//número de linhas de código 
	private static final String CHECKER_NAME = "LineChecker";
	
	public ReportEntry check(CompilationUnit compilationUnit) {
		
		int result = compilationUnit.toString().split("\n").length;
		
		
		return new ReportEntry(CHECKER_NAME, String.valueOf(result));
	}
	public String getLineName() {
		return CHECKER_NAME;
	}
}
