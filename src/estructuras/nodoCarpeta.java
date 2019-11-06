package estructuras;

public class nodoCarpeta {

    private String nombreCarpeta;
    private nodoCarpeta next;
    private nodoCarpeta previous;

    public nodoCarpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
        this.next = null;
        this.previous = null;
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
