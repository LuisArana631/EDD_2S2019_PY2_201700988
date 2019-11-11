package estructuras;

public class nodoSimpleCarpeta {
    
    private String nombre;
    private nodoSimpleCarpeta next;
    
    public nodoSimpleCarpeta(String nombre){
        this.nombre = nombre;
        this.next = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public nodoSimpleCarpeta getNext() {
        return next;
    }

    public void setNext(nodoSimpleCarpeta next) {
        this.next = next;
    }
    
    

}
