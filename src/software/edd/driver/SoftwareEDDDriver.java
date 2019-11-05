
package software.edd.driver;

import estructuras.pila;
import java.io.IOException;

public class SoftwareEDDDriver {
    
    public String userLog = "";
    
    public static void main(String[] args) throws IOException {    
       ventanas.loginWindow login = new ventanas.loginWindow();
       login.setVisible(true);    
       
       pila prueba = new pila();
       
       prueba.push("Luis", "Modificar");
       prueba.push("Melani", "Sexo Rico");
       prueba.push("Luis2", "Coger Melani");
       
       prueba.graficar();
    }
    
}
