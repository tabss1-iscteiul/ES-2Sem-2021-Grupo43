
package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;

import codesmell.report.ReportArrayEntry;
import codesmell.report.ReportEntry;

public class GodClassChecker implements IChecker { // code smells para classes

	private int maxCyclomacy = 50;
	private int maxNumberMethod = 10;
	private int maxNumberLinesCode = 500;

	private String regra1;
	private String regra2;

	private CycloChecker cycloChecker = new CycloChecker(); // inicializa um contador de ciclos
	private MethodChecker methodChecker = new MethodChecker(); // inicializa um contador de métodos
	private LineChecker lineChecker = new LineChecker(); // inicializa

	private static final String CHECKER_NAME = "God_class";
	//Os construtores vazios serão úteis para os testes unitários
	//public GodClassChecker() {

//	}

	public GodClassChecker(int maxCyclomacy, int maxNumberMethod) {

		this.maxCyclomacy = maxCyclomacy;

		this.maxNumberMethod = maxNumberMethod;

	}

	public GodClassChecker(int maxNumberMethod, int maxNumberLinesCode, int maxCyclomacy, String regra1, String regra2) {
		this.maxCyclomacy = maxCyclomacy;
		this.maxNumberMethod = maxNumberMethod;
		this.maxNumberLinesCode = maxNumberLinesCode;
		this.regra1 = regra1;
		this.regra2 = regra2;
	}

	public ReportArrayEntry check(CompilationUnit compilationUnit) {

		ReportEntry cycloResult = cycloChecker.check(compilationUnit);
		ReportEntry methodResult = methodChecker.check(compilationUnit);
		ReportEntry lineResult = lineChecker.check(compilationUnit);
		ReportEntry godClassResult = new ReportEntry(CHECKER_NAME, CHECKER_NAME);

		if (regra1 == "AND" && regra2 == "AND") {

			if (Integer.valueOf(cycloResult.getCheckerValue()) > maxCyclomacy
					&& Integer.valueOf(methodResult.getCheckerValue()) > maxNumberMethod
					&& Integer.valueOf(lineResult.getCheckerValue()) > maxNumberLinesCode) {
				godClassResult = new ReportEntry(CHECKER_NAME, "true");
			} else {
				godClassResult = new ReportEntry(CHECKER_NAME, "false");
			}

		}
		if (regra1 == "AND" && regra2 == "OR") {

			if ((Integer.valueOf(methodResult.getCheckerValue()) > maxNumberMethod
					&& Integer.valueOf(lineResult.getCheckerValue()) > maxNumberLinesCode)
					|| Integer.valueOf(cycloResult.getCheckerValue()) > maxCyclomacy

			) {
				godClassResult = new ReportEntry(CHECKER_NAME, "true");
			} else {
				godClassResult = new ReportEntry(CHECKER_NAME, "false");
			}

		}
		if (regra1 == "OR" && regra2 == "AND") {

			if (Integer.valueOf(methodResult.getCheckerValue()) > maxNumberMethod
					|| (Integer.valueOf(lineResult.getCheckerValue()) > maxNumberLinesCode
							&& Integer.valueOf(cycloResult.getCheckerValue()) > maxCyclomacy)

			) {

				godClassResult = new ReportEntry(CHECKER_NAME, "true");
			} else {
				godClassResult = new ReportEntry(CHECKER_NAME, "false");
			}

		}
		if (regra1 == "OR" && regra2 == "OR") {

			if (Integer.valueOf(methodResult.getCheckerValue()) > maxNumberMethod
					|| Integer.valueOf(lineResult.getCheckerValue()) > maxNumberLinesCode
					|| Integer.valueOf(cycloResult.getCheckerValue()) > maxCyclomacy

			) {
				godClassResult = new ReportEntry(CHECKER_NAME, "true");
			} else {
				godClassResult = new ReportEntry(CHECKER_NAME, "false");
			}

		}
		ReportArrayEntry result = new ReportArrayEntry();
		result.addReportEntry(cycloResult);
		result.addReportEntry(methodResult);
		result.addReportEntry(godClassResult);
		return result;
	}

	public String getCheckerName() {
		return CHECKER_NAME;
	}
}
