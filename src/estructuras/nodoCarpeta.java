package estructuras;

public class nodoCarpeta {

    private String nombreCarpeta;
    private String carpetaPrev;
    private listaSimpleCarpeta carpetas;
    private avlArchivo archivos;
    private nodoCarpeta next;
    private nodoCarpeta previous;

    public nodoCarpeta(String nombreCarpeta, String carpetaPrev) {
        this.nombreCarpeta = nombreCarpeta;
        this.archivos = new avlArchivo();
        this.carpetas = new listaSimpleCarpeta();
        this.carpetaPrev = carpetaPrev;
        this.next = null;
        this.previous = null;
    }        

    public String getCarpetaPrev() {
        return carpetaPrev;
    }

    public void setCarpetaPrev(String carpetaPrev) {
        this.carpetaPrev = carpetaPrev;
    }
    
    
    
    public void insertarCarpetaEnlazada(String nombre){
        this.carpetas.insertar(nombre);
    }
    
    public listaSimpleCarpeta getCarpetas(){
        return this.carpetas;
    }
    
    public void setCarpetas(listaSimpleCarpeta carpetas){
        this.carpetas = carpetas;
    }

    public avlArchivo getArchivos() {
        return this.archivos;
    }

    public void setArchivos(avlArchivo archivos) {
        this.archivos = archivos;
    }

    public String getNombreCarpeta() {
        return this.nombreCarpeta;
    }

    public void setNombreCarpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
    }

    public nodoCarpeta getNext() {
        return next;
    }

    public void setNext(nodoCarpeta next) {
        this.next = next;
    }

    public nodoCarpeta getPrevious() {
        return previous;
    }

    public void setPrevious(nodoCarpeta previous) {
        this.previous = previous;
    }

}
