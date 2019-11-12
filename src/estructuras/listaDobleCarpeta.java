package estructuras;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
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
        insertar(nombreCarpeta);
    }

    public void insertar(String nombreCarpeta) {
        nodoCarpeta nuevo = new nodoCarpeta(nombreCarpeta);

        if (listaVacia() != true) {
            this.fin.setNext(nuevo);
            nuevo.setPrevious(this.fin);
        } else {
            this.inicio = nuevo;
        }
        this.fin = nuevo;

    }

    public void eliminar(String nombreCarpeta) {
        if (listaVacia() != true) {
            nodoCarpeta aux = this.inicio;
            while (aux != null) {
                if (aux.getNombreCarpeta().equals(nombreCarpeta)) {
                    nodoCarpeta tempPrev = aux.getPrevious();
                    nodoCarpeta tempNext = aux.getNext();
                    tempPrev.setNext(tempNext);
                    tempNext.setPrevious(tempPrev);
                    aux.setNext(null);
                    aux.setPrevious(null);
                } else {
                    aux = aux.getNext();
                }
            }
        }
    }

    public void visualizarCarpeta(JPanel panel, String carpetaActual) {
        //Poner el nombre de la carpeta en la variable
        SoftwareEDDDriver.folderLog = carpetaActual;

        //Variables de posicion
        int x = 10;
        int y = 20;
        int conteo = 0;

        //Buscar la carpeta a mostrar contenido
        nodoCarpeta aux = this.inicio;
        while (!carpetaActual.equals(aux.getNombreCarpeta())) {
            aux = aux.getNext();
        }

        //Crear icono de la carpeta        
        ImageIcon folder = new ImageIcon(getClass().getResource("/imagenes/folder.png"));

        //Crear icono para el archivo
        ImageIcon file = new ImageIcon(getClass().getResource("/imagenes/folder.png"));

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

            //Evaluar posicion del boton siguiente                                   
            if (conteo < 4) {
                x += 90;
            }else{
                y +=80;
                x = 10;
                conteo = 0;
            }

            //Agregar boton al panel
            panel.add(botonCarpeta);
            panel.repaint();
            //Siguiente carpeta
            temp = temp.getNext();
            conteo++;
        }

        //Cargar todos los archivos al panel
    }

}
