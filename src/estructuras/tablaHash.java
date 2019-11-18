package estructuras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import software.edd.driver.SoftwareEDDDriver;
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
        SoftwareEDDDriver.bitacora.push(user, "Registrarse.");
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
        return (double) ((double) this.cantidad / (double) this.longitud) > 0.75;
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

            try ( PrintWriter write = new PrintWriter(rutaDot, "UTF-8")) {
                write.println("digraph usuarios {");
                write.println("label=\"Usuarios\";");
                write.println("graph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
                write.println("node [shape=plain];");
                write.println("rankdir=LR;");
                write.println("tablaHash [label=<");
                write.println("<TABLE border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
                write.println("<TR><TD>No.</TD><TD>Usuarios</TD><TD>Password</TD><TD>TimeStamp</TD></TR>");
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
                try ( PrintWriter write = new PrintWriter(htmlUsuarios, "UTF-8")) {
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
                visorHtml.lblNombre.setText("Reporte de Usuarios");
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
                tabla += "<TR><TD>" + i + "</TD><TD>" + this.usuarios[i].getUserS() + "</TD><TD>" + this.usuarios[i].getPassword() + "</TD><TD>" + usuarios[i].getTimeStamp() + "</TD></TR>\r\n";
            } else {
                tabla += "<TR><TD>" + i + "</TD><TD></TD><TD></TD><TD></TD></TR>\r\n";
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

    private String encriptarContraseña(String password) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "Error al encriptar contraseña.", "Error con contraseña.", JOptionPane.ERROR_MESSAGE);
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuilder bf = new StringBuilder();

        for (byte b : hash) {
            bf.append(String.format("%02x", b));
        }

        return bf.toString();
    }

    private int codificarUser(String user) {
        int codigo = 0;

        for (int i = 0; i < user.length(); i++) {
            char caracter = user.charAt(i);

            codigo += caracter;
        }

        return codigo;
    }

    public boolean usuarioExiste(String user) {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    return true;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return false;
            }
        } while (indice != indiceTemp);

        if (indice == indiceTemp && intento > 0) {
            indice = 0;
            int recorrido = 0;
            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        return true;
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return false;
                }
            }

        }

        return this.usuarios[indice] != null;
    }

    public boolean verificarCredenciales(String user, String password) {
        String passVerificar = encriptarContraseña(password);
        int userVerificar = codificarUser(user);
        int intento = 0;

        int indiceBuscar = funcionH(userVerificar, intento);
        int indiceTemp = indiceBuscar;

        do {
            if (this.usuarios[indiceBuscar] != null) {
                if (this.usuarios[indiceBuscar].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    return this.usuarios[indiceBuscar].getPassword().equals(passVerificar);
                } else {
                    intento++;
                    indiceBuscar = funcionH(userVerificar, intento);

                    while (indiceBuscar >= this.longitud) {
                        indiceBuscar = indiceBuscar - this.longitud;
                    }
                }
            } else {
                return false;
            }
        } while (indiceBuscar != indiceTemp);

        if (indiceBuscar == indiceTemp && intento > 0) {
            indiceBuscar = 0;
            int recorrido = 0;
            while (recorrido < this.longitud) {
                if (this.usuarios[indiceBuscar] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indiceBuscar].getUserS().equals(user)) {
                        return true;
                    }
                }

                indiceBuscar++;
                while (indiceBuscar >= this.longitud) {
                    indiceBuscar = indiceBuscar - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return false;
                }
            }

        }

        if (this.usuarios[indiceBuscar] != null) {
            return this.usuarios[indiceBuscar].getPassword().equals(passVerificar);
        } else {
            return false;
        }
    }

    public void insertarCarpeta(String carpetaActual, String nuevaCarpeta, String user) {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().carpetaInterior(nuevaCarpeta, carpetaActual);
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().carpetaInterior(nuevaCarpeta, carpetaActual);
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            this.usuarios[indice].getCarpetas().carpetaInterior(nuevaCarpeta, carpetaActual);
        }

    }

    public void mostrarContenido(String user, String carpeta, JPanel panel) {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().visualizarCarpeta(panel, carpeta);
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().visualizarCarpeta(panel, carpeta);
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            //Si encontramos al usuario
            this.usuarios[indice].getCarpetas().visualizarCarpeta(panel, carpeta);
        }

    }

    public void insertarArchivo(String nombreArchivo, String extension, String contenido, String carpeta, String user) {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().insertarArchivo(nombreArchivo, extension, contenido, carpeta);
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().insertarArchivo(nombreArchivo, extension, contenido, carpeta);
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            this.usuarios[indice].getCarpetas().insertarArchivo(nombreArchivo, extension, contenido, carpeta);
        }

    }

    public String[] usuariosCbo(String user) {
        String[] usuarioCbo = new String[this.cantidad - 1];
        int conteo = 0;

        for (int i = 0; i < this.longitud; i++) {
            if (this.usuarios[i] != null) {
                if (!this.usuarios[i].getUserS().equals(user)) {
                    usuarioCbo[conteo] = this.usuarios[i].getUserS();
                    conteo++;
                }
            }
        }

        return usuarioCbo;
    }

    public void avlArchivo(String carpeta, String user) throws IOException {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().arbolArchivo(carpeta);
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().arbolArchivo(carpeta);
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            this.usuarios[indice].getCarpetas().arbolArchivo(carpeta);
        }

    }

    public void matrizCarpetas(String user) throws IOException {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().graficarMatriz();
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().graficarMatriz();
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            this.usuarios[indice].getCarpetas().graficarMatriz();
        }

    }

    public void listaCarpetas(String user) throws IOException {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().graficarLista();
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().graficarLista();
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            this.usuarios[indice].getCarpetas().graficarLista();
        }

    }

    public void grafoCarpetas(String user) throws IOException {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().graficarGrafo();
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().graficarGrafo();
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            this.usuarios[indice].getCarpetas().graficarGrafo();
        }

    }

    public void eliminarCarpeta(String user, String carpeta) {
        int userVerificar = codificarUser(user);
        int intento = 0;
        int indice = funcionH(userVerificar, intento);
        int indiceTemp = indice;

        do {
            if (this.usuarios[indice] != null) {
                if (this.usuarios[indice].getUserS().equals(user)) {
                    //Si encontramos al usuario
                    this.usuarios[indice].getCarpetas().eliminarCarpeta(carpeta);
                    return;
                } else {
                    intento++;
                    indice = funcionH(userVerificar, intento);

                    while (indice >= this.longitud) {
                        indice = indice - this.longitud;
                    }
                }
            } else {
                return;
            }
        } while (indice != indiceTemp);

        int recorrido = 0;

        if (indice == indiceTemp && intento > 0) {
            indice = 0;

            while (recorrido < this.longitud) {
                if (this.usuarios[indice] == null) {
                    //No validar
                } else {
                    if (this.usuarios[indice].getUserS().equals(user)) {
                        this.usuarios[indice].getCarpetas().eliminarCarpeta(carpeta);
                    }
                }

                indice++;
                while (indice >= this.longitud) {
                    indice = indice - this.longitud;
                }
                if (recorrido < this.longitud) {
                    recorrido++;
                } else {
                    return;
                }
            }

        }

        if (this.usuarios[indice] != null) {
            this.usuarios[indice].getCarpetas().eliminarCarpeta(carpeta);
        }

    }

}
