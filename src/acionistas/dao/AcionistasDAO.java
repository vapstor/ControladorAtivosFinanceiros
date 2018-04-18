package dao.controladorAtivosFinanceiros;

import java.awt.Component;
import model.controladorAtivosFinanceiros.Acionista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
        delete(delete, CPF);
    }
    
    public Acionista findByCPF(String CPF) throws SQLException {
        String select = "SELECT * FROM Acionistas WHERE CPF = ?";
        Acionista acionista = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, CPF);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    acionista = new Acionista();
                    acionista.setCPF(rs.getString("CPF"));
                    acionista.setNome(rs.getString("Nome"));
                    acionista.setCarteira(rs.getInt("Carteira"));
                    acionista.setPassword(rs.getString("Password"));
                }
            }
        }
        return acionista;
    }
    
    public boolean autenticador(String CPF, String Password) throws SQLException {
        String select = "SELECT Password FROM Acionistas WHERE CPF = ?";
        String passBD = null;
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
        }
        return false;
    }
}
//    public List findEstacionamentoConfigs() throws SQLException {
//        List estacionamentos = new ArrayList();
//
//        String select = "SELECT * FROM estacionamento";
//
//        PreparedStatement stmt = 
//			getConnection().prepareStatement(select);
//			
//        ResultSet rs = stmt.executeQuery();
//
//        while (rs.next()) {
//            Estacionamento estacionamento = new Estacionamento();
//            estacionamento.setId(rs.getInt("id"));
//            estacionamento.setTolerancia(rs.getInt("tolerancia"));
//            estacionamento.setValorMinimo(rs.getDouble("valorMinimo"));
//            estacionamento.setPeriodoDeTarifacao(rs.getInt("periodoDeTarifacao"));
//            estacionamento.setValorPorPeriodo(rs.getDouble("valorPorPeriodo"));
//            estacionamento.setCaixa(rs.getDouble("caixa"));
//            
//            estacionamentos.add(estacionamento);
//        }
//
//        rs.close();
//        stmt.close();
//
//        return estacionamentos;
//    }