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
// Classe que realiza os testes unitários relativo ao cálculo de linhas de código da classe (locmethod)
public class LineCheckerTest extends TestCase {

	private LineChecker lineChecker = new LineChecker();
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.checks.LineChecker#check(com.github.javaparser.ast.CompilationUnit)}.
	 * @throws IOException 
	 */
	public final void testCheck() throws IOException {
		ASTReader reader = new ASTReader("C:\\Users\\Fujitsu\\Desktop\\jasml\\src");
		Collection<File> javaFiles = reader.getAllJavaFiles();
		for (File javaFile : javaFiles) {
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			assertNotNull(lineChecker.check(compilationUnit));
		}
	}

	/**
	 * Test method for {@link codesmell.checks.LineChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("LOC_class",lineChecker.getCheckerName());
	}

}
