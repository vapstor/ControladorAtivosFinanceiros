/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth.controller;

import static app.dao.ConnectionDataBase.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vapstor
 */
public class AuthController {
    public boolean autenticador(String CPF, String Password) throws SQLException {
        String select = "SELECT Password FROM Acionistas WHERE CPF = ?";
        String passBD = null;
        String userBD = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, CPF);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //Pega a String da Coluna Password
                    passBD = rs.getString("Password");
                }
            }
            if(Password.equals(passBD)) {
                return true;
            }
//            if(CPF.equals(userBD)) {
//                JOptionPane.showMessageDialog(null, "CPF Já Cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Os campos não podem ser nulos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
}
