package software.edd.driver;

import estructuras.nodoHash;
import estructuras.pila;
import estructuras.tablaHash;
import java.io.IOException;

public class SoftwareEDDDriver {

    public static String userLog = "";
    public static nodoHash userActual;
    public static pila bitacora = new pila();
    public static tablaHash usuarios = new tablaHash(7);

    public static void main(String[] args) throws IOException {
        ventanas.loginWindow login = new ventanas.loginWindow();
        login.setVisible(true);
        usuarios.insertHash("ADMIN", "ADMIN");        
    }

}
