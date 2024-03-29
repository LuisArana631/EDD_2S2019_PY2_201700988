package ventanas;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import software.edd.driver.SoftwareEDDDriver;

public class initialWindow extends javax.swing.JFrame {

    public initialWindow() {
        initComponents();

        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        btnCrearCarpeta.requestFocus();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUser = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnAdministrador = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelVisual = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCrearArchivo = new javax.swing.JButton();
        btnSubirArchivo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCrearCarpeta = new javax.swing.JButton();
        btnRegresarCarpeta = new javax.swing.JButton();
        lblFondo1 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 470, 30));

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
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 60));

        btnAdministrador.setBackground(new java.awt.Color(56, 150, 210));
        btnAdministrador.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministrador.setText("Funciones Administrador");
        btnAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 240, -1));

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N
        panelOpciones.setOpaque(false);

        btnReportes.setBackground(new java.awt.Color(56, 150, 210));
        btnReportes.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("Reportes");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setPreferredSize(new java.awt.Dimension(240, 27));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 280, 60));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelVisual.setBackground(new java.awt.Color(255, 255, 255));
        panelVisual.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N
        panelVisual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelVisual.setPreferredSize(new java.awt.Dimension(430, 3000));

        javax.swing.GroupLayout panelVisualLayout = new javax.swing.GroupLayout(panelVisual);
        panelVisual.setLayout(panelVisualLayout);
        panelVisualLayout.setHorizontalGroup(
            panelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        panelVisualLayout.setVerticalGroup(
            panelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2975, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelVisual);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 480, 400));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Archivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N
        jPanel3.setOpaque(false);

        btnCrearArchivo.setBackground(new java.awt.Color(56, 150, 210));
        btnCrearArchivo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnCrearArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearArchivo.setText("Crear");
        btnCrearArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearArchivoActionPerformed(evt);
            }
        });

        btnSubirArchivo.setBackground(new java.awt.Color(56, 150, 210));
        btnSubirArchivo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnSubirArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirArchivo.setText("Subir");
        btnSubirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(btnSubirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnCrearArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubirArchivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 280, 100));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray), "Carpetas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 1, 12))); // NOI18N
        jPanel1.setOpaque(false);

        btnCrearCarpeta.setBackground(new java.awt.Color(56, 150, 201));
        btnCrearCarpeta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnCrearCarpeta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCarpeta.setText("Crear");
        btnCrearCarpeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCarpetaActionPerformed(evt);
            }
        });

        btnRegresarCarpeta.setBackground(new java.awt.Color(56, 150, 201));
        btnRegresarCarpeta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btnRegresarCarpeta.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresarCarpeta.setText("Regresar Carpeta");
        btnRegresarCarpeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarCarpetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(btnRegresarCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCrearCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresarCarpeta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 280, 100));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white.jpg"))); // NOI18N
        getContentPane().add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 790, 430));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/initial.jpg"))); // NOI18N
        getContentPane().add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -160, 790, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Actualizar bitacora
        SoftwareEDDDriver.bitacora.push(SoftwareEDDDriver.userLog, "Cerrar sesión.");

        //Igualar a null el nodo de usuario que se utiliza, al igual que el string
        SoftwareEDDDriver.userLog = "";

        //Mostrar la ventana de login
        loginWindow login = new loginWindow();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        administradorWindow adminWindow = new administradorWindow();
        adminWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnCrearCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCarpetaActionPerformed
        String nuevaCarpeta = JOptionPane.showInputDialog(null, "Introducir nombre de la carpeta:", "Nombre de la carpeta", 1);
        try {
            if (!nuevaCarpeta.equals("")) {
                SoftwareEDDDriver.usuarios.insertarCarpeta(SoftwareEDDDriver.folderLog, nuevaCarpeta, SoftwareEDDDriver.userLog);
                panelVisual.removeAll();
                SoftwareEDDDriver.usuarios.mostrarContenido(SoftwareEDDDriver.userLog, SoftwareEDDDriver.folderLog, panelVisual);
                panelVisual.repaint();
                SoftwareEDDDriver.bitacora.push(SoftwareEDDDriver.userLog, "Creó la carpeta  "+ nuevaCarpeta+ ".");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnCrearCarpetaActionPerformed

    private void btnCrearArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearArchivoActionPerformed
        createFileWindow creadorArchivo = new createFileWindow();
        creadorArchivo.setVisible(true);
        creadorArchivo.btnCrear.setVisible(true);
        creadorArchivo.btnModificar.setVisible(false);
        creadorArchivo.lblTitulo.setText("Crear Archivo");        
        SoftwareEDDDriver.panel = this.panelVisual;
        creadorArchivo.place_holders();
        
//        this.setVisible(false);
    }//GEN-LAST:event_btnCrearArchivoActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        reportesWindow report = new reportesWindow();
        report.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnRegresarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarCarpetaActionPerformed
        if (!"raiz".equals(SoftwareEDDDriver.folderLog)) {
            panelVisual.removeAll();
            SoftwareEDDDriver.usuarios.mostrarContenido(SoftwareEDDDriver.userLog, SoftwareEDDDriver.prevFolder, panelVisual);
        }
        panelVisual.repaint();
    }//GEN-LAST:event_btnRegresarCarpetaActionPerformed

    private void btnSubirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirArchivoActionPerformed
        //Variable para manejar archivos
        boolean archivo = true;
        boolean exten = false;
        boolean cont = false;
        String nombre = "";
        String extension = "";
        String contenido = "";
        int conteo = 0;
        int lineasConteo = 0;
        //File chooser de archivos
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);
        //Intentar cargar archivo
        try {
            String ruta = buscador.getSelectedFile().getAbsolutePath();
            FileInputStream archivoCarga = new FileInputStream(ruta);
            try (DataInputStream entradaDatos = new DataInputStream(archivoCarga)) {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(entradaDatos));
                String linea;

                while ((linea = buffer.readLine()) != null) {
                    //Cargar archivo
                    for (int i = 0; i < linea.length(); i++) {
                        char letra = linea.charAt(i);

                        if (lineasConteo > 0) {
                            if (archivo == true) {
                                //Llenar nombre si no hay puntos
                                if (letra == 46) {
                                    archivo = false;
                                    exten = true;
                                } else {
                                    nombre += letra;
                                }
                            } else if (exten == true) {
                                //Llena la extension si no hay comas o punto y coma
                                if (letra == 59 || letra == 44) {
                                    cont = true;
                                    exten = false;
                                } else if (Character.isLetter(letra) || Character.isDigit(letra)) {
                                    extension += letra;
                                }
                            } else if (cont == true) {
                                //Solo llena el contenido si no hay comillas
                                if (letra == 34) {
                                    //No hacer nada
                                } else {
                                    contenido+= letra;
                                }
                            }
                        }

                    }

                    if (lineasConteo > 0) {
                        //Insertar el archivo al avl                        
                        SoftwareEDDDriver.usuarios.insertarArchivo(nombre, extension, contenido, SoftwareEDDDriver.folderLog, SoftwareEDDDriver.userLog);
                        conteo++;
                    }

                    lineasConteo++;

                    //Limpiar variables
                    nombre = "";
                    extension = "";
                    contenido = "";
                    archivo = true;
                    cont = false;

                }

                JOptionPane.showMessageDialog(null, "Se han cargado " + conteo + " archivos.");
            }
        } catch (IOException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de carga." + e, "Error con la lectura del archivo.", JOptionPane.ERROR_MESSAGE);
        }

        SoftwareEDDDriver.bitacora.push(SoftwareEDDDriver.userLog, "Carga masiva de archivos.");

        panelVisual.removeAll();
        SoftwareEDDDriver.usuarios.mostrarContenido(SoftwareEDDDriver.userLog, SoftwareEDDDriver.folderLog, panelVisual);
        panelVisual.repaint();
    }//GEN-LAST:event_btnSubirArchivoActionPerformed

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
    public javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnCrearArchivo;
    private javax.swing.JButton btnCrearCarpeta;
    private javax.swing.JButton btnRegresarCarpeta;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblUser;
    public final javax.swing.JPanel panelOpciones = new javax.swing.JPanel();
    public javax.swing.JPanel panelVisual;
    // End of variables declaration//GEN-END:variables
}
