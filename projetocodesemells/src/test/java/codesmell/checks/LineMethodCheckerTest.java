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
// Classe que faz o teste unitário relativo à classe que conta as linhas de cada método
public class LineMethodCheckerTest extends TestCase {
	private LineMethodChecker lineMethodChecker = new LineMethodChecker();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.checks.LineMethodChecker#check(com.github.javaparser.ast.CompilationUnit)}.
	 * @throws IOException 
	 */
	public final void testCheck() throws IOException {
		ASTReader reader = new ASTReader("C:\\Users\\Fujitsu\\Desktop\\jasml\\src");
		Collection<File> javaFiles = reader.getAllJavaFiles();
		for (File javaFile : javaFiles) {
			CompilationUnit compilationUnit = StaticJavaParser.parse(javaFile);
			assertNotNull(lineMethodChecker.check(compilationUnit));
		}
	}

	/**
	 * Test method for {@link codesmell.checks.LineMethodChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("LOC_method", lineMethodChecker.getCheckerName());
	}

}
