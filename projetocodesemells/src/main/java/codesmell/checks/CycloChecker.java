package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;//ir ao interior da classe
import com.github.javaparser.ast.stmt.Statement;//vê se é um if,while 
import codesmell.report.ReportEntry;

public class CycloChecker implements IChecker {

 //utilizacao da biblioteca javaparser - calculo de ifs,else etc...
	private static final String CHECKER_NAME = "WMC_class";

	@Override
	public ReportEntry check(CompilationUnit compilationUnit) {
		int counter = compilationUnit.findAll(Statement.class).stream().mapToInt(statement -> {
			if (statement.isIfStmt() || statement.isWhileStmt() || statement.isForStmt() || statement.isForEachStmt()
					|| statement.isDoStmt()) {
				return 1;

			} else if (statement.isSwitchStmt()) {
				return statement.asSwitchStmt().getEntries().size();//numero de cases de switches
			}
			return 0;

		}).sum();

		return new ReportEntry(CHECKER_NAME, String.valueOf(counter + 1));
	}

	public String getCheckerName() {
		return CHECKER_NAME;
	}
}
