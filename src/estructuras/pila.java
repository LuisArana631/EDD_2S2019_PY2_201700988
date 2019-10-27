
package estructuras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class pila {
    private nodoPila inicio;
    private nodoPila fin;
    private int longitud = 0;
    
    public Boolean empty(){
        return this.inicio == null;
    }
    
    public void push(String user, String operation, String date){        
        this.longitud++;        
        
        nodoPila nuevo = new nodoPila(user, date, operation);
        
        if (this.empty() == false){
            nuevo.setNext(this.inicio);
            this.inicio = nuevo;
        }else{
            this.inicio = nuevo;
            this.fin = nuevo;
        }
    }
    
    public int size(){
        return this.longitud;
    }
    
    public void graficar() throws IOException{
        if (this.empty() == false){
            String ruta = "C:/Users/Luis Fer/Desktop/Reports";           
                                
            File archivo = new File(ruta);
            BufferedWriter bw;           
                        
            if(archivo.exists()){
                bw = new BufferedWriter(new FileWriter(archivo));
                
            }else{
                bw = new BufferedWriter(new FileWriter(archivo));
                
            }            
            bw.close();
        }
    }
}
