/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.DaoInsumo;
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
import java.util.Date;
import modelo.Hospital;
import modelo.Insumo;
import vista.Vista_Datos_Hospital;
import vista.Vista_Datos_Insumo;
import vista.Vista_Insumo;

/**
 *
 * @author karie
 */
public class Controlador_Vista_Insumo implements ActionListener, MouseListener, KeyListener, ItemListener {

    Vista_Insumo frmInsumo;
    Insumo insumo;
    DaoInsumo daoInsumo;
    Controlador_Datos_Insumo ctrInsumo;
    
     public Controlador_Vista_Insumo(Vista_Insumo frmInsumo, Controlador_Datos_Insumo ctrInsumo) {
        this.frmInsumo = frmInsumo;
        this.ctrInsumo = ctrInsumo;
        this.daoInsumo = new DaoInsumo();
        this.insumo = this.ctrInsumo.insumo;
          this.frmInsumo.btnGuardar.addActionListener(this);
        this.frmInsumo.btnCancelar.addActionListener(this);
      
         mostrar();
    }

    public Controlador_Vista_Insumo(Vista_Insumo frmInsumo, Insumo insumo, Controlador_Datos_Insumo ctrInsumo) {
        this.frmInsumo = frmInsumo;
        this.insumo = insumo;
        this.ctrInsumo = ctrInsumo;
        this.frmInsumo.btnGuardar.addActionListener(this);
        this.frmInsumo.btnCancelar.addActionListener(this);
         this.frmInsumo.tfNombre.setText(this.insumo.getNombre_insumo());
        this.frmInsumo.rsFecha_ven.setDatoFecha(this.insumo.getFecha_vencimiento());
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.frmInsumo.btnGuardar){
            guardar();
        }
        if(e.getSource() == this.frmInsumo.btnCancelar){
            Vista_Datos_Insumo frmInsum = new Vista_Datos_Insumo();
            Controlador_Datos_Insumo crtInsumo = new  Controlador_Datos_Insumo(frmInsum);
            frmInsum.setVisible(true);
            this.frmInsumo.dispose();
        }
    }
    
     public void guardar(){
        String nombre = this.frmInsumo.tfNombre.getText();
        Date fecha_ven = this.frmInsumo.rsFecha_ven.getDatoFecha();
        if(!nombre.isEmpty()){
           // boolean funciono = false;
            
            if(this.insumo == null){
                Insumo objInsumo = new Insumo(nombre,fecha_ven);
                daoInsumo.insert(objInsumo);
                
            }else{
//               
                 this.insumo.setNombre_insumo(nombre);
                 this.insumo.setFecha_vencimiento(fecha_ven);
                daoInsumo.update(insumo);
            }
            
              DesktopNotify.setDefaultTheme(NotifyTheme.Green);
           DesktopNotify.showDesktopMessage("Exito  ", "Guardado con exito",DesktopNotify.SUCCESS, 3000);
            
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Campos vacios", DesktopNotify.ERROR, 3000);
        }
        Vista_Datos_Insumo frmInsum = new Vista_Datos_Insumo();
            Controlador_Datos_Insumo crtInsumo = new  Controlador_Datos_Insumo(frmInsum);
            frmInsum.setVisible(true);
            this.frmInsumo.dispose();
        
        
    }
     
      public void mostrar(){
        if(insumo != null){
            this.frmInsumo.tfNombre.setText(this.insumo.getNombre_insumo());
            this.frmInsumo.rsFecha_ven.setDatoFecha(this.insumo.getFecha_vencimiento());
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
