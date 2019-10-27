
package ventanas;

import com.placeholder.PlaceHolder;

public class loginWindow extends javax.swing.JFrame {

    PlaceHolder holder;
    public loginWindow() {
        initComponents();                       
        
        btnIniciar.requestFocus();
        
        this.setLocationRelativeTo(null);        
        place_holders();
    }   
    
    public void place_holders(){
        holder = new PlaceHolder(txtUser, "Ingresar Usuario");
        holder = new PlaceHolder(txtPass, "Ingresar Contraseña");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPass = new javax.swing.JPasswordField();
        lblLogo = new javax.swing.JLabel();
        lblForm = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();
        lblBlanco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPass.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 280, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cloudEDDRed.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 150, 70));

        lblForm.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        lblForm.setForeground(new java.awt.Color(72, 86, 97));
        lblForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForm.setText("Iniciar Sesión");
        lblForm.setToolTipText("");
        getContentPane().add(lblForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 210, 30));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gnome_session_logout.png"))); // NOI18N
        btnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 40, 40));

        lblError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 280, -1));

        btnIniciar.setBackground(new java.awt.Color(56, 150, 201));
        btnIniciar.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 16)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(72, 86, 97));
        btnIniciar.setText("Ingresar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 280, 30));

        btnRegistrar.setBackground(new java.awt.Color(144, 204, 232));
        btnRegistrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 16)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(72, 86, 97));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 280, 30));

        txtUser.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 280, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 290, -1));

        lblBlanco.setBackground(new java.awt.Color(255, 255, 255));
        lblBlanco.setForeground(new java.awt.Color(72, 86, 97));
        lblBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white.jpg"))); // NOI18N
        lblBlanco.setOpaque(true);
        getContentPane().add(lblBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 410, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        String usuario = new String();
        String password = new String();
        
        usuario = txtUser.getText();
        password = txtPass.getText();
        
        if (usuario.equals("") || password.equals("") || usuario.equals("Ingresar Usuario") || password.equals("Ingresar Contraseña")){
            lblError.setText("*No has llenado todos los campos.");
        }else{
            initialWindow inicial = new initialWindow();
            inicial.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registroWindow registro = new registroWindow();
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed
    
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
            java.util.logging.Logger.getLogger(loginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblBlanco;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblForm;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
