package software.edd.driver;

import estructuras.listaError;
import estructuras.nodoHash;
import estructuras.pila;
import estructuras.tablaHash;
import java.io.IOException;

public class SoftwareEDDDriver {

    //Nombre de usuario y carpeta actual
    public static String userLog = "";
    public static String fileLog = "";
    //Nodo de carpeta y usuario actual
    public static nodoHash userActual;
    //Estructuras globales
    public static pila bitacora = new pila();
    public static tablaHash usuarios = new tablaHash(7);
    public static listaError errores =  new listaError();

    public static void main(String[] args) throws IOException {
        ventanas.loginWindow login = new ventanas.loginWindow();
        login.setVisible(true);
        usuarios.insertHash("ADMIN", "ADMIN");        
    }

}
