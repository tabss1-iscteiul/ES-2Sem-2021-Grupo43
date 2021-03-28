package codesmell.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import codesmell.checks.IChecker;
import codesmell.report.Report;
import codesmell.report.ReportEntry;

public class ASTReader implements IReader {

	private final String projectPath;

	public ASTReader(String projectPath) {
		this.projectPath = projectPath;
	}

	private Collection<File> getAllJavaFiles() throws IOException {
		return Files.walk(Paths.get(this.projectPath))
			.filter(p -> predicate(p))
			.map(p -> p.toFile())
			.collect(Collectors.toList());
	}

	private boolean predicate(Path p) {
		return p.toString().endsWith(".java");
	}

	public Report runCheckers(Collection<IChecker> checkers) throws IOException {
		Collection<File> javaFiles = getAllJavaFiles();
		Report report = new Report();
		for (File javaFile : javaFiles) {
			System.out.printf("Processing: %s\n", javaFile.toString());
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			for (IChecker checker : checkers) {
				ReportEntry reportEntry = checker.check(compilationUnit);
				report.addReportEntry(javaFile.toString(), reportEntry);
			}
		}
		return report;
	}
}
