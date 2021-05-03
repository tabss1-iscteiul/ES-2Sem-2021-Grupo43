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
public class CycloCheckerTest extends TestCase {
	
	private CycloChecker cyclomatic = new CycloChecker();
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.checks.CycloChecker#check(com.github.javaparser.ast.CompilationUnit)}.
	 * @throws IOException 
	 */
	public final void testCheck() throws IOException {
		ASTReader reader = new ASTReader("C:\\Users\\Fujitsu\\Desktop\\jasml\\src");
		Collection<File> javaFiles = reader.getAllJavaFiles();
		for (File javaFile : javaFiles) {
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			assertNotNull(cyclomatic.check(compilationUnit));
		}
		
	}

	/**
	 * Test method for {@link codesmell.checks.CycloChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("WMC_class", cyclomatic.getCheckerName());
	}

}
