package estructuras;

public class nodoArchivo {

    private String nombre;    
    private String contenido;
    private nodoArchivo left;
    private nodoArchivo right;

    public nodoArchivo(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.left = null;
        this.right = null;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public nodoArchivo getLeft() {
        return left;
    }

    public void setLeft(nodoArchivo left) {
        this.left = left;
    }

    public nodoArchivo getRight() {
        return right;
    }

    public void setRight(nodoArchivo right) {
        this.right = right;
    }
    
    
    
}
