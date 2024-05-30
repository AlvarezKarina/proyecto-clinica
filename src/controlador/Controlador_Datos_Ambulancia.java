/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.DaoAmbulancia;
import Estructuras.ListaSimple;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Ambulancia;

import vista.Vista_Ambulancia;
import vista.Vista_Datos_Ambulancia;

/**
 *
 * @author karie
 */

public class Controlador_Datos_Ambulancia extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener {

    Vista_Datos_Ambulancia frmDatos;
    //ArrayList<Ambulancia> lista;
    ListaSimple<Ambulancia> lista;
    DaoAmbulancia daoAmbu;
    Ambulancia ambu;

    public Controlador_Datos_Ambulancia(Vista_Datos_Ambulancia frmDatos) {
        this.frmDatos = frmDatos;
        daoAmbu = new DaoAmbulancia();
        this.frmDatos.btnAgregar.addActionListener(this);
        this.frmDatos.btnEditar.addActionListener(this);
        this.frmDatos.btnEliminar.addActionListener(this);
        this.frmDatos.tbDatos_Ambulancia.addMouseListener(this);
        this.frmDatos.btnEditar.setEnabled(false);
        this.frmDatos.btnEliminar.setEnabled(false);
        this.lista = new ListaSimple<>();
       mostrar();
    }

  

    public void mostrar() {
       lista = daoAmbu.selectAll();
       DefaultTableModel modelo = new DefaultTableModel();
        String titulos[] = {"Id", "Marca","Modelo", "Año","Placa", "Tipo de ambulancia"};
        modelo.setColumnIdentifiers(titulos);

        for (Object num : lista.ToArray()) {
            Ambulancia x = (Ambulancia) num;
            Object datos[] = {x.getAmbulancia(), x.getMarca(),x.getModelo(), x.getAnio_fabricacion(), x.getPlaca(), x.getTipo_ambulancia().getNombre_tipo()};
            modelo.addRow(datos);
        }
        this.frmDatos.tbDatos_Ambulancia.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmDatos.btnAgregar) {
            Vista_Ambulancia frmAmbu = new Vista_Ambulancia();
            Controlador_Vista_Ambulancia ctrAmbulancia = new Controlador_Vista_Ambulancia(frmAmbu, this);
            frmAmbu.setVisible(true);
            this.frmDatos.dispose();
            
        }if (e.getSource() == this.frmDatos.btnEditar) {
                Vista_Ambulancia frmAmbu = new Vista_Ambulancia();
                Controlador_Vista_Ambulancia ctrAmbulancia = new Controlador_Vista_Ambulancia(frmAmbu, this);
                frmAmbu.setVisible(true);
                this.frmDatos.dispose();
            
        }if (e.getSource() == this.frmDatos.btnEliminar) {
        
                int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Seleccione una opcion", 0);
                if (eliminar == 0) {
                    daoAmbu.delete(ambu);
                }
               
                this.frmDatos.btnAgregar.setEnabled(true);
                this.frmDatos.btnEditar.setEnabled(false);
                this.frmDatos.btnEliminar.setEnabled(false);
                mostrar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.frmDatos.tbDatos_Ambulancia) {
            int fila = this.frmDatos.tbDatos_Ambulancia.getSelectedRow();
            if (fila >= 0) {
                //this.ambu = lista.get(fila);
                this.ambu = lista.ToArray().get(fila);
                this.frmDatos.btnEditar.setEnabled(true);
                this.frmDatos.btnEliminar.setEnabled(true);
                this.frmDatos.btnAgregar.setEnabled(true);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implementar según sea necesario
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Implementar según sea necesario
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Implementar según sea necesario
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Implementar según sea necesario
    }
}

