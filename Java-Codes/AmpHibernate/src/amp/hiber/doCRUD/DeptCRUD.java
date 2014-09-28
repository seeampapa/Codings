package amp.hiber.doCRUD;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import amp.hiber.persist.Dept;

public class DeptCRUD {
	private SessionFactory factory;
		
	public DeptCRUD() {
		// TODO Auto-generated constructor stub
		//this.factory = factory;
		factory = new Configuration().configure("amp/hiber/config/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public void addDept(int deptNo, String deptName, String location){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Dept dept = new Dept(deptNo, deptName, location);
			session.persist(dept);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
