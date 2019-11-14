package estructuras;

public class listaSimpleCarpeta {

    private nodoSimpleCarpeta inicio;

    public listaSimpleCarpeta() {
        this.inicio = null;
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
            nuevo.setNext(this.inicio);
        }
        this.inicio = nuevo;

    }
    
    public void mostrarCarpetas(){
        nodoSimpleCarpeta aux = this.inicio;
        while(aux!=null){
            System.out.println("Carpeta: "+aux.getNombre());
            aux = aux.getNext();
        }
    }

    public void eliminar(String nombre) {
        nodoSimpleCarpeta aux = this.inicio;
        nodoSimpleCarpeta aux2 = null;

        while (!nombre.equals(aux.getNombre())) {
            aux2 = aux;
            aux = aux.getNext();
        }

        if(aux2==null){
            this.inicio = this.inicio.getNext();
        }else{
            aux2.setNext(aux.getNext());
            aux.setNext(null);
        }
        
    }

}
