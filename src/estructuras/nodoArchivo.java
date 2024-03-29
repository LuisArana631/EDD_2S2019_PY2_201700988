package estructuras;

public class nodoArchivo {

    private String nombre;
    private String extension;
    private String contenido;
    private String timeStamp;
    private String propietario;
    private nodoArchivo left;
    private nodoArchivo right;
    private nodoArchivo siguiente;
    private int altura;

    public nodoArchivo(String nombre, String extension, String contenido, String propietario, String timeStamp) {
        this.nombre = nombre;
        this.extension = extension;
        this.contenido = contenido;
        this.timeStamp = timeStamp;
        this.propietario = propietario;
        this.altura = 0;
        this.left = null;
        this.right = null;
        this.siguiente = null;
    }

    public nodoArchivo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoArchivo siguiente) {
        this.siguiente = siguiente;
    }
        
    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPropietario() {
        return this.propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
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

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
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
