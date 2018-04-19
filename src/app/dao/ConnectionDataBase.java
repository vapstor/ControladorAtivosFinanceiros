package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;

/**
 *
 * @author vapstor
 */

public class ConnectionDataBase {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/acoes_db";
    private static final String USER = "admin";
    private static final String PASS = "admin";

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