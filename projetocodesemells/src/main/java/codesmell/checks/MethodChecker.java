package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import codesmell.report.ReportEntry;

public class MethodChecker implements IChecker {
	private static final String CHECKER_NAME = "MethodChecker";

	public ReportEntry check(CompilationUnit compilationUnit) {
		int result = compilationUnit.findAll(MethodDeclaration.class).size();

		/*compilationUnit.findAll(MethodDeclaration.class).forEach( m -> {
			
			System.out.println("Method " + m.getNameAsString() + "    Lines " + (m.toString().split("\n").length));
		});*/
		return new ReportEntry(CHECKER_NAME, String.valueOf(result));
	}
	
	public String getMethodName() {
		return CHECKER_NAME;
	}

}
