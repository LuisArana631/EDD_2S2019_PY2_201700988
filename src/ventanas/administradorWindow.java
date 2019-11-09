/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import software.edd.driver.SoftwareEDDDriver;

/**
 *
 * @author Luis Fer
 */
public class administradorWindow extends javax.swing.JFrame {

    /**
     * Creates new form administradorWindow
     */
    public administradorWindow() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        btnRegresar3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCargaUsuarios = new javax.swing.JButton();
        btnReporteUsuarios = new javax.swing.JButton();
        btnReporteBitacora = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cloudEDDRed.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 150, 70));

        btnRegresar3.setBackground(new java.awt.Color(56, 150, 201));
        btnRegresar3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnRegresar3.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar3.setText("Regresar");
        btnRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 170, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N

        btnCargaUsuarios.setBackground(new java.awt.Color(56, 150, 201));
        btnCargaUsuarios.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnCargaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnCargaUsuarios.setText("Carga Masiva de Usuarios");
        btnCargaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaUsuariosActionPerformed(evt);
            }
        });

        btnReporteUsuarios.setBackground(new java.awt.Color(56, 150, 201));
        btnReporteUsuarios.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnReporteUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteUsuarios.setText("Reporte de Usuarios");
        btnReporteUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteUsuariosActionPerformed(evt);
            }
        });

        btnReporteBitacora.setBackground(new java.awt.Color(56, 150, 201));
        btnReporteBitacora.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnReporteBitacora.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteBitacora.setText("Reporte de Bitácora");
        btnReporteBitacora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteBitacoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReporteUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnCargaUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btnReporteUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btnReporteBitacora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 290, 190));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 210, 260));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white.jpg"))); // NOI18N
        getContentPane().add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaUsuariosActionPerformed
        
    }//GEN-LAST:event_btnCargaUsuariosActionPerformed

    private void btnRegresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar3ActionPerformed
        initialWindow initial = new initialWindow();
        initial.lblUser.setText(SoftwareEDDDriver.userLog);
        initial.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar3ActionPerformed

    private void btnReporteUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteUsuariosActionPerformed
        try {
            SoftwareEDDDriver.usuarios.graficar();
        } catch (IOException ex) {
            Logger.getLogger(administradorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteUsuariosActionPerformed

    private void btnReporteBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteBitacoraActionPerformed
        try {
            SoftwareEDDDriver.bitacora.graficar();
        } catch (IOException ex) {
            Logger.getLogger(administradorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteBitacoraActionPerformed

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
            java.util.logging.Logger.getLogger(administradorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(administradorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(administradorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(administradorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new administradorWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCargaUsuarios;
    public javax.swing.JButton btnRegresar3;
    public javax.swing.JButton btnReporteBitacora;
    public javax.swing.JButton btnReporteUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}