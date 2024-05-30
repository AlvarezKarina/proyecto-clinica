/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Medicamento;
import Dao.MedicamentoDao;
import Dao.MntoMedicamento;

import vista.VistaMedicamento;

/**
 *
 * @author herna
 */
public class ControladorModalMedicamento extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener{
    //OBJETOS
    VistaMedicamento frmMedicamento;
    MedicamentoDao daoMedic;
    Medicamento medicamentoSeleccionado;
    ControladorMntoMedicamento ctrMedicamento;
    
    
    
    
    public ControladorModalMedicamento(VistaMedicamento frmMedicamento,ControladorMntoMedicamento ctrMedicamento) {
        this.frmMedicamento = frmMedicamento;
        this.ctrMedicamento = ctrMedicamento;//PARA QUE PODAMOS RECIBIR EL MEDICAMENTO SELECCIONADO
        this.daoMedic = new MedicamentoDao();
        this.medicamentoSeleccionado=this.ctrMedicamento.medicamentoSeleccionado;//TOMAMOS EL MEDICAMENTO SELECCIONADO DEL CONTROLADOR PRINCIPAL Y LO IGUALAMOS CON EL DE ESTA VISTA
        this.frmMedicamento.btnRegistrar.addActionListener(this);
        this.frmMedicamento.btnCancelar.addActionListener(this);
        mostrar();
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.frmMedicamento.btnRegistrar) {
            guardar();
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
    public void guardar(){
        //TOMAMOS LOS DATOS
        String nombre = this.frmMedicamento.tfNombre.getText();
        int cantidad = (int) this.frmMedicamento.spCantidad.getValue();
        if (!nombre.isEmpty()) {
            boolean funciono = false;
            
            if (this.medicamentoSeleccionado==null) {
                Medicamento objMedic = new Medicamento(nombre,cantidad);
                funciono = daoMedic.insert(objMedic);//COMO LA INSERCION NOS ENVIARA true SI SE GUARDO Y false SI NO SE GUARDO LO GUARDAMOS EN ESTA VARIABLE BOOLEANA
            }else{
                //this.frmMedicamento.tfNombre.setText(medicamentoSeleccionado.getNom_medicamento());
                Medicamento objMedic = new Medicamento();
                objMedic.setId_Medicamento(this.medicamentoSeleccionado.getId_Medicamento());//TOMAMOS EL ID DEL OBJETO QUE SELECCIONAMOS, PARA PODER USARLO EN LA QUERY DEL DAO
                objMedic.setNom_medicamento(this.frmMedicamento.tfNombre.getText());
                objMedic.setCantidad((int) this.frmMedicamento.spCantidad.getValue());
                funciono = daoMedic.update(objMedic);
            }
            
            if (funciono) {
                DesktopNotify.setDefaultTheme(NotifyTheme.Green);
                DesktopNotify.showDesktopMessage("Exito", "Guardo con exito",DesktopNotify.SUCCESS,3000);
            }
        }else{
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error","Fallo al guardar el dato",DesktopNotify.FAIL,3000 );
        }
        
        //MntoMedicamento frmMntoMedic = new MntoMedicamento();
        
        MntoMedicamento frmMedic = new MntoMedicamento();
        ControladorMntoMedicamento ctrMedic = new ControladorMntoMedicamento(frmMedic);
        frmMedic.setVisible(true);
        this.frmMedicamento.dispose();

    }
    
    public void mostrar(){
        if (medicamentoSeleccionado!=null) {
            //MANDAMOS A MOSTRAR LOS DATOS QUE EDITAREMOS
        this.frmMedicamento.tfNombre.setText(this.medicamentoSeleccionado.getNom_medicamento());
        this.frmMedicamento.spCantidad.setValue(this.medicamentoSeleccionado.getCantidad());
        }
    }
    
}
