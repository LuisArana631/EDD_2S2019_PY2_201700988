package estructuras;

public class listaDobleCarpeta {

    private nodoCarpeta inicio;
    private nodoCarpeta fin;

    public listaDobleCarpeta() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean listaVacia() {
        return this.inicio == null;
    }

    public void insertar(String nombreCarpeta) {
        nodoCarpeta nuevo = new nodoCarpeta(nombreCarpeta);

        if (listaVacia() != true) {
            this.fin.setNext(nuevo);
            nuevo.setPrevious(this.fin);
        } else {
            this.inicio = nuevo;
        }
        this.fin = nuevo;

    }

    public void eliminar(String nombreCarpeta) {
        if (listaVacia() != true) {
            nodoCarpeta aux = this.inicio;
            while (aux != null) {
                if (aux.getNombreCarpeta().equals(nombreCarpeta)) {
                    nodoCarpeta tempPrev = aux.getPrevious();
                    nodoCarpeta tempNext = aux.getNext();
                    tempPrev.setNext(tempNext);
                    tempNext.setPrevious(tempPrev);
                    aux.setNext(null);
                    aux.setPrevious(null);                    
                }else{
                    aux = aux.getNext();
                }
            }
        }
    }

}
