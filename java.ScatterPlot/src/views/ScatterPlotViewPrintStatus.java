package views;
/**
 * {@code}
 * Descriptio:This class represents the view for printing the 
 * summary of plot's information.
 * @author Amin Meyghani
 * @version 1.0
 * 
 */
import javax.swing.*;


public class ScatterPlotViewPrintStatus extends JFrame implements Runnable {

	JScrollPane scroll1;
	JTextArea text1;
	
 ScatterPlotViewPrintStatus() {

		setSize(367, 322);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Plot information");
		scroll1 = new JScrollPane();
		scroll1.setBounds(0, 6, 367, 273);
		getContentPane().add(scroll1);
		
		text1 = new JTextArea();
		scroll1.setViewportView(text1);
		text1.setEditable(false);

		new Thread(this).start();
		setVisible(true);
	}

	public void run(String text) {

		text1.append(text);

	}
//TODO how can i make this to update automatically???
	@Override
	public void run() {
		
	}

}