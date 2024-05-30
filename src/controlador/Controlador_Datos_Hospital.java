/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.Dao_Hospital;
import Estructuras.ListaOrdenada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Hospital;
import vista.Vista_Datos_Hospital;
import vista.Vista_Hospital;

/**
 *
 * @author karie
 */
public class Controlador_Datos_Hospital extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener {
    Vista_Datos_Hospital frmHospital;
    Hospital hospital;
    Dao_Hospital daoHospital;
    ListaOrdenada<Hospital>listaHospital;

    public Controlador_Datos_Hospital(Vista_Datos_Hospital frmHospital) {
        this.frmHospital = frmHospital;
        daoHospital = new Dao_Hospital();
        this.frmHospital.btnAgregar.addActionListener(this);
        this.frmHospital.btnEditar.addActionListener(this);
        this.frmHospital.btnEliminar.addActionListener(this);
        this.frmHospital.tbHospitales.addMouseListener(this);
        this.frmHospital.btnEditar.setEnabled(false);
        this.frmHospital.btnEliminar.setEnabled(false);
        this.listaHospital = new ListaOrdenada<>();
        
        mostrar();
    }
    
       public void mostrar(){
        this.listaHospital = daoHospital.selecAll();
        DefaultTableModel modelo = new DefaultTableModel();
        String titulos[] = {"N", "Nombre","Dirección" };
        modelo.setColumnIdentifiers(titulos);
        for(Object obj: listaHospital.getLista()){
            Hospital x = (Hospital) obj;
            Object datos[] = {x.getHospital(), x.getNombre_hospital(), x.getDireccion_hospital()};
            modelo.addRow(datos);
        }
        
        this.frmHospital.tbHospitales.setModel(modelo);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == this.frmHospital.btnAgregar){
          Vista_Hospital frmHospi = new Vista_Hospital();
          Controlador_Vista_Hospital crtHospital = new Controlador_Vista_Hospital(frmHospi, this);
          frmHospi.setVisible(true);
          this.frmHospital.dispose();
          
      }if(e.getSource() == this.frmHospital.btnEditar){
          Vista_Hospital frmHospi = new Vista_Hospital();
          Controlador_Vista_Hospital crtHospital = new Controlador_Vista_Hospital(frmHospi, this);
          frmHospi.setVisible(true);
          this.frmHospital.dispose();
          
      }if(e.getSource() == this.frmHospital.btnEliminar){
          int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?","Seleccione una opcion",0);
//          System.out.println(eliminar);
//          if(eliminar>=0){
//              daoHospital.delete(hospital);
//          }
//           hospital = null;
           if (eliminar == 0) {
                    daoHospital.delete(hospital);
                }
          this.frmHospital.btnAgregar.setEnabled(true);
          this.frmHospital.btnEditar.setEnabled(false);
          this.frmHospital.btnEliminar.setEnabled(false);
          mostrar();
      }

      
      
      
    }

  
  @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == this.frmHospital.tbHospitales);
       int fila = this.frmHospital.tbHospitales.getSelectedRow();
       if(fila>=0){
           this.hospital = listaHospital.get(fila);
             this.frmHospital.btnEditar.setEnabled(true);
           this.frmHospital.btnEliminar.setEnabled(true);
           this.frmHospital.btnAgregar.setEnabled(true);
         
       }
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
