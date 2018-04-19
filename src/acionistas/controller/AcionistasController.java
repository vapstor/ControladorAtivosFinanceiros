package acionistas.controller;
import acionistas.dao.AcionistasDAO;
import auth.controller.AuthController;
import acoes.dao.CarteiraDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import acionistas.model.Acionista;
import acoes.model.Carteira;
/**
 *
 * @author vapstor
 */
public class AcionistasController extends AcionistasDAO {
    
    public void addCarteira(Component framePai, int idCarteira) throws SQLException, ParseException {
        Carteira novaCarteira = new Carteira(idCarteira, 0.00);
        new CarteiraDAO().salvaCarteira(framePai, novaCarteira);
    }
    
    public void addAcionista(Component framePai, String cpf, String nome, int idCarteira, String password) throws SQLException, ParseException {
        Acionista novoAcionista  = new Acionista(cpf, nome, idCarteira, password);
        new AcionistasDAO().salvar(framePai, novoAcionista);
    }
    
    public Acionista findAcionista(String CPF) throws SQLException {
        return new AcionistasDAO().findByCPF(CPF);
    } 
    
    public boolean autenticaUser(String CPF, String Password) throws SQLException, ParseException {
        return new AuthController().autenticador(CPF, Password);
    }

    public boolean validaCampos(Component pai, String valueCPF, String valueNome, int valueCarteira, String pass) {
        if(valueCPF == null || valueCPF.equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(pai, "O campo CPF não pode ser nulo!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        } else if (valueNome == null || valueNome.equals("")) {
            JOptionPane.showMessageDialog(pai, "O campo Nome não pode ser nulo!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        } else if (valueCarteira == 0) {
            JOptionPane.showMessageDialog(pai, "O campo Carteira não pode ser nulo ou 0!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        } else if(pass == null || pass.equals("")){
            JOptionPane.showMessageDialog(pai, "O campo Senha não pode ser nulo!", "Erro!", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        return true;
    }
}
