package modelo;


import modelo.Consulta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karie
 */
public class Consulta_examen {
    
    private int consulta_examen;
    private String descripcion;
    private Examen examen;
    private Consulta consulta;

    public Consulta_examen() {
    }

    public Consulta_examen(int consulta_examen, String descripcion, Examen examen, Consulta consulta) {
        this.consulta_examen = consulta_examen;
        this.descripcion = descripcion;
        this.examen = examen;
        this.consulta = consulta;
    }

    public int getConsulta_examen() {
        return consulta_examen;
    }

    public void setConsulta_examen(int consulta_examen) {
        this.consulta_examen = consulta_examen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    
    
}
