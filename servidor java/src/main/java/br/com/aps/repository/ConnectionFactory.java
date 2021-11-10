package br.com.aps.repository;

import static java.util.logging.Level.SEVERE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionFactory {

	private static final String URLSQLITE = "jdbc:sqlite:aps-db.db";

	public static Connection getConnection() {

		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(URLSQLITE);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(SEVERE, null, ex);
			return null;
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection con, PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}
			closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
