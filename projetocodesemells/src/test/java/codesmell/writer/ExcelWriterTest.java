/**
 * 
 */
package codesmell.writer;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import codesmell.checks.CycloChecker;
import codesmell.checks.CycloMethodChecker;
import codesmell.checks.GodClassChecker;
import codesmell.checks.IChecker;
import codesmell.checks.LineChecker;
import codesmell.checks.LineMethodChecker;
import codesmell.checks.LongMethodChecker;
import codesmell.checks.MethodChecker;
import codesmell.reader.ASTReader;
import codesmell.reader.IReader;
import codesmell.report.Report;
import junit.framework.TestCase;

/**
 * @author TOSHIBA
 *
 */
// Testes unitários relativo à criação do Excel
public class ExcelWriterTest extends TestCase {
	private ExcelWriter excel = new ExcelWriter("C:\\Users\\Fujitsu\\Desktop\\teste");
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.writer.ExcelWriter#ExcelWriter(java.lang.String)}.
	 */
	public final void testExcelWriter() {
		assertNotNull(excel);
	}

	/**
	 * Test method for {@link codesmell.writer.ExcelWriter#write(codesmell.report.Report)}.
	 * @throws IOException 
	 */
	public final void testWrite() throws IOException {
		Collection<IChecker> checkers = Arrays.asList( 
				new LineChecker(), 
				new MethodChecker(), 
				new CycloChecker(), 
				new CycloMethodChecker(),
				new LineMethodChecker(), new GodClassChecker(50, 150, 70, "AND", "OR" ), new LongMethodChecker(40, 60, "AND"));
			IReader reader = new ASTReader("C:\\Users\\Fujitsu\\Desktop\\jasml\\src");
			Report report = reader.runCheckers(checkers);
			excel.write(report);
	}
}
