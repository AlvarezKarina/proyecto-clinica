/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
/**
 *
 * @author Marlo
 */
public class ListaSimple <T>{
    private Nodo <T> lista;

    public ListaSimple() {
        lista = null;
    }
    
    
    public boolean isEmpty(){
       if(lista==null){
           return true;
       }
       return false;
    }
    
    public ArrayList<T> ToArray(){
        ArrayList listaSimple = new ArrayList();
        Nodo aux = lista;
        while(aux!=null){
            listaSimple.add(aux.getDato());
            aux = aux.getSiguiente();
        }
        return listaSimple;
    }
    
    public <T extends Comparable> void insertar(T dato){
        Nodo nodo = new Nodo(dato);
        if(isEmpty()){
            lista = nodo;
        }else{
            if(dato.compareTo(lista.getDato())<0){
                nodo.setSiguiente(lista);
                lista = nodo;
            }else{
                Nodo anterior = ubicar(dato);
                nodo.setSiguiente(anterior.getSiguiente());
                anterior.setSiguiente(nodo);
            }
        }
    }
    
    
    public<T extends Comparable> Nodo ubicar (T dato){
        Nodo anterior = lista;
        Nodo aux = lista;
        while(aux.getSiguiente()!=null && dato.compareTo(aux.getDato())>0){
            anterior = aux;
            aux = aux.getSiguiente();
        }
        if(dato.compareTo(aux.getDato())>0){
            return aux;
        }
        
        return anterior;
    }
    
    
    
    public <T extends Comparable> Nodo buscarNodo(T dato) {

        Nodo aux = lista;

        while (aux != null) {
            if (dato.compareTo(aux.getDato()) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();
        }

        return null;
    }

    public <T extends Comparable> T buscarDato(T dato) {

        Nodo aux = lista;

        while (aux != null) {
            if (dato.compareTo(aux.getDato()) == 0) {
                return (T) aux.getDato();
            }
            aux = aux.getSiguiente();
        }

        return null;
    }

    public <T extends Comparable> void eliminar(T dato) {

        Nodo q = buscarNodo(dato);

        if (q != null) {
            if (q == lista) {
                lista = q.getSiguiente();

            } else {
                Nodo anterior = ubicar(dato);
                anterior.setSiguiente(q.getSiguiente());
            }
        }
        q = null;
    }  
    
   
}
