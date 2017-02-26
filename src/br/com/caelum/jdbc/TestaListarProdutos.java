package br.com.caelum.jdbc;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.model.Produto;
import br.com.caelum.jdbc.persistence.dao.ProdutoDAO;

public class TestaListarProdutos {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista;
		
		try {
			lista = dao.listaProdutos();
			
			for (Produto produto : lista) {
				System.out.println(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
