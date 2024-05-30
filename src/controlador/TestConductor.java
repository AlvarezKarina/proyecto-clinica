/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.Vista_Datos_Conductor;

/**
 *
 * @author karie
 */
public class TestConductor {
    
    public static void main(String[] args) {
         Vista_Datos_Conductor vistita = new  Vista_Datos_Conductor();
        Controlador_Datos_Conductor crtConductor= new Controlador_Datos_Conductor(vistita);
        vistita.setVisible(true);
    }
    
}
