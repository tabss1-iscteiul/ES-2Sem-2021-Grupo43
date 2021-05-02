package codesmell.reader;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;

import codesmell.checks.IChecker;
import codesmell.report.IReportEntry;
import codesmell.report.Report;
import codesmell.report.ReportEntry;

public class ASTReader implements IReader {

	private final String projectPath;

	public ASTReader(String projectPath) {
		this.projectPath = projectPath;
	}

	public Collection<File> getAllJavaFiles() throws IOException {
		return Files.walk(Paths.get(this.projectPath))
			.filter(p -> predicate(p))
			.map(p -> p.toFile())
			.collect(Collectors.toList());
	}

	private boolean predicate(Path p) {
		return p.toString().endsWith(".java");
	}

	private int countClasses =0;
	public Report runCheckers(Collection<IChecker> checkers) throws IOException {
		Collection<File> javaFiles = getAllJavaFiles();
		Report report = new Report();
		for (File javaFile : javaFiles) {
			System.out.printf("Processing: %s\n", javaFile.toString());
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
		//	getTotalPackages(compilationUnit);
			String packageName = compilationUnit.getPackageDeclaration().map(p -> p.getNameAsString()).orElse("");
			String className = javaFile.getName().replaceAll(".java", "");
			countClasses ++;
			Report.ReportID reportID = new Report.ReportID(packageName, className);
			for( IChecker checker : checkers ) {
				report.addReportEntries(reportID, checker.check(compilationUnit));		
			}
		}
		return report;
	}
		
/*	public int getTotalPackages(CompilationUnit compilationUnit) {
		name = compilationUnit.getPackageDeclaration().get().toString();
		return count;
	}*/
	
	public int getTotalClasses() {
		return countClasses;
	}
	
	public int getTotalPackages() {
		return 0;
	}
}
