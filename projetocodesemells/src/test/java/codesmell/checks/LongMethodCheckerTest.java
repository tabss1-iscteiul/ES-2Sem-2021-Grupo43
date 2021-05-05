/**
 * 
 */
package codesmell.checks;

import java.io.File;
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
	private LongMethodChecker longMethodChecker = new LongMethodChecker();
	//private LongMethodChecker longMethodCheckerValues = new LongMethodChecker(50,10);
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
		assertNotNull(longMethodChecker);
	}

	/**
	 * Test method for {@link codesmell.checks.LongMethodChecker#LongMethodChecker(int, int)}.
	 */
	public final void testLongMethodCheckerIntInt() {
		//assertNotNull(longMethodCheckerValues);
	}

	/**
	 * Test method for {@link codesmell.checks.LongMethodChecker#check(com.github.javaparser.ast.CompilationUnit)}.
	 */
	public final void testCheck() throws IOException {
		ASTReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Collection<File> javaFiles = reader.getAllJavaFiles();
		for (File javaFile : javaFiles) {
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			assertNotNull(longMethodChecker.check(compilationUnit));
		}
	}

	/**
	 * Test method for {@link codesmell.checks.LongMethodChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("Long_Method", longMethodChecker.getCheckerName());
	}

}
