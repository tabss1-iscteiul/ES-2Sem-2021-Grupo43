package codesmell.checks;

public class Codesmells {

	private CycloChecker cycloClass;
	private CycloMethodChecker cycloMethod;
	private LineChecker lineChecker;
	private LineMethodChecker lineMethodChecker;
	private MethodChecker numMethods;

	public Codesmells() {
		this.cycloClass = new CycloChecker();
		this.cycloMethod = new CycloMethodChecker();
		this.lineChecker = new LineChecker();
		this.lineMethodChecker = new LineMethodChecker();
		this.numMethods = new MethodChecker();
	}

	public boolean long_method() {
		if (lineMethodChecker.getMethodLineCounter() > 50 && cycloMethod.getMethodClassCounter() > 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean god_class() {
		if (cycloClass.getClassCycloCounter() > 50 || numMethods.getMethodCounter() > 10) {
			return true;
		} else {
			return false;
		}
	}
}
