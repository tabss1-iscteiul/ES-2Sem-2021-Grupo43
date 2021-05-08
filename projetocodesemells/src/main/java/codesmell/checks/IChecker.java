package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.IReportEntry;

public interface IChecker { // crição de vários checkers
	
	IReportEntry<?> check(CompilationUnit compilationUnit);
	String getCheckerName();

}
