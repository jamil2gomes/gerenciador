package br.com.acoes;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.modelo.Banco;
import br.com.modelo.Pessoa;

/*
 * 
 * Classe respons�vel por salvar uma pessoa no "banco de dados".
 */
public class NovaPessoa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date dataFormatada = DataFormatada.dataFormatada(request);//os dados que vem de um form s�o do tipo string, ent�o � preciso format�-los

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(request.getParameter("user"));// aqui n�o foi preciso fazer um parse pq ele espera uma string
		pessoa.setData(dataFormatada);
		pessoa.setSexo(request.getParameter("sexo"));
		Banco banco = new Banco();
		banco.adiciona(pessoa);//salva no "banco de dados"
		

		return "redirect:entrada?acao=ListaPessoas"; //redireciona para a classe respons�vel por listar as pessoas

	}

}
