package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionPool db = new ConnectionPool();
		Connection connection = db.getConnection();
		Statement stm = connection.createStatement();
		stm.execute("delete from Produto where id > 3");
		
		int count = stm.getUpdateCount();
		System.out.println(count + " linhas atualizadas");
		
		stm.close();
		connection.close();
	}
}
