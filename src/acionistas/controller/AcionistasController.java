package controller.controladorAtivosFinanceiros;
import dao.controladorAtivosFinanceiros.AcionistasDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.controladorAtivosFinanceiros.Acionista;
/**
 *
 * @author vapstor
 */
public class ControladorAtivosFinaceirosController extends AcionistasDAO{
    
    public void addAcionista(Component framePai, String cpf, String nome, String carteira, String password) throws SQLException, ParseException {
        Acionista acionista  = new Acionista();
        acionista.setCPF(cpf);
        acionista.setNome(nome);
        acionista.setCarteira(Integer.parseInt(carteira));
        acionista.setPassword(password);
        
        new AcionistasDAO().salvar(framePai, acionista);
    }
    
    public boolean autenticaUser(String CPF, String Password) throws SQLException, ParseException {
        return new AcionistasDAO().autenticador(CPF, Password);
    }

    public boolean validaCampos(Component pai, String valueCPF, String valueCarteira, String valueNome, String pass) {
        if(valueCPF == null || valueCPF.equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(pai, "O campo CPF não pode ser nulo!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        } else if (valueNome == null || valueNome.equals("")) {
            JOptionPane.showMessageDialog(pai, "O campo Nome não pode ser nulo!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        } else if (valueCarteira == null || valueCarteira.equals("")) {
            JOptionPane.showMessageDialog(pai, "O campo Carteira não pode ser nulo!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        } else if(pass == null || pass.equals("")){
            JOptionPane.showMessageDialog(pai, "O campo Senha não pode ser nulo!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    
}
