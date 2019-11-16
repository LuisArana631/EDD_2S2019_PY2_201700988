package estructuras;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import software.edd.driver.SoftwareEDDDriver;

public class listaDobleCarpeta {

    private nodoCarpeta inicio;
    private nodoCarpeta fin;

    public listaDobleCarpeta() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean listaVacia() {
        return this.inicio == null;
    }

    public void carpetaInterior(String nombreCarpeta, String nombreDestino) {
        nodoCarpeta aux = this.inicio;

        while (!aux.getNombreCarpeta().equals(nombreDestino)) {
            aux = aux.getNext();
        }

        aux.insertarCarpetaEnlazada(nombreCarpeta);
        insertar(nombreCarpeta, nombreDestino);
    }

    public void insertar(String nombreCarpeta, String carpetaPrev) {
        nodoCarpeta nuevo = new nodoCarpeta(nombreCarpeta, carpetaPrev);

        if (listaVacia() != true) {
            this.fin.setNext(nuevo);
            nuevo.setPrevious(this.fin);
        } else {
            this.inicio = nuevo;
        }
        this.fin = nuevo;

    }

    public void mostrarCarpetas() {
        nodoCarpeta aux = this.inicio;
        while (aux != null) {
            System.out.println("Carpeta: " + aux.getNombreCarpeta());
            aux = aux.getNext();
        }
    }

    public void eliminar(String nombreCarpeta) {
        nodoCarpeta now = this.inicio;
        nodoCarpeta prev = null;

        if (listaVacia() != true) {
            while (now != null) {
                if (now.getNombreCarpeta().equals(nombreCarpeta)) {
                    if (prev == null) {
                        this.inicio = this.inicio.getNext();
                        this.inicio.setPrevious(null);
                    } else {
                        prev.setNext(now.getNext());
                        now.getNext().setPrevious(now.getPrevious());
                    }
                }

                prev = now;
                now = now.getNext();
            }
        }
    }

    public void visualizarCarpeta(JPanel panel, String carpetaActual) {
        //Poner el nombre de la carpeta en la variable
        SoftwareEDDDriver.folderLog = carpetaActual;

        //Variables de posicion
        int x = 10;
        int y = 20;
        int conteo = 1;

        //Buscar la carpeta a mostrar contenido
        nodoCarpeta aux = this.inicio;
        while (!carpetaActual.equals(aux.getNombreCarpeta())) {
            aux = aux.getNext();
        }

        //Crear icono de la carpeta        
        ImageIcon folder = new ImageIcon(getClass().getResource("/imagenes/folder.png"));
        SoftwareEDDDriver.prevFolder = aux.getCarpetaPrev();

        //Cargar todas las carpetas al panel
        nodoSimpleCarpeta temp = aux.getCarpetas().getInicio();

        while (temp != null) {

            //Crear el boton
            JButton botonCarpeta = new JButton();
            botonCarpeta.setBounds(x, y, 80, 70);
            botonCarpeta.setContentAreaFilled(false);
            botonCarpeta.setBorderPainted(false);
            botonCarpeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
            //Insertar imagen al boton
            botonCarpeta.setIcon(new ImageIcon(folder.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            botonCarpeta.setBackground(Color.white);
            //Insertar texto al boton
            botonCarpeta.setText(temp.getNombre());
            botonCarpeta.setHorizontalTextPosition(SwingConstants.CENTER);
            botonCarpeta.setVerticalTextPosition(SwingConstants.BOTTOM);
            botonCarpeta.setFont(new Font("Microsoft YaHei UI Light", 1, 9));
            //Menu popup
            JPopupMenu menuPop = new JPopupMenu();
            JMenuItem modificar = new JMenuItem("Modificar");
            JMenuItem eliminar = new JMenuItem("Eliminar");
            menuPop.add(modificar);
            menuPop.add(eliminar);
            //Añadir click listener al boton
            botonCarpeta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if ((e.getModifiers() & 4) != 0) {
                        menuPop.show(botonCarpeta, e.getX(), e.getY());
                    }
                }
            });
            botonCarpeta.add(menuPop);
            //ActionListener del boton
            ActionListener listen = (ActionEvent e) -> {
                SoftwareEDDDriver.folderLog = botonCarpeta.getText();
                panel.removeAll();
                visualizarCarpeta(panel, botonCarpeta.getText());
                panel.repaint();
            };
            botonCarpeta.addActionListener(listen);
            //Funcion de ingresar a carpeta

            //Evaluar posicion del boton siguiente                                   
            if (conteo < 5) {
                x += 90;
            } else {
                y += 80;
                x = 10;
                conteo = 0;
            }

            //Agregar boton al panel
            panel.add(botonCarpeta);
            //Siguiente carpeta            
            conteo++;
            temp = temp.getNext();
        }

        //Crear icono para el archivo
        ImageIcon file = new ImageIcon(getClass().getResource("/imagenes/file.png"));

        //Cargar todos los archivos al panel
        aux.getArchivos().crearBotones(panel, x, y, conteo, file);

        //Repintar el panel
        panel.repaint();
    }

    public void insertarArchivo(String nombreArchivo, String extension, String contenido, String nombreCarpeta) {
        nodoCarpeta aux = this.inicio;

        while (!aux.getNombreCarpeta().equals(nombreCarpeta)) {
            aux = aux.getNext();
        }

        aux.getArchivos().insertar(nombreArchivo, extension, contenido);

    }

    public void arbolArchivo(String nombreCarpeta) throws IOException {
        nodoCarpeta aux = this.inicio;

        while (!aux.getNombreCarpeta().equals(nombreCarpeta)) {
            aux = aux.getNext();
        }

        aux.getArchivos().graficar();

    }

    private void crearImagen(String dirDot, String dirPng) {
        try {
            ProcessBuilder pbuild = new ProcessBuilder("dot", "-Tpng", "-o", dirPng, dirDot);
            pbuild.redirectErrorStream(true);
            pbuild.start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void graficarLista() throws IOException {
        if (this.listaVacia() == false) {
            String ruta = System.getProperty("user.home");
            ruta += "\\Desktop\\Reports";
            File carpeta = new File(ruta);

            if (!carpeta.exists()) {
                if (!carpeta.mkdirs()) {
                    JOptionPane.showMessageDialog(null, "Error al crear la carpeta de Reportes.", "Error con Carpeta.", JOptionPane.ERROR_MESSAGE);                    
                    return;
                }
            }
            
            String rutaDot = ruta + "\\ListaCarpetas.dot";
            File archivo = new File(rutaDot);
            
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            
            try (PrintWriter write = new PrintWriter(rutaDot, "UTF-8")){
                write.println("digraph listaCarpeta {");
                write.println("label=\"Lista Simple de Carpetas\";");
                
            }
        }
    }

}
