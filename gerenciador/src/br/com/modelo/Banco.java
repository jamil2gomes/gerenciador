package br.com.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.PessoaDAO;

public class Banco {
	private List<Pessoa> pessoas = null;
	private static List<Usuario> usuarios = new ArrayList<>();

	private PessoaDAO dao = null;
	
	static {
		Usuario user = new Usuario();
		user.setLogin("admin");
		user.setSenha("admin");
		Banco.usuarios.add(user);
	}
	
	public Banco(){
		
			try {
				this.dao = new PessoaDAO();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	
	public void adiciona(Pessoa pessoa){
		try {
			this.dao.salvar(pessoa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void altera(Pessoa pessoa){
		try {
			this.dao.atualizar(pessoa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Pessoa> getPessoas(){
		
		try {
			this.pessoas = dao.recuperaPessoas();
			return pessoas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public void removeNome(Integer id) {
		try {
			this.dao.remove(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pessoa buscar(Integer id) {
		
		return this.dao.buscaPor(id);
		
	}

	public Usuario existeUsuario(String login, String senha) {

		Usuario usuario = null;
		try {
			         usuario =Banco.usuarios.stream()
					.filter(user->user.ehIgual(login, senha))
					.findFirst()
					.get();
		} catch (Exception e) {
			
		}
		
		if(usuario!=null) 
			return usuario;
		
		
		return null;
	}
	

}
