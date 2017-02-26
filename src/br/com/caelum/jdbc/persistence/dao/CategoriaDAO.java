package br.com.caelum.jdbc.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.model.Categoria;

public class CategoriaDAO {

	private final Connection con;
	
	public CategoriaDAO(Connection con) {
		this.con = con;
	}
	
	public List<Categoria> lista() throws SQLException {
		List<Categoria> listaCategoria = new ArrayList<>();
		String buscalistaProdutos = "SELECT * FROM Categoria";
		
		try (Connection con = this.con) {
			try (PreparedStatement stmt = con.prepareStatement(buscalistaProdutos)) {
				stmt.execute();

				try (ResultSet rs = stmt.getResultSet()) {
					while (rs.next()) {
						Categoria categoria = new Categoria();
						categoria.setId(rs.getInt("id"));
						categoria.setNome(rs.getString("nome"));
						listaCategoria.add(categoria);
					}
				}
			}
		}
		return listaCategoria;
	}
}
