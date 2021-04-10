package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import codesmell.report.ReportEntry;

public class MethodChecker implements IChecker {
	private static final String CHECKER_NAME = "NOM_class";
	
	public ReportEntry check(CompilationUnit compilationUnit) {
		int counter = compilationUnit.findAll(MethodDeclaration.class).size();

		return new ReportEntry(CHECKER_NAME, String.valueOf(counter));
	}
	
	public String getCheckerName() {
		return CHECKER_NAME;
	}
}
