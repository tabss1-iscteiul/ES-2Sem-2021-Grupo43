package codesmell.report;

public interface IReportEntry<T> {

	public String getCheckerName();

	public T getCheckerValue();
	
	public boolean isMultiEntry();

}
