/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author karie
 */
public class ListaDobleCircular <T>{
      private NodoDoble<T> lista;

    public ListaDobleCircular() {
        lista=null;
    }
    
    //METODO PARA SABER SI ESTA VACIO
    public boolean isEmpty(){
        //SI LA LISTA ES NULA, PUES ESTA VACIA
        if(lista==null){
            return true;
        }else{
            return false;
        }
    }
    
    public <T extends Comparable> void insertar(T dato) {

        //creamos el nodo para guardar el dato
        NodoDoble nodito = new NodoDoble(dato);
        if (isEmpty()) { //caso para lista vacìa
            lista = nodito;//la lista sera el nodo
            nodito.setSiguiente(lista);//Agregar
            nodito.setAnterior(lista);//Agregar

            //comparamos el dato que tenemos en la lista    
        } else if (dato.compareTo(lista.getDato()) < 0) { //caso para insertar al inicio
            NodoDoble ultimo = ultimo();
            nodito.setSiguiente(lista);
            //linea para la conexion doble
            lista.setAnterior(nodito); //agregar
            lista = nodito;
            ultimo.setSiguiente(lista);
            lista.setAnterior(ultimo);

        } else {
            NodoDoble anterior = ubicar(dato); //para almacenar al final y entre dos nodos
            nodito.setSiguiente(anterior.getSiguiente());
            //entra al nodo anterior
            anterior.getSiguiente().setAnterior(nodito);

            anterior.setSiguiente(nodito);
            nodito.setAnterior(anterior); //agregar

            }
        }
        
    
            
    public <T extends Comparable> NodoDoble ubicar(T dato){    
        NodoDoble anterior = lista;
        NodoDoble aux=lista;
        while(aux.getSiguiente()!= lista && dato.compareTo(aux.getDato())>0 ){
            
            anterior=aux;
            aux=aux.getSiguiente();
                
        }
         if(dato.compareTo(aux.getDato())>0){   
        return aux;    
         }
         
         return anterior;
    }      
            
    //METODO PARA CONVERTIR A ARRAY LA LISTA
    //ASCENDENTE
    public ArrayList<T> toArrayAsc(){
        //COMO HACEMOS UN METODO DE LISTA SIMPLE, SOLO NOS MOVEMOS EN UNA SOLA DIRECCION
        //POR LO TANTO EL METODO toArray ES EL MISMO QUE EN LAS OTRAS ESTRUCTURAS
        ArrayList listaSimple = new ArrayList<>();
        //USAMOS EL NODO PARA TOMAR TODO EL NODO
        //NO SOLO EL VALOR QUE CONTIENE LA PILITA
        NodoDoble aux = lista;
        //PARA RECORRER LA PILA USAMOS UN WHILE CON UNA VARIABLE AUXILIAR
        //POR QUE LA PILITA NO LA PODEMOS MOVER DE POSICION POR QUE PARA HACERLO TENDRIAMOS QUE ELIMINAR LOS NODOS
       if(isEmpty()) return null;
       do{
          //AGREGAMOS EL DATO A LA LISTA 
            listaSimple.add(aux.getDato());
            //Y PASAMOS AL AUXILIAR AL SIGUIENTE DATO
            aux=aux.getSiguiente(); 
       }while((aux != lista));
            
        return listaSimple;
    }
    
     public <T> NodoDoble ultimo(){ 
        NodoDoble aux=lista;
        if(isEmpty()){
            return null;
        }
        while(aux.getSiguiente() != lista){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    //DESCENDIENTE

     public ArrayList<T> toArrayDes(){
        //COMO HACEMOS UN METODO DE LISTA SIMPLE, SOLO NOS MOVEMOS EN UNA SOLA DIRECCION
        //POR LO TANTO EL METODO toArray ES EL MISMO QUE EN LAS OTRAS ESTRUCTURAS
        ArrayList listaSimple = new ArrayList<>();
        //USAMOS EL NODO PARA TOMAR TODO EL NODO
        //NO SOLO EL VALOR QUE CONTIENE LA PILITA
        NodoDoble aux = ultimo();
        //PARA RECORRER LA PILA USAMOS UN WHILE CON UNA VARIABLE AUXILIAR
        //POR QUE LA PILITA NO LA PODEMOS MOVER DE POSICION POR QUE PARA HACERLO TENDRIAMOS QUE ELIMINAR LOS NODOS
        if(isEmpty()) return null;
        do{
              //AGREGAMOS EL DATO A LA LISTA 
            listaSimple.add(aux.getDato());
            //Y PASAMOS AL AUXILIAR AL SIGUIENTE DATO
            aux=aux.getAnterior();
        } while(aux != lista.getAnterior());
        return listaSimple;
    }
    
    
    //obligando que si vamos a trabajar con clases esta obligando a que tenga el metodo compareble to
    public <T extends Comparable>NodoDoble buscarNodo(T dato){
       //Nodo anterior=lista;
       NodoDoble aux=lista;
       do{
           if(dato.compareTo(aux.getDato())==0){
               return aux;
           }
           aux=aux.getSiguiente();
       }while(aux != lista );
    return null;
    }
    //LOGICA DEL METODO BUSCAR
    //UN WHILE PARA RECORRER, DENTRO DEL WHILE DEBE ESTAR LA LISTA, Y UN IF PARA COMPARAR EL DATO QUE ESTOY BUSCANDO
    //CON LOS DATOS QUE TENGO EN LA LISTA
    //UN IF PARA HACER LA COMPARACION
    //REVISAR EL EJEMPLO DE LISTA ORDENADA, DE LAS PRIMERAS CLASES
    //public class ListaOrdenada <T extends Comparable>{ , DEBEMOS RESTRINGIR A Comparable
     public <T extends Comparable>T buscarDato(T dato){
      // Nodo anterior=lista;
     NodoDoble aux=lista;
       do{
           if(dato.compareTo(aux.getDato())==0){
               return (T) aux.getDato();
           }
           aux=aux.getSiguiente();
       }while(aux != lista );
    return null;
    }
     
     public<T extends Comparable>void eliminar(T dato){
        NodoDoble q = buscarNodo(dato);
        if(q!=null){
           if(q==lista) { //condicion de un nodo
               if(lista.getSiguiente() != lista){
                   NodoDoble ultimo = ultimo();
                   lista = q.getSiguiente();//lista que tiene el siguiente
               //eliminamos los enlaces
               //}if(lista!=null){
               lista.setAnterior(q.getAnterior());
               ultimo.setSiguiente(lista);
               }
               else{
                   lista = null;
               }
          }else{
               NodoDoble anterior=ubicar(dato);
               anterior.setSiguiente(q.getSiguiente());
               //if(q.getSiguiente()!= null){
               q.getSiguiente().setAnterior(anterior);
              // }
           }
        }
        q=null;
        
     }

}
