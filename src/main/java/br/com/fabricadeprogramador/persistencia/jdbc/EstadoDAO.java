package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;

public class EstadoDAO {
	
	private Connection con;
	
	public EstadoDAO(){
		con=ConexaoFactory.getConnection();
	}	
		
	public void cadastrar(Estado estado){
		String sql= "insert into estado (nome, uf) values (?, ?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setString(1, estado.getNome());
			preparador.setString(2, estado.getUf());
			preparador.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
