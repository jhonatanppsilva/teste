package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;


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
	
	public void alterar(Estado estado){
		String sql= "update estado set nome=?, uf=? where id=? ";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setString(1, estado.getNome());
			preparador.setString(2, estado.getUf());
			preparador.setInt(3, estado.getId());
			preparador.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	//salva com insert ou update
		//se o estado tiver id então altera senao insere

		public void salvar(Estado estado) {
			if (estado.getId() == null || estado.getId() == 0) {
				cadastrar(estado);
				
			}else {
				alterar(estado);
			}
		}

		public List<Estado> buscarTodos(){
		
		List<Estado> lista = new ArrayList<Estado>();
		String sql = "select * from estado";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			ResultSet resultado = preparador.executeQuery();
			Estado estado;
			
			while (resultado.next()){
				estado = new Estado();
				estado.setId(resultado.getInt("id"));
				estado.setNome(resultado.getString("nome"));
				estado.setUf(resultado.getString("uf"));				
				lista.add(estado);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
		
		
		
	}
		public void excluir(Estado estado){
			String sql = "delete from estado where id=?";
			
			try (PreparedStatement preparador =  con.prepareStatement(sql)){
				//Criando objeto Statement 
				preparador.setInt(1, estado.getId());
				
				//Executando no banco
				preparador.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
