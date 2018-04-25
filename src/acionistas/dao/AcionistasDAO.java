package acionistas.dao;

import app.dao.GenericDAO;
import java.awt.Component;
import java.awt.HeadlessException;
import acionistas.model.Acionista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import java.util.List;
/**
 *
 * @author vapstor
 */
public class AcionistasDAO extends GenericDAO {
    public void salvar(Component framePai, Acionista acionista) throws SQLException {
        String insert = "INSERT INTO Acionistas ("
                + "CPF, Nome, Carteira, Password)"
                + "values (?,?,?,?)";
        save(
                insert, acionista.getCPF(), acionista.getNome(), 
                acionista.getCarteira(), acionista.getPassword()
        );
        JOptionPane.showMessageDialog(framePai , "Acionista cadastrado com sucesso!", "Usuário Adicionado", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void alterar(Acionista acionista) throws SQLException {
        String update = "UPDATE acionista " +
                        "SET CPF = ?, nome = ?, Carteira = ?, ";
        update(update, acionista.getCPF(), acionista.getNome(), 
                acionista.getCarteira()
        );
    }
 
    public void excluir(String CPF) throws SQLException {
        String delete = "DELETE FROM Acionistas WHERE CPF = ?";
        try {
            delete(delete, CPF);
            JOptionPane.showMessageDialog(null, "O acionista foi deletado com sucesso!", "Usuário deletado", JOptionPane.PLAIN_MESSAGE);
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!" + "\n" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Acionista findByCPF(String CPF) throws SQLException {
        String select = "SELECT * FROM Acionistas WHERE CPF = ?";
        Acionista acionista = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, CPF);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    acionista = new Acionista(
                        rs.getString("CPF"),
                        rs.getString("Nome"),
                        rs.getInt("Carteira"),
                        rs.getString("Password")
                    );
                }
            }
        }
        return acionista;
    }
    
    public ArrayList findIdAllCarteiras() throws SQLException {
        String select = "SELECT Carteira FROM Acionistas";
        ArrayList listaCarteiras = new ArrayList();
        int idCarteira;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    idCarteira = rs.getInt("Carteira");
                    listaCarteiras.add(idCarteira);
                }
                rs.close();
            }
            stmt.close();
        }
        System.out.print(listaCarteiras);
        return listaCarteiras;
    }
}