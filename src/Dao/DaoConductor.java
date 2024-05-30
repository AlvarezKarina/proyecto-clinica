/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Estructuras.ListaDobleCircular;
import Estructuras.ListaOrdenada;
import Estructuras.ListaSimple;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Ambulancia;
import modelo.Conductor;
import modelo.Licencia;
import modelo.Tipo_ambulancia;



/**
 *
 * @author karie
 */
public class DaoConductor {
   
      
    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public DaoConductor() {
        this.conectar = new Conexion();
    }

     public ListaDobleCircular<Conductor> selectAll(){
        String sql = "SELECT con.conductor, con.dui, con.nombre, con.genero, con.numero_licencia, li.tipo_licencia FROM conductor con INNER JOIN licencia li ON con.licencia = li.licencia";
        return select(sql);
    }
      
      public  ListaDobleCircular<Conductor> SelectId(int id){
          String sql = "SELECT * FROM conductor WHERE  conductor " + id;
          return select(sql);
      }
    
    public boolean insert(Conductor obj) {
        String sql = "INSERT INTO conductor (dui,nombre, genero, numero_licencia, licencia)  VALUES (?,?,?,?,?)";
        return AlterarRegistro(sql, obj);
    }
    
    public boolean update(Conductor obj) {
        String sql = "UPDATE conductor SET dui =?, nombre=?, genero =?, numero_licencia =?, licencia =?"
        + " WHERE conductor = "+ obj.getConductor();
        
        return AlterarRegistro(sql, obj);
    }
    
     private boolean AlterarRegistro(String sql, Conductor obj) {
        try{
            this.con = conectar.getConnection();
            this.ps = con.prepareStatement(sql);
           
            this.ps.setString(1, obj.getDui());
            this.ps.setString(2, obj.getNombre());
            this.ps.setString(3, obj.getGenero());
            this.ps.setString(4, obj.getNumero_licencia());
            this.ps.setInt(5, obj.getLicencia().getLicencia());
            this.ps.execute();
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error insertar sql: "+ex.getMessage());
            Logger.getLogger(DaoConductor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoConductor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.conectar.closeConexion(con);
        }
        return false;
    }
     
     private ListaDobleCircular<Conductor> select(String sql) {
        ListaDobleCircular<Conductor> lista = new ListaDobleCircular<>();
        Conductor obj = new Conductor();
        Licencia tipo=null;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                tipo = new Licencia();
                obj = new Conductor();
                obj.setConductor(rs.getInt("conductor"));
                obj.setDui(rs.getString("dui"));
                obj.setNombre(rs.getString("nombre"));
                obj.setGenero(rs.getString("genero"));
                obj.setNumero_licencia(rs.getString("numero_licencia"));
                tipo.setTipo_licencia(rs.getString("tipo_licencia")); System.out.println(tipo.getTipo_licencia());
                obj.setLicencia(tipo);
                lista.insertar(obj);

                //Se guardo el primer objeto a la lista
            }
        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
            conectar.closeConexion(con);
        }
        return lista;
    }
     
     public boolean delete(Conductor obj){
        
        String sql = "DELETE FROM conductor WHERE conductor =' " + obj.getConductor() + "'";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();//tenes que agregar el rs= ps.execute();
            return true;
        }catch(SQLException ex){
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
        }finally{
            try{
                ps.close();
                conectar.closeConexion(con);
            }catch(SQLException ex){
                
            }
        }
        
        return false;
    }
     
      public ListaDobleCircular<String> obtenerTipoLicencia() {// Método para obtener la lista de nombres de países desde la base de datos
        String sql = "select tipo_licencia from licencia";
        ListaDobleCircular<String> lisTipoLicencia = new ListaDobleCircular<>();

        try {
           con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tipo_licencia = rs.getString("tipo_licencia");
                //lisnombresEstadios.add();
                lisTipoLicencia.insertar(tipo_licencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en obtenerNombresEstadio: " + e.getMessage());
        } finally {
            //cerrarConexiones();
        }

        return lisTipoLicencia;
    }
      
       public String obtenerIdLicencia(String tipoLicencia) {//recibe el nombre del pais desde el combobox
        
        String sql = "SELECT licencia FROM licencia WHERE tipo_licencia = ?";//me busca el id del nombre q recibio
        String id = null;

        try {
           this.con = conectar.getConnection();
            this.ps=con.prepareStatement(sql);
            this.ps.setString(1, tipoLicencia);
            this.rs = ps.executeQuery();
            if (rs.next()) {
                //Pais pais = new Pais();
                id = (rs.getString("licencia"));//seteamos el id q nos trajo de la BD

            }
        } catch (SQLException e) {
            e.printStackTrace();
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en obtener ID de contacto: " + e.getMessage());
        } finally {
            conectar.closeConexion(con);
        }

        return id;//retornamos el id 
    }
    
    
}

