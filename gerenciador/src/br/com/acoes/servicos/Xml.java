package br.com.acoes.servicos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.modelo.Pessoa;

public class Xml implements IServico {

	@Override
	public void mostraMensagem(HttpServletRequest request, HttpServletResponse response, List<Pessoa> pessoas)
			throws IOException, ServletException {
		
		XStream strem = new XStream();
		strem.alias("pessoa", Pessoa.class);
		String xml = strem.toXML(pessoas);
		
		response.setContentType("application/xml");
		response.setCharacterEncoding("ISO-8859-1");
		response.getWriter().print(xml);

	}

}
