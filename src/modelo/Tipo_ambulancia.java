package modelo;


import modelo.Ambulancia;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karie
 */
public class Tipo_ambulancia {
    
    private int id_tipo_ambulancia;
    private String nombre_tipo;
    ArrayList<Ambulancia> ambulancia;

    public Tipo_ambulancia() {
    }
    
    

    public Tipo_ambulancia(int id_tipo_ambulancia) {
        this.id_tipo_ambulancia = id_tipo_ambulancia;
    }

    public Tipo_ambulancia(int id_tipo_ambulancia, String nombre_tipo, ArrayList<Ambulancia> ambulancia) {
        this.id_tipo_ambulancia = id_tipo_ambulancia;
        this.nombre_tipo = nombre_tipo;
        this.ambulancia = ambulancia;
    }

    public Tipo_ambulancia(int id_tipo_ambulancia, String nombre_tipo) {
        this.id_tipo_ambulancia = id_tipo_ambulancia;
        this.nombre_tipo = nombre_tipo;
    }
    
    

    public int getId_tipo_ambulancia() {
        return id_tipo_ambulancia;
    }

    public void setId_tipo_ambulancia(int id_tipo_ambulancia) {
        this.id_tipo_ambulancia = id_tipo_ambulancia;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public ArrayList<Ambulancia> getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(ArrayList<Ambulancia> ambulancia) {
        this.ambulancia = ambulancia;
    }

    void add(Tipo_ambulancia ti) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
