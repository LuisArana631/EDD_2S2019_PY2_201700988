package estructuras;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class listaError {

    private nodoSimpleError inicio;
    private nodoSimpleError fin;
    private int longitud;

    public listaError() {
        this.inicio = null;
        this.fin = null;
        this.longitud = 0;
    }

    private boolean listaVacia() {
        return this.inicio != null;
    }

    public void insertar(String user, String password, String motivo) {
        nodoSimpleError nuevo = new nodoSimpleError(user, password, motivo);

        if (listaVacia()) {
            this.fin.setNext(nuevo);
        } else {
            this.inicio = nuevo;
        }

        this.fin = nuevo;
    }
    
    public void graficar() throws IOException{
        if(listaVacia()){
            String ruta = System.getProperty("user.home");
            ruta += "\\Desktop\\Reports";
            File carpeta = new File(ruta);
            
            if(!carpeta.exists()){
                if(!carpeta.mkdirs()){
                    JOptionPane.showMessageDialog(null, "Error al crear la carpeta de Reportes.", "Error con Carpeta.", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            String rutaDot = ruta + "\\Errores.dot";
            File archivo = new File(rutaDot);
            
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            
            try{
                try (PrintWriter write = new PrintWriter(rutaDot, "UTF-8")) {
                    write.println("digraph errores {");
                    write.println("label=\"Usuarios con error\";");
                    
                }
            }catch(Exception e){
                
            }
            
            
        }
    }

    public void setInicio(nodoSimpleError inicio) {
        this.inicio = inicio;
    }

    public nodoSimpleError getInicio() {
        return this.inicio;
    }

    public void setFin(nodoSimpleError fin) {
        this.fin = fin;
    }

    public nodoSimpleError getFin() {
        return this.fin;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return this.longitud;
    }

}
