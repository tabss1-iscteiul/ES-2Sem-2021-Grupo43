
package codesmell;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import codesmell.checks.CycloChecker;
import codesmell.checks.CycloMethodChecker;
import codesmell.checks.GodClassChecker;
import codesmell.checks.IChecker;
import codesmell.checks.LineChecker;
import codesmell.checks.LineMethodChecker;
import codesmell.checks.LongMethodChecker;
import codesmell.checks.MethodChecker;
import codesmell.reader.ASTReader;
import codesmell.reader.IReader;
import codesmell.report.Report;
import codesmell.writer.ConsoleWriter;
import codesmell.writer.ExcelWriter;
import codesmell.writer.IWriter;
public class ConsoleApp {

	public static void main(String args[]) throws IOException {
		// Setup components
		Collection<IChecker> checkers = Arrays.asList( 
			new LineChecker(), 
			new MethodChecker(), 
			new CycloChecker(), 
			new CycloMethodChecker(),
			new LineMethodChecker(), new GodClassChecker(50, 150, 70, "AND", "OR" ), new LongMethodChecker(40, 60, "AND"));
		IReader reader = new ASTReader("C:\\Users\\Fujitsu\\Desktop\\jasml\\src");
		IWriter cwriter = new ConsoleWriter();
		//IWriter writer = new ExcelWriter();

		Report report = reader.runCheckers(checkers);
		//writer.write(report);
		cwriter.write(report);
		
		
		System.out.println("-----------------------------------------" + ((ConsoleWriter)cwriter).counterClasses(report));
		System.out.println("-----------------------------------------" + ((ConsoleWriter)cwriter).counterLinesByMethod(report));
		System.out.println("-----------------------------------------" + ((ConsoleWriter)cwriter).counterMethods(report));
		System.out.println("-----------------------------------------" + ((ConsoleWriter)cwriter).counterPackages(report));
		//((ConsoleWriter)cwriter).counterLinesByMethod(report);
		//((ConsoleWriter)cwriter).counterMethods(report);
		//((ConsoleWriter)cwriter).counterPackages(report);
		
	}
	

}
