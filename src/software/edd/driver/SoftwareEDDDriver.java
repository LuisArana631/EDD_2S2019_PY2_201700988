package software.edd.driver;

import estructuras.listaDobleCarpeta;
import estructuras.listaError;
import estructuras.pila;
import estructuras.tablaHash;
import java.io.IOException;
import ventanas.initialWindow;

public class SoftwareEDDDriver {

    //Nombre de usuario y carpeta actual
    public static String userLog = "Luis";
    public static String folderLog = "";
    public static String fileLog = "";
    //Estructuras globales
    public static pila bitacora = new pila();
    public static tablaHash usuarios = new tablaHash(7);
    public static listaError errores = new listaError();

    public static void main(String[] args) throws IOException {
        /*
        ventanas.loginWindow login = new ventanas.loginWindow();
        login.setVisible(true);
        usuarios.insertHash("ADMIN", "ADMIN");
        */
        
        initialWindow prueba = new initialWindow();
        prueba.setVisible(true);
        prueba.lblUser.setText("Prueba");        
        
        listaDobleCarpeta carpetas = new listaDobleCarpeta();
        carpetas.insertar("raiz");
        carpetas.carpetaInterior("Carpeta1", "raiz");
        carpetas.carpetaInterior("Carpeta2", "raiz");
        carpetas.carpetaInterior("Carpeta3", "raiz");        
        carpetas.visualizarCarpeta(prueba.panelVisual,"raiz");
        prueba.panelVisual.repaint();
    }

}
