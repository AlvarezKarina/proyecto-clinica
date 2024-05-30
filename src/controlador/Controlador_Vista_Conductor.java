/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.DaoAmbulancia;
import Dao.DaoConductor;
import Estructuras.ListaDobleCircular;
import Estructuras.ListaSimple;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import modelo.Ambulancia;
import modelo.Conductor;
import modelo.Licencia;
import modelo.Tipo_ambulancia;
import vista.Vista_Ambulancia;
import vista.Vista_Conductor;
import vista.Vista_Datos_Ambulancia;
import vista.Vista_Datos_Conductor;

/**
 *
 * @author karie
 */
public class Controlador_Vista_Conductor extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener{
    Vista_Conductor frmConductor;
    Controlador_Datos_Conductor ctrConductor;
    DaoConductor daoConductor;
    Licencia tipo;
    Conductor Conduc;
    ListaDobleCircular<String>lista  = new ListaDobleCircular();

    public Controlador_Vista_Conductor(Vista_Conductor frmConductor, Controlador_Datos_Conductor ctrConductor) {
        this.frmConductor = frmConductor;
        this.ctrConductor = ctrConductor;
        this.daoConductor = new DaoConductor();
        this.Conduc = this.ctrConductor.conductor;
        this.frmConductor.btnGuardar.addActionListener(this);
        this.frmConductor.btnCancelar.addActionListener(this);
        mostrar();
        llenarComboBoxs();
    }

    public Controlador_Vista_Conductor(Vista_Conductor frmConductor, Controlador_Datos_Conductor ctrConductor, Conductor Conduc) {
        this.frmConductor = frmConductor;
        this.ctrConductor = ctrConductor;
        this.Conduc = Conduc;
         this.frmConductor.btnGuardar.addActionListener(this);
        this.frmConductor.btnCancelar.addActionListener(this);
       this.frmConductor.tfDui.setText(this.Conduc.getDui());
       this.frmConductor.tfNombre.setText(this.Conduc.getNombre());
         this.getGenero();
        this.frmConductor.tfNumLicencia.setText(this.Conduc.getNumero_licencia());
       
    }

     public String getGenero() {
        //SI EL RADIO BUTTON ESTA SELECCIONANDO FEMENINO
        if (this.frmConductor.rbFemenino.isSelected()) {
            return "Femenino";

        } else {
            return "Masculino";
        }
    }
    
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmConductor.btnGuardar) {
            guardar();
        }
        if (e.getSource() == this.frmConductor.btnCancelar);
        Vista_Datos_Conductor ctrConduc = new Vista_Datos_Conductor();
        Controlador_Datos_Conductor crtVistaConduc= new Controlador_Datos_Conductor(ctrConduc);
        ctrConduc.setVisible(true);
        this.frmConductor.dispose();

    }
    
    public void guardar() {
        String dui = this.frmConductor.tfDui.getText();
        String nombre = this.frmConductor.tfNombre.getText();
         String genero = getGenero();
        String num_licencia = this.frmConductor.tfNumLicencia.getText();
        String tipo_licencia =(String) this.frmConductor.cbTipoLicencia.getSelectedItem();
        
        
        if (!dui.isEmpty() &&!nombre.isEmpty()&& !genero.isEmpty()&& !num_licencia.isEmpty()&& !tipo_licencia.isEmpty()) {
           boolean funciono = false;
                //int anio_Ambulancia = Integer.parseInt(anio_AmbulanciaText);
                //Licencia tipo1 = new Licencia();
                if (this.Conduc == null) {
                    
                   Licencia tipo1 = new Licencia();
                    int idTipo = Integer.parseInt(daoConductor.obtenerIdLicencia(tipo_licencia));
                    tipo1.setLicencia(idTipo);
//                    if(tipo_licencia.equals("Particular")){
//                        tipo1 = new Licencia(1);
//                    }else if(tipo_licencia.equals("Liviana")){
//                        tipo1 = new Licencia(2);
//                    }else if(tipo_licencia.equals("Pesada")){
//                        tipo1 = new Licencia(3);
//                    }
                    
                    Conductor obj = new Conductor(dui,nombre, genero,num_licencia, tipo1);
                  funciono =   daoConductor.insert(obj);
                    
                } else {
                    Licencia tipo = new Licencia();
                    int id_tipo = Integer.parseInt(daoConductor.obtenerIdLicencia(tipo_licencia));
                    tipo.setLicencia(id_tipo);
                    //tipo.setTipo_licencia(tipo_licencia);
                    this.Conduc.setDui(dui);
                    this.Conduc.setNombre(nombre);
                    this.Conduc.setGenero(genero);
                    this.Conduc.setNumero_licencia(num_licencia);
                    this.Conduc.setLicencia(tipo);
                     funciono = daoConductor.update(Conduc);
                }
                 DesktopNotify.setDefaultTheme(NotifyTheme.Green);
           DesktopNotify.showDesktopMessage("Exito  ", "Guardado con exito",DesktopNotify.SUCCESS, 3000);
            
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Campos vacios", DesktopNotify.ERROR, 3000);
        }
         Vista_Datos_Conductor frmConduc = new Vista_Datos_Conductor();
        Controlador_Datos_Conductor crtVistaConduc = new Controlador_Datos_Conductor(frmConduc);
        frmConduc.setVisible(true);
        //this.ctrAmbulancia.mostrar();
        this.frmConductor.dispose();
    }
    
     public void llenarComboBoxs() {// Método para llenar el ComboBox con los nombres de los países
        // Obtén la lista de nombres de países desde la base de datos
        this.lista = daoConductor.obtenerTipoLicencia();
        //this.obtenerNombresEstadio = daoCompra.obtenerNombresEstadio();

        // Limpia el ComboBox antes de agregar los nuevos elementos
        this.frmConductor.cbTipoLicencia.removeAllItems();
        //this.frmRegisCompra.cbEstadio.removeAllItems();

        // Agrega los nombres de países al ComboBox
          for (String tipoLicencia : lista.toArrayAsc()) {
            this.frmConductor.cbTipoLicencia.addItem(tipoLicencia);
        }
//        for (String nombreEstadio : nombresEstadios.toArrayAsc()) {
//            this.frmRegisCompra.cbEstadio.addItem(nombreEstadio);
//        }

    }
     
     public void mostrar(){
        if(Conduc != null){
            this.frmConductor.tfDui.setText(this.Conduc.getDui());
            this.frmConductor.tfNombre.setText(this.Conduc.getNombre());
            this.getGenero();
            this.frmConductor.tfNumLicencia.setText(this.Conduc.getNumero_licencia());
            
            this.frmConductor.cbTipoLicencia.setSelectedItem(this.Conduc.getLicencia());
            //this.frmAmbulancia.cbTipo_Ambulancia
           
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
