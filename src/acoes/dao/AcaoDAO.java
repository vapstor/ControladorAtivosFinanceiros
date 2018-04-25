/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import acoes.model.Acao;
import app.dao.GenericDAO;

/**
 *Data Access Object da Ação em si
 * @author vapstor
 */
public class AcaoDAO extends GenericDAO {
    CarteiraDAO carteiraDao;
    
    public void addAcao(String nome, int quantidade, double corretagem, double cotacao, double valorTotalAcao) throws SQLException {
        try {
            String insert = "INSERT INTO Acoes (Nome, Quantidade, Corretagem, Cotacao, Custo) VALUES(?, ?, ?,? ,?)";
            save(insert, nome, quantidade, cotacao, corretagem, valorTotalAcao);
        } catch (SQLException e) {
            throw new SQLException("Erro: " + e);
        }
    }
    
     public void vendeAcao(int ID, int qntd) throws SQLException {
        if((findAcao(ID).getQuantidade() - qntd) == 0) {
            String delete = "DELETE FROM Acoes WHERE ID= ?";
            delete(delete, ID);
        } else {
            try {
                String update = "UPDATE Acoes SET Quantidade = ? WHERE ID="+ID+";";
                update(update, qntd);
            } catch (SQLException e) {
                throw new SQLException("Erro: " + e);
            }
        }
        
    }
    
    public void limpaListaAcoes() throws SQLException {
        try {
            String deleteAll = "TRUNCATE Acoes";
            delete(deleteAll);
        } catch (SQLException e) {
            throw new SQLException("Erro: " + e);
        }
        
    }
    
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
                        rs.getDouble("Corretagem"),
                        rs.getDouble("Cotacao"),
                        rs.getDouble("Custo")
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
                        rs.getDouble("Corretagem"),
                        rs.getDouble("Cotacao"),
                        rs.getDouble("Custo")
                );
                listaAcoes.add(acao);
            }
            rs.close();
            stmt.close();
        }
        return listaAcoes;
    }
    
    
}
