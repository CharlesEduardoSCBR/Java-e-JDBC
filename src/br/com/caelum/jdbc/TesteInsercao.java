package br.com.caelum.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();

		statement.execute("INSERT INTO Produto(nome, descricao) VALUES('Notebook', 'Notebook i5')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		while (resultSet.next()) {
			System.out.println("id = " + resultSet.getString("id"));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}
}
