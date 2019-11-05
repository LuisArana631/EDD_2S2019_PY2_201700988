
package software.edd.driver;

import estructuras.pila;
import java.io.IOException;

public class SoftwareEDDDriver {
    
    public String userLog = "";
    public pila prueba = new pila();
    
    public static void main(String[] args) throws IOException {    
       ventanas.loginWindow login = new ventanas.loginWindow();
       login.setVisible(true);    
       
    }
    
}
