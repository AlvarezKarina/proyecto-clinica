/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Estructuras.ListaOrdenada;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ambulancia;

import modelo.Hospital;

/**
 *
 * @author karie
 */
public class Dao_Hospital {
    
    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Dao_Hospital() {
        this.conectar = new Conexion();
    }
    
    public ListaOrdenada<Hospital> selecAll(){
        String sql = "SELECT * FROM hospital";
        return select(sql);
    }
    
      public  ListaOrdenada<Hospital> SelectId(int id){
          String sql = "SELECT * FROM hospital WHERE  hospital " + id;
          return select(sql);
      }
    
    public boolean insert(Hospital obj){
        String sql = "INSERT INTO hospital(nombre_hospital, direccion_hospital ) values (?,?)";
        return alterarRegistro(sql, obj);
        
    }
    
    public boolean update(Hospital obj){
        String sql = "UPDATE hospital SET nombre_hospital=?, direccion_hospital=? WHERE hospital= "+obj.getHospital();
        return alterarRegistro(sql, obj);
    }
    
    public boolean delete(Hospital obj) {
        try{
            String sql = "DELETE FROM hospital WHERE hospital="+obj.getHospital();
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("Exito","Registro eliminado con exito", DesktopNotify.ERROR,3000);
        }catch(SQLException ex){
            Logger.getLogger(Dao_Hospital.class.getName()).log(Level.SEVERE, null, ex);
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
          
        }finally{
            try{
                ps.close();
                conectar.closeConexion(con);
                 
            }catch(SQLException ex){
                Logger.getLogger(Dao_Hospital.class.getName()).log(Level.SEVERE, null, ex);
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
          
            }
        }
        
        return false;
    }
    
    private boolean alterarRegistro(String sql, Hospital obj){
        try{
            this.con = this.conectar.getConnection();
            this.ps = con.prepareStatement(sql);
            
            this.ps.setString(1, obj.getNombre_hospital());
            this.ps.setString(2, obj.getDireccion_hospital());
            this.ps.execute();
            return true;
      }catch(Exception ex){
            Logger.getLogger(Dao_Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                ps.close();
                
            }catch(SQLException ex){
                Logger.getLogger(Dao_Hospital.class.getName()).log(Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
        return false;
    }
    
    private ListaOrdenada<Hospital> select(String sql){
        ListaOrdenada<Hospital> listaHopital = new ListaOrdenada<>();
       try {
            this.con = conectar.getConnection();
            this.ps=con.prepareStatement(sql);
            this.rs = ps.executeQuery();
            
            while(rs.next()){
                Hospital hospi = new Hospital();
                hospi.setHospital(rs.getInt("hospital"));
                hospi.setNombre_hospital(rs.getString("nombre_hospital"));
                hospi.setDireccion_hospital(rs.getString("direccion_hospital"));
                listaHopital.add(hospi);
            } 
            
       }catch(Exception e) {
           Logger.getLogger(Dao_Hospital.class.getName()).log(Level.SEVERE, null, e);
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Hospital.class.getName()).log(Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
       return listaHopital;
        
    }
    
}
