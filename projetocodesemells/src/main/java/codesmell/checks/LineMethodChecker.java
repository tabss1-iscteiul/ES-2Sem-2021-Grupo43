package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;

import codesmell.report.IReportEntry;
import codesmell.report.ReportMultipleEntry;

public class LineMethodChecker implements IChecker {
	private static final String CHECKER_NAME = "LineMethodChecker";

	int result = 0;
	String nameMethod = null;

	@Override
	public IReportEntry<?> check(CompilationUnit compilationUnit) {
		ReportMultipleEntry en = new ReportMultipleEntry(CHECKER_NAME);

		compilationUnit.findAll(MethodDeclaration.class).stream().forEach(method -> {
			String nameMethod = method.getNameAsString();

			int result = method.toString().split("\n").length;

			en.addEntry(nameMethod, String.valueOf(result));
		});
		return en;
	}

}
