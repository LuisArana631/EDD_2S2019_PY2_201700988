package estructuras;

public class listaSimpleCarpeta {

    private nodoSimpleCarpeta inicio;
    private nodoSimpleCarpeta fin;
    private int longitud;

    public listaSimpleCarpeta() {
        this.inicio = null;
        this.fin = null;
        this.longitud = 0;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public nodoSimpleCarpeta getFin() {
        return fin;
    }

    public void setFin(nodoSimpleCarpeta fin) {
        this.fin = fin;
    }

    public nodoSimpleCarpeta getInicio() {
        return inicio;
    }

    public void setInicio(nodoSimpleCarpeta inicio) {
        this.inicio = inicio;
    }

    public boolean listaVacia() {
        return this.inicio == null;
    }

    public void insertar(String nombre) {
        nodoSimpleCarpeta nuevo = new nodoSimpleCarpeta(nombre);
        if (!listaVacia()) {
            this.fin.setNext(nuevo);
        } else {
            this.inicio = nuevo;
        }
        this.fin = nuevo;
        this.longitud++;
    }

    public void mostrarCarpetas() {
        nodoSimpleCarpeta aux = this.inicio;
        while (aux != null) {
            System.out.println("Carpeta: " + aux.getNombre());
            aux = aux.getNext();
        }
    }

    public void eliminar(String nombre) {
        nodoSimpleCarpeta aux = this.inicio;
        nodoSimpleCarpeta aux2 = null;

        while (aux != null) {
            if (nombre.equals(aux.getNombre())) {
                break;
            }
            aux2 = aux;
            aux = aux.getNext();
        }

        if (aux2 == null) {
            this.inicio = this.inicio.getNext();
        } else if (aux == this.fin) {
            this.fin = aux2;
            aux2.setNext(null);
        } else {
            aux2.setNext(aux.getNext());
        }
        aux.setNext(null);

        this.longitud--;
    }

}
