package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vapstor
 */

public class GeraConexao {
    
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/acoes_db";
    private static final String USER = "root";
    private static final String PASS = "aff0123456";

    public static Connection GeraConexao() {
        Connection Conexao;
        try {
            Conexao = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("erro sql de conexao: " + e.getMessage());
            Conexao = null;
        }
        return Conexao;
    }
    
    public static Connection getConnection() {
		System.out.println("Conectando ao Banco de Dados");
		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
