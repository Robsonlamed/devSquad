package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class GenericDAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbdevsquad?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "123456";
	
	public Connection conectar() {
		Connection conection = null;
		try {
			Class.forName(driver);
			conection = DriverManager.getConnection(url, user, password);
			return conection;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
