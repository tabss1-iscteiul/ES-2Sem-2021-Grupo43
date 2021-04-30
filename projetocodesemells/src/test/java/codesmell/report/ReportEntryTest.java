/**
 * 
 */
package codesmell.report;

import junit.framework.TestCase;

/**
 * @author TOSHIBA
 *
 */
public class ReportEntryTest extends TestCase {

	
	ReportEntry reportEntry = new ReportEntry("LOC_Method", "10");
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.report.ReportEntry#isMultiEntry()}.
	 */
	public final void testIsMultiEntry() {
		assertEquals(false, reportEntry.isMultiEntry());
	}

}
