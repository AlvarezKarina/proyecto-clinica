package modelo;


import modelo.Hospital;
import modelo.Consulta;
import modelo.Ambulancia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karie
 */
public class Referencia {
    
    private int referencia;
    private Consulta consulta;
    private Ambulancia ambulancia;
    private Hospital hospital;
    private int enfermera; 

    public Referencia() {
    }

    public Referencia(int referencia) {
        this.referencia = referencia;
    }

    public Referencia(int referencia, Consulta consulta, Ambulancia ambulancia, Hospital hospital, int enfermera) {
        this.referencia = referencia;
        this.consulta = consulta;
        this.ambulancia = ambulancia;
        this.hospital = hospital;
        this.enfermera = enfermera;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Ambulancia getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public int getEnfermera() {
        return enfermera;
    }

    public void setEnfermera(int enfermera) {
        this.enfermera = enfermera;
    }
    
    
    
}
