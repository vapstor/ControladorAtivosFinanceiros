/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.view;

import acoes.controller.AcoesController;
import acionistas.controller.AcionistasController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import acionistas.model.Acionista;
import acoes.model.Carteira;
import auth.view.TelaLogin;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;

/**
 *
 * @author vapstor
 */
public class Acoes extends javax.swing.JFrame {
    private final AcoesController ac;
    private Acionista acionistaLogado = null;
    private Carteira carteiraAcionistaLogado = null;
    ArrayList<ArrayList<String>> CurrentTableData;
    Icon icon = new ImageIcon("");
   
    /**
     * Creates new form Acoes
     * @param acionista
     */
    public Acoes(Acionista acionista) throws SQLException {
        this.ac = new AcoesController(acionista);
        this.acionistaLogado = acionista;
        this.carteiraAcionistaLogado = ac.getCarteira();
        this.CurrentTableData = ac.getTableData();
        
        initComponents();
        preencheCampos();
        try {
            Image img = ImageIO.read(getClass().getResource("refreshIcon.png"));
            btnRefresh.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
    //atualizar a cada insert ou delete
    public void atualizaTabela() {
        ArrayList<ArrayList<String>> newTableData = null;
        try {
            newTableData = ac.getTableData();
        } catch (SQLException ex) {
            System.out.println("erro:" + ex);
        }
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String header[] = new String[] {"Tipo de Ação", "Quantidade", "Corretagem", "Cotação", "Total(R$)"};
        dtm.setColumnIdentifiers(header);
        tabelaAcoes.setModel(dtm);
        // add row dynamically into the table      
        for (int i = 0; i < newTableData.size(); i++) {
            dtm.addRow(new Object[] { 
                newTableData.get(i).get(0), 
                newTableData.get(i).get(1), 
                newTableData.get(i).get(2), 
                newTableData.get(i).get(3),
                newTableData.get(i).get(4)
            });
        }
        JOptionPane.showMessageDialog(this, "Tabela Atualizada!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
        int x = tabelaAcoes.getSelectedRow();
        System.out.println(x);
        int y = tabelaAcoes.getSelectedColumn();
        System.out.println(y);
    }
    
    public void incrementaSaldo(double valor) throws SQLException {
        ac.adicionaDinheiro(this.acionistaLogado.getCarteira(), valor);
        double novoSaldo = ac.getCarteira().getSaldo();
        atualizaSaldo(novoSaldo);
    }
    
    public void decrementaSaldo(double valor) throws SQLException, Exception {
        ac.diminuiDinheiro(this.acionistaLogado.getCarteira(), valor);
        double novoSaldo = ac.getCarteira().getSaldo();
        atualizaSaldo(novoSaldo);
    }
    
    public void atualizaSaldo (double novoSaldo){
        if(!this.valueSaldo.getText().equals(String.valueOf(novoSaldo))) {
            this.valueSaldo.setText(String.valueOf(novoSaldo));
        JOptionPane.showMessageDialog(this, "Saldo Atualizado!", "Atualização de Saldo", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelTitulo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        subTitulo = new javax.swing.JLabel();
        panelActions = new javax.swing.JPanel();
        excluirContaBtn = new javax.swing.JButton();
        venderAcaoBtn = new javax.swing.JButton();
        adicionaSaldoBtn = new javax.swing.JButton();
        comprarAcaoBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        labelSaldo = new javax.swing.JLabel();
        retiraSaldoBtn = new javax.swing.JButton();
        inputEditSaldo = new javax.swing.JTextField();
        valueSaldo = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        tituloInfo = new javax.swing.JLabel();
        panelLista = new javax.swing.JPanel();
        panelScrolldaLista = new javax.swing.JScrollPane();
        tabelaAcoes = new javax.swing.JTable();
        tituloPanelLista = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton(this.icon);
        valueNome = new javax.swing.JLabel();
        valueCPF = new javax.swing.JLabel();
        valueCarteira = new javax.swing.JLabel();
        labelCarteira = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Controlador de Ativos Financeiros");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        subTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitulo.setText("Menu Inicial");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTituloLayout.createSequentialGroup()
                        .addComponent(subTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        excluirContaBtn.setText("Excluir Conta");
        excluirContaBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirContaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirContaBtnActionPerformed(evt);
            }
        });

        venderAcaoBtn.setText("Vender ações");
        venderAcaoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        venderAcaoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderAcaoBtnActionPerformed(evt);
            }
        });

        adicionaSaldoBtn.setText("Adicionar Saldo");
        adicionaSaldoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adicionaSaldoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaSaldoBtnActionPerformed(evt);
            }
        });

        comprarAcaoBtn.setText("Comprar Ações");
        comprarAcaoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comprarAcaoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarAcaoBtnActionPerformed(evt);
            }
        });

        logOutBtn.setText("Logout");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        labelSaldo.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelSaldo.setText("Saldo:");

        retiraSaldoBtn.setText("Retirar Saldo");
        retiraSaldoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        retiraSaldoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retiraSaldoBtnActionPerformed(evt);
            }
        });

        inputEditSaldo.setFont(new java.awt.Font("Ubuntu Light", 2, 15)); // NOI18N
        inputEditSaldo.setText("Insira o valor...");
        inputEditSaldo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputEditSaldoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputEditSaldoFocusLost(evt);
            }
        });

        valueSaldo.setText("+saldo");

        javax.swing.GroupLayout panelActionsLayout = new javax.swing.GroupLayout(panelActions);
        panelActions.setLayout(panelActionsLayout);
        panelActionsLayout.setHorizontalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputEditSaldo)
                    .addComponent(excluirContaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelActionsLayout.createSequentialGroup()
                        .addComponent(adicionaSaldoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(retiraSaldoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                    .addComponent(venderAcaoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comprarAcaoBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(panelActionsLayout.createSequentialGroup()
                        .addComponent(labelSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelActionsLayout.setVerticalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSaldo)
                    .addComponent(valueSaldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputEditSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionaSaldoBtn)
                    .addComponent(retiraSaldoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comprarAcaoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(venderAcaoBtn)
                .addGap(67, 67, 67)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirContaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tituloInfo.setFont(new java.awt.Font("Ubuntu", 3, 16)); // NOI18N
        tituloInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInfo.setText("Bem Vindo,");

        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String header[] = new String[] {"Tipo de Ação", "Quantidade", "Corretagem", "Cotação", "Total(R$)"};
        dtm.setColumnIdentifiers(header);
        tabelaAcoes.setModel(dtm);
        // add row dynamically into the table
        for (int i = 0; i < CurrentTableData.size(); i++) {
            dtm.addRow(new Object[] {
                this.CurrentTableData.get(i).get(0),
                this.CurrentTableData.get(i).get(1),
                this.CurrentTableData.get(i).get(2),
                this.CurrentTableData.get(i).get(3),
                this.CurrentTableData.get(i).get(4)
            });
        }
        tabelaAcoes.setModel(dtm);
        tabelaAcoes.setColumnSelectionAllowed(true);
        tabelaAcoes.getTableHeader().setReorderingAllowed(false);
        panelScrolldaLista.setViewportView(tabelaAcoes);
        tabelaAcoes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        tituloPanelLista.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        tituloPanelLista.setText("Histórico de transações:");

        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListaLayout = new javax.swing.GroupLayout(panelLista);
        panelLista.setLayout(panelListaLayout);
        panelListaLayout.setHorizontalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListaLayout.createSequentialGroup()
                        .addComponent(tituloPanelLista)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelListaLayout.createSequentialGroup()
                        .addComponent(panelScrolldaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))))
        );
        panelListaLayout.setVerticalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPanelLista)
                .addGap(18, 18, 18)
                .addComponent(panelScrolldaLista, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        valueNome.setText("+nome");

        valueCPF.setText("XXXX");

        valueCarteira.setText("+carteira");

        labelCarteira.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelCarteira.setText("Carteira:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("CPF:");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueNome, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valueCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCarteira)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valueCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addComponent(panelLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloInfo)
                    .addComponent(valueNome)
                    .addComponent(valueCPF)
                    .addComponent(valueCarteira)
                    .addComponent(labelCarteira)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(panelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excluirContaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirContaBtnActionPerformed
        int dialogButton = JOptionPane.showConfirmDialog(this, "Você realmente deseja excluir sua conta?", "Deletar Conta", JOptionPane.YES_NO_OPTION);
        if(dialogButton == JOptionPane.YES_OPTION) {
            AcionistasController caf = new AcionistasController();
            try {
                AcoesController ac = new AcoesController(acionistaLogado);
            } catch (SQLException ex) {
                Logger.getLogger(Acoes.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                caf.excluir(this.acionistaLogado.getCPF());
                ac.deleteAllData();
                this.acionistaLogado = null;
                this.setVisible(false);
                abreTelaLogin();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar" + "\n" + e);
            }
        }
    }//GEN-LAST:event_excluirContaBtnActionPerformed

    private void venderAcaoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderAcaoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_venderAcaoBtnActionPerformed

    private void comprarAcaoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarAcaoBtnActionPerformed
        abreTelaConfiguraCotacao();
    }//GEN-LAST:event_comprarAcaoBtnActionPerformed

    private void adicionaSaldoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaSaldoBtnActionPerformed
        try {
            incrementaSaldo(Double.parseDouble(this.inputEditSaldo.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Acoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adicionaSaldoBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        int dialogButton = JOptionPane.showConfirmDialog(this, "Você realmente deseja se desconectar?", "Logout", JOptionPane.YES_NO_OPTION);
        if(dialogButton == JOptionPane.YES_OPTION) {
            this.acionistaLogado = null;
            this.setVisible(false);
            abreTelaLogin();
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void retiraSaldoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retiraSaldoBtnActionPerformed
         try {
            decrementaSaldo(Double.parseDouble(this.inputEditSaldo.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Acoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Acoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_retiraSaldoBtnActionPerformed

    private void inputEditSaldoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputEditSaldoFocusGained
        if(inputEditSaldo.getText().equals("Insira o valor...")){
            inputEditSaldo.setText("");
        }
    }//GEN-LAST:event_inputEditSaldoFocusGained

    private void inputEditSaldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputEditSaldoFocusLost
        if(inputEditSaldo.getText().equals("")){
            inputEditSaldo.setText("Insira o valor...");
        }
    }//GEN-LAST:event_inputEditSaldoFocusLost
    
    private void preencheCampos() {
        this.valueNome.setText(this.acionistaLogado.getNome()); 
        this.valueCPF.setText(this.acionistaLogado.getCPF());
//        this.valueSaldo.maxLength(5);
        valueCarteira.setText(String.valueOf(this.carteiraAcionistaLogado.getID()));
        valueSaldo.setText(String.valueOf(this.carteiraAcionistaLogado.getSaldo()));
    }
    
    private void abreTelaLogin() {
        TelaLogin tl = new TelaLogin();
        tl.setVisible(true);
    }
    
    private void abreTelaConfiguraCotacao() {
        String operacao = "ComprarAcoes";
        this.setVisible(false);
        TelaCalcularCarteira tcc = new TelaCalcularCarteira(operacao, this.acionistaLogado, this.carteiraAcionistaLogado);
        tcc.setVisible(true);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionaSaldoBtn;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton comprarAcaoBtn;
    private javax.swing.JButton excluirContaBtn;
    private javax.swing.JTextField inputEditSaldo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCarteira;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JPanel panelActions;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelLista;
    private javax.swing.JScrollPane panelScrolldaLista;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JButton retiraSaldoBtn;
    private javax.swing.JLabel subTitulo;
    private javax.swing.JTable tabelaAcoes;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloInfo;
    private javax.swing.JLabel tituloPanelLista;
    private javax.swing.JLabel valueCPF;
    private javax.swing.JLabel valueCarteira;
    private javax.swing.JLabel valueNome;
    private javax.swing.JLabel valueSaldo;
    private javax.swing.JButton venderAcaoBtn;
    // End of variables declaration//GEN-END:variables

     
}
