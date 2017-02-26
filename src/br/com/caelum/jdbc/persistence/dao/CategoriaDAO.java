package br.com.caelum.jdbc.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.model.Categoria;
import br.com.caelum.jdbc.model.Produto;

public class CategoriaDAO {

	private final Connection con;
	
	public CategoriaDAO(Connection con) {
		this.con = con;
	}
	
	public List<Categoria> lista() throws SQLException {
		List<Categoria> listaCategoria = new ArrayList<>();
		
		String querySQL = "SELECT C.ID AS C_ID, C.NOME AS C_NOME, P.ID AS P_ID, P.NOME AS P_NOME, P.DESCRICAO AS P_DESCRICAO FROM CATEGORIA AS C JOIN PRODUTO AS P ON P.CATEGORIA_ID = C.ID ORDER BY C.ID";
		try (Connection con = this.con) {
			try (PreparedStatement stmt = con.prepareStatement(querySQL)) {
				stmt.execute();

				try (ResultSet rs = stmt.getResultSet()) {
					Categoria ultimaCategoria = null;
					
					while (rs.next()) {						
						int id = rs.getInt("c_id");
						String nome = rs.getString("c_nome");
						
						if(ultimaCategoria == null || !ultimaCategoria.getNome().equals(nome)){
							Categoria categoria = new Categoria(id, nome);
							listaCategoria.add(categoria);
							ultimaCategoria = categoria;
						}
						
						Produto produto = new Produto();
						produto.setId(rs.getInt("p_id"));
						produto.setNome(rs.getString("p_nome"));
						produto.setDescricao(rs.getString("p_descricao"));
						
						ultimaCategoria.adiciona(produto);
					}
				}
			}
		}
		return listaCategoria;
	}
}
