package modelo;


import modelo.Conductor;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karie
 */
public class Licencia {
    
    private int licencia;
    private String tipo_licencia;
    ArrayList<Conductor> conductor;

    public Licencia() {
    }

    public Licencia(int licencia) {
        this.licencia = licencia;
    }

    public Licencia(int licencia, String tipo_licencia, ArrayList<Conductor> conductor) {
        this.licencia = licencia;
        this.tipo_licencia = tipo_licencia;
        this.conductor = conductor;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public ArrayList<Conductor> getConductor() {
        return conductor;
    }

    public void setConductor(ArrayList<Conductor> conductor) {
        this.conductor = conductor;
    }

    
    
    
}
