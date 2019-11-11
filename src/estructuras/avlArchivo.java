package estructuras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import ventanas.viewWindow;

public class avlArchivo {

    private nodoArchivo raiz;

    private boolean arbolVacio() {
        return this.raiz == null;
    }

    private int altura(nodoArchivo nodo) {
        if (arbolVacio()) {
            return -1;
        }

        return nodo.getAltura();
    }

    private int getBalance(nodoArchivo nodo) {
        if (arbolVacio()) {
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

    public void insertar(String nombre, String contenido, String propietario) {
        //Obtener hora y fecha del momento de insercion
        Date datePull = new Date();
        DateFormat dateHour = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
        String timeStamp = dateHour.format(datePull);
        //Enviar datos al metodo insert
        this.raiz = insert(this.raiz, nombre, contenido, timeStamp, propietario);
    }

    private nodoArchivo insert(nodoArchivo nodo, String nombre, String contenido, String timeStamp, String propietario) {
        //Verificar si el nodo esta vacío
        if (nodo == null) {
            return new nodoArchivo(nombre, contenido, timeStamp, propietario);
        }

        //Si el nombre es menor al nodo evaluado ir izquierda
        if (nombre.compareTo(nodo.getNombre()) < 0) {
            nodo.setLeft(insert(nodo.getLeft(), nombre, contenido, timeStamp, propietario));
            //Si el nombre es mayor al nodo evaluado ir derecha
        } else if (nombre.compareTo(nodo.getNombre()) > 0) {
            nodo.setRight(insert(nodo.getRight(), nombre, contenido, timeStamp, propietario));
            //Si el nombre es igual al nodo evaluado actualizar contenido
        } else {
            nodo.setContenido(contenido);
        }

        //Asignar altura del nodo
        nodo.setAltura(Math.max(altura(nodo.getLeft()), altura(nodo.getRight())));

        //Validar rotaciones
        nodo = Balancear(nodo, nombre);

        return nodo;
    }

    private nodoArchivo Balancear(nodoArchivo nodo, String nombre) {
        //Obtener el balance del nodo
        int balance = getBalance(nodo);

        if (balance > 1 && nombre.compareTo(nodo.getLeft().getNombre()) < 0) {
            return rotacionDerecha(nodo);
        } else if (balance < 1 && nombre.compareTo(nodo.getRight().getNombre()) > 0) {
            return rotacionIzquierda(nodo);
        } else if (balance > 1 && nombre.compareTo(nodo.getLeft().getNombre()) > 0) {
            nodo.setLeft(rotacionIzquierda(nodo.getLeft()));
            return rotacionDerecha(nodo);
        } else if (balance < 1 && nombre.compareTo(nodo.getRight().getNombre()) < 0) {
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
            try (PrintWriter write = new PrintWriter(pathDot, "UTF-8")) {
                write.println("digraph ArbolArchivos{");
                write.println("node [shape=record, height=.1];");
                write.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de archivos." + e, "Error con los archivos.", JOptionPane.ERROR_MESSAGE);
            }

            //Llamar metodo para escribir el arbol
            crearArbol(this.raiz, pathDot);

            //Terminamos de escribir el codigo
            try (PrintWriter write = new PrintWriter(pathDot, "UTF-8")) {
                write.println("label= \"Reporte de archivos\";");
                write.println("}");
                write.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de archivos." + e, "Error con los archivos.", JOptionPane.ERROR_MESSAGE);
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
            try (PrintWriter write = new PrintWriter(htmlArchivo, "UTF-8")) {
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
            try (PrintWriter write = new PrintWriter(pathDot, "UTF-8")) {
                write.println("node" + nodo.getNombre() + "[label = \"<f0> |<f1> " + nodo.getNombre() + "\\n" + nodo.getContenido() + "\\n" + nodo.getAltura() + "\\n" + nodo.getPropietario() + "\\n" + nodo.getTimeStamp() + "|<f2> \"];");

                //Validar hijo izquierdo
                if (nodo.getLeft() != null) {
                    write.println("\"node" + nodo.getNombre() + "\":f0 -> \"node" + nodo.getLeft().getNombre() + "\":f1;");
                }

                //Validad hijo derecho
                if (nodo.getRight() != null) {
                    write.println("\"node" + nodo.getNombre() + "\":f2 -> \"node" + nodo.getRight().getNombre() + "\":f1;");
                }

                write.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de archivos." + e, "Error con los archivos.", JOptionPane.ERROR_MESSAGE);
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
}
