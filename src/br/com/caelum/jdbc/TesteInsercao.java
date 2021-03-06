package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {
		String sql;

		ConnectionPool db = new ConnectionPool();

		sql = "INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)";

		try (Connection connection = db.getConnection()) {
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adiciona("TV LCS", "32 polegadas", statement);
				adiciona("Blueray", "Full HDMI", statement);

				connection.commit();

			} catch (Exception ex) {
				connection.rollback();

				System.out.println("Transação para inserir produto não efetudas");
				ex.printStackTrace();
			}
		}
	}

	private static void adiciona(String nome, String descricao, PreparedStatement statement) throws SQLException {
		if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}

		statement.setString(1, nome);
		statement.setString(2, descricao);

		boolean resultado = statement.execute();

		try (ResultSet resultSet = statement.getGeneratedKeys()) {

			while (resultSet.next()) {
				System.out.println("id = " + resultSet.getString("id"));
			}

			System.out.println(resultado);
		}
	}
}
