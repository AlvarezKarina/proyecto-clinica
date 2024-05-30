/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

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
import modelo.Ambulancia;
import modelo.Tipo_ambulancia;

/**
 *
 * @author karie
 */
public class DaoAmbulancia {
    
     
    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public DaoAmbulancia() {
        this.conectar = new Conexion();
    }
    
       public ListaSimple<Ambulancia> selectAll(){
        String sql = "select am.ambulancia,am.marca, am.modelo, am.anio_fabricacion, am.placa, ti.nombre_tipo  from ambulancia am inner join tipo_ambulancia ti on ti.id_tipo_ambulancia = am.id_tipo_ambulancia";
        return select(sql);
    }
      
      public  ListaSimple<Ambulancia> SelectId(int id){
          String sql = "SELECT * FROM ambulancia WHERE  ambulancia " + id;
          return select(sql);
      }
    
    public boolean insert(Ambulancia obj) {
        String sql = "INSERT INTO ambulancia (marca,modelo, anio_fabricacion, placa, id_tipo_ambulancia)  VALUES (?,?,?,?,?)";
        return AlterarRegistro(sql, obj);
    }
    
    public boolean update(Ambulancia obj) {
        String sql = "UPDATE ambulancia SET marca=?, modelo=?, anio_fabricacion=?, placa=?, id_tipo_ambulancia=? WHERE ambulancia ="+ obj.getAmbulancia();
        
        return AlterarRegistro(sql, obj);
    }
    
    private boolean AlterarRegistro(String sql, Ambulancia obj) {
        try{
            this.con = conectar.getConnection();
            this.ps = con.prepareStatement(sql);
           
            this.ps.setString(1, obj.getMarca());
            this.ps.setString(2, obj.getModelo());
            this.ps.setInt(3, obj.getAnio_fabricacion());
            this.ps.setString(4, obj.getPlaca());
            this.ps.setInt(5, obj.getTipo_ambulancia().getId_tipo_ambulancia());
            this.ps.execute();
            return true;
            
       }catch(Exception ex){
            Logger.getLogger(DaoAmbulancia.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                ps.close();
                
            }catch(SQLException ex){
                Logger.getLogger(DaoAmbulancia.class.getName()).log(Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
        return false;
    }
    
    private ListaSimple<Ambulancia> select(String sql) {
        ListaSimple<Ambulancia> lista = new ListaSimple<>();
        Ambulancia obj = new Ambulancia();
        Tipo_ambulancia tipo=null;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                tipo = new Tipo_ambulancia();
                obj = new Ambulancia();
                obj.setAmbulancia(rs.getInt("ambulancia"));
                obj.setMarca(rs.getString("marca"));
                obj.setModelo(rs.getString("modelo"));
                obj.setAnio_fabricacion(rs.getInt("anio_fabricacion"));
                obj.setPlaca(rs.getString("placa"));
                tipo.setNombre_tipo(rs.getString("nombre_tipo")); System.out.println(tipo.getNombre_tipo());
                obj.setTipo_ambulancia(tipo);
                lista.insertar(obj);

                //Se guardo el primer objeto a la lista
            }
       }catch(Exception e) {
           Logger.getLogger(DaoAmbulancia.class.getName()).log(Level.SEVERE, null, e);
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoAmbulancia.class.getName()).log(Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
       return lista;
        
    
    
    }
    
    public boolean delete(Ambulancia obj){
        
        String sql = "DELETE FROM ambulancia WHERE ambulancia=" + obj.getAmbulancia();
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
    
    
    public ListaSimple<String> obtenerTipoAmbulancia() {// Método para obtener la lista de nombres de países desde la base de datos
        String sql = "SELECT nombre_tipo FROM tipo_ambulancia";
        ListaSimple<String> lisTipoAmbulancia = new ListaSimple<>();

        try {
           con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tipo_ambulancia = rs.getString("nombre_tipo");
                //lisnombresEstadios.add();
                lisTipoAmbulancia.insertar(tipo_ambulancia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en obtenerNombresEstadio: " + e.getMessage());
        } finally {
            //cerrarConexiones();
        }

        return lisTipoAmbulancia;
    }
    
    public String obtenerIdTipoAmbu(String tipo_ambulancia) {//recibe el nombre del pais desde el combobox
        
        String sql = "SELECT id_tipo_ambulancia FROM tipo_ambulancia WHERE nombre_tipo= ?";//me busca el id del nombre q recibio
        String id = null;

        try {
           this.con = conectar.getConnection();
            this.ps=con.prepareStatement(sql);
            this.ps.setString(1, tipo_ambulancia);
            this.rs = ps.executeQuery();
            if (rs.next()) {
                //Pais pais = new Pais();
                id = (rs.getString("id_tipo_ambulancia"));//seteamos el id q nos trajo de la BD

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
