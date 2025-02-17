package brokerage.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	protected Connection conn;
	private String url = "jdbc:mysql://localhost:3306/real_estate_brokerage";
	private String user = "root";
	private String pwd = "1234";
	
	protected Dao() {
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e); 
		}
	}
}
