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
public class GodClassCheckerTest extends TestCase {
//	private GodClassChecker godClassCheck = new GodClassChecker();
	private GodClassChecker godClassChecker = new GodClassChecker(50,100);
	private GodClassChecker godClassCheckandand = new GodClassChecker(50, 100, 24, "AND", "AND");
	private GodClassChecker godClassCheckandor = new GodClassChecker(50, 100, 30, "AND", "OR");
	private GodClassChecker godClassCheckorand = new GodClassChecker(50, 24, 20, "OR", "AND");
	private GodClassChecker godClassCheckoror = new GodClassChecker(50, 55, 24, "OR", "OR");

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#GodClassChecker()}.
	 */
//	public final void testGodClassChecker() {
//		assertNotNull(godClassCheck);
//	
//
	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#GodClassChecker(int, int)}.
	 */
	public final void testGodClassCheckerIntInt() {
		assertNotNull(godClassChecker);
	}

	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#GodClassChecker(int, int, int, java.lang.String, java.lang.String)}.
	 */
	public final void testGodClassCheckerIntIntIntStringString() {
		assertNotNull(godClassCheckandand);
		assertNotNull(godClassCheckandor);
		assertNotNull(godClassCheckorand);
		assertNotNull(godClassCheckoror);
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
			assertNotNull(godClassCheckandand.check(compilationUnit));
			assertNotNull(godClassCheckandor.check(compilationUnit));
			assertNotNull(godClassCheckorand.check(compilationUnit));
			assertNotNull(godClassCheckoror.check(compilationUnit));
		}
	}

	/**
	 * Test method for {@link codesmell.checks.GodClassChecker#getCheckerName()}.
	 */
	public final void testGetCheckerName() {
		assertEquals("God_class", godClassChecker.getCheckerName());
	}

}
