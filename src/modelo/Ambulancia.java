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
public class Ambulancia implements Comparable<Ambulancia>{
    
    private int ambulancia;
    private String marca;
    private String modelo;
    private int anio_fabricacion;
    private String placa;
    Tipo_ambulancia tipo_ambulancia;
    ArrayList<Insumo_ambulancia> insumo_ambulancia;
    ArrayList<Referencia> referencia;
    
    public Ambulancia() {
    }

    public Ambulancia(int ambulancia) {
        this.ambulancia = ambulancia;
    }

    public Ambulancia(String marca, String modelo, int anio_fabricacion, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio_fabricacion = anio_fabricacion;
        this.placa = placa;
    }

    public Ambulancia(String marca, String modelo, int anio_fabricacion, String placa, Tipo_ambulancia tipo_ambulancia) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio_fabricacion = anio_fabricacion;
        this.placa = placa;
        this.tipo_ambulancia = tipo_ambulancia;
    }

    

    public Ambulancia(int ambulancia, String marca, String modelo, int anio_fabricacion, String placa, Tipo_ambulancia tipo_ambulancia, ArrayList<Insumo_ambulancia> insumo_ambulancia) {
        this.ambulancia = ambulancia;
        this.marca = marca;
        this.modelo = modelo;
        this.anio_fabricacion = anio_fabricacion;
        this.placa = placa;
        this.tipo_ambulancia = tipo_ambulancia;
        this.insumo_ambulancia = insumo_ambulancia;
    }

    public Ambulancia(String marca_Ambulancia, String modelo_Ambulancia, int anio_Ambulancia, String placa_Ambulancia, int aux) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(int ambulancia) {
        this.ambulancia = ambulancia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio_fabricacion() {
        return anio_fabricacion;
    }

    public void setAnio_fabricacion(int anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Tipo_ambulancia getTipo_ambulancia() {
        return tipo_ambulancia;
    }

    public void setTipo_ambulancia(Tipo_ambulancia tipo_ambulancia) {
        this.tipo_ambulancia = tipo_ambulancia;
    }

    public ArrayList<Insumo_ambulancia> getInsumo_ambulancia() {
        return insumo_ambulancia;
    }

    public void setInsumo_ambulancia(ArrayList<Insumo_ambulancia> insumo_ambulancia) {
        this.insumo_ambulancia = insumo_ambulancia;
    }

    public int compareTo(Ambulancia o) {
       return this.marca.compareTo(o.marca);
    }

//    public void AgregarTipos_Ambulancia(Tipo_ambulancia ti){
//        tipo_ambulancia.add(ti)
//    }
    
}
