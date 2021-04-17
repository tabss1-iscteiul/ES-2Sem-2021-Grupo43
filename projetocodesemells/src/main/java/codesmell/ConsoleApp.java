
package codesmell;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import codesmell.checks.GodClassChecker;
import codesmell.checks.IChecker;
import codesmell.checks.LineChecker;
import codesmell.checks.LongMethodChecker;
import codesmell.reader.ASTReader;
import codesmell.reader.IReader;
import codesmell.report.Report;
import codesmell.writer.ConsoleWriter;
import codesmell.writer.ExcelWriter;
import codesmell.writer.IWriter;
public class ConsoleApp {

	public static void main(String[] args) throws IOException {
		
		Collection<IChecker> checkers = Arrays.asList( 
			new LineChecker(), 
			new LongMethodChecker(), 
			new GodClassChecker());
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		IWriter cwriter = new ConsoleWriter();
		IWriter writer = new ExcelWriter();

		Report report = reader.runCheckers(checkers);
		writer.write(report);
		cwriter.write(report);
	}

}
