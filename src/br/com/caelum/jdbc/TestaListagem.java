package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Database;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		ConnectionPool db = new ConnectionPool();
		
		Connection connection = db.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into Produto (nome, descricao) values ('Notebook', 'Notebook i5')", Statement.RETURN_GENERATED_KEYS);
		System.out.println("O resultado foi: " + resultado);

		ResultSet resultSet = statement.getGeneratedKeys();
		
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println(id + " gerado");
		}
		
		statement.close();
		connection.close();
	}
}
