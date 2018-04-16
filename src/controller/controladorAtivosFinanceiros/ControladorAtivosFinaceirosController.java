package controller.controladorAtivosFinanceiros;
import dao.controladorAtivosFinanceiros.AcionistasDAO;
import java.sql.SQLException;
import java.text.ParseException;
import model.controladorAtivosFinanceiros.Acionista;
/**
 *
 * @author vapstor
 */
public class ControladorAtivosFinaceirosController extends AcionistasDAO{
    
    public void addAcionista(String cpf, String nome, int carteira, String password) throws SQLException, ParseException {
        Acionista acionista  = new Acionista();
        acionista.setCPF(cpf);
        acionista.setNome(nome);
        acionista.setCarteira(carteira);
        acionista.setPassword(password);
        
        new AcionistasDAO().salvar(acionista);
    }
    
    public boolean autenticaUser(String CPF, String Password) throws SQLException, ParseException {
        return new AcionistasDAO().autenticador(CPF, Password);
    }
    
}
