/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import vista.Vista_Datos_Ambulancia;



/**
 *
 * @author karie
 */
public class Inicio_Ambulancia {
    public static void main(String[] args) {
        
        Vista_Datos_Ambulancia vista = new Vista_Datos_Ambulancia();
        Controlador_Datos_Ambulancia vistita = new Controlador_Datos_Ambulancia (vista);
        vista.setVisible(true);
        
        
    }
}
