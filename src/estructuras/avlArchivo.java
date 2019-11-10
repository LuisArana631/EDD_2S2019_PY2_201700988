package estructuras;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class avlArchivo {

    private nodoArchivo raiz;

    private boolean arbolVacio() {
        return this.raiz == null;
    }

    private int altura(nodoArchivo nodo) {
        if (arbolVacio()) {
            return -1;
        }

        return nodo.getAltura();
    }

    private int getBalance(nodoArchivo nodo) {
        if (arbolVacio()) {
            return 0;
        }

        return altura(nodo.getLeft()) - altura(nodo.getRight());
    }

    private nodoArchivo RotacionDerecha(nodoArchivo nodo) {
        nodoArchivo tempIzquierdaNodo = nodo.getLeft();
        nodoArchivo tempT = tempIzquierdaNodo.getRight();

        tempIzquierdaNodo.setRight(nodo);
        nodo.setLeft(tempT);

        nodo.setAltura(Math.max(altura(nodo.getLeft()), altura(nodo.getRight())) + 1);
        tempIzquierdaNodo.setAltura(Math.max(altura(tempIzquierdaNodo.getLeft()), altura(tempIzquierdaNodo.getRight())) + 1);

        return tempIzquierdaNodo;
    }

    private nodoArchivo RotacionIzquierda(nodoArchivo nodo) {
        nodoArchivo tempDerechaNodo = nodo.getRight();
        nodoArchivo tempT = tempDerechaNodo.getLeft();

        tempDerechaNodo.setLeft(nodo);
        nodo.setRight(tempT);

        nodo.setAltura(Math.max(altura(nodo.getLeft()), altura(nodo.getRight())) + 1);
        tempDerechaNodo.setAltura(Math.max(altura(tempDerechaNodo.getLeft()), altura(tempDerechaNodo.getRight())) + 1);

        return tempDerechaNodo;
    }

    public void insertar(String nombre, String contenido) {
        //Obtener hora y fecha del momento de insercion
        Date datePull = new Date();
        DateFormat dateHour = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
        String timeStamp = dateHour.format(datePull);
        //Enviar datos al metodo insert
        this.raiz = insert(this.raiz,nombre, contenido, timeStamp);
    }

    private nodoArchivo insert(nodoArchivo nodo, String nombre, String contenido, String timeStamp) {
        if (arbolVacio()) {
            return new nodoArchivo(nombre, contenido, timeStamp);
        }
        
        
        
        return null;
    }
}
