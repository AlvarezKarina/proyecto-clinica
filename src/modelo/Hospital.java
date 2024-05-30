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
public class Hospital implements Comparable<Hospital>{
    
    private int hospital;
    private String nombre_hospital;
    private String direccion_hospital;
    ArrayList<Referencia> referencia;

    public Hospital() {
    }

    public Hospital(String nombre_hospital, String direccion_hospital) {
        this.nombre_hospital = nombre_hospital;
        this.direccion_hospital = direccion_hospital;
    }
    
    

    public Hospital(int hospital, String nombre_hospital, String direccion_hospital, ArrayList<Referencia> referencia) {
        this.hospital = hospital;
        this.nombre_hospital = nombre_hospital;
        this.direccion_hospital = direccion_hospital;
        this.referencia = referencia;
    }

    public int getHospital() {
        return hospital;
    }

    public void setHospital(int hospital) {
        this.hospital = hospital;
    }

    public String getNombre_hospital() {
        return nombre_hospital;
    }

    public void setNombre_hospital(String nombre_hospital) {
        this.nombre_hospital = nombre_hospital;
    }

    public String getDireccion_hospital() {
        return direccion_hospital;
    }

    public void setDireccion_hospital(String direccion_hospital) {
        this.direccion_hospital = direccion_hospital;
    }

    public ArrayList<Referencia> getReferencia() {
        return referencia;
    }

    public void setReferencia(ArrayList<Referencia> referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "Hospital{" + "hospital=" + hospital + ", nombre_hospital=" + nombre_hospital + ", direccion_hospital=" + direccion_hospital + ", referencia=" + referencia + '}';
    }
    
    

    @Override
    public int compareTo(Hospital o) {
       return this.nombre_hospital.compareTo(o.nombre_hospital);
    }
    
    
}
