package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO;

@WebServlet("/estadocontroller.do")

public class EstadoController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//recebendo os dados da tela formestado.html		
		String nome = req.getParameter("nome");
		String uf   = req.getParameter("uf");
		String id = req.getParameter("id");
		
		//Instanciar o estado
		Estado estado = new Estado();
		estado.setNome(nome);
		estado.setUf(uf);
		
		
		//se o id existir
				if(id!=null){
					estado.setId(Integer.parseInt(id));
				}
		
		//persistindo no banco
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		
		//resposta
		resp.getWriter().print("Estado salvo");
		
	}
	

}
