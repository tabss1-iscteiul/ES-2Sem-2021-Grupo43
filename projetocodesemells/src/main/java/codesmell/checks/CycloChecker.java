package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.Statement;
import codesmell.report.ReportEntry;


public class CycloChecker implements IChecker {
<<<<<<< HEAD
	
=======
	//Métodos ciclomáticos
>>>>>>> branch 'master' of https://github.com/tabss1-iscteiul/ES-2Sem-2021-Grupo43
	private static final String CHECKER_NAME = "CycloChecker";
	//private int counter = 0;

	@Override
	public ReportEntry check(CompilationUnit compilationUnit) {
		int counter = compilationUnit.findAll(Statement.class).stream().mapToInt(statement -> {
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

}
