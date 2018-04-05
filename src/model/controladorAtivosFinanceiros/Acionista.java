package model.controladorAtivosFinanceiros;

/**
 *
 * @author vapstor
 */
public class Acionista {
    private String CPF;
    private String nome;
    private int carteira;
    
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

    public int getCarteira() {
        return carteira;
    }

    public void setCarteira(int carteira) {
        this.carteira = carteira;
    }
    
}
