package dao.controladorAtivosFinanceiros;

import model.controladorAtivosFinanceiros.Acionista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vapstor
 */
public class AcionistasDAO extends GenericDAO {
    public void salvar(Acionista acionista) throws SQLException {
        String insert = "INSERT INTO acoes_db.Acionistas ("
                + "CPF, Nome, Carteira)"
                + "values (?,?,?)";
        save(
                insert, acionista.getCPF(), acionista.getNome(), 
                acionista.getCarteira()
        );
        JOptionPane.showMessageDialog(null, "Usuário Inserido com sucesso na base de dados!", "Usuário Adicionado", JOptionPane.INFORMATION_MESSAGE);
    }
    

     public void alterar(Acionista acionista) throws SQLException {
        String update = "UPDATE acionista " +
                        "SET CPF = ?, nome = ?, Carteira = ?, ";
        update(update, acionista.getCPF(), acionista.getNome(), 
                acionista.getCarteira()
        );
    }

     
    public void excluir(String CPF) throws SQLException {
        String delete = "DELETE FROM acoes_db.Acionistas WHERE CPF = ?";
        delete(delete, CPF);
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
    
    public Acionista findByCPF(String CPF) throws SQLException {
        String select = "SELECT * FROM acionistas WHERE CPF = ?";
        Acionista acionista = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
//            String cpf = JOptionPane.showInputDialog(null, "Digite o CPF que deseja Buscar: ");
            stmt.setString(1, CPF);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    acionista = new Acionista();
                    acionista.setCPF(rs.getString("CPF"));
                    acionista.setNome(rs.getString("Nome"));
//                    acionista.setCarteira(rs.getDouble(acionista.getCarteira()"valorMinimo"));
                }
            }
        }
        return acionista;
    }
}
