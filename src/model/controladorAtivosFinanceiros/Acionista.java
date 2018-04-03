package model.controladorAtivosFinanceiros;

/**
 *
 * @author vapstor
 */
public class Acionista extends Carteira {
    private String CPF;
    private String nome = "Nome Teste";
    private Carteira carteira;
    
    public String getCPF() {
        return this.CPF;
    }
    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
    
}
