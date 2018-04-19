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

/**
 *
 * @author vapstor
 */
public class CotacaoDAO extends GenericDAO {

    public CotacaoDAO() {
    }
    
    public Cotacao findCotacao(String nome) {
        String select = "SELECT * FROM cotacao WHERE nome = ?";
        Cotacao ct = null;
        try {
            try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
                stmt.setString(1, nome);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        //int id, int moedaId, double valor, double corretagem, double imposto
                        ct = new Cotacao(
                                rs.getString("nome"),
                                rs.getDouble("valor"),
                                rs.getDouble("corretagem"),
                                rs.getDouble("imposto")
                        );
                    }
                }
            }
        } catch (SQLException e){
            System.out.println("Erro: " + e);
        }
        
        return ct;
    }
}
