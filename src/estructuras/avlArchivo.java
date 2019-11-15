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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import software.edd.driver.SoftwareEDDDriver;
import ventanas.viewWindow;

public class avlArchivo {

    private nodoArchivo raiz;

    public avlArchivo() {
        this.raiz = null;
    }

    public nodoArchivo getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoArchivo raiz) {
        this.raiz = raiz;
    }

    private boolean arbolVacio() {
        return this.raiz == null;
    }

    private int altura(nodoArchivo nodo) {
        if (nodo == null) {
            return -1;
        }

        return nodo.getAltura();
    }

    private int getBalance(nodoArchivo nodo) {
        if (nodo == null) {
            return 0;
        }

        return altura(nodo.getLeft()) - altura(nodo.getRight());
    }

    private nodoArchivo rotacionDerecha(nodoArchivo nodo) {
        nodoArchivo tempIzquierdaNodo = nodo.getLeft();
        nodoArchivo tempT = tempIzquierdaNodo.getRight();

        tempIzquierdaNodo.setRight(nodo);
        nodo.setLeft(tempT);

        nodo.setAltura(Math.max(altura(nodo.getLeft()), altura(nodo.getRight())) + 1);
        tempIzquierdaNodo.setAltura(Math.max(altura(tempIzquierdaNodo.getLeft()), altura(tempIzquierdaNodo.getRight())) + 1);

        return tempIzquierdaNodo;
    }

    private nodoArchivo rotacionIzquierda(nodoArchivo nodo) {
        nodoArchivo tempDerechaNodo = nodo.getRight();
        nodoArchivo tempT = tempDerechaNodo.getLeft();

        tempDerechaNodo.setLeft(nodo);
        nodo.setRight(tempT);

        nodo.setAltura(Math.max(altura(nodo.getLeft()), altura(nodo.getRight())) + 1);
        tempDerechaNodo.setAltura(Math.max(altura(tempDerechaNodo.getLeft()), altura(tempDerechaNodo.getRight())) + 1);

        return tempDerechaNodo;
    }

    public void insertar(String nombre, String extension, String contenido) {
        //Obtener hora y fecha del momento de insercion
        Date datePull = new Date();
        DateFormat dateHour = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
        String timeStamp = dateHour.format(datePull);
        //Enviar datos al metodo insert
        this.raiz = insert(this.raiz, nombre, extension, contenido, timeStamp, SoftwareEDDDriver.userLog);
    }

    private nodoArchivo insert(nodoArchivo nodo, String nombre, String extension, String contenido, String timeStamp, String propietario) {
        //Verificar si el nodo esta vacío
        if (nodo == null) {
            return new nodoArchivo(nombre, extension, contenido, timeStamp, propietario);
        }

        //Si el nombre es menor al nodo evaluado ir izquierda
        if (nombre.compareTo(nodo.getNombre()) < 0) {
            nodo.setLeft(insert(nodo.getLeft(), nombre, extension, contenido, timeStamp, propietario));
            //Si el nombre es mayor al nodo evaluado ir derecha
        } else if (nombre.compareTo(nodo.getNombre()) > 0) {
            nodo.setRight(insert(nodo.getRight(), nombre, extension, contenido, timeStamp, propietario));
            //Si el nombre es igual al nodo evaluado actualizar contenido
        } else {
            nodo.setContenido(contenido);
        }

        //Asignar altura del nodo
        nodo.setAltura(Math.max(altura(nodo.getLeft()), altura(nodo.getRight())) + 1);

        //Validar rotaciones
        nodo = Balancear(nodo, nombre);

        return nodo;
    }

    private nodoArchivo Balancear(nodoArchivo nodo, String nombre) {
        //Obtener el balance del nodo
        int balance = getBalance(nodo);

        String nombreLeft = "";
        String nombreRight = "";

        if (nodo.getLeft() != null) {
            nombreLeft = nodo.getLeft().getNombre();
        }

        if (nodo.getRight() != null) {
            nombreRight = nodo.getRight().getNombre();
        }

        if (balance > 1 && nombre.compareTo(nombreLeft) < 0) {
            return rotacionDerecha(nodo);
        } else if (balance < -1 && nombre.compareTo(nombreRight) > 0) {
            return rotacionIzquierda(nodo);
        } else if (balance > 1 && nombre.compareTo(nombreLeft) > 0) {
            nodo.setLeft(rotacionIzquierda(nodo.getLeft()));
            return rotacionDerecha(nodo);
        } else if (balance < -1 && nombre.compareTo(nombreRight) < 0) {
            nodo.setRight(rotacionDerecha(nodo.getRight()));
            return rotacionIzquierda(nodo);
        }

        return nodo;

    }

    public void graficar() throws IOException {
        if (!arbolVacio()) {
            //Obtenemos la direccion de la carpeta
            String path = System.getProperty("user.home");
            path += "\\Desktop\\Reports";
            File carpeta = new File(path);

            //Creamos la carpeta de reportes en caso de no existir
            if (!carpeta.exists()) {
                if (!carpeta.mkdirs()) {
                    JOptionPane.showMessageDialog(null, "Error al crear la carpeta de Reportes.", "Error con Carpeta.", JOptionPane.ERROR_MESSAGE);
                }
            }

            //Generamos la ruta del archivo dot
            String pathDot = path + "\\Archivos.dot";
            File archivo = new File(pathDot);

            //Creamos el archivo
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            //Escribimos dentro del archivo .dot
            try ( PrintWriter write = new PrintWriter(pathDot, "UTF-8")) {
                write.println("digraph ArbolArchivos{");
                write.println("node [shape=record, height=.1];");
                write.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de archivos." + e, "Error con los archivos.", JOptionPane.ERROR_MESSAGE);
            }

            //Llamar metodo para escribir el arbol
            crearArbol(this.raiz, pathDot);

            //Terminamos de escribir el codigo
            try ( FileWriter escribir = new FileWriter(pathDot, true);  PrintWriter write = new PrintWriter(escribir)) {
                write.println("label= \"Reporte de archivos\";");
                write.println("}");
                write.close();
            }

            //Generar la imagen con el comando cmd
            String pathPng = path + "\\Archivos.png";
            crearImagen(pathDot, pathPng);

            //Crear archivo html para cargarlo al visor
            String htmlArchivo = path + "\\Archivos.html";
            File reporteHtml = new File(htmlArchivo);

            //Verificar existencia del archivo
            if (!reporteHtml.exists()) {
                reporteHtml.createNewFile();
            }

            //Escribir estructura del archivo html
            try ( PrintWriter write = new PrintWriter(htmlArchivo, "UTF-8")) {
                write.println("<html>");
                write.println("<head>");
                write.println("<title> Reporte de archivos </title>");
                write.println("</head>");
                write.println("<body>");
                write.println("<img src=\"Archivos.png\">");
                write.println("</body>");
                write.println("</html>");
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de archivos." + e, "Error con los archivos.", JOptionPane.ERROR_MESSAGE);
            }

            //Abrir el visor con la pagina cargada
            viewWindow visorHtml = new viewWindow();
            File rec = new File(htmlArchivo);
            try {
                visorHtml.edPaneWeb.setPage(rec.toURI().toURL());
                visorHtml.lblNombre.setText("Reporte de Archivos");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de archivos." + e, "Error con los archivos.", JOptionPane.ERROR_MESSAGE);
            }

            //Set visible true
            visorHtml.setVisible(true);
        }
    }

    private void crearArbol(nodoArchivo nodo, String pathDot) throws IOException {
        if (nodo != null) {
            crearArbol(nodo.getLeft(), pathDot);

            //Escribimos dentro del archivo .dot
            try ( FileWriter escribir = new FileWriter(pathDot, true);  PrintWriter write = new PrintWriter(escribir)) {
                write.println("node" + nodo.getNombre() + "[label = \"<f0> |<f1> " + nodo.getNombre() + "." + nodo.getExtension() + "\\n" + nodo.getContenido() + "\\n" + nodo.getAltura() + "\\n" + nodo.getPropietario() + "\\n" + nodo.getTimeStamp() + "|<f2> \"];");

                //Validar hijo izquierdo
                if (nodo.getLeft() != null) {
                    write.println("\"node" + nodo.getNombre() + "\":f0 -> \"node" + nodo.getLeft().getNombre() + "\":f1;");
                }

                //Validad hijo derecho
                if (nodo.getRight() != null) {
                    write.println("\"node" + nodo.getNombre() + "\":f2 -> \"node" + nodo.getRight().getNombre() + "\":f1;");
                }

                write.close();

            }

            crearArbol(nodo.getRight(), pathDot);
        }
    }

    private void crearImagen(String rutaDot, String rutaPng) {
        try {
            ProcessBuilder pbuild = new ProcessBuilder("dot", "-Tpng", "-o", rutaPng, rutaDot);
            pbuild.redirectErrorStream(true);
            pbuild.start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
        }
    }

    private nodoArchivo eliminar(nodoArchivo nodo, String nombre) {

        if (nodo == null) {
            return nodo;
        }

        //Evaluar si es menor
        if (nombre.compareTo(nodo.getNombre()) < 0) {
            nodo.setLeft(eliminar(nodo.getLeft(), nombre));
            //Evaluar si es mayor
        } else if (nombre.compareTo(nodo.getNombre()) > 0) {
            nodo.setRight(eliminar(nodo.getRight(), nombre));
            //Nodo correcto
        } else //Si el nodo a borrar tiene hijos
        {
            if (nodo.getLeft() == null && nodo.getRight() == null) {
                return null;
                //Si el nodo a borrar tiene hijo derecho
            } else if (nodo.getLeft() == null) {
                nodoArchivo aux = nodo.getRight();
                nodo = null;
                return aux;
                //Si el nodo a borrar tiene hijo izquierdo
            } else if (nodo.getRight() == null) {
                nodoArchivo aux = nodo.getLeft();
                nodo = null;
                return aux;
                //Si el nodo tiene dos hijos
            } else {
                nodoArchivo aux = getAnterior(nodo.getLeft());
                nodo.setNombre(aux.getNombre());
                nodo.setExtension(aux.getExtension());
                nodo.setContenido(aux.getContenido());
                nodo.setTimeStamp(aux.getTimeStamp());
                nodo.setPropietario(aux.getPropietario());
                nodo.setLeft(eliminar(nodo.getLeft(), aux.getNombre()));
            }
        }

        nodo.setAltura(Math.max(altura(nodo.getLeft()), altura(nodo.getRight())) + 1);

        return updateDelete(nodo);

    }

    private nodoArchivo getAnterior(nodoArchivo nodo) {
        nodoArchivo anterior = nodo;

        while (anterior.getRight() != null) {
            anterior = anterior.getRight();
        }

        return anterior;
    }

    private nodoArchivo updateDelete(nodoArchivo nodo) {
        int balance = getBalance(nodo);

        if (balance > 1) {
            if (getBalance(nodo.getLeft()) < 0) {
                nodo.setLeft(rotacionIzquierda(nodo.getLeft()));
            }

            return rotacionDerecha(nodo);
        } else if (balance < -1) {
            if (getBalance(nodo.getRight()) > 0) {
                nodo.setRight(rotacionDerecha(nodo.getRight()));
            }

            return rotacionIzquierda(nodo);
        }

        return nodo;

    }

    public void delete(String nombre) {
        //Llamar a funcion eliminar e igualar el nodo resultante a la raiz
        this.raiz = eliminar(this.raiz, nombre);
    }

    public void descargar(String nombre) throws IOException {
        descargarArchivo(this.raiz, nombre);
    }

    private void descargarArchivo(nodoArchivo nodo, String nombre) throws IOException {

        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "Error al descargar el archivo.", "Error con la descarga.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Evaluar si es menor
        if (nombre.compareTo(nodo.getNombre()) < 0) {
            descargarArchivo(nodo.getLeft(), nombre);
            //Evaluar si es mayor
        } else if (nombre.compareTo(nodo.getNombre()) > 0) {
            descargarArchivo(nodo.getRight(), nombre);
            //Nodo correcto
        } else {
            //Crear el archivo en la carpeta de descargas
            String path = System.getProperty("user.home");
            path += "\\Downloads\\" + nodo.getNombre() + "." + nodo.getExtension();
            File archivo = new File(path);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try ( PrintWriter write = new PrintWriter(path, "UTF-8")) {
                write.println(nodo.getContenido());
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, nodo.getNombre() + "." + nodo.getExtension() + " descargado con exito.", "Se ha descargado el archivo.", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void crearBotones(JPanel panel, int x, int y, int conteo, ImageIcon file) {
        nodoArchivo aux = this.raiz;
        pilaArchivo pila = new pilaArchivo();

        do {
            if (!pila.vacio() && aux == null) {
                //Crear el botonaso            
                JButton botonCarpeta = new JButton();
                botonCarpeta.setBounds(x, y, 80, 70);
                botonCarpeta.setContentAreaFilled(false);
                botonCarpeta.setBorderPainted(false);
                botonCarpeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
                //Insertar imagen al boton
                botonCarpeta.setIcon(new ImageIcon(file.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
                botonCarpeta.setBackground(Color.white);
                //Insertar texto al boton
                botonCarpeta.setText(pila.getInicio().getNombre() + "." + pila.getInicio().getExtension());
                botonCarpeta.setHorizontalTextPosition(SwingConstants.CENTER);
                botonCarpeta.setVerticalTextPosition(SwingConstants.BOTTOM);
                botonCarpeta.setFont(new Font("Microsoft YaHei UI Light", 1, 9));
                //Menu popup
                JPopupMenu menuPop = new JPopupMenu();
                JMenuItem modificar = new JMenuItem("Modificar");
                JMenuItem eliminar = new JMenuItem("Eliminar");
                JMenuItem compartir = new JMenuItem("Compartir");
                menuPop.add(compartir);
                menuPop.add(modificar);
                menuPop.add(eliminar);
                //Añadir click listener al boton
                botonCarpeta.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if ((e.getModifiers() & 4) != 0) {
                            menuPop.show(botonCarpeta, e.getX(), e.getY());
                        }
                    }
                });
                botonCarpeta.add(menuPop);
                //ActionListener del boton
                ActionListener listen = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
                botonCarpeta.addActionListener(listen);

                //Agregar boton al panel
                panel.add(botonCarpeta);
                //Siguiente archivo            
                panel.repaint();

                if (conteo < 4) {
                    x += 90;
                } else {
                    y += 80;
                    x = 10;
                    conteo = 0;
                }
                conteo++;
            }
            if (aux != null) {
                pila.push(aux);
                aux = aux.getLeft();
            } else if (!pila.vacio()) {
                aux = pila.getInicio();
                pila.pop();
                aux = aux.getRight();
            }
        } while (!pila.vacio() || aux != null);
    }

//
//    public void crearBotones(JPanel panel, int x, int y, int conteo, ImageIcon file) {
//        //Crear botones
//        mostrarBotones(this.raiz, panel, x, y, conteo, file);
//    }
//
//    private void mostrarBotones(nodoArchivo nodo, JPanel panel, int x, int y, int conteo, ImageIcon file) {
//        if (nodo != null) {
//
//            //Crear el botonaso            
//            JButton botonCarpeta = new JButton();
//            botonCarpeta.setBounds(x, y, 80, 70);
//            botonCarpeta.setContentAreaFilled(false);
//            botonCarpeta.setBorderPainted(false);
//            botonCarpeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
//            //Insertar imagen al boton
//            botonCarpeta.setIcon(new ImageIcon(file.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
//            botonCarpeta.setBackground(Color.white);
//            //Insertar texto al boton
//            botonCarpeta.setText(nodo.getNombre() + "." + nodo.getExtension());
//            botonCarpeta.setHorizontalTextPosition(SwingConstants.CENTER);
//            botonCarpeta.setVerticalTextPosition(SwingConstants.BOTTOM);
//            botonCarpeta.setFont(new Font("Microsoft YaHei UI Light", 1, 9));
//            //Menu popup
//            JPopupMenu menuPop = new JPopupMenu();
//            JMenuItem modificar = new JMenuItem("Modificar");
//            JMenuItem eliminar = new JMenuItem("Eliminar");
//            JMenuItem compartir = new JMenuItem("Compartir");
//            menuPop.add(compartir);
//            menuPop.add(modificar);
//            menuPop.add(eliminar);
//            //Añadir click listener al boton
//            botonCarpeta.addMouseListener(new MouseAdapter() {
//                public void mouseClicked(MouseEvent e) {
//                    if ((e.getModifiers() & 4) != 0) {
//                        menuPop.show(botonCarpeta, e.getX(), e.getY());
//                    }
//                }
//            });
//            botonCarpeta.add(menuPop);
//            //ActionListener del boton
//            ActionListener listen = new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                }
//            };
//            botonCarpeta.addActionListener(listen);
//
//            //Agregar boton al panel
//            panel.add(botonCarpeta);
//            //Siguiente archivo            
//            panel.repaint();
//
//            if (conteo < 4) {
//                x += 90;
//            } else {
//                y += 80;
//                x = 10;
//                conteo = 0;
//            }
//            conteo++;
//
//            mostrarBotones(nodo.getLeft(), panel, x, y, conteo, file);
//
//            if (conteo < 4) {
//                x += 90;
//            } else {
//                y += 80;
//                x = 10;
//                conteo = 0;
//            }
//            conteo++;
//
//            mostrarBotones(nodo.getRight(), panel, x, y, conteo, file);
//
//        }
//
//    }
}
