package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

/**
 * Objeto de acesso a dados
 * @author aluno
 *
 */

public class UsuarioDAO {
	
	private Connection con;
	
	public UsuarioDAO(){
		//obtendo uma conexão com o banco
		con= ConexaoFactory.getConnection();
	}
	
	public void cadastrar(Usuario usuario){
		String sql = "insert into usuario (nome, login, senha) values(?,?,?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			//criando objeto statement			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			//executando no banco
			preparador.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
