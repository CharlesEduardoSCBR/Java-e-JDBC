package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into Produto (nome, descricao) values ('Notebook', 'Notebook i5')");
		System.out.println("O resultado foi: " + resultado);

		statement.close();
		connection.close();
	}
}
