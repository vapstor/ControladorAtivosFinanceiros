package controller.controladorAtivosFinanceiros;
import dao.controladorAtivosFinanceiros.AcionistasDAO;
import java.sql.SQLException;
import java.text.ParseException;
import model.controladorAtivosFinanceiros.Acionista;
import model.controladorAtivosFinanceiros.User;
/**
 *
 * @author vapstor
 */
public class ControladorAtivosFinaceirosController {
    
    public void addUser(String cpf, char[] Password) throws SQLException, ParseException {
        User user  = new User();
        user.setCPF(cpf);
        user.setPassword(Password);
        
        new AcionistasDAO().salvarUser(user);
    }
    
    public void addAcionista(String cpf, String nome, int carteira) throws SQLException, ParseException {
        Acionista user  = new Acionista();
        user.setCPF(cpf);
        user.setNome(nome);
        user.setCarteira(carteira);
        
        new AcionistasDAO().salvar(user);
    }
    
}
