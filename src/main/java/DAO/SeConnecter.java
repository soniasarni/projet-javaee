package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SeConnecter {
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost/";
		String dataBase="projet_1_ecommerce";
		String user ="root";
		String mot_de_pass="";
	    Connection connect = null ;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection(url+dataBase,user,mot_de_pass);
			System.out.println("success");
		} catch (Exception e) {
		     e.printStackTrace();
		}
		
return connect;
	}

}
