/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.view;

import acionistas.model.Acionista;
import acoes.controller.AcoesController;
import acoes.model.Acao;
import acoes.model.Cotacao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.View;

/**
 *
 * @author vapstor
 */
public class VenderAcoes extends javax.swing.JFrame {
    
    private Acao[] acoesParaVender;
    private int[] quantidadesParaVenda;
    private AcoesController ac;
    private JSpinner[] spinners;
    private JLabel[] labels;
    private int[] selectedRows;
    private Acionista acionistaLogado;

    public VenderAcoes(int[] selectedRows, AcoesController controller, Acionista acionistaLogado) throws SQLException {
        this.ac = controller;
        this.acoesParaVender = recuperaAcoes(selectedRows);
        this.selectedRows = selectedRows;
        initComponents();
        this.spinners = new JSpinner[4];
        this.acionistaLogado = acionistaLogado;
        this.labels = new JLabel[4];
        preencheCampos(acoesParaVender);
        
//        System.out.println("VISIBILIDADE" + "\n" + spinnerAcao3.isVisible() + "\n");
    }
    
    private void preencheCampos(Acao[] acoesParaVender) {
        this.labels = new JLabel[4];
        
        
        this.labels[0] = this.labelPetrobras;
        this.labels[1] = this.labelFort;
        this.labels[2] = this.labelSpotify;
        this.labels[3] = this.labelGoogle;
        
        for (int i = 0; i < acoesParaVender.length; i++) {
            this.labels[i].setText(acoesParaVender[i].getNome());
            SpinnerNumberModel sm = new SpinnerNumberModel(0, 0, (double) (acoesParaVender[i].getQuantidade()), 1);
            switch(i) {
                case 0: spinnerAcao1.setModel(sm);
                        spinnerAcao1.setVisible(true);
                    break;
                case 1: spinnerAcao2.setModel(sm);
                        spinnerAcao2.setVisible(true);
                    break;
                case 2: spinnerAcao3.setModel(sm);
                        spinnerAcao3.setVisible(true);
                    break;
                case 3: spinnerAcao4.setModel(sm);
                        spinnerAcao4.setVisible(true);
                    break;
                default:
                    break;
            }
        }
        
        
        
    }
    
