/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.controller;

import acoes.dao.AcaoDAO;
import acoes.dao.CarteiraDAO;
import acoes.dao.CotacaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import acoes.model.Acao;
import acionistas.model.Acionista;
import acoes.model.Carteira;
import acoes.model.Cotacao;
import javax.swing.JOptionPane;

/**
 *
 * @author vapstor
 */
public class AcoesController {
    CarteiraDAO carteiraDao = new CarteiraDAO();
    AcaoDAO acaoDAO = new AcaoDAO();
    Acionista acionista;
    Carteira carteira;
    Acao acao;
    
    public AcoesController(Acionista acionista) throws SQLException{
        this.acionista = acionista;
        this.carteira = carteiraDao.findCarteira(acionista.getCarteira());
    }
    
    public Carteira getCarteira() throws SQLException {
        return this.carteira;
    }

    public boolean testaLimite(double valor) {
        System.out.println("testa limite get saldo" + this.carteira.getSaldo());
        double saldo = this.carteira.getSaldo();
        return valor < saldo;
    }
    
    public void compraAcao(int idCarteira, double custo, int corretagem, int quantidade) throws SQLException {
//        
////        double precoAcao = custo * quantidade;
////        double acaoCorrigida = carteiraDao.corrigeAcao(precoAcao, corretagem);;
//        //a = a-b; a-=b
//        custo -= custo * getEncargosCompra();
//        double retornoDinheiro = carteiraDao.alteraDinheiro(idCarteira, custo);
//        System.out.println(retornoDinheiro); //Conferir se retorno está correto
    }
    //TODO Carteira Controller
    public double adicionaDinheiro (int idCarteira, double valor) throws SQLException {
        String add = "Adicionar";
        double novoSaldo = carteiraDao.alteraDinheiro(idCarteira, valor, add);
        return novoSaldo;
    }
    
     //TODO Carteira Controller
    public double diminuiDinheiro (int idCarteira, double valor) throws SQLException, Exception {
        String del = "Dimiuir";
        if(!testaLimite(valor)) {
            System.out.println("Sem Limite");
            JOptionPane.showMessageDialog(null, "Não é possível realizar a ação!", "Sem Limite", JOptionPane.ERROR_MESSAGE);
        } else {
            return carteiraDao.alteraDinheiro(idCarteira, valor, del);
        }
        return this.carteira.getSaldo();
    }
    
    private double getEncargosCompra() {
        CotacaoDAO ctdao = new CotacaoDAO(); 
        Cotacao ct = ctdao.findCotacao("compra");
        Double encargo = ct.getImposto() + ct.getCorretagem();
        return encargo;
    }
    
    private double getEncargosVenda() {
        CotacaoDAO ctdao = new CotacaoDAO(); 
        Cotacao ct = ctdao.findCotacao("venda");
        Double encargo = ct.getImposto() + ct.getCorretagem();
        return encargo;
    }
    
    public List getAcoes() throws SQLException {
       return acaoDAO.findAcoes();
    }
    
    public Acao getAcao(int index) throws SQLException {
       return acaoDAO.findAcao(index); 
    }
    
    public ArrayList<ArrayList<String>> getTableData() throws SQLException{
        
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        List listaAcoes = getAcoes();
        
        for(int i = 0; i < listaAcoes.size(); i++ ) {
            acao = (Acao) listaAcoes.get(i);
            ArrayList<String> row = new ArrayList();
            row.add(acao.getNome()); 
            row.add(String.valueOf(acao.getQuantidade())); 
            row.add(String.valueOf(acao.getCotacao())); 
            row.add(String.valueOf(acao.getCotacao()*acao.getQuantidade())); 
            data.add(row);
        }
        return data;
    }
    
    
}
