package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

/**
 * Objeto de acesso a dados
 * 
 * @author aluno
 *
 */

public class UsuarioDAO {

	private Connection con;

	public UsuarioDAO() {
		// obtendo uma conexão com o banco
		con = ConexaoFactory.getConnection();
	}

	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario (nome, login, senha) values(?,?,?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			// criando objeto statement
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			// executando no banco
			preparador.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			// criando objeto statement
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());

			// executando no banco
			preparador.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(Usuario usuario){
		String sql = "delete from usuario where id=?";
		
		try (PreparedStatement preparador =  con.prepareStatement(sql)){
			//Criando objeto Statement 
			preparador.setInt(1, usuario.getId());
			
			//Executando no banco
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//salva com insert ou update
	//se o usuario tiver id então altera senao insere

	public void salvar(Usuario usuario) {
		if (usuario.getId() == null || usuario.getId() == 0) {
			cadastrar(usuario);
			
		}else {
			alterar(usuario);
		}
	}
	
	public List<Usuario> buscarTodos(){
		
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			ResultSet resultado = preparador.executeQuery();
			Usuario usuario;
			
			while (resultado.next()){
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				lista.add(usuario);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
		
		
		
	}
	
	public Usuario buscaPorId(Integer id){
		
		Usuario usuRetorno = null;
		
		String sql = "select * from usuario where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setInt(1, id);
			
			
			ResultSet resultado = preparador.executeQuery();
			
			if (resultado.next())
			{
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				
			}
			
			System.out.println("Encontrado com sucesso");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return usuRetorno;
		
		
	}

	


	
}
