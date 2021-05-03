package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.IReportEntry;

public interface IChecker {//criacao de vários checkers.
	
	IReportEntry<?> check(CompilationUnit compilationUnit);
	String getCheckerName();
}
