package estructuras;

public class pilaArchivo {

    private nodoArchivo inicio;
    private int conteo;

    public pilaArchivo() {
        this.inicio = null;
        this.conteo = 0;
    }

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
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
        this.conteo++;
        this.inicio = nodo;
    }

    public void pop() {
        if (!vacio()) {
            if(this.conteo==1){
                this.inicio = null;
            }else{
                this.inicio = this.inicio.getSiguiente();
            }
            conteo--;
        }
    }

}
