package br.com.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.modelo.Banco;
import br.com.modelo.Pessoa;

public class ListaPessoas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();

		List<Pessoa> lista = banco.getPessoas();

		request.setAttribute("pessoas", lista);

		return "forward:listaPessoa.jsp";
	}

}
