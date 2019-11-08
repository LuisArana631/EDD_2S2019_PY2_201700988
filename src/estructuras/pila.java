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

public class pila {

    private nodoPila inicio;
    private int longitud = 0;

    public Boolean empty() {
        return this.inicio == null;
    }

    public void push(String user, String operation) {
        this.longitud++;

        Date datePull = new Date();
        DateFormat dateHour = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
        String date = dateHour.format(datePull);
        nodoPila nuevo = new nodoPila(user, date, operation);

        if (this.empty() == false) {
            nuevo.setNext(this.inicio);
            this.inicio = nuevo;
        } else {
            this.inicio = nuevo;
        }
    }

    public int size() {
        return this.longitud;
    }

    public void graficar() throws IOException {
        if (this.empty() == false) {
            String ruta = System.getProperty("user.home");
            ruta = ruta + "\\Desktop\\Reports";
            File carpeta = new File(ruta);

            if (!carpeta.exists()) {
                if (!carpeta.mkdirs()) {
                    JOptionPane.showMessageDialog(null, "Error al crear la carpeta de Reportes.", "Error con Carpeta.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String rutaImg = ruta + "\\Bitacora.dot";
            File archivo = new File(rutaImg);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try {
                try (PrintWriter write = new PrintWriter(rutaImg, "UTF-8")) {
                    write.println("digraph bitacora {");
                    write.println("label=\"Bitácora\";");
                    write.println("graph [fontsize=25 fontname=\"Verdana\" compound=true];");
                    write.println("node [shape=record fontsize=25 fontname=\"Verdana\"];");
                    write.print("struct1 [label=\"{");

                    nodoPila aux = this.inicio;
                    int count = 0;

                    while (aux != null) {
                        if (count != 0) {
                            write.print("|");
                        }

                        write.print("<f");
                        write.print(count);
                        write.print("> ");
                        write.print(aux.getOperation());
                        write.println("\\n");
                        write.print(aux.getDate());
                        write.println("\\n");
                        write.print(aux.getUser());
                        write.println("\\n");

                        count++;
                        aux = aux.getNext();
                    }

                    write.print("}\"];}");
                    write.close();
                }
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
            }

            String rutaPng = ruta + "\\Bitacora.png";
            crearImagen(rutaImg, rutaPng);

            //Crear archivo HTML para poder abrirla desde la app en tiempo correcto
            String htmlBitacora = ruta + "\\Bitacora.html";
            File reporteHtml = new File(htmlBitacora);

            //Verificar que exista el archivo
            if (!reporteHtml.exists()) {
                reporteHtml.createNewFile();
            }

            //Escribir el código html dentro del archivo 
            try {
                //Iniciar método printWriter para escribir o capturar error
                try (PrintWriter write = new PrintWriter(htmlBitacora, "UTF-8")) {
                    write.println("<html>");
                    write.println("<head>");
                    write.println("<title> Reporte Bitacora</title>");
                    write.println("</head>");
                    write.println("<body>");
                    write.println("<img src=\"Bitacora.png\">");
                    write.println("</body>");
                    write.println("</html>");
                }
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
            }

            //Abrir visor Web con la página creada del reporte
            viewWindow visorHtml = new viewWindow();
            File rec = new File(htmlBitacora);
            try {
                visorHtml.edPaneWeb.setPage(rec.toURI().toURL());
                visorHtml.lblNombre.setText("Reporte de Bitácora");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
            }

            visorHtml.setVisible(true);

        }
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
}
