package br.com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.conexao.ConnectionPool;
import br.com.modelo.Pessoa;

public class PessoaDAO {
	
	private Connection conexao;
	
	
	public PessoaDAO() throws SQLException {
		this.conexao = new ConnectionPool().getConexao();
	}
	
	
	public Pessoa salvar(Pessoa pessoa) throws SQLException  {
		String sql = "insert into pessoas (nome, data,sexo) values (?, ?, ?)";

		try (PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, pessoa.getNome());
			java.util.Date data = pessoa.getData();
			
			statement.setDate(2, new Date(data.getTime()));
			statement.setString(3,pessoa.getSexo());

			statement.execute();

			try (ResultSet keys = statement.getGeneratedKeys()) {
				keys.next();
				int id = keys.getInt(1);
				pessoa.setId(id);
			}
		}
			return pessoa;
	}
	
	
	public List<Pessoa> recuperaPessoas() throws SQLException {

		String sql = "select id, nome, data, sexo from pessoas";
 
		try (PreparedStatement statment = conexao.prepareStatement(sql)) {
			
		
			
			ResultSet resultSet = statment.executeQuery(sql);
			
			final List<Pessoa> pessoas = new ArrayList<>();
			
			while (resultSet.next() ) {
				Pessoa pessoa = montaPessoa(resultSet);
				pessoas.add(pessoa);
			}
			
			//pessoas.forEach(System.out::println);
			return pessoas;
			
		}

	}

	private Pessoa montaPessoa(ResultSet resultSet) throws SQLException {
		String nome = resultSet.getString("nome");
		String sexo = resultSet.getString("sexo");
		Date data = resultSet.getDate("data");
		int id = resultSet.getInt("id");
		
		Pessoa p = new Pessoa(nome, data,sexo);
		p.setId(id);

		return p;
}
	
	public Pessoa buscaPor(Integer id) {
		
		
		try (PreparedStatement ps = this.conexao
				.prepareStatement("select id,nome,data,sexo from pessoas where id = ?") ) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(rs.getString("nome"));
			pessoa.setData(rs.getDate("data"));
			pessoa.setSexo(rs.getString("sexo"));
			
			pessoa.setId(rs.getInt("id"));
			
			return pessoa;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
				
	}
	
	
	public Pessoa atualizar(Pessoa pessoa) throws SQLException {

		String sql = "UPDATE pessoas SET nome = ?,data = ?, sexo = ?WHERE id = ? ";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {

			ps.setString(1, pessoa.getNome());
			java.util.Date data = pessoa.getData();
			
			ps.setDate(2, new Date(data.getTime()));
			ps.setString(3, pessoa.getSexo());
			ps.setInt(4, pessoa.getId());

			ps.execute();

		}

		return pessoa;

	}
	
	public void remove(Integer id) throws SQLException {
		String sql = "DELETE FROM pessoas  where id = ? ";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {
	
			ps.setInt(1, id);

			ps.execute();

		}
	}

}
