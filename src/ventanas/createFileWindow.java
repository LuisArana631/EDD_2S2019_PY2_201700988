/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import com.placeholder.PlaceHolder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import software.edd.driver.SoftwareEDDDriver;

/**
 *
 * @author Luis Fer
 */
public class createFileWindow extends javax.swing.JFrame {

    PlaceHolder holder;

    public createFileWindow() {
        initComponents();
        
        this.setLocationRelativeTo(null);

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        lblTimeStamp.setText(hourdateFormat.format(date));
    }

    public void place_holders() {
        holder = new PlaceHolder(txtNombre, "Nombre del archivo");
        holder = new PlaceHolder(txtContenido, "Contenido del archivo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTimeStamp = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblFondo1 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTimeStamp.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        getContentPane().add(lblTimeStamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 110, 20));

        lblError.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 20));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cloudEDDRed.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 140, 60));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 14))); // NOI18N
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setOpaque(false);

        txtContenido.setColumns(20);
        txtContenido.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtContenido.setRows(5);
        jScrollPane1.setViewportView(txtContenido);

        txtNombre.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 260));

        btnModificar.setBackground(new java.awt.Color(56, 150, 201));
        btnModificar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 150, -1));

        btnCrear.setBackground(new java.awt.Color(56, 150, 201));
        btnCrear.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Crear");
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 150, -1));

        btnCancelar.setBackground(new java.awt.Color(56, 150, 201));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 150, -1));

        lblTitulo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Crear Archivo");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 230, 30));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white.jpg"))); // NOI18N
        getContentPane().add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 390, 370));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/initial.jpg"))); // NOI18N
        getContentPane().add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombreArchivo = txtNombre.getText();
        String contenido = txtContenido.getText();

        if (!nombreArchivo.equals("") && !nombreArchivo.equals("Nombre del archivo") && !contenido.equals("") && !contenido.equals("Contenido del archivo")) {
            try {
                String[] datos = nombreArchivo.split("\\.", 2);
                SoftwareEDDDriver.usuarios.insertarArchivo(datos[0], datos[1], contenido, SoftwareEDDDriver.folderLog, SoftwareEDDDriver.userLog);
                SoftwareEDDDriver.bitacora.push(SoftwareEDDDriver.userLog, "Creo el archivo " + nombreArchivo + ".");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo, nombre incorrecto.", "Error con archivo.", JOptionPane.ERROR_MESSAGE);
            }

            cambiarVentana();
        } else {
            lblError.setText("*Debes completar los campos.");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void cambiarVentana() {
//        initialWindow inicial = new initialWindow();

        //Verificar el tipo de usuario que ingreso
//        if (SoftwareEDDDriver.userLog.equals("ADMIN")) {
//            inicial.btnAdministrador.setVisible(true);
//        } else {
//            inicial.btnAdministrador.setVisible(false);
//        }

        //Mostrar el JFrame de la ventana inicial
//        SoftwareEDDDriver.usuarios.mostrarContenido(SoftwareEDDDriver.userLog, SoftwareEDDDriver.folderLog, inicial.panelVisual);
//        inicial.setVisible(true);
//        inicial.lblUser.setText(SoftwareEDDDriver.userLog);
        SoftwareEDDDriver.panel.removeAll();
        SoftwareEDDDriver.usuarios.mostrarContenido(SoftwareEDDDriver.userLog, SoftwareEDDDriver.folderLog, SoftwareEDDDriver.panel);
        SoftwareEDDDriver.panel.repaint();
        this.setVisible(false);
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cambiarVentana();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String nombreArchivo = txtNombre.getText();
        String contenido = txtContenido.getText();

        if (!nombreArchivo.equals("") && !nombreArchivo.equals("Nombre del archivo") && !contenido.equals("") && !contenido.equals("Contenido del archivo")) {
            try {
                String[] datos = nombreArchivo.split("\\.", 2);
                SoftwareEDDDriver.usuarios.insertarArchivo(datos[0], datos[1], contenido, SoftwareEDDDriver.folderLog, SoftwareEDDDriver.userLog);
                SoftwareEDDDriver.bitacora.push(SoftwareEDDDriver.userLog, "Modificó el archivo " + nombreArchivo + ".");
                JOptionPane.showMessageDialog(null, "Modificación Realizada.", "Modificación exitosa.", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al modificar el archivo, nombre incorrecto.", "Error con archivo.", JOptionPane.ERROR_MESSAGE);
            }

            cambiarVentana();
        } else {
            lblError.setText("*Debes completar los campos.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(createFileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createFileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createFileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createFileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createFileWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblTimeStamp;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JTextArea txtContenido;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
