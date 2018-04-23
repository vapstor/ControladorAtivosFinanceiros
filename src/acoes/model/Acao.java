/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.model;

/**
 *
 * @author vapstor
 */
public class Acao {
    private String nome; // compra/venda
    private int quantidade;
    private double cotacao;
    private double corretagem;
    private int idCarteira;
    private double custo;
    
    //cotacao = custo/preco
    public Acao(int id, String nome, int quantidade, double cotacao, double corretagem, double custo){
        this.nome = nome;
        this.quantidade = quantidade;
        this.custo = custo;
        this.corretagem = corretagem;
        this.cotacao = cotacao;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarteira() {
        return idCarteira;
    }

    public void setCarteira(int idCarteira) {
        this.idCarteira = idCarteira;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public double getCorretagem() {
        return corretagem;
    }

    public void setCorretagem(double corretagem) {
        this.corretagem = corretagem;
    }

    public int getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(int idCarteira) {
        this.idCarteira = idCarteira;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    
    
}
