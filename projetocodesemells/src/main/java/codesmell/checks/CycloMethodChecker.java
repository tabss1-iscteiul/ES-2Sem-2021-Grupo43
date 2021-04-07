package codesmell.checks;


import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;

import codesmell.report.ReportMultipleEntry;

public class CycloMethodChecker implements IChecker {
	//Métodos Ciclomáticos
	private static final String CHECKER_NAME = "CycloMethodChecker";

	public ReportMultipleEntry check(CompilationUnit compilationUnit) {
		ReportMultipleEntry en = new ReportMultipleEntry(CHECKER_NAME);
		compilationUnit.findAll(MethodDeclaration.class).forEach(method -> {
			String methodName = method.getNameAsString();
			int counter = method.findAll(Statement.class).stream().mapToInt(statement -> {
				if (statement.isIfStmt() || statement.isWhileStmt() || statement.isForStmt()
						|| statement.isForEachStmt() || statement.isDoStmt()) {
					return 1;

				} else if (statement.isSwitchStmt()) {
					return statement.asSwitchStmt().getEntries().size();
				}
				return 0;
			}).sum();
			en.addEntry(methodName, String.valueOf(counter + 1));
		});

		return en;
	}

}
