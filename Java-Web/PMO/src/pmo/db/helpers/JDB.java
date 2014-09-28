package pmo.db.helpers;

import java.sql.*;
import java.util.*;

public class JDB extends JDBconn{
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public JDB() {
		// TODO Auto-generated constructor stub
		super();
	}
	public JDB(int DBtype, String host, String port, String dbName, String uName, String pwd) {
		super(DBtype, host, port, dbName, uName, pwd);
	}
	
	public ArrayList<ArrayList<String>> selectQry(String qry){
		System.out.println(qry);
		int collen = 0;
		ArrayList<ArrayList<String>> alist = new ArrayList<ArrayList<String>>();
		// connection
		conn(); // from Super Class
		try{
			stmt = con.prepareStatement(qry);
			rs = stmt.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			collen = rsm.getColumnCount();// Statement stmt=con.createStatement();
			int i = 0;
			while(rs.next()){
				alist.add(new ArrayList<String>());
				for(int j=0;j<collen;j++){
					((ArrayList<String>)alist.get(i)).add(rs.getString(j+1));
					System.out.print(rs.getString(j+1) + "\t");
				}
				System.out.println();
				i = i + 1;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clos(); // from super class
		return alist;
	}
	
	public ResultSet selectQuery(String qry){
		System.out.println(qry);
		int collen = 0;
		ArrayList<ArrayList<String>> alist = new ArrayList<ArrayList<String>>();
		// connection
		conn(); // from Super Class
		try{
			stmt = con.prepareStatement(qry);
			rs = stmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//clos(); // from super class
		return rs;
	}
	public ArrayList<ArrayList<String>> selectQry(ArrayList<String> coln, String tName, String wcla) {
		String qry = null;
		String cols = "";
		String v2;
		int l= coln.size();
		for (int i=0; i<l; i++){
			v2 = (String) coln.get(i);
			if(i==(l-1))
				cols = cols + v2;
			else
				cols = cols + v2 + ",";
		}
		if (wcla!=null)
			qry = "Select " + cols + " from " + tName + " where "+ wcla;
		else
			qry = "Select " + cols + " from " + tName;
		
		return selectQry(qry);
	}
	
	public String execUpdate(String qry){
		System.out.println(qry);
		String msg = null;
		conn();
		try{
			stmt = con.prepareStatement(qry);
			int i = stmt.executeUpdate();
			if(i>0){
				msg = "Record Inserted.";
			}else{
				msg = "Error Occurred. Please try after sometime.";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		clos();
		return msg;
	}
	
	public String insertQry(String tName, ArrayList<String> values) {
		String qry = null;
		String vals = "";
		String vl;
		int len = values.size();
		
		for (int i=0; i<len; i++){
			vl = (String) values.get(i);
			if(i==(len-1))
				vals = vals +"'" + vl +"'";
			else
				vals = vals +"'" + vl +"'"+ ",";
		}
		qry = "insert into " + tName + " values (" + vals + ")";
		
		return execUpdate(qry);
	}
	
	public String updateQry (String tName, ArrayList<String> values, String wcls) {
		String qry = null;
		String vals = "";
		String vl;
		int len = values.size();
		
		for(int i=0; i<len; i++){
			vl = (String) values.get(i);
			if(i==(len-1))
				vals = vals + vl ;
			else
				vals = vals + vl + ",";
		}
		if (wcls!=null)
			qry = "update " + tName + " set " + vals+ " where "+ wcls;
		else
			qry = "update " + tName + " set " + vals;
		
		return execUpdate(qry);
	}
}