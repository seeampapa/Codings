package amp.jdbc.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import oracle.jdbc.driver.OracleTypes;

public class JDBC_SP {

	private String dbName = "xe";
	private String dbHost = "localhost";
	private String dbPort = "1521";
	private String dbUser = "amp";
	private String dbPwd = "maniacon";
	private String orclConnUrl;
	
	private Connection dbConn;
	private CallableStatement calStmt;
	
	public JDBC_SP() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init(){
		this.orclConnUrl = "jdbc:oracle:thin:@"+ dbHost+":"+dbPort+":"+dbName;
		
		//STEP 1: lookup for Driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//STEP 2: Get Connection from Driver
		try {
			dbConn = DriverManager.getConnection(orclConnUrl, dbUser, dbPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//SELECT-INTO callable
	private void executeCallable(){
		try {
			calStmt = dbConn.prepareCall("{call getassociatebyid(?,?,?,?)}");
			calStmt.setInt(1, 1);
			calStmt.registerOutParameter(2, Types.VARCHAR);
			calStmt.registerOutParameter(3, Types.NUMERIC);
			calStmt.registerOutParameter(4, Types.VARCHAR);
			calStmt.executeQuery();
				System.out.println(calStmt.getString(2));
				System.out.println(calStmt.getLong(3));
				System.out.println(calStmt.getString(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// CURSOR callable
	private void executeCursorCallable(){
		try {
			calStmt = dbConn.prepareCall("{call getallassociates(?)}");
			calStmt.registerOutParameter(1, OracleTypes.CURSOR);
			/*ResultSet rs = calStmt.executeQuery();*/
			calStmt.execute();
			ResultSet rs = (ResultSet) calStmt.getObject(1);
			while(rs.next()){
				System.out.println(rs.getInt("ID"));
				System.out.println(rs.getString("NAME"));
				System.out.println(rs.getLong("MOBILE"));
				System.out.println(rs.getString("EMAIL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printResultSet(ResultSet rs){
		try {
			if(rs==null)
				System.out.println("rs is null");
			int colLen = rs.getMetaData().getColumnCount();
			for(int column = 0; column<colLen; column++){
				System.out.print(rs.getMetaData().getColumnLabel(column+1));
				System.out.print("\t");
			}
			System.out.println();
			while(rs.next()){
				for(int column = 0; column<colLen; column++){
					System.out.print(rs.getString(column+1));
					System.out.print("\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void close(){
		try {
			//rs.close();
			calStmt.close();
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBC_SP sp = new JDBC_SP();
		sp.executeCallable();
		sp.close();
	}
}
