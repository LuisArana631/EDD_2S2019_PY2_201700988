package software.edd.driver;

import estructuras.listaError;
import estructuras.pila;
import estructuras.tablaHash;
import java.io.IOException;
import javax.swing.JPanel;

public class SoftwareEDDDriver {

    //Panel para el creador de archivos
    public static JPanel panel;
    //Nombre de usuario y carpeta actual
    public static String userLog = "Luis";
    public static String folderLog = "";
    public static String prevFolder = "";
    public static String fileLog = "";
    //Estructuras globales
    public static pila bitacora = new pila();
    public static tablaHash usuarios = new tablaHash(7);
    public static listaError errores = new listaError();

    public static void main(String[] args) throws IOException {

        ventanas.loginWindow login = new ventanas.loginWindow();
        login.setVisible(true);
        usuarios.insertHash("ADMIN", "ADMIN");

    }

}
