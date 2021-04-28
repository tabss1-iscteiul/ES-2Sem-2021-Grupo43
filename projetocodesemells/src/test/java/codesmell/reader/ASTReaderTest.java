/**
 * 
 */
package codesmell.reader;

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
import junit.framework.TestCase;

/**
 * @author TOSHIBA
 *
 */
public class ASTReaderTest extends TestCase {

	private ASTReader reader  = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.reader.ASTReader#ASTReader(java.lang.String)}.
	 */
	public final void testASTReader() {
		assertNotNull(reader);
	}

	/**
	 * Test method for {@link codesmell.reader.ASTReader#runCheckers(java.util.Collection)}.
	 * @throws IOException 
	 */
	public final void testRunCheckers() throws IOException {
		Collection<IChecker> checkers = Arrays.asList( 
				new LineChecker(), 
				new MethodChecker(), 
				new CycloChecker(), 
				new CycloMethodChecker(),
				new LineMethodChecker(), new GodClassChecker(), new LongMethodChecker());
		reader.runCheckers(checkers);
	}

}
