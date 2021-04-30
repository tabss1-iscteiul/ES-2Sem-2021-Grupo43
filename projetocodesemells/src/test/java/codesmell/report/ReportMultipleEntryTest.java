/**
 * 
 */
package codesmell.report;

import junit.framework.TestCase;

/**
 * @author TOSHIBA
 *
 */
public class ReportMultipleEntryTest extends TestCase {
	private ReportMultipleEntry multipleEntry = new ReportMultipleEntry("WMC_Class");

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.report.ReportMultipleEntry#getCheckerValue()}.
	 */
	public final void testGetCheckerValue() {
		assertNotNull(multipleEntry.getCheckerValue());
	}

	/**
	 * Test method for {@link codesmell.report.ReportMultipleEntry#isMultiEntry()}.
	 */
	public final void testIsMultiEntry() {
		assertEquals(true, multipleEntry.isMultiEntry());
	}

}
