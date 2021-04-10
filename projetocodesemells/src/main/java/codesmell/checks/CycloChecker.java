package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.Statement;
import codesmell.report.ReportEntry;

public class CycloChecker implements IChecker {
	private static final String CHECKER_NAME = "WMC_class";
	private int counter = 0;

	@Override
	public ReportEntry check(CompilationUnit compilationUnit) {
		counter = compilationUnit.findAll(Statement.class).stream().mapToInt(statement -> {
			if (statement.isIfStmt() || statement.isWhileStmt() || statement.isForStmt() || statement.isForEachStmt()
					|| statement.isDoStmt()) {
				return 1;

			} else if (statement.isSwitchStmt()) {
				return statement.asSwitchStmt().getEntries().size();
			}
			return 0;

		}).sum();

		return new ReportEntry(CHECKER_NAME, String.valueOf(counter + 1));
	}
	
	public String getNameCycloCheker() {
		return CHECKER_NAME;
	}
	
	public int getClassCycloCounter() {
		return counter;
	}

}
