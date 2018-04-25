/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.view;

import acionistas.model.Acionista;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vapstor
 */
public class VenderAcoes extends javax.swing.JFrame {

    public VenderAcoes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        labelAcao1 = new javax.swing.JLabel();
        spinnerAcao1 = new javax.swing.JSpinner();
        labelAcao2 = new javax.swing.JLabel();
        spinnerAcao2 = new javax.swing.JSpinner();
        labelAcao3 = new javax.swing.JLabel();
        spinnerAcao3 = new javax.swing.JSpinner();
        venderAcaoBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        labelAcao4 = new javax.swing.JLabel();
        spinnerAcao4 = new javax.swing.JSpinner();
        labelImposto = new javax.swing.JLabel();
        inputImposto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Vender Ações");

        labelAcao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAcao1.setText("Acao01");

        labelAcao2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAcao2.setText("Acao02");

        labelAcao3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAcao3.setText("Acao03");

        venderAcaoBtn.setText("Vender Ações");

        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        labelAcao4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAcao4.setText("Acao04");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(venderAcaoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAcao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAcao2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelImposto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAcao4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAcao3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerAcao4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerAcao3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerAcao2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerAcao1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputImposto, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titulo)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAcao1)
                    .addComponent(spinnerAcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAcao2)
                    .addComponent(spinnerAcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAcao3)
                    .addComponent(spinnerAcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAcao4)
                    .addComponent(spinnerAcao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelImposto)
                    .addComponent(inputImposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 25, Short.MAX_VALUE)
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
    }//GEN-LAST:event_cancelBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField inputImposto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelAcao1;
    private javax.swing.JLabel labelAcao2;
    private javax.swing.JLabel labelAcao3;
    private javax.swing.JLabel labelAcao4;
    private javax.swing.JLabel labelImposto;
    private javax.swing.JSpinner spinnerAcao1;
    private javax.swing.JSpinner spinnerAcao2;
    private javax.swing.JSpinner spinnerAcao3;
    private javax.swing.JSpinner spinnerAcao4;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton venderAcaoBtn;
    // End of variables declaration//GEN-END:variables
}
