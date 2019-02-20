package br.com.acoes.servicos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.modelo.Pessoa;

public class Json implements IServico {

	@Override
	public void mostraMensagem(HttpServletRequest request, HttpServletResponse response, List<Pessoa> pessoas)
			throws IOException, ServletException {
		
		Gson gson = new Gson();
		String json = gson.toJson(pessoas);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("ISO-8859-1");
		response.getWriter().print(json);

	}

}
