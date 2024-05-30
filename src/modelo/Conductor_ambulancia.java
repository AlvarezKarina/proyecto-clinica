package modelo;


import modelo.Conductor;
import modelo.Ambulancia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karie
 */
public class Conductor_ambulancia {
    
    private int conductor_ambulancia;
    private Ambulancia ambuelancia;
    private Conductor conductor;

    public Conductor_ambulancia(int conductor_ambulancia) {
        this.conductor_ambulancia = conductor_ambulancia;
    }

    public Conductor_ambulancia(int conductor_ambulancia, Ambulancia ambuelancia, Conductor conductor) {
        this.conductor_ambulancia = conductor_ambulancia;
        this.ambuelancia = ambuelancia;
        this.conductor = conductor;
    }

    public int getConductor_ambulancia() {
        return conductor_ambulancia;
    }

    public void setConductor_ambulancia(int conductor_ambulancia) {
        this.conductor_ambulancia = conductor_ambulancia;
    }

    public Ambulancia getAmbuelancia() {
        return ambuelancia;
    }

    public void setAmbuelancia(Ambulancia ambuelancia) {
        this.ambuelancia = ambuelancia;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
    
    
}
