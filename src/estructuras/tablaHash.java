package estructuras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;
import ventanas.viewWindow;

public class tablaHash {

    private nodoHash[] usuarios;
    private int longitud;
    private int cantidad;

    public tablaHash(int longitud) {
        this.usuarios = new nodoHash[longitud];
        this.longitud = longitud;
        this.cantidad = 0;
    }

    private int funcionH(int valUser, int intento) {
        return (valUser % this.longitud) + (intento * intento);
    }

    public void insertHash(String user, String password) {
        nodoHash nuevo = new nodoHash(user, password);
        this.cantidad++;
        insertarHash(nuevo.getUserI(), nuevo);        
    }

    private void insertarHash(int valUser, nodoHash nuevo) {        
                
        int intento = 0;
        int pos = funcionH(valUser, intento);
        int posTemp = pos;        
        
        do {
            if (this.usuarios[pos] == null) {
                this.usuarios[pos] = nuevo;                
                break;
            } else {
                intento++;
                pos = funcionH(valUser, intento);

                while (pos >= this.longitud) {
                    pos = pos - this.longitud;
                }
            }
        } while (pos != posTemp);

        if (pos == posTemp && intento > 0) {
            while (this.usuarios[pos] != null) {
                pos++;
                while (pos >= this.longitud) {
                    pos = pos - this.longitud;
                }
            }
            this.usuarios[pos] = nuevo;            
        }
        
        if (desbordamiento()) {
            redimensionar();
        }
        
    }

    private boolean desbordamiento() {
        return (double)((double)this.cantidad / (double)this.longitud) > 0.75;
    }

    private void redimensionar() {
        int temp = this.longitud;
        this.longitud = siguientePrimo(this.longitud);

        nodoHash[] nuevaTabla = new nodoHash[this.longitud];

        for (int i = 0; i < temp; i++) {
            if (this.usuarios[i] != null) {

                int intento = 0;
                int nuevaPos = funcionH(this.usuarios[i].getUserI(), intento);
                int posTemp = nuevaPos;

                do {
                    if (nuevaTabla[nuevaPos] == null) {
                        nuevaTabla[nuevaPos] = this.usuarios[i];                        
                        break;
                    } else {

                        intento++;
                        nuevaPos = funcionH(this.usuarios[i].getUserI(), intento);

                        while (nuevaPos >= this.longitud) {
                            nuevaPos = nuevaPos - this.longitud;
                        }

                    }
                } while (nuevaPos != posTemp);

                if (nuevaPos == posTemp && intento > 0) {
                    while (nuevaTabla[nuevaPos] != null) {
                        nuevaPos++;
                        while (nuevaPos >= this.longitud) {
                            nuevaPos = nuevaPos - this.longitud;
                        }
                    }
                    nuevaTabla[nuevaPos] = this.usuarios[i];
                }

            }

        }

        this.usuarios = nuevaTabla;
    }

    private int siguientePrimo(int inicio) {
        int siguiente = inicio + 1;
        while (!esPrimo(siguiente)) {
            siguiente++;
        }
        return siguiente;
    }

    private boolean esPrimo(int num) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != num)) {
            if (num % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    public void graficar() throws IOException {
        System.out.println(this.cantidad);
        if (this.cantidad != 0) {
            String path = System.getProperty("user.home");
            path = path + "\\Desktop\\Reports";
            File carpeta = new File(path);

            if (!carpeta.exists()) {
                if (!carpeta.mkdirs()) {
                    JOptionPane.showMessageDialog(null, "Error al crear la carpeta de Reportes.", "Error con Carpeta.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String rutaDot = path + "\\Usuarios.dot";
            File archivo = new File(rutaDot);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try (PrintWriter write = new PrintWriter(rutaDot, "UTF-8")) {
                write.println("digraph usuarios {");
                write.println("label=\"Usuarios\";");
                write.println("graph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
                write.println("node [shape=plain];");
                write.println("rankdir=LR;");
                write.println("tablaHash [label=<");
                write.println("<TABLE border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
                write.println("<TR><TD>No.</TD><TD>Nombre</TD><TD>Password</TD></TR>");
                //Metodo para escribir la tabla de usuarios
                write.println(creartabla());
                write.println("</TABLE>");
                write.println(">,];");
                write.println("}");
                write.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
            }

            String rutaPng = path + "\\Usuarios.png";
            crearImagen(rutaDot, rutaPng);

            String htmlUsuarios = path + "\\Usuarios.html";
            File reporteHtml = new File(htmlUsuarios);

            if (!reporteHtml.exists()) {
                reporteHtml.createNewFile();
            }

            try {
                try (PrintWriter write = new PrintWriter(htmlUsuarios, "UTF-8")) {
                    write.println("<html>");
                    write.println("<head>");
                    write.println("<title> Reporte Usuarios </title>");
                    write.println("</head>");
                    write.println("<body>");
                    write.println("<img src=\"Usuarios.png\">");
                    write.println("</body>");
                    write.println("</html>");
                }
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
            }

            viewWindow visorHtml = new viewWindow();
            File rec = new File(htmlUsuarios);
            try {
                visorHtml.edPaneWeb.setPage(rec.toURI().toURL());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
            }
            visorHtml.setVisible(true);
        }
    }

    private String creartabla() {
        String tabla = "";
        for (int i = 0; i < this.longitud; i++) {
            if (this.usuarios[i] != null) {
                tabla += "<TR><TD>" + i + "</TD><TD>" + usuarios[i].getUserS() + "</TD><TD>" + usuarios[i].getPassword() + "</TD></TR>\n";
            } else {
                tabla += "<TR><TD>" + i + "</TD><TD></TD><TD></TD></TR>";
            }
        }
        return tabla;
    }

    private void crearImagen(String dirDot, String dirPng) {
        try {
            ProcessBuilder pbuild = new ProcessBuilder("dot", "-Tpng", "-o", dirPng, dirDot);
            pbuild.redirectErrorStream(true);
            pbuild.start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el reporte de usuarios." + e, "Error con los usuarios.", JOptionPane.ERROR_MESSAGE);
        }
    }

}
