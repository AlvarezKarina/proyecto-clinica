package Estructuras;



import java.util.ArrayList;

/**
 *
 * @author karie
 */
public class ListaOrdenada<T extends Comparable> {
   

    private ArrayList lista;

    public ListaOrdenada() {
        this.lista = new ArrayList();
    }

    public T get(int index) {
//        if (lista.isEmpty()) {
//            return (T) "Lista Vacia";
//        }
        if (lista.size() > index) {

            return (T) lista.get(index);
        }
//        return (T) lista.get(index);
        return (T) "No Existe";
    }

    public int size() {
        return lista.size();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public boolean remove(T o) {
        return lista.remove(o);
    }

   
    public int indexOf(T o) {
        return lista.indexOf(o);
    }

    public ArrayList getLista() {
        return lista;
    }

    public void add(T o) {
        for (int i = 0; i < lista.size(); i++) {
            if (o.compareTo(lista.get(i)) < 0) {
                lista.add(i, o);
                return;
            }
        }
        lista.add(o);
    }
}
