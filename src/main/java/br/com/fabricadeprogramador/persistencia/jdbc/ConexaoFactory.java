package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	public static Connection getConnection() {
        
		
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}
	
		
		Connection c=null;
		try {
			c = DriverManager .getConnection("jdbc:postgresql://localhost:5432/fabricawebdb", "postgres","postgres");
		} catch (SQLException e) {
			throw new RuntimeException("não conectou", e);
			
			
		}
		return c;
	}



}
