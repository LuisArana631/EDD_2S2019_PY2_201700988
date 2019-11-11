package estructuras;

public class listaSimpleCarpeta {

    private nodoSimpleCarpeta inicio;

    public listaSimpleCarpeta() {
        this.inicio = null;
    }

    public boolean listaVacia() {
        return this.inicio == null;
    }

    public void insertar(String nombre) {
        nodoSimpleCarpeta nuevo = new nodoSimpleCarpeta(nombre);
        if (!listaVacia()) {
            nuevo.setNext(nuevo);
        } else {
            this.inicio = nuevo;
        }
    }

    public void eliminar(String nombre) {
        nodoSimpleCarpeta aux = this.inicio;
        nodoSimpleCarpeta aux2 = null;

        while (!nombre.equals(aux.getNombre())) {
            aux2 = aux;
            aux = aux.getNext();
        }
        
        aux2.setNext(aux.getNext()); 
    }

}
