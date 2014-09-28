package amp.hiber.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import amp.hiber.doCRUD.DeptCRUD;

public class StartMain {
	
	//private static SessionFactory factory;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DeptCRUD deptEdit = new DeptCRUD();
		deptEdit.addDept(200, "AMPrady LAB", "INDIA");
		//deptEdit.closeSession();
	}

}
