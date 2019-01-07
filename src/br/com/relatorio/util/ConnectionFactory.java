package br.com.relatorio.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private String url = "jdbc:mysql://localhost/bradesco";
	private String user = "master";
	private String pass = "matos132739";
	
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
