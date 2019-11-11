package estructuras;

public class nodoArchivo {

    private String nombre;    
    private String contenido;
    private String timeStamp;
    private String propietario;
    private nodoArchivo left;
    private nodoArchivo right;
    private int altura;

    public nodoArchivo(String nombre, String contenido, String propietario, String timeStamp) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.timeStamp = timeStamp;
        this.propietario = propietario;
        this.altura = 0;
        this.left = null;
        this.right = null;
    }    
    
    public String getPropietario(){
        return this.propietario;
    }
    
    public void setPropietario(String propietario){
        this.propietario = propietario;
    }
    
    public int getAltura(){
        return this.altura;
    }
    
    public void setAltura(int altura){
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
    
    public String getTimeStamp(){
        return this.timeStamp;
    }
    
    public void setTimeStamp(String timeStamp){
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
