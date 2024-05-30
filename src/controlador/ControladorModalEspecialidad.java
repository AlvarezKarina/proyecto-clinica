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
import java.awt.event.MouseListener;


import vista.MntoEspecialidad;
import vista.VistaEspecialidad;

/**
 *
 * @author herna
 */
public class ControladorModalEspecialidad extends MouseAdapter implements ActionListener,MouseListener, KeyListener, ItemListener{


    VistaEspecialidad frmEspecialidad;
    EspecialidadDao daoEspec;
    Especialidad especialidadSeleccionada;
    ControladorMntoEspecialidad ctrEspecialidad;

    public ControladorModalEspecialidad(VistaEspecialidad frmEspecialidad, ControladorMntoEspecialidad ctrEspecialidad) {
        this.frmEspecialidad = frmEspecialidad;
        this.ctrEspecialidad = ctrEspecialidad;
        
        this.daoEspec = new EspecialidadDao();
        this.especialidadSeleccionada=this.ctrEspecialidad.especialidadSeleccionada;
        
        this.frmEspecialidad.btnCancelar.addActionListener(this);
        this.frmEspecialidad.btnRegistrar.addActionListener(this);
        mostrar();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.frmEspecialidad.btnRegistrar) {
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
        String nombre = this.frmEspecialidad.tfNombre.getText();
        if (!nombre.isEmpty()) {
            boolean funciono = false;
            //SI NO HEMOS SELECCIONADO UNA ESPECIALIDAD ES POR QUE GUARDAREMOS UN REGISTRO NUEVO
            if (this.especialidadSeleccionada==null) {
                Especialidad objEspec = new Especialidad();
                objEspec.setNom_Especialidad(nombre);
                funciono=daoEspec.insert(objEspec);//COMO LA INSERCION NOS ENVIARA true SI SE GUARDO Y false SI NO SE GUARDO LO GUARDAMOS EN ESTA VARIABLE BOOLEANA
            }else{
                Especialidad objEspec = new Especialidad();
                objEspec.setId_Especialidad(especialidadSeleccionada.getId_Especialidad());
                objEspec.setNom_Especialidad(nombre);
                funciono = daoEspec.update(objEspec);
            }
            
            //VERIFICAMOS SI EL PROCESOS FUNCIONO
            if (funciono) {
                DesktopNotify.setDefaultTheme(NotifyTheme.Green);
                DesktopNotify.showDesktopMessage("Exito","Guardo con exito",DesktopNotify.SUCCESS,3000);
            }
            
        }else{
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "El dato no pudo ser guardado",DesktopNotify.ERROR,4000);
        }
        
        MntoEspecialidad frmMntoEspec = new MntoEspecialidad();
        ControladorMntoEspecialidad ctrMntoEspec = new ControladorMntoEspecialidad(frmMntoEspec);
        frmMntoEspec.setVisible(true);
        this.frmEspecialidad.dispose();
        
        
    }
    public void mostrar(){
        if (especialidadSeleccionada!=null) {
            this.frmEspecialidad.tfNombre.setText(especialidadSeleccionada.getNom_Especialidad());
        }
    }
    
}

