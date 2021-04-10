package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import codesmell.report.ReportEntry;

public class MethodChecker implements IChecker {
	private static final String CHECKER_NAME = "NOM_class";
	private int counter = 0;
	
	public ReportEntry check(CompilationUnit compilationUnit) {
		counter = compilationUnit.findAll(MethodDeclaration.class).size();

		return new ReportEntry(CHECKER_NAME, String.valueOf(counter));
	}
	
	public String getMethodName() {
		return CHECKER_NAME;
	}
	
	public int getMethodCounter() {
		return counter;
	}

}
