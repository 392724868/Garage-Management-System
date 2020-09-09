package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
	private static Properties props = new Properties();
	static {		
		try {
			props.load(new FileInputStream("database.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		Connection con = null;
		try {
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String username = props.getProperty("user");
			String password = props.getProperty("password");
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("failed to register driver.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("failed to execute sql.");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Statement pst,Connection con){
		if(pst!=null){
			try{
				pst.close();
			}catch(SQLException c){}
		}
		if(con!=null){
			try{
				con.close();
			}catch(SQLException c){}
		}
	}
	


	public static void close(ResultSet rs, Statement pst, Connection con){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException c){}
		}
		
		if(pst!=null){
			try{
				pst.close();
			}catch(SQLException c){}
		}
		if(con!=null){
			try{
				con.close();
			}catch(SQLException c){}
		}
	}
	
}
