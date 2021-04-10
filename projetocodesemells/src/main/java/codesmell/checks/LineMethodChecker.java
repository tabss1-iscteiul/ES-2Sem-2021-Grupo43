package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;

import codesmell.report.IReportEntry;
import codesmell.report.ReportMultipleEntry;

public class LineMethodChecker implements IChecker {
	private static final String CHECKER_NAME = "LOC_method";
	private int counter = 0;

	@Override
	public IReportEntry<?> check(CompilationUnit compilationUnit) {
		ReportMultipleEntry en = new ReportMultipleEntry(CHECKER_NAME);

		compilationUnit.findAll(MethodDeclaration.class).stream().forEach(method -> {
			String nameMethod = method.getNameAsString();

			int counterComment = method.findAll(Comment.class).stream().mapToInt(comment -> {

				if (comment.isLineComment() || comment.isBlockComment() || comment.isJavadocComment()
						|| comment.isOrphan()) {
					return 1;
				} else {
					return 0;
				}
			}).sum();

			counter = method.toString().split("\n").length - counterComment;

			en.addEntry(nameMethod, String.valueOf(counter));
		});
		return en;
	}

	public String getMethodLineName() {
		return CHECKER_NAME;
	}

	public int getMethodLineCounter() {
		return counter;
	}
}
