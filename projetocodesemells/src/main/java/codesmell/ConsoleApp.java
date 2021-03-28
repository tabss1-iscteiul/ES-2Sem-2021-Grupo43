
package codesmell;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import codesmell.checks.IChecker;
import codesmell.checks.LineChecker;
import codesmell.checks.MethodChecker;
import codesmell.reader.ASTReader;
import codesmell.reader.IReader;
import codesmell.report.Report;
import codesmell.writer.ConsoleWriter;
import codesmell.writer.IWriter;

public class ConsoleApp {

	public static void main(String[] args) throws IOException {
		// Setup components
		Collection<IChecker> checkers = Arrays.asList( 
			new LineChecker(), 
			new MethodChecker());
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		IWriter writer = new ConsoleWriter();
		
		// Running main code
		Report report = reader.runCheckers(checkers);
		writer.write(report);
	}

}
