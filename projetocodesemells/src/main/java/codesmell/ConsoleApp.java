
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

	public static void main(String[] args) throws IOException {
		
		   try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Interface().setVisible(true);
	            }
	        });
		
		// Setup components
		Collection<IChecker> checkers = Arrays.asList( 
			new LineChecker(), 
			new MethodChecker(), 
			new CycloChecker(), 
			new CycloMethodChecker(),
			new LineMethodChecker(), new GodClassChecker(), new LongMethodChecker());
		IReader reader = new ASTReader("C:\\Users\\TOSHIBA\\Desktop\\jamsl\\src");
		IWriter cwriter = new ConsoleWriter();
		IWriter writer = new ExcelWriter();

		Report report = reader.runCheckers(checkers);
		writer.write(report);
		cwriter.write(report);
	}

}
