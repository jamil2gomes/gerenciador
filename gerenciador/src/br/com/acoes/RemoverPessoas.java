package br.com.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.modelo.Banco;
/*
 * Classe responsável pela remoção da pessoa na lista.
 */
public class RemoverPessoas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();
		banco.removeNome(Integer.valueOf(request.getParameter("id"))); //pega o id da pessoa passada no parametro

		return "redirect:entrada?acao=ListaPessoas"; //redireciona para a view listaPessoa

	}

}
