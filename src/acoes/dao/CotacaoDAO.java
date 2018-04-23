/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.dao;

import app.dao.GenericDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import acoes.model.Cotacao;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author vapstor
 */
public class CotacaoDAO extends GenericDAO {

    public CotacaoDAO() {
    }
    
    public Cotacao findCotacao(String nome) {
        String select = "SELECT * FROM Cotacoes WHERE Nome = ?";
        Cotacao cotacao = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //String tipo, double valor, double corretagem, double imposto
                    cotacao = new Cotacao(
                            rs.getString("Nome"),
                            rs.getDouble("Valor"),
                            rs.getDouble("Corretagem"),
                            rs.getDouble("Imposto")
                    );
                }
            }
        } catch (SQLException e){
            System.out.println("Erro: " + e);
        }
        return cotacao;
    }
    
    public void updateCotacao(Component framePai, String nome, double valor, double corretagem, double imposto) {
        String update = "UPDATE Cotacoes SET Valor = ?, Corretagem = ?, Imposto = ? WHERE Nome= '"+nome+"'";
        try (PreparedStatement stmt = getConnection().prepareStatement(update)) {
            stmt.setDouble(1, valor);
            stmt.setDouble(2, corretagem);
            stmt.setDouble(3, imposto);
            int rs = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e){
            System.out.println("Erro: " + e);
        }
    }
}
