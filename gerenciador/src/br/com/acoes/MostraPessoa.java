package br.com.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.modelo.Banco;
import br.com.modelo.Pessoa;

public class MostraPessoa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		Pessoa p = banco.buscar(Integer.valueOf(request.getParameter("id")));

		// System.out.println(p.getNome());

		request.setAttribute("pessoa", p);

		return "forward:formPessoaEditar.jsp";

	}

}
