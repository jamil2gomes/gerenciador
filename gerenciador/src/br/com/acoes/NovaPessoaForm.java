package br.com.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Essa classe � respons�vel pelo redirecionamento para o fomul�rio de cadastro de pessoas
 * 
 */
public class NovaPessoaForm implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "forward:formPessoa.jsp";
	}

}
