/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controladorAtivosFinanceiros;

/**
 *
 * @author Matheus
 */
public class TelaInicialLogado extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicialLogado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        subTitulo = new javax.swing.JLabel();
        panelActions = new javax.swing.JPanel();
        comprarAcaoBtn = new javax.swing.JButton();
        venderAcaoBtn = new javax.swing.JButton();
        valorCarteiraBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        comprarAcaoBtn1 = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        tituloInfo = new javax.swing.JLabel();
        valueCPF = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        valueCarteira = new javax.swing.JLabel();
        labelCarteira = new javax.swing.JLabel();
        labelSaldo = new javax.swing.JLabel();
        valueSaldo = new javax.swing.JLabel();
        nomeAcionista = new javax.swing.JLabel();

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

        comprarAcaoBtn.setText("Alterar Senha");
        comprarAcaoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comprarAcaoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarAcaoBtnActionPerformed(evt);
            }
        });

        venderAcaoBtn.setText("Vender ações");
        venderAcaoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        venderAcaoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderAcaoBtnActionPerformed(evt);
            }
        });

        valorCarteiraBtn.setText("Valor da Carteira");
        valorCarteiraBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        valorCarteiraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorCarteiraBtnActionPerformed(evt);
            }
        });

        logOutBtn.setText("Logout");

        comprarAcaoBtn1.setText("Comprar Ações");
        comprarAcaoBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comprarAcaoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarAcaoBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelActionsLayout = new javax.swing.GroupLayout(panelActions);
        panelActions.setLayout(panelActionsLayout);
        panelActionsLayout.setHorizontalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorCarteiraBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(comprarAcaoBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(venderAcaoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comprarAcaoBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelActionsLayout.setVerticalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActionsLayout.createSequentialGroup()
                .addComponent(comprarAcaoBtn1)
                .addGap(18, 18, 18)
                .addComponent(valorCarteiraBtn)
                .addGap(18, 18, 18)
                .addComponent(venderAcaoBtn)
                .addGap(18, 18, 18)
                .addComponent(comprarAcaoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(logOutBtn))
        );

        tituloInfo.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        tituloInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInfo.setText("Seja Bem Vindo");

        valueCPF.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        valueCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueCPF.setText("xxx.xxx.xxx-xx");

        labelCPF.setText("CPF:");

        valueCarteira.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        valueCarteira.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueCarteira.setText("+nCarteira");

        labelCarteira.setText("Carteira");

        labelSaldo.setText("Saldo:");

        valueSaldo.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        valueSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueSaldo.setText("+valorSaldo");

        nomeAcionista.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        nomeAcionista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeAcionista.setText("+nome");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeAcionista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCarteira)
                                    .addComponent(labelSaldo)
                                    .addComponent(labelCPF))
                                .addGap(18, 18, 18)
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valueSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valueCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(valueCarteira, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addComponent(tituloInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomeAcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPF)
                    .addComponent(valueCPF))
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCarteira)
                    .addComponent(valueCarteira))
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSaldo)
                    .addComponent(valueSaldo))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprarAcaoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarAcaoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprarAcaoBtnActionPerformed

    private void venderAcaoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderAcaoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_venderAcaoBtnActionPerformed

    private void comprarAcaoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarAcaoBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprarAcaoBtn1ActionPerformed

    private void valorCarteiraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorCarteiraBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorCarteiraBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicialLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialLogado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comprarAcaoBtn;
    private javax.swing.JButton comprarAcaoBtn1;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelCarteira;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel nomeAcionista;
    private javax.swing.JPanel panelActions;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel subTitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloInfo;
    private javax.swing.JButton valorCarteiraBtn;
    private javax.swing.JLabel valueCPF;
    private javax.swing.JLabel valueCarteira;
    private javax.swing.JLabel valueSaldo;
    private javax.swing.JButton venderAcaoBtn;
    // End of variables declaration//GEN-END:variables
}
