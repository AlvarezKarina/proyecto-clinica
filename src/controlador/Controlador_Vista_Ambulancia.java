/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dao.DaoAmbulancia;
import Estructuras.ListaOrdenada;
import Estructuras.ListaSimple;
import com.mysql.cj.xdevapi.Statement;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelo.Ambulancia;
import modelo.Tipo_ambulancia;
import vista.Vista_Ambulancia;
import vista.Vista_Datos_Ambulancia;

/**
 *
 * @author karie
 */

public class Controlador_Vista_Ambulancia extends MouseAdapter implements ActionListener, MouseListener, KeyListener, ItemListener {

    Vista_Ambulancia frmAmbulancia;
    Controlador_Datos_Ambulancia ctrAmbulancia;
    DaoAmbulancia daoAmbu;
    Tipo_ambulancia tipo;
    Ambulancia Ambu;
    ListaSimple<String>obtenerNombresEstadio  = new ListaSimple();

    public Controlador_Vista_Ambulancia(Vista_Ambulancia frmAmbulancia, Controlador_Datos_Ambulancia ctrAmbulancia) {
        this.frmAmbulancia = frmAmbulancia;
        this.ctrAmbulancia = ctrAmbulancia;
        this.daoAmbu = new DaoAmbulancia();
        this.Ambu = this.ctrAmbulancia.ambu;
        this.frmAmbulancia.btnGuardar_Ambulancia.addActionListener(this);
        this.frmAmbulancia.btnCancelar.addActionListener(this);
        mostrar();
        llenarComboBoxs();
        //cargarCombo();
       
    }

