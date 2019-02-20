package br.com.acoes.servicos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.modelo.Pessoa;

public interface IServico {

	void mostraMensagem(HttpServletRequest request, HttpServletResponse response, List<Pessoa>pessoas) throws IOException, ServletException;
}
