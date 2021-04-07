package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.IReportEntry;

public interface IChecker {
	IReportEntry<?> check(CompilationUnit compilationUnit);
	
}
