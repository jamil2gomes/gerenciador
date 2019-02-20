package br.com.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acoes.Acao;


@WebFilter("/entrada")
public class ControladorCentralFilter implements Filter {

   
	
	public void doFilter(ServletRequest filterRequest, ServletResponse filterResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)filterRequest;
		HttpServletResponse response = (HttpServletResponse)filterResponse;
		
		String paramAcao = request.getParameter("acao");
		String nomeClasse = "br.com.acoes." + paramAcao;
		
		try {
			Class<?> classe = Class.forName(nomeClasse); // load the class
			Acao acao = (Acao) classe.newInstance();
			String link = acao.executa(request, response);
			redireciona(link, request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
	
	private void redireciona(String link, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] tipo = link.split(":");

		if (tipo[0].equals("forward")) {
			request.getRequestDispatcher("WEB-INF/view/" + tipo[1]).forward(request, response);
		} else {
			response.sendRedirect(tipo[1]);
		}
	}

	
}
