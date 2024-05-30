/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.DaoConductor;
import Estructuras.ListaDobleCircular;
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
import modelo.Conductor;
import vista.Vista_Ambulancia;
import vista.Vista_Conductor;
import vista.Vista_Datos_Conductor;

/**
 *
 * @author karie
 */
public class Controlador_Datos_Conductor extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener {
    
    Vista_Datos_Conductor frmConductor;
    ListaDobleCircular<Conductor> lista;
    DaoConductor daoConduc;
    Conductor conductor;

    public Controlador_Datos_Conductor(Vista_Datos_Conductor frmConductor) {
        this.frmConductor = frmConductor;
        daoConduc = new DaoConductor();
        this.lista = new ListaDobleCircular<>();
        this.frmConductor.btnAgregar.addActionListener(this);
        this.frmConductor.btnEditar.addActionListener(this);
        this.frmConductor.btnEliminar.addActionListener(this);
        this.frmConductor.tbConductores.addMouseListener(this);
        this.frmConductor.btnEditar.setEnabled(false);
        this.frmConductor.btnEliminar.setEnabled(false);
        mostrar();
    }
    
    
    public void mostrar() {
       lista = daoConduc.selectAll();
       DefaultTableModel modelo = new DefaultTableModel();
        String titulos[] = {"Id", "Dui","Nombre", "Genero", "Numero de licencia", "Tipo de licencia"};
        modelo.setColumnIdentifiers(titulos);

        for (Object obj : lista.toArrayAsc()) {
            Conductor x = (Conductor) obj;
            Object datos[] = {x.getConductor(), x.getDui(),x.getNombre(), x.getGenero(), x.getNumero_licencia(), x.getLicencia().getTipo_licencia()};
            modelo.addRow(datos);
        }
        this.frmConductor.tbConductores.setModel(modelo);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmConductor.btnAgregar) {
            Vista_Conductor frmConduc = new Vista_Conductor();
            Controlador_Vista_Conductor ctrConductor = new Controlador_Vista_Conductor(frmConduc, this);
            frmConduc.setVisible(true);
            this.frmConductor.dispose();
            
        }if (e.getSource() == this.frmConductor.btnEditar) {
              Vista_Conductor frmConduc = new Vista_Conductor();
            Controlador_Vista_Conductor ctrConductor = new Controlador_Vista_Conductor(frmConduc, this);
            frmConduc.setVisible(true);
            this.frmConductor.dispose();
            
        }if (e.getSource() == this.frmConductor.btnEliminar) {
        
                int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Seleccione una opcion", 0);
                if (eliminar == 0) {
                    daoConduc.delete(conductor);
                }
               
                this.frmConductor.btnAgregar.setEnabled(true);
                this.frmConductor.btnEditar.setEnabled(false);
                this.frmConductor.btnEliminar.setEnabled(false);
                mostrar();
        }
    }

    
     @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.frmConductor.tbConductores) {
            int fila = this.frmConductor.tbConductores.getSelectedRow();
            if (fila >= 0) {
                //this.ambu = lista.get(fila);
                this.conductor = lista.toArrayAsc().get(fila);
                this.frmConductor.btnEditar.setEnabled(true);
                this.frmConductor.btnEliminar.setEnabled(true);
                this.frmConductor.btnAgregar.setEnabled(true);
            }
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
