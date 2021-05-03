package codesmell.report;

import java.util.ArrayList;
import java.util.List;

public class ReportArrayEntry implements IReportEntry<List<IReportEntry<?>>> { // valor aos checkers

	private List<IReportEntry<?>> checkerValue = new ArrayList<>();

	public String getCheckerName() {
		return "";
	}

	public List<IReportEntry<?>> getCheckerValue() {
		return checkerValue;
	}

	@Override
	public boolean isMultiEntry() {
		return false;
	}

	public void addReportEntry(IReportEntry<?> e) {
		checkerValue.add(e);
	}

}
