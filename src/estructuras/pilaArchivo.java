package estructuras;

public class pilaArchivo {

    private nodoArchivo inicio;

    public pilaArchivo() {
        this.inicio = null;
    }

    public nodoArchivo getInicio() {
        return inicio;
    }

    public void setInicio(nodoArchivo inicio) {
        this.inicio = inicio;
    }

    public boolean vacio() {
        return this.inicio == null;
    }
        
    public void push(nodoArchivo nodo) {        
        if (!vacio()) {
            nodo.setSiguiente(this.inicio);
        }
        this.inicio = nodo;
    }

    public nodoArchivo pop() {
        if (!vacio()) {
            nodoArchivo ret = this.inicio;
            this.inicio = this.inicio.getSiguiente();

            return ret;
        }
        return null;
    }

}
