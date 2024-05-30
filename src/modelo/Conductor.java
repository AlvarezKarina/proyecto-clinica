package modelo;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karie
 */
public class Conductor implements Comparable<Conductor>{
    
    private int conductor;
    private String dui;
    private String nombre;
    private String genero;
    private String numero_licencia;
    Licencia licencia;
    ArrayList<Conductor_ambulancia> conductor_ambulancia;

    public Conductor() {
    }

    public Conductor(int conductor, String dui, String nombre, String genero, String numero_licencia, Licencia licencia, ArrayList<Conductor_ambulancia> conductor_ambulancia) {
        this.conductor = conductor;
        this.dui = dui;
        this.nombre = nombre;
        this.genero = genero;
        this.numero_licencia = numero_licencia;
        this.licencia = licencia;
        this.conductor_ambulancia = conductor_ambulancia;
    }

    public Conductor(String dui, String nombre, String genero, String numero_licencia, Licencia licencia) {
        this.dui = dui;
        this.nombre = nombre;
        this.genero = genero;
        this.numero_licencia = numero_licencia;
        this.licencia = licencia;
    }
    
    

    public int getConductor() {
        return conductor;
    }

    public void setConductor(int conductor) {
        this.conductor = conductor;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public ArrayList<Conductor_ambulancia> getConductor_ambulancia() {
        return conductor_ambulancia;
    }

    public void setConductor_ambulancia(ArrayList<Conductor_ambulancia> conductor_ambulancia) {
        this.conductor_ambulancia = conductor_ambulancia;
    }

    @Override
    public int compareTo(Conductor o) {
       return this.nombre.compareTo(o.nombre);
    }
    
    
}
