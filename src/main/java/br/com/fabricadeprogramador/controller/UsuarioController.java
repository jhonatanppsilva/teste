package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")

public class UsuarioController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//recebendo dados da tela formusuario.html
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		String id = req.getParameter("id");
		
		//instanciando a classe usuario e setando valores		
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		//se o id existir
		if(id!=null){
			usu.setId(Integer.parseInt(id));
		}
				
		
		//Persistindo no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usu);
		
		//resposta
		resp.getWriter().print("salvo");
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Pegando o id da tela
		String id = req.getParameter("id");
		
		//Preencher o objeto usuario
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt(id));
		
		//Excluir
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		usuarioDAO.excluir(usu);
		
		//Mensagem
		resp.getWriter().print("Excluido!");
		
	}

}
