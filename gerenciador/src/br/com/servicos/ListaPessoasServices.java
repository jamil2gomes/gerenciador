package br.com.servicos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acoes.servicos.Json;
import br.com.acoes.servicos.Xml;
import br.com.modelo.Banco;
import br.com.modelo.Pessoa;



@WebServlet("/pessoas")
public class ListaPessoasServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Pessoa>pessoas = new Banco().getPessoas();
		
		String valorCabecalho = request.getHeader("Accept");
		
		if(valorCabecalho.contains("xml"))
		{
			
			new Xml().mostraMensagem(request, response, pessoas);
			
		}else if(valorCabecalho.contains("json"))
		{
			new Json().mostraMensagem(request, response, pessoas);
			
		}else {
			response.setContentType("application/json");
			response.setCharacterEncoding("ISO-8859-1");
			response.getWriter().print("{'mensagem':'Tipo de conteúdo não suportado'}");
		}
		
		
		
		
		
	}

	
}
