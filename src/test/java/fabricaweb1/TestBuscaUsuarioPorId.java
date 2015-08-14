package fabricaweb1;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestBuscaUsuarioPorId {

	public static void testBuscaPorId() {
		UsuarioDAO usudao = new UsuarioDAO();
		Usuario usuRetorno = usudao.buscaPorId(4 );

		if (usuRetorno != null)
			System.out
					.println(usuRetorno.getId() + " " + usuRetorno.getNome()
							+ " " + usuRetorno.getLogin() + " "
							+ usuRetorno.getSenha());

	}

	public static void main(String[] args) {
		testBuscaPorId();
	}

}
