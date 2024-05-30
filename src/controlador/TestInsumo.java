/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.Vista_Datos_Insumo;

/**
 *
 * @author karie
 */
public class TestInsumo {
    public static void main(String[] args) {
         Vista_Datos_Insumo vistita = new  Vista_Datos_Insumo();
        Controlador_Datos_Insumo crtInsumo= new Controlador_Datos_Insumo(vistita);
        vistita.setVisible(true);
    }
    
}
