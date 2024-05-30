/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author karie
 */
public class NodoDoble <T>{
    
   
//LO CONVERTIMOS A TIPO GENERICO
    //ATRIBUTOS
    private T dato;
    //CREAMOS LOS DOS NODOS
    private NodoDoble<T> anterior;
    private NodoDoble<T> siguiente;

    public NodoDoble(T dato) {
        this.dato = dato;
        //SI SOLO MANDAMOS EL DATO LOS NODOS ESTARAN VACIOS
        this.anterior=null;
        this.siguiente=null;
    }
    
    //SOBRECARGAMOS EL METODO

    public NodoDoble(T dato, NodoDoble<T> anterior, NodoDoble<T> siguiente) {
        this.dato = dato;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    
    //GETTERS Y SETTERS

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
   
    
}