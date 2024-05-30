/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.Dao_Hospital;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Hospital;
import vista.Vista_Datos_Hospital;
import vista.Vista_Hospital;

/**
 *
 * @author karie
 */
public class Controlador_Vista_Hospital implements ActionListener, MouseListener, KeyListener, ItemListener {

    Vista_Hospital frmHospital;
    Hospital hospital;
    Dao_Hospital daoHospital;
    Controlador_Datos_Hospital ctrHospital;

    public Controlador_Vista_Hospital(Vista_Hospital frmHospital, Controlador_Datos_Hospital ctrHospital) {
        this.frmHospital = frmHospital;
        this.ctrHospital = ctrHospital;
        this.daoHospital = new Dao_Hospital();
        this.hospital = this.ctrHospital.hospital;
        this.frmHospital.btnGuardar.addActionListener(this);
        this.frmHospital.btnCancelar.addActionListener(this);
        mostrar();
    }

    public Controlador_Vista_Hospital(Vista_Hospital frmHospital, Hospital hospital, Controlador_Datos_Hospital ctrHospital) {
        this.frmHospital = frmHospital;
        this.hospital = hospital;
        this.ctrHospital = ctrHospital;
        this.frmHospital.btnGuardar.addActionListener(this);
        this.frmHospital.btnCancelar.addActionListener(this);
        this.frmHospital.tfNombre_Hospital.setText(this.hospital.getNombre_hospital());
        this.frmHospital.tfDireccion.setText(this.hospital.getDireccion_hospital());
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.frmHospital.btnGuardar){
            guardar();
        }
        if(e.getSource() == this.frmHospital.btnCancelar){
            Vista_Datos_Hospital frmHospi = new Vista_Datos_Hospital();
            Controlador_Datos_Hospital crtHopital = new  Controlador_Datos_Hospital(frmHospi);
            frmHospi.setVisible(true);
            this.frmHospital.dispose();
        }
    }
    
    
    public void guardar(){
        String nombre = this.frmHospital.tfNombre_Hospital.getText();
        String direccion = this.frmHospital.tfDireccion.getText();
        if(!nombre.isEmpty() && !direccion.isEmpty()){
           // boolean funciono = false;
            
            if(this.hospital == null){
                Hospital objHospital = new Hospital(nombre,direccion);
                daoHospital.insert(objHospital);
                
            }else{
//               
                 this.hospital.setNombre_hospital(nombre);
                 this.hospital.setDireccion_hospital(direccion);
                daoHospital.update(hospital);
            }
            
              DesktopNotify.setDefaultTheme(NotifyTheme.Green);
           DesktopNotify.showDesktopMessage("Exito  ", "Guardado con exito",DesktopNotify.SUCCESS, 3000);
            
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Campos vacios", DesktopNotify.ERROR, 3000);
        }
        
            Vista_Datos_Hospital frmHospi = new Vista_Datos_Hospital();
            Controlador_Datos_Hospital crtHopital = new  Controlador_Datos_Hospital(frmHospi);
            frmHospi.setVisible(true);
            this.frmHospital.dispose();
        
        
    }
    
    public void mostrar(){
        if(hospital != null){
            this.frmHospital.tfNombre_Hospital.setText(this.hospital.getNombre_hospital());
            this.frmHospital.tfDireccion.setText(this.hospital.getDireccion_hospital());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
