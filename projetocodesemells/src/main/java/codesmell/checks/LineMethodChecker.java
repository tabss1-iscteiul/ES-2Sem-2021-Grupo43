package codesmell.checks;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;

import codesmell.report.IReportEntry;
import codesmell.report.ReportMultipleEntry;

public class LineMethodChecker implements IChecker {
	private static final String CHECKER_NAME = "LOC_method";

	int result = 0;
	String nameMethod = null;

	@Override
	public ReportMultipleEntry check(CompilationUnit compilationUnit) {
		ReportMultipleEntry en = new ReportMultipleEntry(CHECKER_NAME);

		compilationUnit.findAll(MethodDeclaration.class).stream().forEach(method -> {
			String nameMethod = method.getDeclarationAsString(false, false);
			
			int counterComment = method.findAll(Comment.class).stream().mapToInt(comment ->{
				if (comment.isLineComment() || comment.isBlockComment() || 
						comment.isJavadocComment() || comment.isOrphan()) {
					return 1;
				}else {
					return 0;
				}
			}).sum();
			
			int result = method.toString().split("\n").length - counterComment;

			en.addEntry(nameMethod, String.valueOf(result));
		});
		return en;
	}

	@Override
	public String getCheckerName() {
		return CHECKER_NAME;
	}

}
