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
public class CycloMethodCheckerTest extends TestCase {

	private CycloMethodChecker cycloMethodChecker = new CycloMethodChecker();
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.checks.CycloMethodChecker#check(com.github.javaparser.ast.CompilationUnit)}.
	 * @throws IOException 
	 */
	public final void testCheck() throws IOException {
		ASTReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		Collection<File> javaFiles = reader.getAllJavaFiles();
		for (File javaFile : javaFiles) {
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			assertNotNull(cycloMethodChecker.check(compilationUnit));
		}
	}

	/**
	 * Test method for {@link codesmell.checks.CycloMethodChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("CYCLO_method", cycloMethodChecker.getCheckerName());
	}

}
