
package ventanas;

import com.placeholder.PlaceHolder;

public class loginWindow extends javax.swing.JFrame {

    PlaceHolder holder;
    public loginWindow() {
        initComponents();                       
        
        this.setLocationRelativeTo(null);        
        place_holders();
    }   
    
    public void place_holders(){
        holder = new PlaceHolder(txtUser, "Usuario");
        holder = new PlaceHolder(txtPass, "Contraseña");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        lblBlanco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIniciar.setText("jButton1");
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 280, -1));

        btnSalir.setText("jButton2");
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        btnRegistrar.setText("jButton1");
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 280, -1));

        txtUser.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 280, 40));

        txtPass.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 280, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cloudEDD.png"))); // NOI18N
        lblLogo.setText("jLabel2");
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 380, 110));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        lblBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white.jpg"))); // NOI18N
        getContentPane().add(lblBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 440, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
