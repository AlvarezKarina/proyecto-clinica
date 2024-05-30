/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.DaoInsumo;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Hospital;
import modelo.Insumo;
import vista.Vista_Datos_Insumo;
import vista.Vista_Hospital;
import vista.Vista_Insumo;

/**
 *
 * @author karie
 */
public class Controlador_Datos_Insumo extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener {
    Vista_Datos_Insumo frmInsumo;
    Insumo insumo;
    DaoInsumo daoInsumo;
    ListaOrdenada<Insumo>listaInsumo;

    public Controlador_Datos_Insumo(Vista_Datos_Insumo frmInsumo) {
        this.frmInsumo = frmInsumo;
        daoInsumo = new DaoInsumo();
        this.frmInsumo.btnGuardar.addActionListener(this);
        this.frmInsumo.btnEditar.addActionListener(this);
        this.frmInsumo.btnEliminar.addActionListener(this);
        this.frmInsumo.tbDatos.addMouseListener(this);
        //this.frmInsumo.btnGuardar.setEnabled(true);
        this.frmInsumo.btnEditar.setEnabled(false);
        this.frmInsumo.btnEliminar.setEnabled(false);
        this.listaInsumo = new ListaOrdenada<>();
        
        
        mostrar();
    }
    
    
      public void mostrar(){
        this.listaInsumo = daoInsumo.selecAll();
        DefaultTableModel modelo = new DefaultTableModel();
        String titulos[] = {"N", "Nombre","Fecha de vencimiento" };
        modelo.setColumnIdentifiers(titulos);
        for(Object obj: listaInsumo.getLista()){
            Insumo x = (Insumo) obj;
            Object datos[] = {x.getInsumo(), x.getNombre_insumo(), x.getFecha_vencimiento()};
            modelo.addRow(datos);
        }
        
        this.frmInsumo.tbDatos.setModel(modelo);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == this.frmInsumo.btnGuardar){
          Vista_Insumo frmInsu = new Vista_Insumo();
          Controlador_Vista_Insumo crtInsumo = new Controlador_Vista_Insumo(frmInsu, this);
          frmInsu.setVisible(true);
          this.frmInsumo.dispose();
          
      }if(e.getSource() == this.frmInsumo.btnEditar){
        Vista_Insumo frmInsu = new Vista_Insumo();
          Controlador_Vista_Insumo crtInsum = new Controlador_Vista_Insumo(frmInsu, this);
          frmInsu.setVisible(true);
          this.frmInsumo.dispose();
          
      }if(e.getSource() == this.frmInsumo.btnEliminar){
          int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?","Seleccione una opcion",0);
//          System.out.println(eliminar);
//          if(eliminar>=0){
//              daoHospital.delete(hospital);
//          }
//           hospital = null;
           if (eliminar == 0) {
                    daoInsumo.delete(insumo);
                }
          this.frmInsumo.btnGuardar.setEnabled(true);
          this.frmInsumo.btnEditar.setEnabled(false);
          this.frmInsumo.btnEliminar.setEnabled(false);
          mostrar();
      }
      
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == this.frmInsumo.tbDatos);
       int fila = this.frmInsumo.tbDatos.getSelectedRow();
       if(fila>=0){
           this.insumo = listaInsumo.get(fila);
             this.frmInsumo.btnEditar.setEnabled(true);
           this.frmInsumo.btnEliminar.setEnabled(true);
           this.frmInsumo.btnGuardar.setEnabled(true);
         
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
