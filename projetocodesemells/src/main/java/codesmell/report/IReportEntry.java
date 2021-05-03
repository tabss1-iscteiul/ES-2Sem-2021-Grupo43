package codesmell.report;

public interface IReportEntry<T> { // permite que os métodos sejam implementados nas classes

	public String getCheckerName();

	public T getCheckerValue();
	
	public boolean isMultiEntry();

}
