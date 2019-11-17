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
public class reportesWindow extends javax.swing.JFrame {

    /**
     * Creates new form reportesWindow
     */
    public reportesWindow() {
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

        btnRegresar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnReportArchivos = new javax.swing.JButton();
        btnReportLista = new javax.swing.JButton();
        btnReportGrafo = new javax.swing.JButton();
        btnReportMatriz = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(56, 150, 201));
        btnRegresar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 170, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cloudEDDRed.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 150, 70));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N

        btnReportArchivos.setBackground(new java.awt.Color(56, 150, 201));
        btnReportArchivos.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnReportArchivos.setForeground(new java.awt.Color(255, 255, 255));
        btnReportArchivos.setText("Reporte de Archivos");
        btnReportArchivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportArchivosActionPerformed(evt);
            }
        });

        btnReportLista.setBackground(new java.awt.Color(56, 150, 201));
        btnReportLista.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnReportLista.setForeground(new java.awt.Color(255, 255, 255));
        btnReportLista.setText("Reporte de Lista de Carpetas");
        btnReportLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportListaActionPerformed(evt);
            }
        });

        btnReportGrafo.setBackground(new java.awt.Color(56, 150, 201));
        btnReportGrafo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnReportGrafo.setForeground(new java.awt.Color(255, 255, 255));
        btnReportGrafo.setText("Reporte de Grafo de Carpetas");
        btnReportGrafo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportGrafoActionPerformed(evt);
            }
        });

        btnReportMatriz.setBackground(new java.awt.Color(56, 150, 201));
        btnReportMatriz.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnReportMatriz.setForeground(new java.awt.Color(255, 255, 255));
        btnReportMatriz.setText("Reporte de Matriz de Carpetas");
        btnReportMatriz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportMatrizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReportLista, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnReportArchivos)
                .addGap(18, 18, 18)
                .addComponent(btnReportLista)
                .addGap(18, 18, 18)
                .addComponent(btnReportMatriz)
                .addGap(18, 18, 18)
                .addComponent(btnReportGrafo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 290, 230));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 210, 290));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white.jpg"))); // NOI18N
        getContentPane().add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportArchivosActionPerformed
        try {
            SoftwareEDDDriver.usuarios.avlArchivo(SoftwareEDDDriver.folderLog, SoftwareEDDDriver.userLog);
        } catch (IOException ex) {
            Logger.getLogger(reportesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnReportArchivosActionPerformed

    private void btnReportListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportListaActionPerformed
        try {
            SoftwareEDDDriver.usuarios.listaCarpetas(SoftwareEDDDriver.userLog);
        } catch (IOException ex) {
            Logger.getLogger(reportesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportListaActionPerformed

    private void btnReportGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportGrafoActionPerformed
        try {
            SoftwareEDDDriver.usuarios.grafoCarpetas(SoftwareEDDDriver.userLog);
        } catch (IOException ex) {
            Logger.getLogger(reportesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportGrafoActionPerformed

    private void btnReportMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportMatrizActionPerformed
        try {
            SoftwareEDDDriver.usuarios.matrizCarpetas(SoftwareEDDDriver.userLog);
        } catch (IOException ex) {
            Logger.getLogger(reportesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportMatrizActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        cambiarVentana();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cambiarVentana() {
        initialWindow inicial = new initialWindow();

        //Verificar el tipo de usuario que ingreso
        if (SoftwareEDDDriver.userLog.equals("ADMIN")) {
            inicial.btnAdministrador.setVisible(true);
        } else {
            inicial.btnAdministrador.setVisible(false);
        }

        //Mostrar el JFrame de la ventana inicial
        SoftwareEDDDriver.usuarios.mostrarContenido(SoftwareEDDDriver.userLog, SoftwareEDDDriver.folderLog, inicial.panelVisual);
        inicial.setVisible(true);
        inicial.lblUser.setText(SoftwareEDDDriver.userLog);
        this.setVisible(false);
    }

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
            java.util.logging.Logger.getLogger(reportesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reportesWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegresar;
    public javax.swing.JButton btnReportArchivos;
    public javax.swing.JButton btnReportGrafo;
    public javax.swing.JButton btnReportLista;
    public javax.swing.JButton btnReportMatriz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
