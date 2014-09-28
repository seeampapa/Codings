package stage1;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ExamplePanel extends JPanel{
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Font f = new Font("SansSerif", Font.BOLD, 14);
	    Font fi = new Font("SansSerif", Font.BOLD + Font.ITALIC, 14);
	    FontMetrics fm = g.getFontMetrics(f);
	    FontMetrics fim = g.getFontMetrics(fi);
	    int cx = 75; int cy = 100;
	    g.setFont(f);
	    g.drawString("Hello, ", cx, cy);
	    cx += fm.stringWidth("Hello, ");
	    g.setFont(fi);
	    g.drawString("World!", cx, cy);
	  } //paintComponent	  
}
