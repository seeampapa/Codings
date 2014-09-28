package amp.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FirstSWT {
	
	private Shell shell;
	
	public FirstSWT(Display disp) {
		shell = new Shell(disp);
		shell.setText("App Name");
        shell.setLayout(new FillLayout());
		shell.setLocation(300, 300);
        shell.setToolTipText("This is a window");
        
		shell.setSize(200, 200);
		
		//shell.setLayout(new FillLayout());
		
		//center(shell);
		
		initUI();
		
		shell.open();
		
		while(!shell.isDisposed()){
			if(!disp.readAndDispatch()){
				disp.sleep();
			}
		}
		disp.dispose();
	}
	
	public void center(Shell shell){
		Rectangle bounds = shell.getDisplay().getBounds();
		Point p = shell.getSize();
		
		int nLeft = (bounds.width - p.x) / 2;
		int nright = (bounds.height - p.y) / 2;
		
		shell.setBounds(nLeft, nright, p.x, p.y);
	}
	
	public void initUI() {
        Button quit = new Button(shell, SWT.PUSH);
        quit.setText("Quit");
        quit.setBounds(75, 130, 50, 30);
        
        quit.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.getDisplay().dispose();
                System.exit(0);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }
	
	public static void main(String args[]){
		Display disp = new Display();
		new FirstSWT(disp);
		disp.dispose();
		
	}
}
