package codesmell.report;

public class ReportEntry implements IReportEntry<String>{
	private String checkerName;
	private String checkerValue;
	
	public ReportEntry(String checkerName, String checkerValue) {// só esta feito para os checkers das classes
		super();
		this.checkerName = checkerName;
		this.checkerValue = checkerValue;
	}
	public String getCheckerName() {
		return checkerName;
	}
	public String getCheckerValue() {
		return checkerValue;
	}
	@Override
	public boolean isMultiEntry() {
		return false;
	}
	

	
}
