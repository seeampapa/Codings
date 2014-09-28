package amp.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	private String dbName = "xe";
	private String dbHost = "localhost";
	private String dbPort = "1521";
	private String dbUser = "amp";
	private String dbPwd = "maniacon";
	private String orclConnUrl;
	
	private Connection dbConn;
	private Statement stmt;
	
	public JDBC() {
		init();
		// TODO Auto-generated constructor stub
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
	
	private ResultSet executeSelectQry(String qry){
		try {
			stmt = dbConn.createStatement();
			return stmt.executeQuery(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private ResultSet executeSelectPreparedQry(String qry, int id){
		try{
			PreparedStatement pstmt = dbConn.prepareStatement(qry);
			pstmt.setInt(1, id);
			return pstmt.executeQuery();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	private void printResultSet(ResultSet rs){
		try {
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
	
	private void amendTable(String qry){
		try {
			stmt = dbConn.createStatement();
			stmt.executeUpdate(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void close(){
		try {
			//rs.close();
			stmt.close();
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBC jdb = new JDBC();
		//jdb.amendTable("insert into associates values (associates_id.nextval, 'pradeep', '9999999999', '@.')");
		jdb.printResultSet(jdb.executeSelectQry("select * from associates"));
		jdb.printResultSet(jdb.executeSelectPreparedQry("select * from associates where id = ?", 21));
	}
}
