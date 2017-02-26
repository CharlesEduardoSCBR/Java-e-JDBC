package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {
		String sql;

		sql = "INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)";

		Connection connection = Database.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		adiciona("TV LCS", "32 polegadas", statement);
		adiciona("Blueray", "Full HDMI", statement);

		statement.close();
		connection.close();
	}

	private static void adiciona(String nome, String descricao, PreparedStatement statement) throws SQLException {

		if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}

		statement.setString(1, nome);
		statement.setString(2, descricao);

		boolean resultado = statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println("id = " + resultSet.getString("id"));
		}

		System.out.println(resultado);

		resultSet.close();
	}
}
