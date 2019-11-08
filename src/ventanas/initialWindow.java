
package ventanas;


public class initialWindow extends javax.swing.JFrame {

    
    public initialWindow() {
        initComponents();
        
        btnCrearCarpeta.requestFocus();
        
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUser = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();
        btnCrearCarpeta2 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCrearArchivo = new javax.swing.JButton();
        btnModificarArchivo = new javax.swing.JButton();
        btnEliminarArchivo = new javax.swing.JButton();
        btnSubirArchivo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCrearCarpeta = new javax.swing.JButton();
        btnModificarCarpeta = new javax.swing.JButton();
        btnEliminarCarpeta = new javax.swing.JButton();
        btnSubirCarpeta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblFondo1 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        btnAdmin.setBackground(new java.awt.Color(56, 150, 201));
        btnAdmin.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnAdmin.setText("Funciones Administrador");
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 256, -1));

        btnCrearCarpeta2.setBackground(new java.awt.Color(56, 150, 201));
        btnCrearCarpeta2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnCrearCarpeta2.setText("Reportes");
        btnCrearCarpeta2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearCarpeta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCarpeta2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearCarpeta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 256, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoutcloud.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 70, 60));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cloudEDDRed.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 60));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Archivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N
        jPanel3.setOpaque(false);

        btnCrearArchivo.setBackground(new java.awt.Color(56, 150, 210));
        btnCrearArchivo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnCrearArchivo.setText("Crear");
        btnCrearArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnModificarArchivo.setBackground(new java.awt.Color(56, 150, 210));
        btnModificarArchivo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnModificarArchivo.setText("Modificar");
        btnModificarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEliminarArchivo.setBackground(new java.awt.Color(56, 150, 210));
        btnEliminarArchivo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnEliminarArchivo.setText("Eliminar");
        btnEliminarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSubirArchivo.setBackground(new java.awt.Color(56, 150, 210));
        btnSubirArchivo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnSubirArchivo.setText("Subir");
        btnSubirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarArchivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnCrearArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnCrearArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubirArchivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 280, 170));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Carpetas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N
        jPanel1.setOpaque(false);

        btnCrearCarpeta.setBackground(new java.awt.Color(56, 150, 201));
        btnCrearCarpeta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnCrearCarpeta.setText("Crear");
        btnCrearCarpeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnModificarCarpeta.setBackground(new java.awt.Color(56, 150, 201));
        btnModificarCarpeta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnModificarCarpeta.setText("Modificar");
        btnModificarCarpeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEliminarCarpeta.setBackground(new java.awt.Color(56, 150, 201));
        btnEliminarCarpeta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnEliminarCarpeta.setText("Eliminar");
        btnEliminarCarpeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSubirCarpeta.setBackground(new java.awt.Color(56, 150, 201));
        btnSubirCarpeta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btnSubirCarpeta.setText("Subir");
        btnSubirCarpeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubirCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarCarpeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnCrearCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCrearCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubirCarpeta)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 280, 170));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 480, 350));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white.jpg"))); // NOI18N
        getContentPane().add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 790, 430));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/initial.jpg"))); // NOI18N
        getContentPane().add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -160, 790, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        loginWindow login = new loginWindow();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCrearCarpeta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCarpeta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearCarpeta2ActionPerformed

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
            java.util.logging.Logger.getLogger(initialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(initialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(initialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(initialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new initialWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnCrearArchivo;
    private javax.swing.JButton btnCrearCarpeta;
    private javax.swing.JButton btnCrearCarpeta2;
    private javax.swing.JButton btnEliminarArchivo;
    private javax.swing.JButton btnEliminarCarpeta;
    private javax.swing.JButton btnModificarArchivo;
    private javax.swing.JButton btnModificarCarpeta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JButton btnSubirCarpeta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
