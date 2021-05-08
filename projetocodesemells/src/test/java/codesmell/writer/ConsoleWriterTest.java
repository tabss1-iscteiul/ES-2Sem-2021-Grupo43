/**
 * 
 */
package codesmell.writer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import codesmell.checks.IChecker;
import codesmell.checks.CycloChecker;
import codesmell.checks.CycloMethodChecker;
import codesmell.checks.GodClassChecker;
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
	private GodClassChecker godClass = new GodClassChecker(50, 150, 70, "AND", "OR" );
	private LongMethodChecker methodChecker = new LongMethodChecker(40, 60, "AND");
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link codesmell.writer.ConsoleWriter#write(codesmell.report.Report)}.
	 * 
	 * @throws IOException
	 */
	public final void testWrite() throws IOException {
		Collection<IChecker> checkers = Arrays.asList(new LineChecker(), new MethodChecker(), new CycloChecker(),
				new CycloMethodChecker(), new LineMethodChecker(), godClass, methodChecker);
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Report report = reader.runCheckers(checkers);
		consoleWriter.write(report);
	}

	/**
	 * Test method for
	 * {@link codesmell.writer.ConsoleWriter#counterClasses(codesmell.report.Report)}.
	 * 
	 * @throws IOException
	 */
	public final void testCounterClasses() throws IOException {
		Collection<IChecker> checkers = Arrays.asList(new LineChecker(), new MethodChecker(), new CycloChecker(),
				new CycloMethodChecker(), new LineMethodChecker(), godClass, methodChecker);
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Report report = reader.runCheckers(checkers);
		int classes = consoleWriter.counterClasses(report);
		assertEquals(44, classes);
	}

	/**
	 * Test method for
	 * {@link codesmell.writer.ConsoleWriter#counterLinesByMethod(codesmell.report.Report)}.
	 * 
	 * @throws IOException
	 */
	public final void testCounterLinesByMethod() throws IOException {
		Collection<IChecker> checkers = Arrays.asList(new LineChecker(), new MethodChecker(), new CycloChecker(),
				new CycloMethodChecker(), new LineMethodChecker(), godClass, methodChecker);
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Report report = reader.runCheckers(checkers);
		int lines = consoleWriter.counterLinesByMethod(report);
		assertEquals(4069, lines);
	}

	/**
	 * Test method for
	 * {@link codesmell.writer.ConsoleWriter#counterPackages(codesmell.report.Report)}.
	 */
	public final void testCounterPackages() throws IOException{
		Collection<IChecker> checkers = Arrays.asList(new LineChecker(), new MethodChecker(), new CycloChecker(),
				new CycloMethodChecker(), new LineMethodChecker(), new GodClassChecker(), new LongMethodChecker());
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Report report = reader.runCheckers(checkers);
		int packages = consoleWriter.counterPackages(report);
		assertEquals(5, packages);
	}

	/**
	 * Test method for
	 * {@link codesmell.writer.ConsoleWriter#counterMethods(codesmell.report.Report)}.
	 * @throws IOException 
	 */
	public final void testCounterMethods() throws IOException {
		Collection<IChecker> checkers = Arrays.asList(new LineChecker(), new MethodChecker(), new CycloChecker(),
				new CycloMethodChecker(), new LineMethodChecker(), new GodClassChecker(), new LongMethodChecker());
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Report report = reader.runCheckers(checkers);
		int methods = consoleWriter.counterMethods(report);
		assertEquals(197, methods);
	}

}
