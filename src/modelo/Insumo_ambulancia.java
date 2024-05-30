/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author karie
 */
public class Insumo_ambulancia {
    
    private int insumo_ambulancia;
    private Ambulancia ambulancia;
    private Insumo insumo;

    public Insumo_ambulancia() {
    }

    public Insumo_ambulancia(int insumo_ambulancia) {
        this.insumo_ambulancia = insumo_ambulancia;
    }

    public Insumo_ambulancia(int insumo_ambulancia, Ambulancia ambulancia, Insumo insumo) {
        this.insumo_ambulancia = insumo_ambulancia;
        this.ambulancia = ambulancia;
        this.insumo = insumo;
    }

    public int getInsumo_ambulancia() {
        return insumo_ambulancia;
    }

    public void setInsumo_ambulancia(int insumo_ambulancia) {
        this.insumo_ambulancia = insumo_ambulancia;
    }

    public Ambulancia getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    
    
    
}
