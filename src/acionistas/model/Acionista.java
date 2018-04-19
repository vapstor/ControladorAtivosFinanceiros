package acionistas.model;

/**
 *
 * @author vapstor
 */
public class Acionista {
    private String CPF, nome, password;
    private int carteira;

    public Acionista(String CPF, String nome, int carteira, String password) {
        this.CPF = CPF;
        this.nome = nome;
        this.carteira = carteira;
        this.password = password;
    }    
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
