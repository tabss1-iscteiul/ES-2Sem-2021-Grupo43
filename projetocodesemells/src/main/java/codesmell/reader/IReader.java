package codesmell.reader;

import java.io.IOException;
import java.util.Collection;

import codesmell.checks.IChecker;
import codesmell.report.Report;

public interface IReader {
	Report runCheckers(Collection<IChecker> checkers) throws IOException;
}
