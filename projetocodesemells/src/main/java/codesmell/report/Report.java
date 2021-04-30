package codesmell.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

	private final Map<ReportID, List<IReportEntry<?>>> reportMap = new HashMap<>();

	public void addReportEntries(ReportID key, IReportEntry<?> entry) {
		List<IReportEntry<?>> values = reportMap.getOrDefault(key, new ArrayList<>());
		if (entry instanceof ReportArrayEntry) {
			values.addAll(((ReportArrayEntry) entry).getCheckerValue());
		} else {
			values.add(entry);
		}
		reportMap.put(key, values);
	}

	public Map<ReportID, List<IReportEntry<?>>> getReport() {
		return reportMap;
	}

	public static class ReportID {

		private String className;
		private String packageName;

		public ReportID(String packageName, String className) {
			super();
			this.className = className;
			this.packageName = packageName;
		}

		public String getClassName() {
			return className;
		}

		public String getPackageName() {
			return packageName;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((className == null) ? 0 : className.hashCode());
			result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
			return result;
		}

	/*	@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ReportID other = (ReportID) obj;
			if (className == null) {
				if (other.className != null)
					return false;
			} else if (!className.equals(other.className))
				return false;
			if (packageName == null) {
				if (other.packageName != null)
					return false;
			} else if (!packageName.equals(other.packageName))
				return false;
			return true;
		}*/

	}
}
