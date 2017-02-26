package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.model.Categoria;
import br.com.caelum.jdbc.persistence.dao.CategoriaDAO;

public class TestaCategorias {

	public static void main(String[] args) {

		try (Connection con = new ConnectionPool().getConnection()) {
			List<Categoria> categorias = new CategoriaDAO(con).lista();

			for (Categoria categoria : categorias) {
				System.out.println(categoria.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}