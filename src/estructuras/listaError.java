package estructuras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;
import ventanas.viewWindow;

public class listaError {

    private nodoSimpleError inicio;
    private nodoSimpleError fin;
    private int longitud;

    public listaError() {
        this.inicio = null;
        this.fin = null;
        this.longitud = 0;
    }

    public void resetLista(){
        this.inicio = null;
        this.fin = null;
        this.longitud = 0;
    }
    
    private boolean listaVacia() {
        return this.inicio != null;
    }

    public void insertar(String user, String password, String motivo) {
        nodoSimpleError nuevo = new nodoSimpleError(user, password, motivo);

        if (listaVacia()) {
            this.fin.setNext(nuevo);
        } else {
            this.inicio = nuevo;
        }

        this.fin = nuevo;
        this.longitud++;
    }

    public void graficar() throws IOException {
        if (listaVacia()) {
            String ruta = System.getProperty("user.home");
            ruta += "\\Desktop\\Reports";
            File carpeta = new File(ruta);

            if (!carpeta.exists()) {
                if (!carpeta.mkdirs()) {
                    JOptionPane.showMessageDialog(null, "Error al crear la carpeta de Reportes.", "Error con Carpeta.", JOptionPane.ERROR_MESSAGE);
                }
            }

            String rutaDot = ruta + "\\Errores.dot";
            File archivo = new File(rutaDot);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try (PrintWriter write = new PrintWriter(rutaDot, "UTF-8")) {
                write.println("digraph error {");
                write.println("label=\"Usuarios con Error\";");
                write.println("graph [pad = \"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
                write.println("node [shape=plain];");
                write.println("rankdir = LR;");
                write.println("usuariosError [label=<");
                write.println("<TABLE border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
                write.println("<TR><TD>No.</TD><TD>Usuario</TD><TD>Password</TD><TD>Motivo</TD></TR>");
                //Metodo para escribir la tabla de usuarios no admitidos
                write.println(crearTabla());
                write.println("</TABLE>");
                write.println(">,];");
                write.println("}");
                write.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios con error." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
            }

            String rutaPng = ruta + "\\Errores.png";
            crearImagen(rutaDot, rutaPng);

            String htmlUsuarios = ruta + "\\Errores.html";
            File reporteHtml = new File(htmlUsuarios);

            if (!reporteHtml.exists()) {
                reporteHtml.createNewFile();
            }

            try {
                try (PrintWriter write = new PrintWriter(htmlUsuarios, "UTF-8")) {
                    write.println("<html>");
                    write.println("<head>");
                    write.println("<title> Reporte Usuarios con Error </title>");
                    write.println("</head>");
                    write.println("<body>");
                    write.println("<img src=\"Errores.png\">");
                    write.println("</body>");
                    write.println("</html>");
                }
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios con error." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
            }

            viewWindow visorHtml = new viewWindow();
            File rec = new File(htmlUsuarios);
            try {
                visorHtml.edPaneWeb.setPage(rec.toURI().toURL());
                visorHtml.lblNombre.setText("Reporte de Usuarios no Admitidos");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios con error." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
            }
            visorHtml.setVisible(true);
        }
    }

    private String crearTabla() {
        String tabla = "";
        int conteo = 1;
        nodoSimpleError aux = this.inicio;

        while (aux != null) {
            tabla += "<TR><TD>" + conteo + "</TD><TD>" + aux.getUser() + "</TD><TD>" + aux.getPassword() + "</TD><TD>" + aux.getMotivo() + "</TD></TR>\n";
            aux = aux.getNext();
            conteo++;
        }

        return tabla;
    }

    private void crearImagen(String dirDot, String dirPng) {
        try {
            ProcessBuilder pbuild = new ProcessBuilder("dot", "-Tpng", "-o", dirPng, dirDot);
            pbuild.redirectErrorStream(true);
            pbuild.start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios con error." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setInicio(nodoSimpleError inicio) {
        this.inicio = inicio;
    }

    public nodoSimpleError getInicio() {
        return this.inicio;
    }

    public void setFin(nodoSimpleError fin) {
        this.fin = fin;
    }

    public nodoSimpleError getFin() {
        return this.fin;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return this.longitud;
    }

}
