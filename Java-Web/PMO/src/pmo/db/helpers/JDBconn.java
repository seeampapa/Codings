package pmo.db.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

//import com.sybase.jdbc2.jdbc.SybDriver;


public abstract class JDBconn {
	protected Connection con;
	private int DBtype;
	private String host;
	private String dbName;
	private String port;
	private String uName;
	private String pwd;
	
	public JDBconn() {
		// TODO Auto-generated constructor stub
		/*this.DBtype = 1;
		this.host = "db4free.net";
		this.port = "3306";
		this.dbName = "seeampapa";
		this.uName = "seeampapa";
		this.pwd = "maniacon";*/
		this.DBtype = 0;
		this.host = "localhost";
		this.port = "1521";
		this.dbName = "xe";
		this.uName = "seeampapa";
		this.pwd = "maniacon";
	}
	
	public JDBconn(int DBtype, String host, String port, String dbName, String uName, String pwd){
		this.DBtype = DBtype;
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.uName = uName;
		this.pwd = pwd;
	}
	
	protected void conn(){
		String oracleURL = "jdbc:oracle:thin:@"+host+":"+port+":"+dbName;
		String mysqlURL = "jdbc:mysql://" + host + ":" + port +  "/" + dbName + "?" + "user=" + uName + "&password=" + pwd;
		//String mysqlURL = "jdbc:mysql://" + host + ":" + port +  "/" + dbName;
		String sybaseURL = "jdbc:sybase:Tds:" + host + ":" + port + "?charset=iso_1&SERVICENAME=" + dbName;
		String[] dbURL = {oracleURL, mysqlURL, sybaseURL};
		
		switch(DBtype){
		case(0):
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case(1):
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(mysqlURL);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		/*case(2):
			try {
			    SybDriver sybDriv = (SybDriver)Class.forName("com.sybase.jdbc2.jdbc.SybDriver").newInstance(); // for sybase driver
			    DriverManager.registerDriver((Driver) sybDriv);
				
			    con = DriverManager.getConnection(sybaseURL, uName, pwd);
			} catch(ClassNotFoundException e) {
			    System.err.println("Error loading driver: " + e);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;*/
		default:
			System.out.println("DBType should be 1 or 2 or 3. Read the Help.");
			break;		
		}
		
		try{
			con = DriverManager.getConnection(dbURL[DBtype],uName, pwd);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	protected void clos(){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	protected abstract ArrayList<ArrayList<String>> selectQry(String qry);
	protected abstract String execUpdate(String qry);
}
