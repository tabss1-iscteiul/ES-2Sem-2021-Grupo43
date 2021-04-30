/**
 * 
 */
package codesmell.report;

import junit.framework.TestCase;

/**
 * @author TOSHIBA
 *
 */
public class ReportArrayEntryTest extends TestCase {

	private ReportArrayEntry reportArrayEntry = new ReportArrayEntry();
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.report.ReportArrayEntry#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("", reportArrayEntry.getCheckerName());
	}
	
	/**
	 * Test method for {@link codesmell.report.ReportArrayEntry#isMultiEntry()}.
	 */
	public final void testIsMultiEntry() {
		assertEquals(false, reportArrayEntry.isMultiEntry());
	}

}