    public Controlador_Vista_Ambulancia(Vista_Ambulancia frmAmbulancia, Controlador_Datos_Ambulancia ctrAmbulancia, Ambulancia Ambu) {
        this.frmAmbulancia = frmAmbulancia;
        this.ctrAmbulancia = ctrAmbulancia;
        this.Ambu = Ambu;
        this.frmAmbulancia.btnGuardar_Ambulancia.addActionListener(this);
        this.frmAmbulancia.btnCancelar.addActionListener(this);
       this.frmAmbulancia.tfMarca_Ambulancia.setText(this.Ambu.getMarca());
        this.frmAmbulancia.tfModelo.setText(this.Ambu.getModelo());
            this.frmAmbulancia.tfAño_Ambulancia.setText(String.valueOf(this.Ambu.getAnio_fabricacion()));
            this.frmAmbulancia.tfPlaca_Ambulancia.setText(this.Ambu.getPlaca());
            //this.frmAmbulancia.cbTipo_Ambulancia
    }

  

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmAmbulancia.btnGuardar_Ambulancia) {
            guardar();
        }
        if(e.getSource() == this.frmAmbulancia.btnCancelar){
               Vista_Datos_Ambulancia ctrAmbu = new Vista_Datos_Ambulancia();
        Controlador_Datos_Ambulancia crtVistaAm = new Controlador_Datos_Ambulancia(ctrAmbu);
        ctrAmbu.setVisible(true);
        this.frmAmbulancia.dispose();
        }
     
    }

    public void guardar() {
        String marca_Ambulancia = this.frmAmbulancia.tfMarca_Ambulancia.getText();
        String modelo_Ambulancia = this.frmAmbulancia.tfModelo.getText();
        //String anio_AmbulanciaText = this.frmAmbulancia.tfAño_Ambulancia.getText();
        int anio_Ambulancia = Integer.parseInt(this.frmAmbulancia.tfAño_Ambulancia.getText());
        String placa_Ambulancia = this.frmAmbulancia.tfPlaca_Ambulancia.getText();
        String tipo_ambulancia =(String) this.frmAmbulancia.cbTipo_Ambulancia.getSelectedItem();
        
        
        if (!marca_Ambulancia.isEmpty() &&!modelo_Ambulancia.isEmpty()&& !this.frmAmbulancia.tfAño_Ambulancia.getText().isEmpty()&& !placa_Ambulancia.isEmpty()) {
           
                //int anio_Ambulancia = Integer.parseInt(anio_AmbulanciaText);
                //Tipo_ambulancia tipo1 = new Tipo_ambulancia();
                if (this.Ambu == null) {
                    boolean funciono = false;
                    Tipo_ambulancia tipo1 = new Tipo_ambulancia();
                    int id_tipo = Integer.parseInt(daoAmbu.obtenerIdTipoAmbu(tipo_ambulancia));
                    tipo1.setId_tipo_ambulancia(id_tipo);
//                
                    
                    Ambulancia obj = new Ambulancia(marca_Ambulancia,modelo_Ambulancia, anio_Ambulancia, placa_Ambulancia, tipo1);
                    funciono = daoAmbu.insert(obj);
                    
                } else {
                    Tipo_ambulancia tipo = new Tipo_ambulancia();
                    int idTipo = Integer.parseInt(daoAmbu.obtenerIdTipoAmbu(tipo_ambulancia));
                    tipo.setId_tipo_ambulancia(idTipo);
                    this.Ambu.setMarca(marca_Ambulancia);
                    this.Ambu.setModelo(modelo_Ambulancia);
                    this.Ambu.setAnio_fabricacion(anio_Ambulancia);
                    this.Ambu.setPlaca(placa_Ambulancia);
                    this.Ambu.setTipo_ambulancia(tipo);
                    daoAmbu.update(Ambu);
                }
                 DesktopNotify.setDefaultTheme(NotifyTheme.Green);
           DesktopNotify.showDesktopMessage("Exito  ", "Guardado con exito",DesktopNotify.SUCCESS, 3000);
            
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Campos vacios", DesktopNotify.ERROR, 3000);
        }
         Vista_Datos_Ambulancia ctrAmbu = new Vista_Datos_Ambulancia();
        Controlador_Datos_Ambulancia crtVistaAm = new Controlador_Datos_Ambulancia(ctrAmbu);
        ctrAmbu.setVisible(true);
        //this.ctrAmbulancia.mostrar();
        this.frmAmbulancia.dispose();
    }
    
    public void llenarComboBoxs() {// Método para llenar el ComboBox con los nombres de los países
        // Obtén la lista de nombres de países desde la base de datos
        this.obtenerNombresEstadio = daoAmbu.obtenerTipoAmbulancia();
        //this.obtenerNombresEstadio = daoCompra.obtenerNombresEstadio();

        // Limpia el ComboBox antes de agregar los nuevos elementos
        this.frmAmbulancia.cbTipo_Ambulancia.removeAllItems();
        //this.frmRegisCompra.cbEstadio.removeAllItems();

        // Agrega los nombres de países al ComboBox
          for (String nombreEstadio : obtenerNombresEstadio.ToArray()) {
            this.frmAmbulancia.cbTipo_Ambulancia.addItem(nombreEstadio);
        }
//        for (String nombreEstadio : nombresEstadios.toArrayAsc()) {
//            this.frmRegisCompra.cbEstadio.addItem(nombreEstadio);
//        }

    }
    
//    public void cargarCombo(JComboBox c){
//        DefaultComboBoxModel combo = new DefaultComboBoxModel();
//        c.setModel(combo);
//        try{
//            Statement st = 
//        }catch(Exception e){
//            
//        }
//    }

    public void mostrar(){
        if(Ambu != null){
            this.frmAmbulancia.tfMarca_Ambulancia.setText(this.Ambu.getMarca());
            this.frmAmbulancia.tfModelo.setText(this.Ambu.getModelo());
            this.frmAmbulancia.tfAño_Ambulancia.setText(String.valueOf(this.Ambu.getAnio_fabricacion()));
            this.frmAmbulancia.cbTipo_Ambulancia.setSelectedItem(this.Ambu.getTipo_ambulancia());
            this.frmAmbulancia.tfPlaca_Ambulancia.setText(this.Ambu.getPlaca());
            //this.frmAmbulancia.cbTipo_Ambulancia
           
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
