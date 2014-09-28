package stage1;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Examples extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Examples() {
		// TODO Auto-generated constructor stub
		setTitle("seeampapa");
		setSize(1000,600); // default size is 0,0
		setLocation(100,30); // default is 0,0 (top left corner)
		
		addWindowListener(new WindowAdapter() {
		  	public void windowClosing(WindowEvent e) {
			   System.exit(0);
		  	} //windowClosing
		} );
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(new JTextField());
		
		Container content = getContentPane();
		content.add(panel);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ex = new Examples();
                ex.setVisible(true);
            }
        });
	}
}
