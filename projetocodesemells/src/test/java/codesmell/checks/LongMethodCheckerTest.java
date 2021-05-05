/**
 * 
 */
package codesmell.checks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import codesmell.reader.ASTReader;
import junit.framework.TestCase;

/**
 * @author TOSHIBA
 *
 */
public class LongMethodCheckerTest extends TestCase {
	private LongMethodChecker longMethod = new LongMethodChecker();
	private LongMethodChecker longMethodor = new LongMethodChecker(300, 400, "AND");
	private LongMethodChecker longMethodand = new LongMethodChecker(100, 70, "OR");

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.checks.LongMethodChecker#LongMethodChecker()}.
	 */
	public final void testLongMethodChecker() {
		assertNotNull(longMethod);
	}

	/**
	 * Test method for {@link codesmell.checks.LongMethodChecker#LongMethodChecker(int, int, java.lang.String)}.
	 */
	public final void testLongMethodCheckerIntIntString() {
		assertNotNull(longMethodand);
		assertNotNull(longMethodor);
	}

	/**
	 * Test method for {@link codesmell.checks.LongMethodChecker#check(com.github.javaparser.ast.CompilationUnit)}.
	 * @throws IOException 
	 */
	public final void testCheck() throws IOException {
		ASTReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Collection<File> javaFiles = reader.getAllJavaFiles();
		for (File javaFile : javaFiles) {
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			assertNotNull(longMethod.check(compilationUnit));
		}
	}

	/**
	 * Test method for {@link codesmell.checks.LongMethodChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("Long_Method", longMethod.getCheckerName());
	}

}
