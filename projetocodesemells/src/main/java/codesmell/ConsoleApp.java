
package codesmell;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import codesmell.checks.CycloChecker;
import codesmell.checks.CycloMethodChecker;
import codesmell.checks.IChecker;
import codesmell.checks.LineChecker;
import codesmell.checks.LineMethodChecker;
import codesmell.checks.MethodChecker;
import codesmell.reader.ASTReader;
import codesmell.reader.IReader;
import codesmell.report.Report;
import codesmell.writer.ConsoleWriter;
import codesmell.writer.IWriter;
// Método para testar as características gerais do projeto
public class ConsoleApp {

	public static void main(String[] args) throws IOException {
		// Setup components
		Collection<IChecker> checkers = Arrays.asList( 
			new LineChecker(), 
			new MethodChecker(), 
			new CycloChecker(), 
			new CycloMethodChecker(),
			new LineMethodChecker());
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		IWriter writer = new ConsoleWriter();
		
		// Running main code
		Report report = reader.runCheckers(checkers);
		writer.write(report);
	}

}
