package controller.controladorAtivosFinanceiros;
import dao.controladorAtivosFinanceiros.AcionistasDAO;
import java.sql.SQLException;
import java.text.ParseException;
import model.controladorAtivosFinanceiros.Acionista;
/**
 *
 * @author vapstor
 */
public class ControladorAtivosFinaceirosController {
    
    public void addAcionista(String cpf, String nome, int carteira) throws SQLException, ParseException {
        Acionista user  = new Acionista();
        user.setCPF(cpf);
        user.setNome(nome);
        user.setCarteira(carteira);
        
        new AcionistasDAO().salvar(user);
    }
    
}
