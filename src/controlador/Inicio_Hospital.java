/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.Vista_Datos_Hospital;




/**
 *
 * @author karie
 */
public class Inicio_Hospital {
    public static void main(String[] args) {
        Vista_Datos_Hospital vistita = new  Vista_Datos_Hospital();
        Controlador_Datos_Hospital crtHospital = new Controlador_Datos_Hospital(vistita);
        vistita.setVisible(true);
    }
}
