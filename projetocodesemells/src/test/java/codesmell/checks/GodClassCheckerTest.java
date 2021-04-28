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
public class GodClassCheckerTest extends TestCase {

	private GodClassChecker godClassChecker = new GodClassChecker();
	private GodClassChecker godClassCheckerValues = new GodClassChecker(50,30);
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#GodClassChecker()}.
	 */
	public final void testGodClassChecker() {
		assertNotNull(godClassChecker);
	}

	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#GodClassChecker(int, int)}.
	 */
	public final void testGodClassCheckerIntInt() {
		assertNotNull(godClassCheckerValues);
	}

	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#check(com.github.javaparser.ast.CompilationUnit)}.
	 * @throws IOException 
	 */
	public final void testCheck() throws IOException {
		ASTReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Collection<File> javaFiles = reader.getAllJavaFiles();
		for (File javaFile : javaFiles) {
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			assertNotNull(godClassChecker.check(compilationUnit));
		}
	}

	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("God_class", godClassChecker.getCheckerName());
	}

}
