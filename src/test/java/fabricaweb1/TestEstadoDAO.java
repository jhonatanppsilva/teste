package fabricaweb1;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO;

public class TestEstadoDAO {

	public static void main(String[] args) {
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado ms = new Estado();
		
		ms.setNome("Mato Grosso do sul");
		ms.setUf("ms");
		
		Estado sp = new Estado();
		sp.setNome("São paulo");
		sp.setUf("sp");
		
		estadoDAO.cadastrar(sp);
		System.out.println("Estado Cadastrado com sucesso");
		
	
		
		
		
	}

}
