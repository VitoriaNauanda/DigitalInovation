package projetinho;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBCjava {

	private ConnectionJDBCjava() {
		throw new UnsupportedOperationException();
	}
	public static Connection getConnection() {
			String urlConnection = "jdbc:mysql://localhost/vitoria_digital";
			Connection conn = null;
		try {
			conn = DriverManager.getConnection(urlConnection, "root", "89906640");
			System.out.println("Conexão Sucedida");
		}catch(Exception e){
			System.out.println("Falhou "+e.getMessage());
		}
		return conn;
	}
	
}
