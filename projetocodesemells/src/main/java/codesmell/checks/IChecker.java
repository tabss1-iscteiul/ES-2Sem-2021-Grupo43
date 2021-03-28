package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.ReportEntry;

public interface IChecker {
	ReportEntry check(CompilationUnit compilationUnit);
}