    public final Acao[] recuperaAcoes(int[] selectedRows) throws SQLException {
        Acao[] acoesToSell;
        acoesToSell = new Acao[selectedRows.length];
        int id;
        Acao acao;
        for (int i = 0; i < selectedRows.length; i++) {   
            id = ac.rowIndexToAcaoId(selectedRows[i]);
            acao = ac.getAcao(id);
            acoesToSell[i] = acao;
        }
        return acoesToSell;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        labelPetrobras = new javax.swing.JLabel();
        spinnerAcao1 = new javax.swing.JSpinner();
        labelFort = new javax.swing.JLabel();
        spinnerAcao2 = new javax.swing.JSpinner();
        labelSpotify = new javax.swing.JLabel();
        spinnerAcao3 = new javax.swing.JSpinner();
        venderAcaoBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        labelGoogle = new javax.swing.JLabel();
        spinnerAcao4 = new javax.swing.JSpinner();
        labelImposto = new javax.swing.JLabel();
        inputImposto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        labelCorretagem = new javax.swing.JLabel();
        inputCorretagem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Vender Ações");

        labelPetrobras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        spinnerAcao1.setVisible(false);

        labelFort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        spinnerAcao2.setVisible(false);

        labelSpotify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        spinnerAcao3.setVisible(false);

        venderAcaoBtn.setText("Vender Ações");
        venderAcaoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderAcaoBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        labelGoogle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        spinnerAcao4.setVisible(false);

        labelImposto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImposto.setText("Imposto:");

        inputImposto.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        inputImposto.setText("Digite aqui...");
        inputImposto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputImpostoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputImpostoFocusLost(evt);
            }
        });

        jButton1.setText("Lucro/Prejuízo não realizado");

        labelCorretagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCorretagem.setText("Corretagem");

        inputCorretagem.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        inputCorretagem.setText("Digite aqui...");
        inputCorretagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputCorretagemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputCorretagemFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(venderAcaoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCorretagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPetrobras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelFort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelImposto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelGoogle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSpotify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(spinnerAcao4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(spinnerAcao3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(spinnerAcao2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(spinnerAcao1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(inputImposto, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                            .addComponent(inputCorretagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titulo)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPetrobras)
                    .addComponent(spinnerAcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFort)
                    .addComponent(spinnerAcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSpotify)
                    .addComponent(spinnerAcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGoogle)
                    .addComponent(spinnerAcao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelImposto)
                    .addComponent(inputImposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorretagem)
                    .addComponent(inputCorretagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venderAcaoBtn)
                    .addComponent(cancelBtn))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputImpostoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputImpostoFocusGained
        if(inputImposto.getText().equals("Digite aqui...")) {
            inputImposto.setText("");
        }
    }//GEN-LAST:event_inputImpostoFocusGained

    private void inputImpostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputImpostoFocusLost
        if(inputImposto.getText().equals("")) {
            inputImposto.setText("Digite aqui...");
        }
    }//GEN-LAST:event_inputImpostoFocusLost

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
        try {
            abreTelaAcoes();
        } catch (SQLException ex) {
            Logger.getLogger(VenderAcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void venderAcaoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderAcaoBtnActionPerformed
        //vetor com a mesma quantidade de ações
        quantidadesParaVenda = new int[acoesParaVender.length];
        double imposto = Double.parseDouble(this.inputImposto.getText());
        double corretagem = Double.parseDouble(this.inputCorretagem.getText());
        for (int i = 0; i < quantidadesParaVenda.length; i++) {
            switch(i) {
                case 0: 
                    quantidadesParaVenda[0] = (int)((double) spinnerAcao1.getValue());
                    break;
                case 1: 
                    quantidadesParaVenda[1] = (int)((double) spinnerAcao2.getValue());
                    break;
                case 2: 
                    quantidadesParaVenda[2] = (int)((double) spinnerAcao2.getValue());
                    break;
                case 3:
                    quantidadesParaVenda[3] = (int)((double) spinnerAcao3.getValue());
                    break;
                default:
                    break;
            }
        }
//        System.out.println("ARRAY DE QUANTIDADES PARA VENDA"+ String.valueOf(quantidadesParaVenda[0]));
        
        
        try {
            String operacao = "Venda";
            for (int i = 0; i < acoesParaVender.length; i++) {
                
                double custo = Double.parseDouble(String.valueOf(this.acoesParaVender[i].getCusto()));
                int qntd = Integer.parseInt(String.valueOf(quantidadesParaVenda[i]));
                int idAcao = Integer.parseInt(String.valueOf(this.acoesParaVender[i].getId()));
                
                ac.atualizaCotacaoVenda(this,
                    operacao,
                    custo,
                    Double.parseDouble(String.valueOf(this.inputCorretagem.getText())),
                    Double.parseDouble(String.valueOf(this.inputImposto.getText()))
                );
                
                ac.vendeAcoes(custo, qntd, idAcao);
            }
            this.acoesParaVender = null;
            this.quantidadesParaVenda = null;
            this.setVisible(false);
            abreTelaAcoes();
        } catch (SQLException ex) {
            Logger.getLogger(VenderAcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_venderAcaoBtnActionPerformed

    private void inputCorretagemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputCorretagemFocusGained
        if(inputCorretagem.getText().equals("Digite aqui...")) {
            inputCorretagem.setText("");
        }        
    }//GEN-LAST:event_inputCorretagemFocusGained

    private void inputCorretagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputCorretagemFocusLost
        if(inputCorretagem.getText().equals("")) {
            inputCorretagem.setText("Digite aqui...");
        }
    }//GEN-LAST:event_inputCorretagemFocusLost

   

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField inputCorretagem;
    private javax.swing.JTextField inputImposto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelCorretagem;
    private javax.swing.JLabel labelFort;
    private javax.swing.JLabel labelGoogle;
    private javax.swing.JLabel labelImposto;
    private javax.swing.JLabel labelPetrobras;
    private javax.swing.JLabel labelSpotify;
    private javax.swing.JSpinner spinnerAcao1;
    private javax.swing.JSpinner spinnerAcao2;
    private javax.swing.JSpinner spinnerAcao3;
    private javax.swing.JSpinner spinnerAcao4;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton venderAcaoBtn;
    // End of variables declaration//GEN-END:variables

    private void abreTelaAcoes() throws SQLException {
        this.setVisible(false);
        Acoes a = new Acoes(acionistaLogado);
        a.setVisible(true);
        a.atualizaTabela();
    }

}
