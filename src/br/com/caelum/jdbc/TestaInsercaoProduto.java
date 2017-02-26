package br.com.caelum.jdbc;

import java.sql.SQLException;

import br.com.caelum.jdbc.model.Produto;
import br.com.caelum.jdbc.persistence.dao.ProdutoDAO;

public class TestaInsercaoProduto {

	public static void main(String[] args) {
		Produto p1 = new Produto("Mesa Azul", "Mesa com 4 pés");
		ProdutoDAO dao = new ProdutoDAO(null);
		try {
			dao.salva(p1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
