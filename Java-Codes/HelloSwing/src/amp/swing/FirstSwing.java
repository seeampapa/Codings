package amp.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstSwing {
	
	private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   private JPanel inputPanel;

	   public FirstSwing(){
	      prepareGUI();
	   }

	   public static void main(String[] args){
	      FirstSwing swing = new FirstSwing();  
	      swing.showEventDemo();       
	   }
	      
	   private void prepareGUI(){
	      mainFrame = new JFrame("Java SWING Examples");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(4, 1));

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        

	      statusLabel.setSize(350,100);
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }        
	      });    
	      
	      inputPanel = new JPanel();
	      inputPanel.setLayout(new FlowLayout());
	      
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(inputPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }

	   private void showEventDemo(){
	      headerLabel.setText("Control in action: Button"); 
	      
	      JLabel label = new JLabel();
	      label.setText("Enter a Name");
	      label.setToolTipText("Label 1");
	      
	      JTextField text = new JTextField();
	      text.setName("name");
	      
	      inputPanel.add(label);
	      inputPanel.add(text);

	      JButton okButton = new JButton("OK");
	      JButton submitButton = new JButton("Submit");
	      JButton cancelButton = new JButton("Cancel");
	      JButton close = new JButton("Close");

	      okButton.setActionCommand("OK");
	      submitButton.setActionCommand("Submit");
	      cancelButton.setActionCommand("Cancel");
	      close.setActionCommand("Close");
	      
	      okButton.addActionListener(new ButtonClickListener()); 
	      submitButton.addActionListener(new ButtonClickListener()); 
	      cancelButton.addActionListener(new ButtonClickListener());
	      close.addActionListener(new ButtonClickListener());

	      controlPanel.add(okButton);
	      controlPanel.add(submitButton);
	      controlPanel.add(cancelButton);       
	      controlPanel.add(close);

	      mainFrame.setVisible(true);  
	   }

	   private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         if( command.equals( "OK" ))  {
	        	 
	            statusLabel.setText("Ok Button clicked.");
	         }
	         else if( command.equals( "Submit" ) )  {
	            statusLabel.setText("Submit Button clicked."); 
	         }
	         else if(command.equals("Cancel")) {
	            statusLabel.setText("Cancel Button clicked.");
	         }else{
	    		   System.exit(0);  
	         }
	      }		
	   }
	
}
