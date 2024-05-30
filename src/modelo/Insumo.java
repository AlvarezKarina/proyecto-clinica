package modelo;


import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karie
 */
public class Insumo implements Comparable<Insumo>{
    
    private int insumo;
    private String nombre_insumo;
    private Date fecha_vencimiento;

    ArrayList<Insumo_ambulancia> insumo_ambulancia;

    public Insumo() {
    }
    
    
    
     public Insumo(int insumo) {
        this.insumo = insumo;
    }

    public Insumo(String nombre_insumo, Date fecha_vencimiento) {
        this.nombre_insumo = nombre_insumo;
        this.fecha_vencimiento = fecha_vencimiento;
    }
     
     

    public Insumo(int insumo, String nombre_insumo, Date fecha_vencimiento, ArrayList<Insumo_ambulancia> insumo_ambulancia) {
        this.insumo = insumo;
        this.nombre_insumo = nombre_insumo;
        this.fecha_vencimiento = fecha_vencimiento;
        this.insumo_ambulancia = insumo_ambulancia;
    }

    public int getInsumo() {
        return insumo;
    }

    public void setInsumo(int insumo) {
        this.insumo = insumo;
    }

    public String getNombre_insumo() {
        return nombre_insumo;
    }

    public void setNombre_insumo(String nombre_insumo) {
        this.nombre_insumo = nombre_insumo;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public ArrayList<Insumo_ambulancia> getInsumo_ambulancia() {
        return insumo_ambulancia;
    }

    public void setInsumo_ambulancia(ArrayList<Insumo_ambulancia> insumo_ambulancia) {
        this.insumo_ambulancia = insumo_ambulancia;
    }
    
    

 
    @Override
    public int compareTo(Insumo o) {
        return this.nombre_insumo.compareTo(o.getNombre_insumo());
    }
     
     
    
}
