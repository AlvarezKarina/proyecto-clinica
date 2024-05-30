/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.MedicamentoDao;
import Dao.MntoMedicamento;
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
import modelo.Medicamento;

import vista.VistaMedicamento;

/**
 *
 * @author herna
 */
public class ControladorMntoMedicamento extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener {

    //OBJETOS 
    MntoMedicamento frmMedicamento;
    MedicamentoDao daoMedic;
    Medicamento medicamentoSeleccionado;
    Bicola<Medicamento> listaMedicamentos;
    public ControladorMntoMedicamento(MntoMedicamento frmMedicamento) {
        daoMedic = new MedicamentoDao();
        this.frmMedicamento = frmMedicamento;
        this.frmMedicamento.btnAgregar.addActionListener(this);
        this.frmMedicamento.btnEditar.addActionListener(this);
        this.frmMedicamento.btnEliminar.addActionListener(this);
        this.frmMedicamento.tbMedicamentos.addMouseListener(this);
        this.frmMedicamento.btnEditar.setEnabled(false);
        this.frmMedicamento.btnEliminar.setEnabled(false);
        mostrar();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.frmMedicamento.tbMedicamentos) {
            int fila = this.frmMedicamento.tbMedicamentos.getSelectedRow();
            if (fila >= 0) {
                this.medicamentoSeleccionado=listaMedicamentos.toArray().get(fila);
                this.frmMedicamento.btnEditar.setEnabled(true);
                this.frmMedicamento.btnEliminar.setEnabled(true);
                this.frmMedicamento.btnAgregar.setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmMedicamento.btnAgregar) {
            VistaMedicamento frmMedic = new VistaMedicamento();
            ControladorModalMedicamento ctrModalMedic = new ControladorModalMedicamento(frmMedic, this);
            frmMedic.setVisible(true);
            this.frmMedicamento.dispose();
        }
        if (e.getSource()==this.frmMedicamento.btnEditar) {
            VistaMedicamento frmMedic = new VistaMedicamento();
            ControladorModalMedicamento ctrModal = new ControladorModalMedicamento(frmMedic, this);
            frmMedic.setVisible(true);
            this.frmMedicamento.dispose();
        }
        if (e.getSource()==this.frmMedicamento.btnEliminar) {
            int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?","Seleccione una opcion",0);
            System.out.println(eliminar);
            if (eliminar==0) {
                daoMedic.delete(medicamentoSeleccionado);
            }  
            this.frmMedicamento.btnAgregar.setEnabled(true);
            this.frmMedicamento.btnEditar.setEnabled(false);
            this.frmMedicamento.btnEliminar.setEnabled(false);
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

    //METODOS Y PROCEDIMIENTOS
    public void mostrar() {
        this.listaMedicamentos = daoMedic.selectAll();
        DefaultTableModel modelo = new DefaultTableModel();
        String titulos[] = {"ID", "NOMBRE","CANTIDAD"};
        modelo.setColumnIdentifiers(titulos);
        for (Medicamento x : listaMedicamentos.toArray()) {
            Object datos[] = {x.getId_Medicamento(), x.getNom_medicamento(),x.getCantidad()};
            modelo.addRow(datos);
        }
       /* while(!listaMedicamentos.isEmpty()){
            Medicamento med=listaMedicamentos.pollFirst();
            Object datos[]={med.getId_Medicamento(),med.getNom_medicamento(),med.getCantidad()};
            modelo.addRow(datos); 
        }*/
        this.frmMedicamento.tbMedicamentos.setModel(modelo);
    }

}
