package codesmell.report;

public class ReportEntry {
	private String checkerName;
	private String checkerValue;
	
	public ReportEntry(String checkerName, String checkerValue) {
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
	

}
