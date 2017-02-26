package br.com.caelum.jdbc;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();

		boolean resultado = statement.execute("INSERT INTO Produto(nome, descricao) VALUES('Notebook', 'Notebook i5')");
		System.out.println(resultado);
		
		statement.close();
		connection.close();
	}
}
