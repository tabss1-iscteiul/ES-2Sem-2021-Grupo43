package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import codesmell.report.ReportEntry;

public class MethodChecker implements IChecker {//numero de metodos da classe 
	private static final String CHECKER_NAME = "NOM_class";

	public ReportEntry check(CompilationUnit compilationUnit) {
		int result = compilationUnit.findAll(MethodDeclaration.class).size();
		return new ReportEntry(CHECKER_NAME, String.valueOf(result));
	}

	@Override
	public String getCheckerName() {
		return CHECKER_NAME;
	}

}
