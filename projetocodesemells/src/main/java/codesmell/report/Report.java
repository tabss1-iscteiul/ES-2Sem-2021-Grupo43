package codesmell.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

	private final Map<String, List<ReportEntry>> reportMap = new HashMap<>();
	
	public void addReportEntry(String key, ReportEntry entry) {
		List<ReportEntry> values = reportMap.getOrDefault(key, new ArrayList<>());
		values.add(entry);
		reportMap.put(key, values);
	}
	
	public Map<String, List<ReportEntry>> getReport(){
		return reportMap;
	}
}
