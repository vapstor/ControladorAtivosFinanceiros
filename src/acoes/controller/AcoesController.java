/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.controller;

import acionistas.controller.AcionistasController;
import acionistas.dao.AcionistasDAO;
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
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author vapstor
 */
public class AcoesController {
    CarteiraDAO carteiraDao = new CarteiraDAO();
    AcionistasDAO acionistaDao = new AcionistasDAO();
    CotacaoDAO cotacaoDao = new CotacaoDAO();
    Cotacao cotCompra = cotacaoDao.findCotacao("Compra");
    AcaoDAO acaoDAO = new AcaoDAO();
    Acionista acionista;
    Carteira carteira;
    Acao acao;
    
    public AcoesController(Acionista acionista) throws SQLException{
        this.acionista = acionista;
        this.carteira = carteiraDao.findCarteira(this.acionista.getCarteira());
    }
    
    public Carteira getCarteira() throws SQLException {
        return this.carteira;
    }

    public boolean testaLimite(int idCarteira, double valor) throws SQLException {
        double saldo = carteiraDao.findCarteira(idCarteira).getSaldo();
        return valor <= saldo;
    }
    
    public void adicionaDinheiro (int idCarteira, double valor) throws SQLException {
        String add = "Adicionar";
        carteiraDao.alteraDinheiro(idCarteira, valor, add);
        this.carteira.setSaldo(carteiraDao.findCarteira(idCarteira).getSaldo());
    }
    
    public void diminuiDinheiro (int idCarteira, double valor) throws SQLException, Exception {
        String del = "Diminuir";
        if(!testaLimite(idCarteira, valor)) {
            JOptionPane.showMessageDialog(null, "Não é possível realizar a ação!", "Sem Limite", JOptionPane.ERROR_MESSAGE);
        } else {
            carteiraDao.alteraDinheiro(idCarteira, valor, del);
            this.carteira.setSaldo(carteiraDao.findCarteira(idCarteira).getSaldo());
        }
    }
    
    
    public void atualizaCotacaoCompra(Component framePai, String tipo, double custo, double corretagem) throws SQLException {
        cotacaoDao.updateCotacao(framePai, tipo, custo, corretagem, 0.00);
    }
    
    public void addAcaoCompra(int quantidade, double valor, double valorNoCaixa) throws SQLException {
        double precoAcao = valor * quantidade;        
        double precoAcaoCorrigida = precoAcao + getEncargosCompra(precoAcao);
        
        
        if(precoAcaoCorrigida > valorNoCaixa) {
            JOptionPane.showMessageDialog(null, "O investimento é menor que o custo das ações!" 
                    + "\n" 
                    + "\n" 
                    + "Preço total com encargos: " +precoAcaoCorrigida
                    + "\n" 
                    + "Total de Investimentos em Caixa: " +valorNoCaixa,
                    "Investimento Insuficiente", JOptionPane.ERROR_MESSAGE
            );
        } else {
            acaoDAO.addAcao(cotCompra.getNome(), quantidade, precoAcaoCorrigida, this.carteira.getID());
        }
    }
    
    
    private double getEncargosCompra(double precoAcao) {
        CotacaoDAO ctdao = new CotacaoDAO(); 
        Cotacao ct = ctdao.findCotacao("Compra");
        Double encargo = precoAcao * ct.getCorretagem() ;
        return encargo;
    }
    
    private double getEncargosVenda() {
        CotacaoDAO ctdao = new CotacaoDAO(); 
        Cotacao ct = ctdao.findCotacao("Venda");
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
        System.out.println(listaAcoes+" <- Lista Acoes");
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
