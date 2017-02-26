package br.com.caelum.jdbc;

import java.sql.Connection;

import br.com.caelum.jdbc.model.Produto;

public class TestaInsercaoProduto {

	public static void main(String[] args) {

		Produto p1 = new Produto("Mesa Azul", "Mesa com 4 pés");
		
		try(Connection con = new ConnectionPool().getConnection()){
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Ocorreu um problema com sua conexão do banco de dados.");
		}
	}

}
