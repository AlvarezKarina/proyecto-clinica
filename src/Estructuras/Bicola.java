/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author herna
 */
public class Bicola <T>{
    //VARIABLES
    private Nodo<T> frente;
    private Nodo<T> fin;

    public Bicola() {
        //COLA VACIA
        this.frente = null;
        this.fin = null;
    }
         
    
    public boolean isEmpty(){
        return frente==null;
    }
    
    //METODO PARA VER LOS ELEMENTOS DE LA COLA
    public ArrayList<T> toArray(){
        //PRIMERO DECLARAMOS EL ARRAYLIST
        ArrayList lista = new ArrayList();
        
        //USAMOS EL NODO PARA TOMAR TODO EL NODO
        //NO SOLO EL VALOR QUE CONTIENE LA COLA
        Nodo<T> aux = frente;
        //PARA RECORRER LA PILA USAMOS UN WHILE CON UNA VARIABLE AUXILIAR
        //POR QUE LA PILITA NO LA PODEMOS MOVER DE POSICION POR QUE PARA HACERLO TENDRIAMOS QUE ELIMINAR LOS NODOS
        while(aux!=null){
            //AGREGAMOS EL DATO A LA LISTA 
            lista.add(aux.getDato());
            //Y PASAMOS AL AUXILIAR AL SIGUIENTE DATO
            aux=aux.getSiguiente();
        }
        return lista;
    }
    
    public T peek(){
        T aux = null;
   
        if(!isEmpty()){//SI LA PILITA NO ESTA VACIA
            aux = frente.getDato();
        }
        return aux;//SI NO DEVOLVERA VACIO
    }
    
    //METODO PARA GUARDAR EN LA COLA
    public void offer(T dato){
        //CREAMOS UN NODO
        Nodo nodo = new Nodo(dato);
        if (isEmpty()) {
            //SI ESTA VACIA LA COLA 
            //PARA INGRESAR EL PRIMER DATO APUNTAMOS EL FRENTE Y EL FIN HACIA EL PRIMER NODO
            frente = nodo;
            fin = nodo;
        }else{
            //MANDAMOS EL nodo AL SIGUIENTE NODO
            fin.setSiguiente(nodo);
            //Y PASAMOS EL FIN HACIA ESE ULTIMO NODO QUE AGREGAMOS
            fin=fin.getSiguiente();
        }
    }
    
    //METODO PARA ELIMINAR 
    public T poll(){
        //SI ESTA VACIA NO RETORNARA NADA
        if (isEmpty()) {
            return null;
        }
        //SI TIENE DATOS GUARDAREMOS EL DATO QUE ESTA EN EL FRENTE EN UNA VARIABLE DE TIPO NODO
        T aux = frente.getDato();
        //PASAMOS EL FRENTE AL SIGUIENTE NODO
        frente = frente.getSiguiente();
        
        //SI ESTAMOS EN EL ULTIMO NODO Y QUEREMOS QUE SE ELIMINE
        //MANDAMOS A FIN NULL
        if (frente==null) {
            fin=null;
        }
        return (T) aux;
    }
    
    //METODO PARA SACAR DEL FRENTE DE LA COLA
    public T pollFirst(){
        return poll();
    }
    //METODO PARA INGRESAR POR EL FIN DE LA COLA
    public void offerLast(T dato){
        offer(dato);
    }
    
    //METODO PARA INGRESAR POR EL FRENTE DE LA COLA
    public void offerFirst(T dato){
        Nodo nodo = new Nodo(dato,frente);
        frente = nodo;
        
        if(fin==null){
            //SI ESTA VACIO HACEMOS QUE FIN Y FRENTE APUNTEN AL MISMO NODO
            fin = frente;
        }
    }
    //MEOTODO PARA SACAR POR EL FINAL DE LA COLA
    public T pollLast(){
        //REVISAMOS QUE  LA COLA NO ESTE  VACIA
        if (isEmpty()) {
            return null;
        }
        //SI EL FRENTE ESTA EN EL MISMO NODO QUE FIN
        //LO SACAMOS DE MANERA NORMAL
        if (frente==fin) {
            return poll();
        }else{
            //TOMAMOS EL DATO QUE ESTA AL FINAL DE LA COLA
        T aux = fin.getDato();
        
        //FORMULA PARA QUE MOVER EL FIN UNA POSICION ANTES DE DONDE ESTABA PARA PODER ELIMINAR EL NODO FINAL
        while(fin.getSiguiente().getSiguiente() !=null){
            fin=fin.getSiguiente();
        }
        
        fin.setSiguiente(null);
        return aux;
        }
        
    }
}