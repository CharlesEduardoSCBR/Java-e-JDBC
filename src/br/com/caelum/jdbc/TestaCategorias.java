package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.model.Categoria;
import br.com.caelum.jdbc.model.Produto;
import br.com.caelum.jdbc.persistence.dao.CategoriaDAO;
import br.com.caelum.jdbc.persistence.dao.ProdutoDAO;

public class TestaCategorias {

	public static void main(String[] args) {

		try (Connection con = new ConnectionPool().getConnection()) {
			List<Categoria> categorias = new CategoriaDAO(con).lista();

			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
				for(Produto produto : categoria.getProdutos()){
					System.out.println(produto.getNome());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}