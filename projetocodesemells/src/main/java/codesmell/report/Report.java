package codesmell.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

	private final Map<String, List<IReportEntry<?>>> reportMap = new HashMap<>();

	public void addReportEntry(String key, IReportEntry<?> entry) {
		List<IReportEntry<?>> values = reportMap.getOrDefault(key, new ArrayList<>());
		if (entry instanceof ReportArrayEntry) {
			values.addAll(((ReportArrayEntry)entry).getCheckerValue());
		}else {
			values.add(entry);
		}
		reportMap.put(key, values);
	}

	public Map<String, List<IReportEntry<?>>> getReport() {
		return reportMap;
	}
}
