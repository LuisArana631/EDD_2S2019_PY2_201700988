
package ventanas;

import com.placeholder.PlaceHolder;
import javax.swing.JOptionPane;
import software.edd.driver.SoftwareEDDDriver;

public class registroWindow extends javax.swing.JFrame {
    
    PlaceHolder holder;
    public registroWindow() {
        initComponents();
        
        btnRegistrar.requestFocus();
        
        this.setLocationRelativeTo(null);        
        
        place_holders();
    }
    
    public void place_holders(){
        holder = new PlaceHolder(txtUser,"Ingresar Usuario");
        holder = new PlaceHolder(txtContraseña, "Ingresar Contraseña");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblForm = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();
        lblBlanco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblForm.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        lblForm.setForeground(new java.awt.Color(72, 86, 97));
        lblForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForm.setText("Registrar Usuario");
        lblForm.setToolTipText("");
        getContentPane().add(lblForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 210, 30));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cloudEDDRed.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 150, 70));

        txtUser.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 280, 40));

        lblError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 280, -1));

        txtContraseña.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 280, 40));

        btnRegistrar.setBackground(new java.awt.Color(56, 150, 201));
        btnRegistrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 16)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(72, 86, 97));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 280, 30));

        btnIniciar.setBackground(new java.awt.Color(144, 204, 232));
        btnIniciar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 16)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(72, 86, 97));
        btnIniciar.setText("Ingresar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 280, 30));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gnome_session_logout.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 40, 40));

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
        loginWindow login = new loginWindow();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String usuario;
        String password;
        
        usuario = txtUser.getText();
        password = txtContraseña.getText();
        
        if (usuario.equals("") || password.equals("") || usuario.equals("Ingresar Usuario") || password.equals("Ingresar Contraseña")){
            lblError.setText("*No has llenado todos los campos.");
        }else{
            //Verificar que el usuario no exista            
            boolean existe = SoftwareEDDDriver.usuarios.usuarioExiste(usuario);                        
            if(!existe){
                if(password.length() < 8){
                    lblError.setText("*Contraseña invalida. Debe contenter 8 caracteres mínimo.");
                }else{
                    SoftwareEDDDriver.usuarios.insertHash(usuario,password);
                    JOptionPane.showMessageDialog(null, "Usuario creado con exito.", usuario+" bienvenido.", JOptionPane.INFORMATION_MESSAGE);
                    loginWindow login = new loginWindow();
                    login.setVisible(true);
                    this.setVisible(false);
                }
            }else{
                lblError.setText("*Usuario ya existe.");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(registroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroWindow().setVisible(true);
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
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
