package br.com.acoes;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.modelo.Banco;
import br.com.modelo.Pessoa;

public class AlteraPessoa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));
		String nome = request.getParameter("user");
		String sexo = request.getParameter("sexo");
		Date data = DataFormatada.dataFormatada(request);

		Banco banco = new Banco();
		Pessoa pessoa = banco.buscar(id);
		pessoa.setNome(nome);
		pessoa.setData(data);
		pessoa.setSexo(sexo);
		banco.altera(pessoa);

		return "redirect:entrada?acao=ListaPessoas";

	}

}
