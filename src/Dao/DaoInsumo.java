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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hospital;
import modelo.Insumo;

/**
 *
 * @author karie
 */
public class DaoInsumo {
  
    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public DaoInsumo() {
        this.conectar = new Conexion();
    }
    
     public ListaOrdenada<Insumo> selecAll(){
        String sql = "SELECT * FROM insumo";
        return select(sql);
    }
     
        public  ListaOrdenada<Insumo> SelectId(int id){
          String sql = "SELECT * FROM insumo WHERE  insumo " + id;
          return select(sql);
      }
     
      public boolean insert(Insumo obj){
        String sql = "INSERT INTO insumo(nombre_insumo, fecha_vencimiento ) values (?,?)";
        return alterarRegistro(sql, obj);
        
    }
      
        
    public boolean update(Insumo obj){
        String sql = "UPDATE insumo SET nombre_insumo=?, fecha_vencimiento=? WHERE insumo= "+obj.getInsumo();
        return alterarRegistro(sql, obj);
    }
    
     public boolean delete(Insumo obj) {
        try{
            String sql = "DELETE FROM insumo WHERE insumo="+ obj.getInsumo();
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
    
     private boolean alterarRegistro(String sql, Insumo obj){
        try{
            this.con = this.conectar.getConnection();
            this.ps = con.prepareStatement(sql);
            
            this.ps.setString(1, obj.getNombre_insumo());
            this.ps.setDate(2,  new java.sql.Date(obj.getFecha_vencimiento().getTime()));
            this.ps.execute();
            return true;
      }catch(Exception ex){
            Logger.getLogger(DaoInsumo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                ps.close();
                
            }catch(SQLException ex){
                Logger.getLogger(DaoInsumo.class.getName()).log(Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
        return false;
    }
    
 private ListaOrdenada<Insumo> select(String sql){
        ListaOrdenada<Insumo> listaInsumo = new ListaOrdenada<>();
       try {
            this.con = conectar.getConnection();
            this.ps=con.prepareStatement(sql);
            this.rs = ps.executeQuery();
            
            while(rs.next()){
                Insumo insum = new Insumo();
                insum.setInsumo(rs.getInt("insumo"));
                insum.setNombre_insumo(rs.getString("nombre_insumo"));
                insum.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                listaInsumo.add(insum);
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
       return listaInsumo;
        
    }
    
}
