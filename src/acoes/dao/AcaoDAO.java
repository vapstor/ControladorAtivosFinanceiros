/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.dao;

import static app.dao.ConnectionDataBase.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import acoes.model.Acao;

/**
 *Data Access Object da Ação em si
 * @author vapstor
 */
public class AcaoDAO {
    CarteiraDAO carteiraDao;
    
    public Acao findAcao(int idAcao) throws SQLException {
        String select = "SELECT * FROM Acoes WHERE ID = ?";
        Acao acao = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, Integer.toString(idAcao));
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                acao = new Acao(
                        rs.getInt("ID"),
                        rs.getString("Nome"),
                        rs.getInt("Quantidade"),
                        rs.getDouble("Cotacao"),
                        rs.getInt("idCarteira")
                );
            }
            rs.close();
            stmt.close();
        }
        return acao;
    }
    
    public List findAcoes() throws SQLException {
        String select = "SELECT * FROM Acoes";
        List listaAcoes = new ArrayList();
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Acao acao = new Acao(
                        rs.getInt("ID"),
                        rs.getString("Nome"),
                        rs.getInt("Quantidade"),
                        rs.getDouble("Cotacao"),
                        rs.getInt("idCarteira")
                );
                listaAcoes.add(acao);
            }
            rs.close();
            stmt.close();
        }
        return listaAcoes;
    }
    
    
}
