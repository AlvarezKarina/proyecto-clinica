/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.EspecialidadDao;
import Estructuras.Bicola;
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
import modelo.Especialidad;
import vista.MntoEspecialidad;
import vista.VistaEspecialidad;

/**
 *
 * @author herna
 */
public class ControladorMntoEspecialidad extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener{
    
    MntoEspecialidad frmEspecialidad;
    EspecialidadDao daoEspecialidad;
    Especialidad especialidadSeleccionada;
    Bicola<Especialidad> listaEspecialidad;
    
    
    
    
    public ControladorMntoEspecialidad(MntoEspecialidad frmEspecialidad) {
        this.frmEspecialidad = frmEspecialidad;
        daoEspecialidad = new EspecialidadDao();
        //ESCUCHAMOS LOS BOTONES
        this.frmEspecialidad.btnAgregar.addActionListener(this);
        this.frmEspecialidad.btnEditar.addActionListener(this);
        this.frmEspecialidad.btnEliminar.addActionListener(this);
        this.frmEspecialidad.tbEspecialidades.addMouseListener(this);
        //LOS BOTONES DE EDITAR Y ELIMINAR POR DEFECTO LOS DESABILITAMOS
        this.frmEspecialidad.btnEditar.setEnabled(false);
        this.frmEspecialidad.btnEliminar.setEnabled(false);
        //METODO MOSTRAR PARA QUE MUESTRE LOS DATOS DE LA BASE DE DATOS
        mostrar();
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource()==this.frmEspecialidad.tbEspecialidades) {
            //TOMAMOS EL DATO DE LA FILA
            int fila=this.frmEspecialidad.tbEspecialidades.getSelectedRow();
            if (fila>=0) {
                this.especialidadSeleccionada=listaEspecialidad.toArray().get(fila);
                this.frmEspecialidad.btnAgregar.setEnabled(false);
                this.frmEspecialidad.btnEditar.setEnabled(true);
                this.frmEspecialidad.btnEliminar.setEnabled(true);
            }
        }
    }
    
             
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.frmEspecialidad.btnAgregar) {
            VistaEspecialidad frmEspec = new VistaEspecialidad();
            ControladorModalEspecialidad ctrEspec = new ControladorModalEspecialidad(frmEspec, this);
            frmEspec.setVisible(true);
            this.frmEspecialidad.dispose();
        }
        
        if (e.getSource()==this.frmEspecialidad.btnEditar) {
            VistaEspecialidad frmEspec = new VistaEspecialidad();
            ControladorModalEspecialidad ctrEspec = new ControladorModalEspecialidad(frmEspec, this);
            frmEspec.setVisible(true);
            this.frmEspecialidad.dispose();
        }
        if (e.getSource()==this.frmEspecialidad.btnEliminar) {
            int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?","Seleccione una opcion",0);
            if (eliminar==0) {
                daoEspecialidad.delete(especialidadSeleccionada);
            }
            this.frmEspecialidad.btnAgregar.setEnabled(true);
            this.frmEspecialidad.btnEditar.setEnabled(false);
            this.frmEspecialidad.btnEliminar.setEnabled(false);
            mostrar();
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
    //METODOS Y PROCESOS
    public void mostrar(){
        listaEspecialidad = daoEspecialidad.selectAll();
        DefaultTableModel modelo = new DefaultTableModel();
        String titulos[]={"Id","Especialidad"};
        modelo.setColumnIdentifiers(titulos);
        for (Especialidad x: listaEspecialidad.toArray()) {
            Object datos[]={x.getId_Especialidad(),x.getNom_Especialidad()};
            modelo.addRow(datos);            
        }
        /*while(!listaEspecialidad.isEmpty()){
            Especialidad esp=listaEspecialidad.poll();
            Object datos[]={esp.getId_Especialidad(),esp.getNom_Especialidad()};
            modelo.addRow(datos); 
        }*/
        
        this.frmEspecialidad.tbEspecialidades.setModel(modelo);
    }
    
}
