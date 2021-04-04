package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;

import codesmell.report.ReportEntry;


public class CycloChecker implements IChecker{
	private static final String CHECKER_NAME = "CycloChecker";
	private int counter =0;
	@Override
	public ReportEntry check(CompilationUnit compilationUnit) {
		compilationUnit.findAll(Statement.class).forEach(statement ->{
				if (statement.isIfStmt()) {
					counter ++;
				}
				if (statement.isWhileStmt()) {
					counter ++;
				}
				if (statement.isForStmt()) {
					counter ++;
				}
				if (statement.isSwitchStmt()) {
					counter += statement.asSwitchStmt().getEntries().size();
				}
		});
		
	return new ReportEntry(CHECKER_NAME, String.valueOf(counter));
	}
	public String getCycloChecker() {
		return CHECKER_NAME;
	}

	
}
