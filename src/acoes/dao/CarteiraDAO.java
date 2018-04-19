/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.dao;

import acionistas.model.Acionista;
import app.dao.GenericDAO;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import acoes.model.Carteira;

/**
 *
 * @author vapstor
 */
public class CarteiraDAO extends GenericDAO {
    
    public void salvaCarteira(Component framePai, Carteira novaCarteira) throws SQLException {
        try { 
//            String insertCarteiraFk = "INSERT INTO Carteira (ID, saldo) values ((SELECT Carteira FROM Acionistas WHERE CPF = ?), ?);";
            String insertCarteira = "INSERT INTO Carteira ("+ "ID, Saldo)"+ "values (?,?)";
            save(
                    insertCarteira, novaCarteira.getID(), novaCarteira.getSaldo()
            );
            System.out.println("Carteira Salva (CARTEIRA DAO)!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(framePai, "Ocorreu um erro" + "\n" + e);
        }
    }
    
    public Carteira findCarteira(int ID) throws SQLException {
        String select = "SELECT * FROM Carteira WHERE ID = ?";
        
        Carteira carteira = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setInt(1, ID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    carteira = new Carteira(
                        rs.getInt("ID"),
                        rs.getDouble("Saldo")
                    );
                }
                rs.close();
            }
            stmt.close();
        }
        return carteira;
    }
    
    public double alteraDinheiro(int idCarteira, double valor, String operacao) throws SQLException {
        Carteira carteira = findCarteira(idCarteira);
        
        if(operacao.equals("Adicionar")) {
            carteira.setSaldo(carteira.getSaldo() + valor);
            System.out.println("novo saldo carteira add"+ carteira.getSaldo());
            double novoSaldo = carteira.getSaldo();
            
            String update = "UPDATE Carteira SET Saldo = ? WHERE Carteira.ID = ?;";
            
            try (PreparedStatement stmt = getConnection().prepareStatement(update)) {
                stmt.setString(1, Double.toString(novoSaldo));
                stmt.setString(2, Integer.toString(idCarteira));
                int rs = stmt.executeUpdate();
                System.out.println(rs);
                stmt.close();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Erro: " + e);
            }
            return novoSaldo;
        } else {
            carteira.setSaldo(carteira.getSaldo() - valor);
            double novoSaldo = carteira.getSaldo();
            String update = "UPDATE Carteira SET Saldo = ? WHERE Carteira.ID = ?;";
            try (PreparedStatement stmt = getConnection().prepareStatement(update)) {
                stmt.setString(1, Double.toString(novoSaldo));
                stmt.setString(2, Integer.toString(idCarteira));
                int rs = stmt.executeUpdate();
                System.out.println(rs);
                stmt.close();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Erro: " + e);
            }
            return novoSaldo;
        }
    }
   
    
//    public void compraAcao(Component framePai, Acionista acionista, double valorAcao ,double corretagem) throws SQLException {
//        String insert = "INSERT INTO Acionistas ("
//                + "CPF, Nome, Carteira, Password)"
//                + "values (?,?,?,?)";
//        save(
//                insert, acionista.getCPF(), acionista.getNome(), 
//                acionista.getCarteira(), acionista.getPassword()
//        );
//        JOptionPane.showMessageDialog(framePai , "Acionista cadastrado com sucesso!", "Usuário Adicionado", JOptionPane.PLAIN_MESSAGE);
//    }
}
