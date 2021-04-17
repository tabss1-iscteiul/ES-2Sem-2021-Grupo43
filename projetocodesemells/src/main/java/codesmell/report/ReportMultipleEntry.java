package codesmell.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportMultipleEntry implements IReportEntry<List<ReportMultipleEntry.Entry>> {
	private String checkerName;
	private List<Entry> checkerValues = new ArrayList<ReportMultipleEntry.Entry>();

	public ReportMultipleEntry(String checkerName) {
		super();
		this.checkerName = checkerName;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public List<Entry> getCheckerValue() {
		return checkerValues;
	}

	public Map<String, String> getCheckerValueAsMap(){
		return checkerValues.stream().collect(Collectors.toMap(e -> e.getName(), e -> e.getValue()));
	}
	public void addEntry(String name, String value) {
		checkerValues.add(new Entry(name, value));
	}

	public static class Entry {
		private String name;
		private String value;

		public Entry(String name, String value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}

	}

	@Override
	public boolean isMultiEntry() {
		return true;
	}

}
