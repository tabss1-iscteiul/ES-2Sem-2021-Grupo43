package codesmell.reader;

import java.io.IOException;
import java.util.Collection;

import codesmell.checks.IChecker;
import codesmell.report.Report;

public interface IReader { // recebe os checkers e dá a cada checker cada compilationUnit - prepara a escrita no excel
	Report runCheckers(Collection<IChecker> checkers) throws IOException;
}
