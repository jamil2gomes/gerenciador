package br.com.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {
	
	private DataSource dataSource;
	
	
	public ConnectionPool() {
		
		MysqlDataSource mysqlDataSource = new MysqlDataSource();
		
		String url = "jdbc:mysql://localhost/bdpessoa?useSSL=false";
		
		mysqlDataSource.setURL(url);
		mysqlDataSource.setUser("root");
		mysqlDataSource.setPassword("j4m1l!123");

		this.dataSource = mysqlDataSource;

	}
	
	
	public Connection getConexao() throws SQLException {
		
		Connection conexao = dataSource.getConnection();
		
		return conexao;
	}

}
