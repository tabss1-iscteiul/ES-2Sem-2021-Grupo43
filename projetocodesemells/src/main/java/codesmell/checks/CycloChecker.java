package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

import codesmell.report.ReportEntry;


public class CycloChecker implements IChecker{

	@Override
	public ReportEntry check(CompilationUnit compilationUnit) {
		//compilationUnit.findAll()
		
		compilationUnit.findAll(MethodDeclaration.class);
		return null;
	}
	

}
