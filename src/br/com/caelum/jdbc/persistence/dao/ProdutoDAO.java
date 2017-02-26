package br.com.caelum.jdbc.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionPool;
import br.com.caelum.jdbc.model.Produto;

public class ProdutoDAO {

	public void salva(Produto salva) throws SQLException {
		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)";

		try (Connection con = new ConnectionPool().getConnection()) {
			con.setAutoCommit(false);

			if (salva.getNome().equals("Blueray")) {
				throw new IllegalArgumentException("Problema ocorrido");
			}

			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, salva.getNome());
				stmt.setString(2, salva.getDescricao());
				stmt.execute();

				try (ResultSet resultSet = stmt.getGeneratedKeys()) {
					while (resultSet.next()) {
						salva.setId(resultSet.getInt("id"));
					}
				}

				con.commit();

			} catch (Exception ex) {
				con.rollback();

				System.out.println("Transação para inserir produto não efetudas");
				ex.printStackTrace();
			}
		}
	}

	public List<Produto> listaProdutos() throws SQLException {
		List<Produto> listaProdutos = new ArrayList<>();
		String buscalistaProdutos = "SELECT * FROM PRODUTO";

		try (Connection con = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(buscalistaProdutos)) {
				stmt.execute();
				transformaResultadoEmProdutos(listaProdutos, stmt);
			}
		}
		return listaProdutos;
	}

	private void transformaResultadoEmProdutos(List<Produto> listaProdutos, PreparedStatement stmt)
			throws SQLException {
		try (ResultSet resultSet = stmt.getResultSet()) {
			while (resultSet.next()) {
				Produto produto = new Produto();

				produto.setId(resultSet.getInt("id"));
				produto.setNome(resultSet.getString("nome"));
				produto.setDescricao(resultSet.getString("descricao"));
				listaProdutos.add(produto);
			}
		}
	}
}