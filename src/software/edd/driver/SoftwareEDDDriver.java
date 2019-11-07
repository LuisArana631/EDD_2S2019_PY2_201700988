
package software.edd.driver;

import estructuras.pila;
import estructuras.tablaHash;
import java.io.IOException;

public class SoftwareEDDDriver {
    
    public String userLog = "";
    public pila prueba = new pila();
    
    public static void main(String[] args) throws IOException {    
       ventanas.loginWindow login = new ventanas.loginWindow();
       login.setVisible(true);   
       
       tablaHash usuarios = new tablaHash(7);
       pila bitacora  = new pila();
       
       bitacora.push("Luis", "asfasf");
       bitacora.push("Melani", "asfasf");       
       //bitacora.graficar();
       
       usuarios.insertHash("Luis", "0123", 0);
       usuarios.insertHash("wqrwqr", "0123", 0);
       usuarios.insertHash("asfasf", "01234", 2);
       usuarios.insertHash("leighbunbun", "01234", 4);
       usuarios.insertHash("asfasf2", "01234", 3);
       usuarios.insertHash("Samael", "asfasf", 0);
       //usuarios.insertHash("FAsfa", "asfasf", 45);
       //usuarios.insertHash("Asfasfasfasfa", "asfasf", 45);
       
            
       
       usuarios.graficar();
       
    }
    
}
