/**
 * 
 */
package codesmell.writer;

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
public class ConsoleWriterTest extends TestCase {

	private ConsoleWriter consoleWriter = new ConsoleWriter();
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.writer.ConsoleWriter#write(codesmell.report.Report)}.
	 * @throws IOException 
	 */
	public final void testWrite() throws IOException {
		Collection<IChecker> checkers = Arrays.asList( 
				new LineChecker(), 
				new MethodChecker(), 
				new CycloChecker(), 
				new CycloMethodChecker(),
				new LineMethodChecker(), new GodClassChecker(), new LongMethodChecker());
			IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
			Report report = reader.runCheckers(checkers);
			consoleWriter.write(report);
		}

}
