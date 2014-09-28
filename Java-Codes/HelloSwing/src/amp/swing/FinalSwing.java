package amp.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class FinalSwing {
	
	private JFrame mainF;
	private JLabel headerLabel;
	private JPanel mainPanel;
	
	// constructor
	public FinalSwing() {
		setMainFrame();
	}
	
	// mainF
	private void setMainFrame(){
		mainF = new JFrame("Amp Swing App");
		mainF.setSize(1000,500);
		mainF.setLayout(new GridLayout(2, 1));
		mainF.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		
		headerLabel = new JLabel("", JLabel.CENTER);
		headerLabel.setSize(50, 500);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		mainF.add(headerLabel);
		mainF.add(mainPanel);
		mainF.setVisible(true);
	}

	// PSVM
	public static void main(String[] args) {
		new FinalSwing();
	}

}
