
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
import codesmell.writer.ExcelWriter;
import codesmell.writer.IWriter;
<<<<<<< HEAD
=======

// M�todo para testar as caracter�sticas gerais do projeto
>>>>>>> branch 'master' of https://github.com/tabss1-iscteiul/ES-2Sem-2021-Grupo43.git
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
<<<<<<< HEAD
		IWriter cwriter = new ConsoleWriter();
		IWriter writer = new ExcelWriter();

=======
		IWriter writer = new ConsoleWriter();
		
		// Running main code
>>>>>>> branch 'master' of https://github.com/tabss1-iscteiul/ES-2Sem-2021-Grupo43.git
		Report report = reader.runCheckers(checkers);
		writer.write(report);
		cwriter.write(report);
	}

}
