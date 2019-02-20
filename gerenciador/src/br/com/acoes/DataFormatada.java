package br.com.acoes;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/*
 * 
 * Essa classe � respons�vel por formatar a data vinda do formul�rio para o tipo Date do java (todos dados vindo de um form � uma string).
 */
public class DataFormatada {

	public static Date dataFormatada(HttpServletRequest request) throws ServletException {
		Date dataFormatada = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");//cria um formato de data: dia/mes/ano
			String data = request.getParameter("data");//recebe o dado do campo data na requisi��o
			dataFormatada = format.parse(data);   //formata a data para o padrao desejado
		} catch (Exception e) {
			throw new ServletException(e);
		}

		return dataFormatada;
	}

}
