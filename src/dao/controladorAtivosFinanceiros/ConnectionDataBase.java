/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.controladorAtivosFinanceiros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author vapstor
 */

public class ConnectionDataBase {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/estacionamento_db";
    private static String USER = "";
    private static String PASS = "";

	public static Connection getConnection() {
		System.out.println("Conectando ao Banco de Dados");
		try {
			Class.forName(DRIVER_CLASS);
                        USER = JOptionPane.showInputDialog(null, "Digite o Usuário do BD");
                        
                        JPasswordField pf = new JPasswordField();
                        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Digite a Senha do BD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (okCxl == JOptionPane.OK_OPTION) {
                          PASS = new String(pf.getPassword());
                          System.err.println("You entered: " + PASS);
                        }
                        
                        return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}